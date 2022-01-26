package Utils;

import baseEntities.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult tr) {
        Object currentClass = tr.getInstance();
        try {
            WebDriver driver = ((BaseTest) currentClass).driver;
            byte[] srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            saveScreenshot(srcFile);
        } catch (Exception ex) {

        }
    }
}
