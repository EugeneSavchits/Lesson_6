package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HW_JavaScriptExecutor extends BaseTest {

    @Test
    public void javaScriptExecutor()  {
        driver.get("http://the-internet.herokuapp.com/floating_menu#home");

        WebElement webElement = driver.findElement(By.xpath("//div[@style = 'text-align: center;']"));

        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("window.scrollTo(0,document.body.scrollHeight);");
        Assert.assertTrue(webElement.isDisplayed());

    }
}
