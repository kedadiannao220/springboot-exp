package com.pgy.direct;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.pgy.RabbitConstant;

/**
 * @author admin
 * @version V1.0 06/06/2018 admin Exp $
 * @description
 */
@Component
public class DirectReceive {
    @RabbitListener(queues = RabbitConstant.DIRECT_QUEUE)
    public void directReceive1(String object) {
        System.out.println("direct queue receive..." + JSON.toJSONString(object));
    }

    @RabbitListener(queues = RabbitConstant.DIRECT_QUEUE)
    public void directReceive2(Message object) {
        System.out.println("direct queue receive..." + JSON.toJSONString(object));

    }

    @RabbitListener(queues = RabbitConstant.HASH_0_QUEUE)
    public void directHash0Receive(Message object) {
        System.out.println("hash0Queue receive---------------- " + new String(object.getBody()));
    }

    @RabbitListener(queues = RabbitConstant.HASH_1_QUEUE)
    public void directHash1Receive(Message object) {
        System.out.println("hash1Queue receive---------------- " + new String(object.getBody()));
    }

    @RabbitListener(queues = RabbitConstant.HASH_2_QUEUE)
    public void directHash2Receive(Message object) {
        System.out.println("hash2Queue receive---------------- " + new String(object.getBody()));
    }

}
