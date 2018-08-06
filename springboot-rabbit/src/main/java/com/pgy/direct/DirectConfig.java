package com.pgy.direct;

import com.pgy.RabbitConstant;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * @author admin
 * @version V1.0 06/06/2018 admin Exp $
 * @description
 */
@SpringBootConfiguration
public class DirectConfig {

    @Bean
    public Queue directQueue() {
        return new Queue(RabbitConstant.DIRECT_QUEUE);
    }

    @Bean
    Queue hash0Queue() {
        return new Queue(RabbitConstant.HASH_0_QUEUE);
    }

    @Bean
    Queue hash1Queue() {
        return new Queue(RabbitConstant.HASH_1_QUEUE);
    }

    @Bean
    Queue hash2Queue() {
        return new Queue(RabbitConstant.HASH_2_QUEUE);
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
    public Binding directBindHash0Queue(Queue hash0Queue, DirectExchange directExchange) {
        return BindingBuilder.bind(hash0Queue).to(directExchange)
            .with(RabbitConstant.HASH_0_ROUTING);
    }

    @Bean
    public Binding directBindHash1Queue(Queue hash1Queue, DirectExchange directExchange) {
        return BindingBuilder.bind(hash1Queue).to(directExchange)
            .with(RabbitConstant.HASH_1_ROUTING);
    }

    @Bean
    public Binding directBindHash2Queue(Queue hash2Queue, DirectExchange directExchange) {
        return BindingBuilder.bind(hash2Queue).to(directExchange)
            .with(RabbitConstant.HASH_2_ROUTING);
    }

}
