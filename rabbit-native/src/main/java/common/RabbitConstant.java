package common;

/**
 *
 * @author pengganyu
 * @version V1.0 08/08/2018 pengganyu Exp $
 */

public class RabbitConstant {

    /**
     * Queue args
     */
    public static final int    MAX_QUEUE_PRIORITY = 10;
    public static final String QUEUE_MESSAGE_TTL  = "10000";

    /**
     * Queue list
     */
    public static final String PRIORITY_QUEUE     = "priority_queue";
    public static final String DELAY_QUEUE        = "delay_queue";
    public static final String DLX_QUEUE          = "dlx_queue";

    /**
     * RouteKey list
     */

    /**
     * Exchange list
     */
    public static final String DLX_EXCHANGE       = "dlx_exchange";
    public static final String DELAY_EXCHANGE     = "delay_exchange";
    public static final String NORMAL_EXCHANGE    = "normal_exchange";

}
