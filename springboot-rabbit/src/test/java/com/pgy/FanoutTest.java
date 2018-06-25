package com.pgy;

import com.pgy.fanout.FanoutSend;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author admin
 * @version V1.0 2018/6/21 admin Exp $
 * @description
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class FanoutTest {

    @Autowired
    private FanoutSend fanoutSend;

    @Test
    public void test() {
        fanoutSend.send();
    }

    @Test
    public void testSendByRoutingKey() {
        fanoutSend.sendByRoutingKey();
    }

}