import org.junit.Test;
import receive.RabbitReceive;

/**
 *
 * @author pengganyu
 * @version V1.0 08/08/2018 pengganyu Exp $
 */

public class ReceiveTest {


    @Test
    public void priorityReceive(){
        RabbitReceive rabbitReceive = new RabbitReceive();
        rabbitReceive.priorityReceive();
    }
}
