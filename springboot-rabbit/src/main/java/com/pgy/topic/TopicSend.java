package com.pgy.topic;

import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @author admin
 * @version V1.0 2018/6/21 admin Exp $
 * @description
 */
@Component
public class TopicSend {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private TopicExchange  topic;

    public void sendByRoutingKey(String routingKey) {
        String message = "TopicSend....." + routingKey + "......" + UUID.randomUUID().toString();
        rabbitTemplate.convertAndSend(topic.getName(), routingKey, message);
        System.out.println(message);
    }
}
