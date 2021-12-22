
import org.testng.Assert;
import org.testng.annotations.Test;



public class CalcTest extends BaseTest {
    Calculator cal = new Calculator("CalcTest");

    //@Test (invocationCount = 3, invocationTimeOut = 1000)
    @Test (invocationCount = 6, threadPoolSize = 3)
    public void invocationTest () throws InterruptedException {
        Thread.sleep(250);
        Assert.assertEquals(cal.sum(2,3), 5);
    }

    @Test (enabled = false)
    public void testSum() {
        System.out.println("CalcTest -> testSum");
    }
}
