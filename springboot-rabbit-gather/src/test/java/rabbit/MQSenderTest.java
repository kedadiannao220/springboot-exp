package rabbit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author admin
 * @version V1.0 2018/6/22 admin Exp $
 * @description
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class MQSenderTest {

    @Autowired
    private MQSender mqSender;

    @Test
    public void testDirectSend() {
        //        mqSender.directSend(getJobMsgEvent());
        mqSender.directSendListT(getJobMsgEvent());
    }

    @Test
    public void testFanoutSend() {
        mqSender.fanoutSend(getJobMsgEvent());
    }

    @Test
    public void testTopicSend() {
        mqSender.topicSend(getJobMsgEvent(), "hello.to");
    }

    public static JobMsgEvent getJobMsgEvent() {
        JobMsgEvent jobMsgEvent = new JobMsgEvent();

        Map<String, Object> map = new HashMap<>(2);

        map.put("id", UUID.randomUUID().toString());

        jobMsgEvent.setHandlerType("JobInstanceCreateHandler");
        jobMsgEvent.setSender("MQSender");
        jobMsgEvent.setParam(map);
        return jobMsgEvent;
    }

}