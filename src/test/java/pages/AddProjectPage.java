package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddProjectPage extends BasePage {
    //Описание элементов страницы
    private By PAGE_OPENED_IDENTIFIER = By.cssSelector(".content-header-title.page_title");

    private By name_Selector = By.id("name");
    private By announcement_Selector = By.id("announcement");
    private By use_Selector = By.id("suite_mode_single_baseline");
    private By add_Selector = By.id("accept");

    //Конструктор страницы
    public AddProjectPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageOpened (){
        return super.isPageOpened(PAGE_OPENED_IDENTIFIER);
    }

    //Реализация гетерров элементов
    public WebElement getNameField () {
        return driver.findElement(name_Selector);
    }

    public WebElement getAnnouncementField () {
        return driver.findElement(announcement_Selector);
    }

    public WebElement getUseField () {
        return driver.findElement(use_Selector);
    }

    public WebElement getAddButton () {
        return driver.findElement(add_Selector);
    }

    //Реализация базовых методов
    public void addProjectFinal (String nameProject, String announcement) {
        getNameField().sendKeys(nameProject);
        getAnnouncementField().sendKeys(announcement);
        getUseField().click();
        getAddButton().click();
    }
}
