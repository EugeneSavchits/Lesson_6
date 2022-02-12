package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private final By username_selector = By.id("name"); //поиск через By
    private final String password_selector = "#password";// поиск через CSS сеоектор тогда можно как String
    private final String login_button_selector = "#button_primary";

    public SelenideElement getUsernameField() {
        return $(username_selector);
    }
    public SelenideElement getPasswordField() {
        return $(password_selector);
    }
    public SelenideElement getLoginButton() {
        return $(login_button_selector);
    }
}