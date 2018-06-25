package com.pgy.topic;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author admin
 * @version V1.0 2018/6/21 admin Exp $
 * @description
 */
@Component
public class TopicReceive {

    @RabbitListener(queues = "topicQueue1")
    public void topicQueue1Receive(String message) {
        System.out.println("topicQueue1.... " + message);
    }

    @RabbitListener(queues = "topicQueue2")
    public void topicQueue2Receive(String message) {
        System.out.println("topicQueue2.... " + message);
    }
}
