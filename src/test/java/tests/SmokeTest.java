package tests;

import baseEntities.BaseTest;
import core.ReadProperties;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddProjectPage;
import pages.DashboardPage;
import pages.LoginPage;

public class SmokeTest extends BaseTest {


    @Test
    public void loginTest() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(ReadProperties.getUsername(), ReadProperties.getPassword());

    }

    @Test
    public void addProjectTest() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(ReadProperties.getUsername(), ReadProperties.getPassword());

        DashboardPage dashboardPage = new DashboardPage(driver);

        dashboardPage.addProject();

        AddProjectPage addProjectPage = new AddProjectPage(driver);

        addProjectPage.addProjectFinal("sea", "announcement");

        String message = driver.findElement(By.cssSelector(".message.message-success")).getText();

        Assert.assertEquals(message, "Successfully added the new project.", "Проект не добавлен");
    }

    @Test
    public void findProjectTest()  {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(ReadProperties.getUsername(), ReadProperties.getPassword());

        DashboardPage dashboardPage = new DashboardPage(driver);

        dashboardPage.findProject("123").click();

        String openProject = driver.findElement(By.id("navigation-project")).getText();

        Assert.assertEquals(openProject, "123", "Проект не найден");


    }

}
