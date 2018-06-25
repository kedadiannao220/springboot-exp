package com.pgy.direct;

import java.util.Map;

/**
 * @author admin
 * @version V1.0 2018/6/22 admin Exp $
 */
public class JobMsgEvent {
    private String              handleType;
    private Map<String, Object> param;

    public String getHandleType() {
        return handleType;
    }

    public void setHandleType(String handleType) {
        this.handleType = handleType;
    }

    public Map<String, Object> getParam() {
        return param;
    }

    public void setParam(Map<String, Object> param) {
        this.param = param;
    }

    @Override
    public String toString() {
        return "JobMsgEvent{" + "handleType='" + handleType + '\'' + ", param=" + param + '}';
    }
}
