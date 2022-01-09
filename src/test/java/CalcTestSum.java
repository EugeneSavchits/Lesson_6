import org.testng.Assert;
import org.testng.annotations.Test;

public class CalcTestSum extends BaseTest {

    Calculator calc = new Calculator();

    @Test (description = "Тест сложения двух положительных чисел", priority = 1)
    public void testSum1 () {
        Assert.assertEquals(calc.sum(1, 2), 3, "Неверная сумма положительных чисел");
    }

    @Test (priority = 1)
    public void testSum2 () {
        Assert.assertEquals(calc.sum(1, -2), -1, "Неверная сумма положительного и отрицательного числа");
    }

    @Test (priority = 1)
    public void testSum3 () {
        Assert.assertEquals(calc.sum(-1, -2), -3, "Неверная сумма двух отрицательных чисел");
    }

    @Test (priority = 2, invocationCount = 16, threadPoolSize = 4)
    public void testSum4 () {
        Assert.assertEquals(calc.sum(5, 0), 5, "Неверная сумма сложения нуля и положительного числа");
    }

}
