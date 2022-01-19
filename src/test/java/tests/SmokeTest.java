package tests;

import Utils.Randomization;
import Utils.Retry;
import baseEntities.BaseTest;
import core.ReadProperties;
import models.Project;
import models.User;
import models.UserBuilder;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;

public class SmokeTest extends BaseTest {

    Project addProject;
    Project updateProject;

    @Test
    public void loginTest() {
        User user = new User()
                .setEmail(ReadProperties.getUsername())
                .setPassword(ReadProperties.getPassword());

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(user);

        DashboardPage dashboardPage = new DashboardPage(driver);
        Assert.assertTrue(dashboardPage.getAddProjectButton().isDisplayed());
    }

    @Test
    public void loginTestWithBuilder() {
        UserBuilder user = new UserBuilder.Builder()
                .withEmail(ReadProperties.getUsername())
                .withPassword(ReadProperties.getPassword())
                .build();

        LoginPage loginPage = new LoginPage(driver);
        //loginPage.login(user); //Поменять на класс UserBuilder в LoginPage

        DashboardPage dashboardPage = new DashboardPage(driver);
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

    private void setupProjects() {
        addProject = new Project();
        addProject.setName(Randomization.getRandomString(8));
        addProject.setTypeOfProject(Randomization.getRandomType());

        updateProject = new Project();
        updateProject.setName(Randomization.getRandomString(8));
        updateProject.setTypeOfProject(Randomization.getRandomType());
    }

}


