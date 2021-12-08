package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeWork1 {

    static String URL = "https://kermi-fko.ru/raschety/Calc-Rehau-Solelec.aspx";
    static String URL2 = "https://masterskayapola.ru/kalkulyator/laminata.html";

    @Test
    public void homework_test1 () throws InterruptedException {
        String widthValue = "3";
        String lengthValue = "4";

        String expectedPower = "1680";
        String expectedSpecificPower = "140";

        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
        //1.Открыть браузер и перейти на тестируемую страницу
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL);

        //2. Ввести ширину пола
        WebElement width = driver.findElement(By.id("el_f_width"));
        width.sendKeys(widthValue);

        //3. Ввести длинну пола
        WebElement length = driver.findElement(By.id("el_f_lenght"));
        length.sendKeys(lengthValue);

        //4. Выбрать тип помещения
        WebElement typeRoom = driver.findElement(By.id("room_type"));
        Select roomDropDown = new Select(typeRoom);
        roomDropDown.selectByValue("3");

        //5. Выбрать тип обогрева
        WebElement typeHeating = driver.findElement(By.id("heating_type"));
        Select heatingDropDown = new Select(typeHeating);
        heatingDropDown.selectByValue("2");

        //6. Нажать Рассчитать
        WebElement calculate = driver.findElement(By.name("button"));
        calculate.click();

        //7.Получение актуальных результатов
        String actualPower = driver.findElement(By.id("floor_cable_power")).getAttribute("value");
        String actualSpecificPower = driver.findElement(By.id("spec_floor_cable_power")).getAttribute("value");

        //8. Сравнение актуальных и ожидаемых результато

        Assert.assertEquals(actualPower, expectedPower, "Мощности различны");
        Assert.assertEquals(actualSpecificPower, expectedSpecificPower, "Удельные мощности различны");


        Thread.sleep(5000);
        driver.quit();
    }
    @Test
    public void homework_test2 () throws InterruptedException {
        String lenghtValue = "6";
        String widthValue = "8";
        String lenghtPanelValue = "2000";
        String widthPanelValue = "200";
        String panelsPackageValue = "24";

        String expectedArea = "47.72 м2.";
        String expectedNumberPanels = "123 шт.";
        String expectedNumberPackages = "6 шт.";

        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
        //1.Открыть браузер и перейти на тестируемую страницу
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL2);

        //2. Ввести длинну помещения
        WebElement lenght = driver.findElement(By.name("calc_roomwidth"));
        lenght.clear();
        lenght.sendKeys(Keys.BACK_SPACE);
        lenght.sendKeys(Keys.BACK_SPACE);
        lenght.sendKeys(Keys.BACK_SPACE);
        lenght.sendKeys(Keys.BACK_SPACE);
        lenght.sendKeys(Keys.BACK_SPACE);
        lenght.sendKeys(lenghtValue);

        //3.Ввести ширину помещения
        WebElement width = driver.findElement(By.name("calc_roomheight"));
        width.clear();
        width.sendKeys(Keys.BACK_SPACE);
        width.sendKeys(Keys.BACK_SPACE);
        width.sendKeys(Keys.BACK_SPACE);
        width.sendKeys(Keys.BACK_SPACE);
        width.sendKeys(Keys.BACK_SPACE);
        width.sendKeys(widthValue);

        //4.Ввести длину панели ламината
        WebElement lenghtPanel = driver.findElement(By.name("calc_lamwidth"));
        lenghtPanel.clear();
        lenghtPanel.sendKeys(Keys.BACK_SPACE);
        lenghtPanel.sendKeys(Keys.BACK_SPACE);
        lenghtPanel.sendKeys(Keys.BACK_SPACE);
        lenghtPanel.sendKeys(Keys.BACK_SPACE);
        lenghtPanel.sendKeys(lenghtPanelValue);

        //5.Ввести ширину панели ламината
        WebElement widthPanel = driver.findElement(By.name("calc_lamheight"));
        widthPanel.clear();
        widthPanel.sendKeys(Keys.BACK_SPACE);
        widthPanel.sendKeys(Keys.BACK_SPACE);
        widthPanel.sendKeys(Keys.BACK_SPACE);
        widthPanel.sendKeys(widthPanelValue);

        //6. Ввести колличество панелей в упаковке
        WebElement panelsPackage = driver.findElement(By.name("calc_inpack"));
        panelsPackage.clear();
        panelsPackage.sendKeys(Keys.BACK_SPACE);
        panelsPackage.sendKeys(Keys.BACK_SPACE);
        panelsPackage.sendKeys(panelsPackageValue);

        //7. Нажать рассчитать
        WebElement calculate = driver.findElement(By.cssSelector("input[type = 'button']"));
        calculate.click();

        //8. Получение актуальных результатов
        String actualAreaRoom = driver.findElement(By.id("s_lam")).getText();
        String actualNumberPanels = driver.findElement(By.id("l_count")).getText();
        String actualNumberPackages = driver.findElement(By.id("l_packs")).getText();

        //9. Сравненение актуальных и ожидаемых результатов
        Assert.assertEquals(actualAreaRoom, expectedArea, "Площади комнаты различны");
        Assert.assertEquals(actualNumberPanels, expectedNumberPanels, "колличество панелей различно");
        Assert.assertEquals(actualNumberPackages, expectedNumberPackages, "колличество упаковок различно");

        Thread.sleep(5000);
        driver.quit();





    }
}
