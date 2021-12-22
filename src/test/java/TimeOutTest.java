import org.testng.annotations.Test;

import java.util.List;

public class TimeOutTest {

    @Test (timeOut = 1000)
    public void timeOutTest () throws InterruptedException {
        Thread.sleep(1005);
    }
}
