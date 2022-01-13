package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashboardPage extends BasePage {
    private static String ENDPOINT = "/dashboard";
    protected By PAGE_OPENED_IDENTIFIER = By.id("activityChart");

    protected By addProjectButtonSelector = By.id("sidebar-projects-add");

    public DashboardPage(WebDriver driver, boolean openPageByUrl) {
        super(driver, openPageByUrl);
    }

    @Override
    protected void openPage() {
        driver.get(BASE_URL+ENDPOINT);
    }

    public boolean isPageOpened() {
        return !super.isPageOpened(PAGE_OPENED_IDENTIFIER);
    }

    public WebElement getAddProjectButton() {
        return driver.findElement(addProjectButtonSelector);
    }

}
