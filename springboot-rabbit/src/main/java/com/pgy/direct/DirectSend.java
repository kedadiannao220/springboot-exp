package com.pgy.direct;

import com.pgy.RabbitConstant;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @author admin
 * @version V1.0 31/05/2018 admin Exp $
 * @description
 */
@Component
public class DirectSend {

    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private DirectExchange directExchange;

    public void directExchangeSend() {
        String message = "directExchangeSend" + UUID.randomUUID().toString();

        System.out.println("direct exchange send... " + message);

        rabbitTemplate.convertAndSend(directExchange.getName(), RabbitConstant.ROUTING_KEY,
            message);
    }

    public void directSend(Object object) {
        rabbitTemplate.convertAndSend(directExchange.getName(), RabbitConstant.ROUTING_KEY, object);
    }

}
