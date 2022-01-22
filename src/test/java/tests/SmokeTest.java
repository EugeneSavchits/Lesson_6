package tests;

import Utils.Randomization;
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
import pages.ProjectViewPage;

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


    private void setupProjects() {
        addProject = new Project();
        addProject.setName(Randomization.getRandomString(10));
        addProject.setTypeOfProject(Randomization.getRandomType());
        addProject.setAnnouncement(Randomization.getRandomString(25));
        addProject.setShowAnnouncement(true);

        updateProject = new Project();
        updateProject.setName(Randomization.getRandomString(15));
        updateProject.setTypeOfProject(Randomization.getRandomType());
        updateProject.setAnnouncement(Randomization.getRandomString(25));
    }

    @Test (dependsOnMethods = "loginTest")
    public void addProjectTest () {
        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.getAddProjectButton().click();
        AddProjectPage addProjectPage = new AddProjectPage(driver);
        setupProjects();
        addProjectPage.addProject(addProject);
        Assert.assertNotNull(driver.findElement(By.xpath("//*[. = '"+addProject.getName()+"']")));
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class = 'message message-success']")).isDisplayed());
    }

    @Test (dependsOnMethods = "addProjectTest")
    public void updateProjectTest ()  {
        ProjectViewPage projectViewPage = new ProjectViewPage(driver, true);
        projectViewPage.getOpenCurrentProject(addProject).click();
        projectViewPage.updateProject(addProject, updateProject);
        Assert.assertNotNull(driver.findElement(By.xpath("//*[. = '"+updateProject.getName()+"']")));
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class = 'message message-success']")).isDisplayed());
    }

    @Test (dependsOnMethods = "updateProjectTest")
    public void deleteProjectTest () {
        ProjectViewPage projectViewPage = new ProjectViewPage(driver, true);
        projectViewPage.deleteProject(updateProject);
        Assert.assertEquals(driver.findElement(By.xpath("//*[@class = 'message message-success']")).getText(), "Successfully deleted the project.");
    }
}


