package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FileUploaderTest extends BaseTest {

    @Test public void fileUploaderTest () throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/upload");


        WebElement chooseFile = driver.findElement(By.id("file-upload"));
        WebElement uploadFile = driver.findElement(By.id("file-submit"));

        chooseFile.sendKeys("D:\\oboi-pogonia-gerb-wallpapers-pagonia-belarus-emblem-belarus.jpg");
        uploadFile.click();

        //Лучший вариант
        //Waits waits = new Waits(driver);
        //WebElement header = waits.waitForVisibility(By.xpath("//h3[. = 'File Uploaded!']"));
        //WebElement fileName = waits.waitForVisibility(By.id("uploaded-files"));



        WebElement header = driver.findElement(By.xpath("//h3[. = 'File Uploaded!']"));
        WebElement fileName = driver.findElement(By.id("uploaded-files"));

        Assert.assertTrue(header.isDisplayed());
        //Assert.assertTrue(header != null);
        Assert.assertEquals(fileName.getText(), "oboi-pogonia-gerb-wallpapers-pagonia-belarus-emblem-belarus.jpg");

    }
}
