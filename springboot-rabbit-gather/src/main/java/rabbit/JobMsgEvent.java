package rabbit;

import java.io.Serializable;
import java.util.Map;

/**
 * Job在传输过程当中的消息对象体
 * @author admin
 * @version V1.0 2018/6/21 admin Exp $
 */
public class JobMsgEvent implements Serializable {

    private static final long   serialVersionUID = -4246607809448592832L;

    /**
     * HandlerType，用于转发至对应的Handler进行业务处理
     */
    private String              handlerType;

    /**
     * 消息发送方 
     */
    private String              sender;

    /**
     * 参数列表
     * 经测试，可以支持100w条的uuid发送
     */
    private Map<String, Object> param;

    public String getHandlerType() {
        return handlerType;
    }

    public void setHandlerType(String handlerType) {
        this.handlerType = handlerType;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public Map<String, Object> getParam() {
        return param;
    }

    public void setParam(Map<String, Object> param) {
        this.param = param;
    }

    @Override
    public String toString() {
        return "rabbit.JobMsgEvent{" + "handlerType='" + handlerType + '\'' + ", sender='" + sender + '\''
               + ", param=" + param + '}';
    }
}
