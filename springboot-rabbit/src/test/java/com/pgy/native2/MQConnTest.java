package com.pgy.native2;

import org.junit.Test;

import java.io.IOException;

/**
 *
 * @author pengganyu
 * @version V1.0 2018/7/24 pengganyu Exp $
 */
public class MQConnTest {

    //    @Test
    public void test() {
        MQConn mqConn = new MQConn();
        mqConn.send();
    }

    @Test
    public void testSendPriority() throws IOException {
        MQConn mqConn = new MQConn();
        mqConn.sendPriority();
    }

    @Test
    public void testReceive() {
        MQConn mqConn = new MQConn();
        mqConn.receive();
    }

}