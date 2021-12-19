package tests;

import baseEntities.BaseTest;
import core.ReadProperties;
import org.testng.annotations.Test;
import pages.LoginPage;

public class SmokeTest extends BaseTest {

    @Test
    public void loginTest () {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.getEmailField().sendKeys(ReadProperties.getUsername());
        loginPage.getPasswordField().sendKeys(ReadProperties.getPassword());
        loginPage.getLoginButton().click();

    }

    @Test
    public void loginTest1 () {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(ReadProperties.getUsername(), ReadProperties.getPassword());

    }


}
