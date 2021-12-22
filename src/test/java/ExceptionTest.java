import org.testng.annotations.Test;

import java.util.List;

public class ExceptionTest {

    Calculator calc = new Calculator("ExceptionTest");

    @Test (expectedExceptions = NullPointerException.class)
    public void testNPE () {
        List list = null;
        System.out.println(list.size());
    }
}
