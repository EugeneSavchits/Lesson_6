package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    private static String ENDPOINT = "/auth/login";

    protected By PAGE_OPENED_IDENTIFIER = By.id("button_primary");

    @FindBy(id = "name")
    public WebElement emailField;

    @FindBy(id = "password")
    public WebElement passwordField;

    @FindBy(id = "button_primary")
    public WebElement loginButton;



    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void openPage() {
        driver.get(BASE_URL+ENDPOINT);
    }

    public boolean isPageOpened() {
        return !super.isPageOpened(PAGE_OPENED_IDENTIFIER);
    }

}
