package pages;

import baseEntity.BasePage;
import elements.Button;
import elements.Input;
import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private static final By PAGE_OPENED_IDENTIFIER = By.id("button_primary");
    private static String ENDPOINT = "/index.php?/auth/login";
    protected By emailSelector = By.id("name");
    protected By passwordSelector = By.id("password");
    protected By loginSelector = By.id("button_primary");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void openPage() {
        driver.get(BASE_URL + ENDPOINT);
    }

    @Override
    protected boolean isPageOpened() {
        return waits.waitForVisibility(PAGE_OPENED_IDENTIFIER).isDisplayed();
    }

    public Input getEmailField() {
        return new Input(driver, emailSelector);
    }

    public Input getPasswordField() {
        return new Input(driver, passwordSelector);
    }

    public Button getLoginButton() {
        return new Button(driver, loginSelector);
    }

    public void login(User user) {
        getEmailField().sendKeys(user.getEmail());
        getPasswordField().sendKeys(user.getPassword());
        getLoginButton().click();
    }
}
