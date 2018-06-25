package com.pgy.direct;

import com.pgy.RabbitConstant;
import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * @author admin
 * @version V1.0 06/06/2018 admin Exp $
 * @description
 */
@SpringBootConfiguration
public class DirectConfig {

    @Value("${rabbitmq.queue.name}")
    private String annotationQueueName;

    @Bean
    public Queue directQueue() {
        return new Queue(RabbitConstant.DIRECT_QUEUE);
    }

    @Bean
    public Queue annotationQueue() {
        return new Queue(annotationQueueName);
    }

    @Bean
    public DirectExchange exchange() {
        return new DirectExchange(RabbitConstant.DIRE_EXCHANGE);
    }

    @Bean
    public Binding directBuildBinding1(Queue directQueue, DirectExchange directExchange) {
        return BindingBuilder.bind(directQueue).to(directExchange).with(RabbitConstant.ROUTING_KEY);
    }

    @Bean
    public Binding directBuildBinding2(Queue annotationQueue, DirectExchange directExchange) {
        return BindingBuilder.bind(annotationQueue).to(directExchange)
            .with(RabbitConstant.ROUTING_KEY);
    }

}
