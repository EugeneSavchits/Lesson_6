package baseEntities;

import Utils.Waits;
import org.openqa.selenium.WebDriver;

public class BaseStep {
    protected WebDriver driver;
    protected Waits waits;

    public BaseStep(WebDriver driver) {
        this.driver = driver;
        this.waits = new Waits(driver);
    }
}
