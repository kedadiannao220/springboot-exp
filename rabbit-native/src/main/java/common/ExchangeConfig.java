package common;

import com.rabbitmq.client.Channel;

import java.io.IOException;

/**
 *
 * @author pengganyu
 * @version V1.0 08/08/2018 pengganyu Exp $
 */

public class ExchangeConfig {

    public static void stateExchange(Channel channel, String name, String type) {
        try {
            channel.exchangeDeclare(name, type);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
