package common;

import com.rabbitmq.client.Channel;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static common.RabbitConstant.MAX_QUEUE_PRIORITY;

/**
 *
 * @author pengganyu
 * @version V1.0 08/08/2018 pengganyu Exp $
 */

public class QueueConfig {

    public static void statePriorityQueue(Channel ch) {
        Map<String, Object> args = new HashMap<>();
        args.put("x-max-priority", MAX_QUEUE_PRIORITY);
        stateQueue(ch, RabbitConstant.PRIORITY_QUEUE, args);

    }

    public static void stateDelayQueue(Channel ch) {
        Map<String, Object> args = new HashMap<>();
        args.put("x-message-ttl", RabbitConstant.QUEUE_MESSAGE_TTL);
        args.put("x-dead-letter-exchange", RabbitConstant.DLX_EXCHANGE);
        stateQueue(ch, RabbitConstant.DELAY_QUEUE, args);
    }

    public static void stateDlxQueue(Channel ch) {
        stateQueue(ch, RabbitConstant.DLX_QUEUE, null);
    }

    public static void stateQueue(Channel ch, String queueName, Map<String, Object> args) {
        try {
            ch.queueDeclare(queueName, true, false, false, args);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
