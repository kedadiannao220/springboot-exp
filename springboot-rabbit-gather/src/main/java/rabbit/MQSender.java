package rabbit;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * MQ 相关服务，主要是发消息
 * @author admin
 * @version V1.0 2018/6/21 admin Exp $
 */
@Component
public class MQSender {
    private static Logger  logger = LoggerFactory.getLogger(MQSender.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private DirectExchange directExchange;

    @Autowired
    private FanoutExchange fanoutExchange;

    @Autowired
    private TopicExchange  topicExchange;

    public void directSend(JobMsgEvent jobMsgEvent) {
        rabbitTemplate.convertAndSend(directExchange.getName(), MQConstant.DEFAULT_ROUTINT_KEY,
            jobMsgEvent);

        logger.info("-------------directSend : " + JSON.toJSONString(jobMsgEvent, true));
    }

    public void directSendListT(JobMsgEvent jobMsgEvent) {
        List<JobMsgEvent> jobMsgEventList = Arrays.asList(jobMsgEvent);

        rabbitTemplate.convertAndSend(directExchange.getName(), MQConstant.DEFAULT_ROUTINT_KEY,
            jobMsgEventList);

        logger.info("-------------directSend : " + JSON.toJSONString(jobMsgEvent, true));
    }

    public void fanoutSend(JobMsgEvent jobMsgEvent) {
        rabbitTemplate.convertAndSend(fanoutExchange.getName(), "Hello", jobMsgEvent);

        logger.info("-------------fanoutSend : " + JSON.toJSONString(jobMsgEvent, true));

    }

    public void topicSend(JobMsgEvent jobMsgEvent, String routingKey) {
        rabbitTemplate.convertAndSend(topicExchange.getName(), routingKey, jobMsgEvent);

        logger.info("-------------topicSend : " + JSON.toJSONString(jobMsgEvent, true));
    }

}
