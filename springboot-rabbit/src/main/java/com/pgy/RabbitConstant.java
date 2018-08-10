package com.pgy;

/**
 * @author admin
 * @version V1.0 01/06/2018 admin Exp $
 * @description
 */
public class RabbitConstant {
    public static final String ROUTING_KEY          = "helloRouting";
    public static final String DIRE_EXCHANGE        = "dire_exchange";
    public static final String DEAD_LETTER_EXCHANGE = "dead_letter_exchange";
    public static final String DELAY_EXCHANGE       = "delay_exchange";

    public static final String TOPIC_EXCHANGE       = "helloExchange";
    public static final String TOPIC_ROUTING        = "hello.#";
    public static final String DLX_ROUTING          = "dlx";

    public static final String HASH_0_ROUTING       = "hash0";
    public static final String HASH_1_ROUTING       = "hash1";
    public static final String HASH_2_ROUTING       = "hash2";

    public static final String HASH_0_QUEUE         = "hash0Queue";
    public static final String HASH_1_QUEUE         = "hash1Queue";
    public static final String HASH_2_QUEUE         = "hash2Queue";
    public static final String TOPIC_QUEUE          = "topic_queue";
    public static final String DIRECT_QUEUE         = "helloQueue";
    public static final String DLX_QUEUE            = "dlx_process_queue";
    public static final String DELAY_QUEUE          = "delay_queue";

}
