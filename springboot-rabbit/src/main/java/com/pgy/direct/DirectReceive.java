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
        System.out.println("direct exchange receive..." + JSON.toJSONString(object));
    }

    @RabbitListener(queues = RabbitConstant.DIRECT_QUEUE)
    public void directReceive2(Message object) {
        String str = new String(object.getBody());
        System.out.println(str.getBytes().length);
    }

    @RabbitListener(queues = "${rabbitmq.queue.name}")
    public void directReceive3(Message object) {
        String str = new String(object.getBody());
        System.out.println(str.getBytes().length);
    }

}
