import data.StaticProvider;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CalcTest1 extends BaseTest {

    private Calculator calc = new Calculator("CalcTest1");

    @Test (description = "Test of Sum in my Calculator", groups = "smoke")
    public void testSum() {
        System.out.println("CalcTest1 -> testSum");
    }

    @Test
    public void testSum1() {
        System.out.println("CalcTest1 -> testSum1");
        Assert.assertEquals(calc.sum(2, 3), 6);
    }

    @Test (dataProvider = "dataForSum", dataProviderClass = StaticProvider.class)
    public void dataProviderTest(int a, int b, int expectedResult) {
        Assert.assertEquals(calc.sum(a, b), expectedResult);
    }
}
