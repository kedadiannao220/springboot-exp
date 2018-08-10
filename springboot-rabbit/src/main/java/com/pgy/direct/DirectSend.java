package com.pgy.direct;

import com.pgy.RabbitConstant;
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

    public void directExchangeSend() {
        String message = "directExchangeSend" + UUID.randomUUID().toString();

        System.out.println("direct exchange send... " + message);

        rabbitTemplate.convertAndSend(RabbitConstant.DIRE_EXCHANGE, RabbitConstant.ROUTING_KEY,
            message);
    }

    public void directSend(Object object) {
        rabbitTemplate.convertAndSend(RabbitConstant.DIRE_EXCHANGE, RabbitConstant.ROUTING_KEY,
            object);
    }

    /**
     * 将message 进行hash处理
     * @param object
     * @param hashStr
     */
    public void hashMsgSender(Object object, String hashStr) {
        switch (hashStr.hashCode() % 3) {
            case 0:
                System.out.println("hash0Queue sender---------------- " + object);
                rabbitTemplate.convertAndSend(RabbitConstant.DIRE_EXCHANGE,
                    RabbitConstant.HASH_0_ROUTING, object);
                break;
            case 1:
                System.out.println("hash1Queue sender---------------- " + object);

                rabbitTemplate.convertAndSend(RabbitConstant.DIRE_EXCHANGE,
                    RabbitConstant.HASH_1_ROUTING, object);
                break;
            default:
                System.out.println("hash2Queue sender---------------- " + object);
                rabbitTemplate.convertAndSend(RabbitConstant.DIRE_EXCHANGE,
                    RabbitConstant.HASH_2_ROUTING, object);

        }
    }

    public void ttlSend(Object object) {
        System.out.println("delayQueue sender---------------- " + object);
        rabbitTemplate.convertAndSend(RabbitConstant.DELAY_EXCHANGE, "", object);
    }

}
