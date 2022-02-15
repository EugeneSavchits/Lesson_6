package steps;

import baseEntity.BaseCucumberTest;
import core.BrowsersService;
import core.ReadProperties;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.User;
import org.testng.Assert;
import pages.DashboardPage;
import pages.LoginPage;

public class FirstStepdefs extends BaseCucumberTest {
    LoginPage loginPage;

    @Given("открыт браузер")
    public void browserIsStarted() {
        driver = new BrowsersService().getDriver();
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    @When("страница логина открыта")
    public void loginPageIsOpened() {
        loginPage = new LoginPage(driver, true);
    }

    @Then("username field is displayed")
    public void usernameFieldIsDisplayed() {
        Assert.assertTrue(loginPage.getEmailField().isDisplayed());
    }

    @Given("user logged in")
    public void userLoggedIn() {
        User user = User.builder()
                .email(ReadProperties.getUsername())
                .password(ReadProperties.getPassword())
                .build();
        loginPage.login(user);
    }

    @When("user {string} with password {string} logged in")
    public void userWithPasswordLoggedIn(String username, String password) {
        loginPage.login(username, password);
    }

    @Then("add project button is displayed")
    public void addProjectButtonIsDisplayed() {
        DashboardPage dashboardPage = new DashboardPage(driver, false);
        Assert.assertTrue(dashboardPage.getAddProjectButton().isDisplayed());
    }

    @And("username is {string}")
    public void usernameIs(String username) {
        DashboardPage dashboardPage = new DashboardPage(driver, false);
        Assert.assertEquals(dashboardPage.getVisibleUsername(), username);
    }
}




















