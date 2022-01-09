import data.DataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CalcTestDifference extends BaseTest {
    Calculator calc = new Calculator();

    @Test(priority = 1)
    public void testDifference1 () {
        Assert.assertEquals(calc.difference(3, 5), -2, "Неверная сумма вычитания положительных чисел");
    }

    @Test (priority = 2)
    public void testDifference2 () {
        Assert.assertEquals(calc.difference(1, -2), 3, "Неверная сумма вычитания положительного и отрицательного числа");
    }

    @Test (priority = 1)
    public void testDifference3 () {
        Assert.assertEquals(calc.difference(-1, -3), 2, "Неверная сумма вычитания двух отрицательных чисел");
    }

    @Test (priority = 2, dataProvider = "dataForDifference", dataProviderClass = DataProvider.class)
    public void testDifference4 (int a, int b, int expectedResult) {
        Assert.assertEquals(calc.difference(a, b), expectedResult);
    }
}
