package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FrameTest extends BaseTest {

    @Test
    public void frameTest (){
        driver.get("https://the-internet.herokuapp.com/iframe");

        driver.switchTo().frame(0);
        Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "Your content goes here.");

        //driver.switchTo().frame(driver.findElement(By.id("mce_0_ifr")));

        //Assert.assertTrue(driver.findElement(By.id("tinymce")).isDisplayed());


    }
}
