package rabbit;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

;

/**
 * MQ接收消息体
 * @author admin
 * @version V1.0 2018/6/21 admin Exp $
 */
@Component
public class MQConsumer {
    private static Logger logger = LoggerFactory.getLogger(MQConsumer.class);

    /**
     * direct mode receive
     * @param msg
     */
    @RabbitListener(queues = "${rabbitmq.queue.direct}")
    public void directReceive(Message msg) {

        //        Object obj = JSON.parseObject(msg.getBody(),Object.class);

        Object obj = SerializableUtil.toObject(msg.getBody());

        logger.info("-------------directReceive : " + JSON.toJSONString(obj, true));
    }

    /**
     * fanout mode receive
     * @param msg
     */
    @RabbitListener(queues = "${rabbitmq.queue.fanout}")
    public void fanoutReceive(Message msg) {
        Object obj = SerializableUtil.toObject(msg.getBody());

        logger.info("-------------fanoutReceive : " + JSON.toJSONString(obj, true));
    }

    /**
     * topic mode receive
     * @param msg
     */
    @RabbitListener(queues = "${rabbitmq.queue.topic}")
    public void topicReceive(Message msg) {
        Object obj = SerializableUtil.toObject(msg.getBody());

        logger.info("-------------topicReceive : " + JSON.toJSONString(obj, true));
    }

}
