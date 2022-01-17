package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Waits;


public class HW_WaitsTest extends BaseTest {

    @Test
    public void WaitsTest () {
        driver.get("http://the-internet.herokuapp.com/dynamic_loading/1");

        Waits waits = new Waits(driver,5);

        driver.findElement(By.tagName("button")).click();
        Assert.assertTrue(waits.waitForVisibility(By.id("loading")).isDisplayed());
        Assert.assertTrue(waits.waitForVisibility(By.xpath("//*[. = 'Hello World!']")).isDisplayed());
    }
}
