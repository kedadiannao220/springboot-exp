package sender;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import common.ExchangeConfig;
import common.QueueConfig;
import common.RabbitConnect;
import common.RabbitConstant;

import java.io.IOException;

/**
 *
 * @author pengganyu
 * @version V1.0 08/08/2018 pengganyu Exp $
 */

public class RabbitSender {

    public void sendPriorityMsg(String msg, int priority) {
        Channel channel = RabbitConnect.getChannel();

        QueueConfig.statePriorityQueue(channel);

        ExchangeConfig.stateExchange(channel, RabbitConstant.NORMAL_EXCHANGE,
            BuiltinExchangeType.DIRECT.getType());

        /**
         * 设置消息的优先级
         */
        AMQP.BasicProperties.Builder builder = new AMQP.BasicProperties.Builder();
        builder.priority(priority);

        commonSender(channel, msg, RabbitConstant.NORMAL_EXCHANGE, builder.build());
    }

    public void commonSender(Channel channel, String message, String exchangeName,
                             AMQP.BasicProperties basicProperties) {

        System.out.println("sender msg \n" + message);
        try {
            channel.basicPublish(exchangeName, "", false, basicProperties, message.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
