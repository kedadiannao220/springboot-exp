package common;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 *
 * @author pengganyu
 * @version V1.0 08/08/2018 pengganyu Exp $
 */

public class RabbitConnect {

    private static ConnectionFactory connectionFactory;

    private static void init() {

        connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("127.0.0.1");
        connectionFactory.setPort(5672);
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");
        connectionFactory.setVirtualHost("/");
    }

    public static Connection getConn() {
        if (connectionFactory == null) {
            init();
        }
        try {
            return connectionFactory.newConnection();
        } catch (IOException | TimeoutException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Channel getChannel() {
        try {
            return getConn().createChannel();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
