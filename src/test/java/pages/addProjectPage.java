package pages;

import baseEntities.BasePage;
import enums.ProjectType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class addProjectPage extends BasePage {

    private static String ENDPOINT = "/dashboard"; // поменять надо
    private static final By PAGE_OPENED_IDENTIFIER = By.id("activityChart"); //поменять надо
    private static String typeRadioButtonSelector = "//*[@name = 'suite_mode' and @value='replace']";

    public addProjectPage(WebDriver driver) {
        super(driver);
    }

    public addProjectPage(WebDriver driver, boolean openPageByUrl) {
        super(driver, openPageByUrl);
    }

    @Override
    protected void openPage() {
        driver.get(BASE_URL+ENDPOINT);
    }

    @Override
    protected boolean isPageOpened() {
        return waits.waitForVisibility(PAGE_OPENED_IDENTIFIER).isDisplayed();
    }

    public void setType (ProjectType type) {
        driver.findElement(By.xpath(typeRadioButtonSelector.replace("replace", String.valueOf(type))));
    }
}
