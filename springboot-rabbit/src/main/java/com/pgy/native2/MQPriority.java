package com.pgy.native2;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

/**
 * 测试队列的优先级
 * @author pengganyu
 * @version V1.0 2018/7/24 pengganyu Exp $
 */

public class MQPriority {
    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("127.0.0.1");
        connectionFactory.setPort(5672);
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");
        connectionFactory.setVirtualHost("/");
        connectionFactory.setAutomaticRecoveryEnabled(true);
        Connection conn = connectionFactory.newConnection();
        final Channel channel = conn.createChannel();

        Map<String, Object> queueArgs = new HashMap<String, Object>();
        queueArgs.put("x-max-sender", 10);
        channel.queueDeclare("my-sender-queue", true, false, false, queueArgs);

        // 投递优先级消息
        String msg = "msg-sender-";
        AMQP.BasicProperties.Builder builder = new AMQP.BasicProperties.Builder();
        for (int i = 0; i < 20;) {
            builder.priority(i);
            AMQP.BasicProperties properties = builder.build();
            channel.basicPublish("", "my-sender-queue", properties, (msg + i).getBytes());
            i = i + 2;
        }

        // 创建消费者
        channel.basicQos(1);
        channel.basicConsume("my-sender-queue", new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope,
                                       AMQP.BasicProperties properties,
                                       byte[] body) throws IOException {
                System.out.println(new String(body, "utf-8"));
                channel.basicAck(envelope.getDeliveryTag(), false);
            }
        });

    }
}
