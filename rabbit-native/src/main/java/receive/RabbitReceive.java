package receive;

import com.rabbitmq.client.*;
import common.RabbitConnect;
import common.RabbitConstant;

import java.io.IOException;

/**
 *
 * @author pengganyu
 * @version V1.0 08/08/2018 pengganyu Exp $
 */

public class RabbitReceive {

    public void priorityReceive() {
        Channel channel = RabbitConnect.getChannel();
        while (true) {
            try {
                assert channel != null;
                channel.basicConsume(RabbitConstant.PRIORITY_QUEUE, true,
                    new DefaultConsumer(channel) {
                        @Override
                        public void handleDelivery(String consumerTag, Envelope envelope,
                                                   AMQP.BasicProperties properties,
                                                   byte[] body) throws IOException {
                            String message = new String(body, "UTF-8");
                            System.out.println(" [x] Received '" + message + "'");
                        }
                    });
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
