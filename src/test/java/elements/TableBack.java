package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

public class TableBack {
    private UIElement uiElement;

    public TableBack(WebDriver driver, By by){
        this.uiElement = new UIElement(driver, by);
    }

    public TableBack(WebDriver driver, WebElement webElement){
        this.uiElement = new UIElement(driver, webElement);
    }

    public UIElement getRow(int i){
        ArrayList<UIElement> list = uiElement.findUIElements(By.tagName("tr"));
        return list.get(i);
    }

    public void getRow(String text){

    }

    public void getColumn(int i){

    }

    public void getColumn(String header){

    }

    public UIElement getCell(int columnNumber, int rowNumber){
        UIElement row = getRow(rowNumber);
        ArrayList<UIElement> list = row.findUIElements(By.tagName("td"));

        return list.get(columnNumber);
    }

    public UIElement getElementFromCell (UIElement cellElement, By by){
        return cellElement.findElement(by);
    }
}
