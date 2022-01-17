package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HW_Actions extends BaseTest {

    @Test
    public void actionTest ()  {
        driver.get("http://the-internet.herokuapp.com/login");

        WebElement userName = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.className("radius"));


        Actions action = new Actions(driver);
        action
                .sendKeys(userName, "tomsmith")
                .sendKeys(password, "SuperSecretPassword!")
                .click(loginButton)
                .build()
                .perform();

        WebElement youLogged = driver.findElement(By.id("flash"));
        WebElement message = driver.findElement(By.xpath("//*[. = 'Welcome to the Secure Area. When you are done click logout below.']"));

        Assert.assertTrue(youLogged.isDisplayed());
        Assert.assertEquals(message.getText(), "Welcome to the Secure Area. When you are done click logout below.");

    }
}
