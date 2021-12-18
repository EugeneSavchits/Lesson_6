package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Lesson_8_HW_xPath {

    static String URL = "https://www.microsoft.com/ru-ru/";

    @Test
    public void XPath()  {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL);


        WebElement absolutePath = driver.findElement(By.xpath("/html/body/div"));

        //Все элементы на странице начиная с html- тэга
        WebElement allElementsInHTMLPath = driver.findElement(By.xpath("//*"));

        //Элемент по тэгу
        WebElement bodyPath = driver.findElement(By.xpath("//body"));

        //Дочерний элемент относительно родителя
        WebElement childPath = driver.findElement(By.xpath("//button/span"));

        //Поиск элемента с аттрибутом и его значением
        WebElement tagWithAttrPath = driver.findElement(By.xpath("//a[@id='shellmenu_0']"));

        //Поиск родителя у элемента с аттрибутом и его значением
        WebElement parentPath1 = driver.findElement(By.xpath("//a[@id='shellmenu_0']/.."));
        WebElement parentPath2 = driver.findElement(By.xpath("//a[@id='shellmenu_0']/parent::li"));

        //Поиск элемента по индексу
        WebElement elementByIndexPath = driver.findElement(By.xpath("(//div)[20]"));

        //Поиск элемента по полному соответствию по тексту
        WebElement searchByTextPath = driver.findElement(By.xpath("//*[text() = 'Microsoft Store']"));
        WebElement searchByTextPath1 = driver.findElement(By.xpath("//*[. = 'Microsoft Store']"));

        //Поиск элемента по подстроке в тексте
        WebElement searchBySubstringPath = driver.findElement(By.xpath("//*[contains(text(), 'предприятий')]"));

        //Поиск элемента по аттрибуту значение которого начинается с
        WebElement searchByStartsWithPath = driver.findElement(By.xpath("//*[starts-with(@class, 'mectrl_pro')]"));

        //Использование логического оператора
        WebElement searchByTwoAttrPath = driver.findElement(By.xpath("//*[@class='c-uhff-link' and text() = 'Сведения о рекламе']"));

        //Использование логического оператора
        WebElement searchBySpecificAttrPath = driver.findElement(By.xpath("//input[@type != 'hidden']"));

        //Axes - Оси
        //Использование ancestor - все предки текущего узла
        WebElement path1 = driver.findElement(By.xpath("//*[@id='mectrl_headerPicture']/ancestor::a"));

        //Использование child - все предки текущего узла зависят от уровня
        WebElement path2_1 = driver.findElement(By.xpath("//li/child::a"));
        WebElement path2_2 = driver.findElement(By.xpath("//li/a"));           //аналог только проще

        //Использование descendant - все предки текущего узла не зависимо от уровня
        WebElement path3_1 = driver.findElement(By.xpath("//div/descendant::button"));
        WebElement path3_2 = driver.findElement(By.xpath("//div//button"));           //аналог только проще

        //Использование following - Выбирает всё в документе после закрытия тэга текущего узла
        WebElement path4_1 = driver.findElement(By.xpath("//div[@role='presentation' and @class='m-heading-4']/following::div"));
        WebElement path4_2 = driver.findElement(By.xpath("(//div[@role='presentation' and @class='m-heading-4']/following::div/*[@data-grid='col-6'])[2]"));

        //Использование following-sibling - Выбирает все узлы одного уровня после текущего узла
        WebElement path5_1 = driver.findElement(By.xpath("//div[@role='presentation' and @class='m-heading-4']/following-sibling::div"));


        //Использование preceding - Выбирает все узлы, которые появляются перед текущим узлом в документе
        WebElement path6_1 = driver.findElement(By.xpath("//div[@role='presentation' and @class='m-heading-4']/preceding::div"));

        //Использование preceding-sibling - Выбирает все узлы одного уровня до текущего узла
        WebElement path7_1 = driver.findElement(By.xpath("//div[@id='primaryR4']/preceding-sibling::div"));

        driver.quit();
    }
}

