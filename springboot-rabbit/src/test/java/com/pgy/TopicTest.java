package com.pgy;

import com.pgy.topic.TopicSend;
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
public class TopicTest {

    private static String[] routingArray = { "2.hello.2", "hello.2", "hello.to.hello", "", "null",
                                             "2hello", "hello2" };

    @Autowired
    private TopicSend topicSend;


    /**
     * Q1    hello*
     * Q2    hello#
     * 2.hello.2        Q1
     * hello.2          Q1 Q2
     * hello.to.hello   Q2
     * null             无
     * ""               无
     * 2hello           无
     * hello2           无
     */
    @Test
    public void testSendByRoutingKey() {

        for (String routing : routingArray) {
            topicSend.sendByRoutingKey(routing);
        }

    }

}