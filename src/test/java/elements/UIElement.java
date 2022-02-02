package elements;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import utils.Waits;

import java.util.ArrayList;
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
        public void sendKeys(CharSequence... charSequences) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", webElement);
        webElement.sendKeys(charSequences);
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
    public String getAttribute(String name) {
        return webElement.getAttribute(name);
    }

    @Override
    public boolean isSelected() {
        return webElement.isSelected();
    }

    @Override
    public boolean isEnabled() {
        return webElement.isEnabled();
    }

    @Override
    public String getText() {
        return webElement.getText();
    }

    @Override
    public List<WebElement> findElements(By by){
        return null;
    }


    public ArrayList<UIElement> findUIElements(By by) {
        ArrayList<UIElement> list = new ArrayList<>();
        for (WebElement element : webElement.findElements(by)) {
            list.add(new UIElement(driver, element));
        }
        return list;
    }

    @Override
    public UIElement findElement(By by) {
        return new UIElement(driver, webElement.findElement(by));
    }

    @Override
    public boolean isDisplayed() {
        return webElement.isDisplayed();
    }

    @Override
    public Point getLocation() {
        return webElement.getLocation();
    }

    @Override
    public Dimension getSize() {
        return webElement.getSize();
    }

    @Override
    public Rectangle getRect() {
        return webElement.getRect();
    }

    @Override
    public String getCssValue(String propertyName) {
        return webElement.getCssValue(propertyName);
    }

    @Override
    public <X> X getScreenshotAs(OutputType<X> outputType) throws WebDriverException {
        return webElement.getScreenshotAs(outputType);
    }

    public void DoubleClick () {
        new Actions(driver)
                .doubleClick()
                .build()
                .perform();
    }

}
