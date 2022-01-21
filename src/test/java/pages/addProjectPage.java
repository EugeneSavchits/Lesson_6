package pages;

import baseEntities.BasePage;
import enums.ProjectType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class addProjectPage extends BasePage {

    private static String ENDPOINT = "admin/projects/add/1";
    private static final By PAGE_OPENED_IDENTIFIER = By.id("accept");
    private static String typeRadioButtonSelector = "//*[@name = 'suite_mode' and @value='replace']";

    protected By nameProjectSelector = By.id("name");
    protected By announcementSelector = By.id("announcement");
    protected By isShowAnnouncementSelector = By.id("announcement");
    protected By isCompleted = By.id("is_completed");

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
