import org.testng.Assert;
import org.testng.annotations.Test;

public class CalcTestMultiplication extends BaseTest {
    
    Calculator calc = new Calculator();

    @Test(priority = 1)
    public void testMultiplication1 () {
        Assert.assertEquals(calc.multiplication(2, 2), 4, "Неверная сумма умножения положительных чисел");
    }

    @Test (priority = 2)
    public void testMultiplication2 () {
        Assert.assertEquals(calc.multiplication(3, -5), -15, "Неверная сумма умножения положительного и отрицательного числа");
    }

    @Test (priority = 1)
    public void testMultiplication3 () {
        Assert.assertEquals(calc.multiplication(-3, -2), 6, "Неверная сумма умножения двух отрицательных чисел");
    }

    @Test (priority = 2)
    public void testMultiplication4 () {
        Assert.assertEquals(calc.multiplication(5, 0), 0, "Неверная сумма умножения нуля и положительного числа");
    }
}
