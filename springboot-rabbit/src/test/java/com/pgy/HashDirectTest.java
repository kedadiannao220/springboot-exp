package com.pgy;

import com.pgy.direct.DirectSend;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

/**
 * @author admin
 * @version V1.0 31/05/2018 admin Exp $
 * @description
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class HashDirectTest {

    @Autowired
    private DirectSend directSend;

    @Test
    public void directExchangeSend() {
        directSend.directExchangeSend();
    }

    @Test
    public void directSend() {
        int i = 5;
        while (i > 0) {
            String str = UUID.randomUUID().toString();
            directSend.hashMsgSender(str, str);
            i--;
        }

    }

}