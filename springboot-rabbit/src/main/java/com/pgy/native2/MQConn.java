package com.pgy.native2;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

/**
 * @author admin
 * @version V1.0 2018/6/25 admin Exp $
 * @description
 */

public class MQConn {
    public Channel getChannel() {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("10.0.0.123");
        factory.setPort(5672);
        factory.setUsername("idcos");
        factory.setPassword("P@ssw0rd");
        factory.setVirtualHost("/idcos");
        Connection connection = null;
        try {
            connection = factory.newConnection();
        } catch (IOException | TimeoutException e) {
            e.printStackTrace();
        }
        Channel channel = null;
        try {
            channel = connection != null ? connection.createChannel() : null;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return channel;
    }

    public void send() {
        Channel channel = getChannel();
        try {
            channel.queueDeclare("rabbitmq.queue.direct", false, false, false, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String message = "Hello World!";
        try {
            channel.basicPublish("", "rabbitmq.queue.direct", null, message.getBytes("UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(" [x] Sent '" + message + "'");
    }

    public void sendPriority() throws IOException {
        Channel channel = getChannel();

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
        try {
            channel.close();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }

    }

    public void receive() {
        Map<String, Object> args = new HashMap<String, Object>();
        args.put("x-max-sender", 10);
        Channel channel = getChannel();
        try {
            channel.queueDeclare("rabbitmq.queue.direct", false, false, false, args);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope,
                                       AMQP.BasicProperties properties,
                                       byte[] body) throws IOException {
                String message = new String(body, "UTF-8");
                System.out.println(" [x] Received '" + message + "'");
            }
        };
        try {
            channel.basicConsume("rabbitmq.queue.direct", true, consumer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
