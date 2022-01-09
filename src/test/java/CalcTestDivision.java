import data.DataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;


public class CalcTestDivision extends BaseTest {
    Calculator calc = new Calculator();

    @Test ()
    public void testDivision1 () {
        Assert.assertEquals(calc.division(3, 5), 0.6, "Неверная сумма деления положительных чисел");
    }

    @Test ()
    public void testDivision2 () {
        Assert.assertEquals(calc.division(2, -4), -0.5, "Неверная сумма деления положительного и отрицательного числа");
    }

    @Test ()
    public void testDivision3 () {
        Assert.assertEquals(calc.division(-5, -2), 2.5, "Неверная сумма деления двух отрицательных чисел");
    }

    @Test (expectedExceptions = ArithmeticException.class)
    public void testDivision4 () {
        System.out.println(6/0);;
    }

    @Test (dataProvider = "dataForDivision", dataProviderClass = DataProvider.class, retryAnalyzer = Retry.class)
    public void testDivision5 (double a, double b, double expectedResult) {
        Assert.assertEquals(calc.division(a, b), expectedResult);
    }
}
