import org.junit.Test;
import sender.RabbitSender;

/**
 *
 * @author pengganyu
 * @version V1.0 08/08/2018 pengganyu Exp $
 */

public class SenderTest {

    @Test
    public void sendPriorityMsg() {
        RabbitSender rabbitSender = new RabbitSender();

        for (int i = 0; i <= 10; i++) {
            rabbitSender.sendPriorityMsg("hello priority " + i + " msg", i);
        }
    }
}
