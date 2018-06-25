package com.pgy.fanout;

import org.springframework.amqp.core.FanoutExchange;
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
public class FanoutSend {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private FanoutExchange fanout1;

    /**
     * null routing key
     */
    public void send() {
        String message = "FanoutSend....." + UUID.randomUUID().toString();
        rabbitTemplate.convertAndSend(fanout1.getName(), "", message);
        System.out.println(message);
    }

    /**
     * 此routingKey没有用处，""的时候也可以接收，随便一个字符串也可以接收？
     */
    public void sendByRoutingKey() {
        String message = "FanoutSend....." + UUID.randomUUID().toString();
        rabbitTemplate.convertAndSend(fanout1.getName(), "routingKey", message);
        System.out.println(message);
    }
}
