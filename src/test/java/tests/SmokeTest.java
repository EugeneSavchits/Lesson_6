package tests;

import Utils.Retry;
import baseEntities.BaseTest;
import core.ReadProperties;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;

public class SmokeTest extends BaseTest {

    @Test
    public void loginTest() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.getEmailField().sendKeys(ReadProperties.getUsername());
        loginPage.getPasswordField().sendKeys(ReadProperties.getPassword());
        loginPage.getLoginButton().click();

        DashboardPage dashboardPage = new DashboardPage(driver, true);


        Assert.assertTrue(dashboardPage.getAddProjectButton().isDisplayed());
    }

    @Test (retryAnalyzer = Retry.class)
    public void flakyLoginTest() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.getEmailField().sendKeys(ReadProperties.getUsername());
        loginPage.getPasswordField().sendKeys(ReadProperties.getPassword());
        loginPage.getLoginButton().click();

        DashboardPage dashboardPage = new DashboardPage(driver, true);

        Assert.assertTrue(dashboardPage.getAddProjectButton().isDisplayed());
    }
}
