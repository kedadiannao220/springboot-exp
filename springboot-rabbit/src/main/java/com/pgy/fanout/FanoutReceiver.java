package com.pgy.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author admin
 * @version V1.0 2018/6/21 admin Exp $
 * @description
 */
@Component
public class FanoutReceiver {

    @RabbitListener(queues = "fanoutQueue1")
    public void fanoutQueue1Receive(String message) {
        System.out.println("fanoutQueue1Receive.... " + message);
    }

    @RabbitListener(queues = "fanoutQueue2")
    public void fanoutQueue2Receive(String message) {
        System.out.println("fanoutQueue2Receive.... " + message);
    }
}
