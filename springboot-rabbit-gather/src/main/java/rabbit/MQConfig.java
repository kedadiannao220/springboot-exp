package rabbit;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * MQ的配置信息
 * @author admin
 * @version V1.0 2018/6/21 admin Exp $
 */
@SpringBootConfiguration
public class MQConfig {
    @Value("${rabbitmq.queue.direct}")
    private String directQueue;

    @Value("${rabbitmq.queue.fanout}")
    private String fanoutQueue;

    @Value("${rabbitmq.queue.topic}")
    private String topicQueue;

    @Value("${rabbitmq.topic.route}")
    private String topicRoute;

    @Bean
    public Queue directQueue() {
        return new Queue(directQueue);
    }

    @Bean
    public Queue fanoutQueue() {
        return new Queue(fanoutQueue);
    }

    @Bean
    public Queue topicQueue() {
        return new Queue(topicQueue);
    }

    @Bean
    public DirectExchange exchange() {
        return new DirectExchange(MQConstant.JOB_DIRECT_EXCHANGE);
    }

    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange(MQConstant.JOB_FANOUT_EXCHANGE);
    }

    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(MQConstant.JOB_TOPIC_EXCHANGE);
    }

    @Bean
    public Binding directBuildBinding(Queue directQueue, DirectExchange directExchange) {
        return BindingBuilder.bind(directQueue).to(directExchange)
            .with(MQConstant.DEFAULT_ROUTINT_KEY);
    }

    @Bean
    public Binding fanoutBuildBinding(Queue fanoutQueue, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(fanoutQueue).to(fanoutExchange);
    }

    @Bean
    public Binding topicBuildBinding(Queue topicQueue, TopicExchange topicExchange) {
        return BindingBuilder.bind(topicQueue).to(topicExchange).with(topicRoute);
    }

    @Bean
    public MQConsumer MQConsumer() {
        return new MQConsumer();
    }

    @Bean
    public MQSender MQSender() {
        return new MQSender();
    }

}
