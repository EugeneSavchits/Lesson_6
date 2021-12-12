package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class HomeWork_2_Css {
    static String URL = "https://babariko.vision/";

    @Test
    public void Css () throws InterruptedException {

        //НЕ МОГУ ТОЛЬКО ПОНЯТЬ ПОЧЕМУ ПРИ ЗАПУСКЕ ТЕСТА НЕ ОТКРЫВАЕТСЯ САЙТ, ХОТЯ В БРАУЗЕРЕ ВСЕ ОТКРЫВАЛОСЬ, ТЕСТ ЗАПУСТИЛ ПЕРВЫЙ РАЗ КОГДА УЖЕ ВСЕ СДЕЛАЛ!

        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL);
        Thread.sleep(5000);


        WebElement classSelector =driver.findElement(By.cssSelector(".l-section-slider")); // пойск по классу

        WebElement idSelector = driver.findElement(By.cssSelector("#page-header")); // пойск по ID

        WebElement tagSelector = driver.findElement(By.cssSelector("body")); // пойск по tag


        WebElement tagAttributeValueSelector =driver.findElement(By.cssSelector("header[id='page-header']")); // поиск по tag и атрибуту со значением

        WebElement tagAttributeSelector = driver.findElement(By.cssSelector("header[id]")); // поиск по tag и присутствием атрибута

        WebElement multipleClassesSelector =driver.findElement(By.cssSelector(".w-image.hide-for-not-sticky")); // поиск по двум классам в элементе

        WebElement simpleHierarchicalSelector = driver.findElement(By.cssSelector(".w-image.hide-for-not-sticky .attachment-full.size-full")); // поиск простого дочернего элемента

        WebElement fullHierarchicalSelector = driver.findElement(By.cssSelector("div .wpb_wrapper .attachment-full.size-full")); // использование трехуровневой иерархии для поиска дочернего элемента

        WebElement searchLikeContainsSelector = driver.findElement(By.cssSelector("img[src*='kupreeva']")); // поиск c вхождением подстроки в значении атрибута

        WebElement searchBYWordSelector = driver.findElement(By.cssSelector("div[style~='url(\"https://i.ytimg.com/vi/v7q_SKxNtW8/maxresdefault.jpg\");']")); // поиск c вхождением слова в значении атрибута

        WebElement valueStartsFromSelector = driver.findElement(By.cssSelector("a[class^='js']"));  // поиск элемента с аттрибутом значение которого начинается с...

        WebElement valueEndsWithSelector = driver.findElement(By.cssSelector("a[class$='toggle']"));  // поиск элемента с аттрибутом значение которого заканчивается на...

        WebElement childRightAfterParentsSelector = driver.findElement(By.cssSelector("svg>g")); // поиск дочернего g у которого родитель svg

        WebElement elementRightAfterElementSelector = driver.findElement(By.cssSelector("#menu-item-15474+li")); // поиск элемента c тэгом li который идет сразу после элемента #menu-item-15474 на том же уровне

        WebElement elementOnTheSameLevelSelector = driver.findElement(By.cssSelector("#menu-item-15474~#menu-item-8900")); // поиск элемента #menu-item-8900 которому предшевствует элемент #menu-item-15474 на томже уровне

        WebElement firstChildSelector =driver.findElement(By.cssSelector("ul:first-child")); //поиск первого дочерненго элемента с тэгом ul на одном уровне

        WebElement lastChildSelector = driver.findElement(By.cssSelector("ul:first-child")); //поиск последнего дочерненго элемента с тэгом ul на одном уровне

        WebElement nthChildFromBeginSelector =driver.findElement(By.cssSelector("li:nth-child(4)")); // поиск n-го дочернего элемента c начала на одном уровне

        WebElement nthChildFromEndSelector =driver.findElement(By.cssSelector("li:nth-last-child(6)")); // поиск n-го дочернего элемента с конца на одном уровне

        driver.quit();
    }
}
