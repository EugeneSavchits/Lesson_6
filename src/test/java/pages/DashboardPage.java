package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashboardPage extends BasePage {
    //Описание элементов страницы
    private By PAGE_OPENED_IDENTIFIER = By.id("navigation-dashboard");

    private By addProject_Selector = By.id("sidebar-projects-add");


    //Конструктор страницы
    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageOpened() {
        return super.isPageOpened(PAGE_OPENED_IDENTIFIER);
    }

    //Реализация гетерров элементов
    public WebElement getAddProjectButton() {
        return driver.findElement(addProject_Selector);
    }


    //Реализация базовых методов
    public void addProject() {
        getAddProjectButton().click();
    }
    public WebElement findProject (String nameProject) {
        return driver.findElement(By.xpath("//*[text() = '"+nameProject+"']"));
    }
       }
