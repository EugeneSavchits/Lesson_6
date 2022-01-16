package tests;

import Utils.Retry;
import baseEntities.BaseTest;
import core.ReadProperties;
import models.Project;
import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddProjectPage;
import pages.DashboardPage;
import pages.LoginPage;

public class SmokeTest extends BaseTest {



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

    @Test (retryAnalyzer = Retry.class)
    public void flakyLoginTest() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.getEmailField().sendKeys(ReadProperties.getUsername());
        loginPage.getPasswordField().sendKeys(ReadProperties.getPassword());
        loginPage.getLoginButton().click();

        DashboardPage dashboardPage = new DashboardPage(driver, true);

        Assert.assertTrue(dashboardPage.getAddProjectButton().isDisplayed());
    }

    @Test
    public void AddProject ()  {

        Project project = new Project();
        User user = new User()
                .setEmail(ReadProperties.getUsername())
                .setPassword(ReadProperties.getPassword());
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(user);
        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.getAddProjectButton().click();
        AddProjectPage addProjectPage = new AddProjectPage(driver);
        addProjectPage.addProject(project);
        Assert.assertTrue(driver.findElement(By.xpath("//*[. = '"+project.getNameProject()+"']")).isDisplayed());


    }

    @Test
    public void updateProject() {
        Project project = new Project();
        User user = new User()
                .setEmail(ReadProperties.getUsername())
                .setPassword(ReadProperties.getPassword());
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(user);
        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.getAddProjectButton().click();
        AddProjectPage addProjectPage = new AddProjectPage(driver);
        addProjectPage.addProject(project);
        driver.findElement(By.xpath("//*[. = '"+project.getNameProject()+"']")).click();
        driver.findElement(By.id("name")).sendKeys("12345");
        driver.findElement(By.id("accept")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[. = 'Successfully updated the project.']")).isDisplayed());
    }


    @Test
    public void delProject()  {
        Project project = new Project();
        User user = new User()
                .setEmail(ReadProperties.getUsername())
                .setPassword(ReadProperties.getPassword());
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(user);
        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.getAddProjectButton().click();
        AddProjectPage addProjectPage = new AddProjectPage(driver);
        addProjectPage.addProject(project);
        driver.findElement(By.id("navigation-admin")).click();
        driver.findElement(By.id("navigation-sub-projects")).click();
        driver.findElement(By.xpath("//*[. = '"+project.getNameProject()+"']/following::td[2]")).click();
        driver.findElement(By.xpath("//strong [. = 'Yes, delete this project (cannot be undone)']")).click();
        driver.findElement(By.xpath("//div[@id='deleteDialog']//a[@class = 'button button-ok button-left button-positive dialog-action-default']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[. = 'Successfully deleted the project.']")).isDisplayed());

    }
}
