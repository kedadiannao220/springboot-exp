package com.pgy;

import com.pgy.direct.DirectSend;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author admin
 * @version V1.0 31/05/2018 admin Exp $
 * @description
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class DlxTest {

    @Autowired
    private DirectSend directSend;

    @Test
    public void ttlDlxTest() {
        directSend.ttlSend("hello ttl && dlx");

        // 由于设置message ttl为10s，所以设置Test线程停留11s，保证dlx queue可以收到消息
        try {
            Thread.sleep(11000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}