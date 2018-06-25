package rabbit;

import java.io.Serializable;
import java.util.Map;

/**
 * 非job本身体系的消息传输对象，其他系统发消息时的对象
 * @author admin
 * @version V1.0 2018/6/21 admin Exp $
 */
public class BizMsgEvent implements Serializable {
    private static final long   serialVersionUID = -4246607809448592832L;

    /**
     * 消息发送方
     */
    private String              sender;

    /**
     * 参数列表
     * 经测试，可以支持100w条的uuid发送
     */
    private Map<String, Object> param;

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
        return "rabbit.BizMsgEvent{" + "sender='" + sender + '\'' + ", param=" + param + '}';
    }
}
