package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class CSSSelector {


    private void cssSelector () {
        By classSelector = By.cssSelector(".radio"); // пойск по классу radio
        By classSelector1 = By.className("radio"); // поиск по названию класса одинаковые с первым

        By idSelector = By.cssSelector("#suite_mode_single"); // пойск по ID
        By idSelector1 = By.id("suite_mode_single"); // поиск по ID

        By tagSelector = By.cssSelector("label"); // пойск по tag
        By tagSelector1 = By.tagName("label"); // поиск по tag

        By tagAttributSelector = By.cssSelector("label[for='name']"); // поиск по tag и атрибуту со значением
        By tagAttributSelector1 = By.cssSelector("label[for]"); // поиск по tag и атрибуту без значением

        By multipleClassesSelector = By.cssSelector(".column.overflow-content"); // поиск по двум классам в элементе

        By simpleHierarchicalSelector = By.cssSelector(".table .content-inner"); // поиск простого дочернего элемента

        By fullHierarchicalSelector = By.cssSelector("body .table .content-inner"); // использование трехуровневой иерархии для поиска дочернего элемента

        By searchLikeContainsSelector = By.cssSelector("form[action*='admin']"); // поиск c вхождением подстроки в значении атрибута
        By searchBYWordSelector = By.cssSelector("form[action~='admin']"); // поиск c вхождением слова в значении атрибута

        By valueStartsFromSelector = By.cssSelector ("a[href^='https://']");  // поиск элемента с аттрибутом значение которого начинается с...

        By valueEndsWithSelector = By.cssSelector ("a[href$='@gmail.com']");  // поиск элемента с аттрибутом значение которого заканчивается на...

        By childRightAfterParentsSelector = By.cssSelector("ul>li"); // поиск дочернего li у которого родитель ul

        By elementRightAfterElementSelector = By.cssSelector("#form+script"); // поиск элемента script который идет сразу после элемента #form на том же уровне
        By elementOnTheSameLevelSelector = By.cssSelector("#form~script"); // поиск элементов script которым предшевствует элемент #form на том же уровне

        By firstChildSelector = By.cssSelector("li:first-child"); //поиск первого дочерненго элемента с тэгом li на одном уровне
        By lastChildSelector = By.cssSelector("li:last-child"); //поиск последнего дочерненго элемента с тэгом li на одном уровне

        By nthChildFromBeginSelector = By.cssSelector("li:nth-child(2)"); // поиск эннего дочернего элемента c начала с тэгом li на одном уровне
        By nthlastChildSelector = By.cssSelector("li:nth-last-child(3)"); // поиск эннего дочернего элемента с конца с тэгом li на одном уровне















    }
}
