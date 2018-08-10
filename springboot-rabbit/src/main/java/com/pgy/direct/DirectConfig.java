package com.pgy.direct;

import com.pgy.RabbitConstant;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

import java.util.HashMap;
import java.util.Map;

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
    Queue delayQueue() {
        Map<String, Object> param = new HashMap<>(2);
        param.put("x-dead-letter-exchange", RabbitConstant.DEAD_LETTER_EXCHANGE);
        // message ttl time 单位ms
        param.put("x-message-ttl", 10000);
        // queue ttl time 单位ms

        return new Queue(RabbitConstant.DELAY_QUEUE, true, false, false, param);
    }

    @Bean
    Queue dlxQueue() {
        return new Queue(RabbitConstant.DLX_QUEUE, true, false, false, null);
    }

    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange(RabbitConstant.DIRE_EXCHANGE);
    }

    @Bean
    public DirectExchange deadLetterExchange() {
        return new DirectExchange(RabbitConstant.DEAD_LETTER_EXCHANGE, true, false);
    }

    @Bean
    public DirectExchange delayExchange() {
        return new DirectExchange(RabbitConstant.DELAY_EXCHANGE, true, false);
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

    @Bean
    public Binding delayBind(Queue delayQueue, DirectExchange delayExchange) {
        return BindingBuilder.bind(delayQueue).to(delayExchange).with("");
    }

    @Bean
    public Binding dlxBind(Queue dlxQueue, DirectExchange deadLetterExchange) {
        return BindingBuilder.bind(dlxQueue).to(deadLetterExchange).with("");
    }

}
