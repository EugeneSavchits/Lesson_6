package elements;

import org.openqa.selenium.*;
import utils.Waits;

import java.util.List;

public class UIElement implements WebElement {

    private final WebDriver driver;
    private  By by = null;
    private  WebElement webElement;
    private final Waits waits;

    public UIElement(WebDriver driver,By by){
        this.driver = driver;
        this.by = by;
        this.webElement = driver.findElement(by);
        this.waits = new Waits(driver);
    }


    public UIElement(WebDriver driver,WebElement webElement){
        this.driver = driver;
        this.webElement = webElement;
        this.waits = new Waits(driver);
    }

    @Override
    public void click() {
        try {
            webElement.click();
        }catch (ElementNotVisibleException ex) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", webElement);
            waits.waitForClickable(webElement);
            webElement.click();
        }
    }

    @Override
    public void submit() {
        webElement.submit();
    }

    @Override
    public void sendKeys(CharSequence... CharSequence) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", webElement);
        webElement.sendKeys(CharSequence);
    }

    @Override
    public void clear() {
        webElement.clear();

    }

    @Override
    public String getTagName() {
        return webElement.getTagName();
    }

    @Override
    public String getDomProperty(String name) {
        return WebElement.getDomProperty(name);
    }

    @Override
    public String getDomAttribute(String name) {
        return WebElement.getDomAttribute(name);
    }

    @Override
    public String getAttribute(String name) {
        return null;
    }

    @Override
    public String getAriaRole() {
        return WebElement.super.getAriaRole();
    }

    @Override
    public String getAccessibleName() {
        return WebElement.super.getAccessibleName();
    }

    @Override
    public boolean isSelected() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    @Override
    public String getText() {
        return null;
    }

    @Override
    public List<WebElement> findElements(By by) {
        return webElement.findElements(by);
    }

    @Override
    public WebElement findElement(By by) {
        return webElement.findElement(by);
    }


    @Override
    public boolean isDisplayed() {
        return false;
    }

    @Override
    public Point getLocation() {
        return null;
    }

    @Override
    public Dimension getSize() {
        return null;
    }

    @Override
    public Rectangle getRect() {
        return null;
    }

    @Override
    public String getCssValue(String propertyName) {
        return null;
    }

    @Override
    public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
        return null;
    }
}
