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
public class DirectTest {

    @Autowired
    private DirectSend directSend;

    @Test
    public void directExchangeSend() {
        directSend.directExchangeSend();
    }

    /**
     * 1kw条数据
     */
    @Test
    public void directSend() {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 1000000; i++) {
            sb.append(UUID.randomUUID().toString());
            sb.append(",");
        }
        sb.deleteCharAt(sb.length()-1);
        String testStr = sb.toString();

        directSend.directSend(testStr);
    }

}