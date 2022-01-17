package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ActionTest extends BaseTest {

    @Test
    public void actionTest1 () throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/drag_and_drop");

        WebElement source = driver.findElement(By.id("column-a"));
        WebElement target = driver.findElement(By.id("column-b"));
        Actions action = new Actions(driver);
        action
                .moveToElement(source)
                .clickAndHold()
                .moveToElement(target)
                .release()
                //.dragAndDrop(source, target)
                .build()
                .perform();

        Thread.sleep(5000);

//        public void DragAndDropJS(WebElement source, WebElement destination, WebDriver driver) {
//            JavascriptExecutor js = (JavascriptExecutor) driver;
//            js.executeScript("function createEvent(typeOfEvent) {\n"
//                    + "var event =document.createEvent(\"CustomEvent\");\n"
//                    + "event.initCustomEvent(typeOfEvent,true, true, null);\n"
//                    + "event.dataTransfer = {\n" + "data: {},\n" + "setData: function (key, value) {\n" + "this.data[key] = value;\n"
//                    + "},\n" + "getData: function (key) {\n"
//                    + "return this.data[key];\n" + "}\n" + "};\n" + "return event;\n" + "}\n" + "\n"
//                    + "function dispatchEvent(element, event,transferData) {\n" + "if (transferData !== undefined) {\n"
//                    + "event.dataTransfer = transferData;\n" + "}\n" + "if (element.dispatchEvent) {\n" + "element.dispatchEvent(event);\n"
//                    + "} else if (element.fireEvent) {\n" + "element.fireEvent(\"on\" + event.type, event);\n" + "}\n" + "}\n" + "\n"
//                    + "function simulateHTML5DragAndDrop(element, destination) {\n" + "var dragStartEvent =createEvent('dragstart');\n"
//                    + "dispatchEvent(element, dragStartEvent);\n" + "var dropEvent = createEvent('drop');\n"
//                    + "dispatchEvent(destination, dropEvent,dragStartEvent.dataTransfer);\n"
//                    + "var dragEndEvent = createEvent('dragend');\n"
//                    + "dispatchEvent(element, dragEndEvent,dropEvent.dataTransfer);\n" + "}\n" + "\n"
//                    + "var source = arguments[0];\n" + "var destination = arguments[1];\n"
//                    + "simulateHTML5DragAndDrop(source,destination);", source, destination);
//        }

    }

    @Test
    public void actionTest2 () throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/context_menu");

        WebElement target = driver.findElement(By.id("hot-spot"));

        Actions action = new Actions(driver);
        action
                //.moveToElement(target)
                .contextClick(target)
                .build()
                .perform();

        Thread.sleep(5000);
    }
}
