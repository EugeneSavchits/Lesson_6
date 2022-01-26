package tests.gui;

import baseEntities.BaseTest;
import models.Milestone;
import models.Project;
import models.User;
import org.testng.annotations.Test;
import pages.LoginPage;

public class MilestoneTests extends BaseTest {

    @Test
    public void test1() {
        Project project = new Project();
        User user = User.builder().build();
        Milestone milestone = new Milestone();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(user);


        projectSteps.addProject(project);
        milestoneSteps.createMilestone(project, milestone);

    }
}
