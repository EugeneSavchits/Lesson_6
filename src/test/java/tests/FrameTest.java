package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FrameTest extends BaseTest {

    @Test
    public void frameTest (){
        driver.get("https://the-internet.herokuapp.com/iframe");

        //driver.switchTo().frame(0);// поиск по номеру фрейма
        //driver.switchTo().frame(driver.findElement(By.id("mce_0_ifr"))); //пойск как вебэлемент
        driver.switchTo().frame("mce_0_ifr"); //поиск по имени фрейма лиюо по ID

        Assert.assertTrue(driver.findElement(By.id("tinymce")).isDisplayed());

        //driver.switchTo().parentFrame(); //возврат к родительскому фрейму на уровень выше
        //driver.switchTo().defaultContent(); //возврат на главнуую страницу


    }
}
