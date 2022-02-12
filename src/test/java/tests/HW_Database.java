package tests;


import baseEntity.BaseTest;
import dbEntries.MilestoneTable;
import dbEntries.ProjectsTable;
import dbEntries.TestCaseTable;
import models.Milestone;
import models.Project;
import models.TestCase;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.AddMilestonePage;
import pages.AddProjectPage;
import pages.AddTestCasePage;
import pages.LoginPage;

import java.sql.ResultSet;
import java.sql.SQLException;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class HW_Database extends BaseTest {

    public static Logger logger = Logger.getLogger(HW_Database.class);

    Project addProject;
    Milestone addMilestone;
    Milestone updateMilestone;
    TestCase addTestCase;
    TestCase updateTestCase;

    @Test
    public void loginTest() {

        open("/");

        LoginPage loginPage = new LoginPage();
        loginPage.getUsernameField().setValue(username);

        loginPage.getPasswordField().val(password);
        loginPage.getLoginButton().click();

        $(".page_title").shouldBe(visible).shouldHave(text("All Projects"));
    }

    @Test(dependsOnMethods = "loginTest")
    public void addProjectTest() {

        ProjectsTable projectsTable = new ProjectsTable(dataBaseService);

        projectsTable.createTable();
        projectsTable.addProject("AAA_SEA", "SEA_Announcement");

        String nameProject = null;
        String announcement = null;

        ResultSet rs = projectsTable.getProjectByID(1);

        try {
            while (rs.next()) {
                nameProject = rs.getString("project");
                announcement = rs.getString("announcement");

                logger.info("nameProject: " + nameProject);
                logger.info("lastname: " + announcement);
            }
        } catch (SQLException e) {
            logger.error(e.toString());
        }
        projectsTable.dropTable();

        open("/index.php?/admin/projects/add/1");
        addProject = new Project();
        addProject.setName(nameProject);
        addProject.setAnnouncement(announcement);


        AddProjectPage addProjectPage = new AddProjectPage();
        addProjectPage.addProject(addProject);
        $(By.xpath("//*[@class = 'message message-success']")).shouldBe(visible).shouldHave(text("Successfully added the new project."));
    }

    @Test(dependsOnMethods = "addProjectTest")
    public void addMilestonesTest() {
        open("/index.php?/dashboard");
        $(byText(addProject.getName())).click();
        $("#navigation-overview-addmilestones").click();

        MilestoneTable milestoneTable = new MilestoneTable(dataBaseService);

        milestoneTable.createTable();
        milestoneTable.addMilestone("SEA_Milestone", "SEA_References", "SEA_Description");
        milestoneTable.addMilestone("UPDATE_SEA_Milestone", "UPDATE_SEA_References", "UPDATE_SEA_Description");

        String nameMilestone = null;
        String reference = null;
        String description = null;

        ResultSet rs = milestoneTable.getMilestoneByID(1);

        try {
            while (rs.next()) {
                nameMilestone = rs.getString("milestone");
                reference = rs.getString("reference");
                description = rs.getString("description");

                logger.info("nameMilestone: " + nameMilestone);
                logger.info("reference: " + reference);
                logger.info("description: " + description);
            }
        } catch (SQLException e) {
            logger.error(e.toString());
        }

        addMilestone = new Milestone();
        addMilestone.setName(nameMilestone);
        addMilestone.setReferences(reference);
        addMilestone.setDescription(description);

        AddMilestonePage addMilestonePage = new AddMilestonePage();
        addMilestonePage.addMilestone(addMilestone);
        $(By.xpath("//*[@class = 'message message-success']")).shouldBe(visible).shouldHave(text("Successfully added the new milestone."));

    }

    @Test(dependsOnMethods = "addMilestonesTest")
    public void updateMilestoneTest() {
        $(byText(addMilestone.getName())).click();
        $(byText("Edit")).click();

        MilestoneTable milestoneTable = new MilestoneTable(dataBaseService);

        String nameMilestone = null;
        String reference = null;
        String description = null;

        ResultSet rs = milestoneTable.getMilestoneByID(2);

        try {
            while (rs.next()) {
                nameMilestone = rs.getString("milestone");
                reference = rs.getString("reference");
                description = rs.getString("description");

                logger.info("nameMilestone: " + nameMilestone);
                logger.info("reference: " + reference);
                logger.info("description: " + description);
            }
        } catch (SQLException e) {
            logger.error(e.toString());
        }

        milestoneTable.dropTable();

        updateMilestone = new Milestone();
        updateMilestone.setName(nameMilestone);
        updateMilestone.setReferences(reference);
        updateMilestone.setDescription(description);

        AddMilestonePage updateMilestonePage = new AddMilestonePage();
        updateMilestonePage.updateMilestone(updateMilestone);
        $(By.xpath("//*[@class = 'message message-success']")).shouldBe(visible).shouldHave(text("Successfully updated the milestone."));
    }

    @Test(dependsOnMethods = "updateMilestoneTest")
    public void deleteMilestoneTest() {
        $(byText(updateMilestone.getName())).click();
        $(byText("Edit")).click();
        $(By.xpath("//*[@class = 'button button-negative button-delete']")).click();
        $(byText("Yes, delete this milestone (cannot be undone)")).click();
        $(By.xpath("//div[@id='deleteDialog']//a[@class = 'button button-ok button-left button-positive dialog-action-default']")).click();
        $(By.xpath("//*[@class = 'message message-success']")).shouldBe(visible).shouldHave(text("Successfully deleted the milestone."));

    }

    @Test(dependsOnMethods = "deleteMilestoneTest")
    public void addTestCaseTest() {
        open("/index.php?/dashboard");
        $(byText(addProject.getName())).click();
        $("#sidebar-cases-add").click();

        TestCaseTable testCaseTable = new TestCaseTable(dataBaseService);

        testCaseTable.createTable();
        testCaseTable.addTestcase("SEA_TEST_CASE", "SEA_Preconditions");
        testCaseTable.addTestcase("UPDATE_SEA_TEST_CASE", "UPDATE_SEA_Preconditions");

        String title = null;
        String preconditions = null;

        ResultSet rs = testCaseTable.getMilestoneByID(1);

        try {
            while (rs.next()) {
                title = rs.getString("title");
                preconditions = rs.getString("preconditions");


                logger.info("titleTestCase: " + title);
                logger.info("preconditions: " + preconditions);
            }
        } catch (SQLException e) {
            logger.error(e.toString());
        }


        addTestCase = new TestCase();
        addTestCase.setTitle(title);
        addTestCase.setPreconditions(preconditions);

        AddTestCasePage addTestCasePage = new AddTestCasePage();
        addTestCasePage.addTestCase(addTestCase);
        $(By.xpath("//*[@class = 'message message-success']")).shouldBe(visible);
        $(byText("Add another")).shouldBe(visible);

    }

    @Test(dependsOnMethods = "addTestCaseTest")
    public void updateTestCaseTest() {
        $(byText("Edit")).click();

        TestCaseTable testCaseTable = new TestCaseTable(dataBaseService);

        String title = null;
        String preconditions = null;

        ResultSet rs = testCaseTable.getMilestoneByID(2);

        try {
            while (rs.next()) {
                title = rs.getString("title");
                preconditions = rs.getString("preconditions");


                logger.info("titleTestCase: " + title);
                logger.info("preconditions: " + preconditions);
            }
        } catch (SQLException e) {
            logger.error(e.toString());
        }

        testCaseTable.dropTable();

        updateTestCase = new TestCase();
        updateTestCase.setTitle(title);
        updateTestCase.setPreconditions(preconditions);

        AddTestCasePage updateTestCasePage = new AddTestCasePage();
        updateTestCasePage.updateTestCase(updateTestCase);
        $(By.xpath("//*[@class = 'message message-success']")).shouldBe(visible).shouldHave(text("Successfully updated the test case."));
    }

    @Test(dependsOnMethods = "updateTestCaseTest")
    public void deleteTestCaseTest() {
        $(byText("Edit")).click();
        $(byText("Delete this test case")).click();
        $(By.xpath("//a[@class = 'button button-left button-ok button-positive dialog-action-default' and @onclick = 'this.blur(); App.Cases.confirmDeletion(false, false); return false;']")).click();
        $(By.xpath("//*[@class = 'message message-success']")).shouldBe(visible).shouldHave(text("Successfully flagged the test case as deleted."));
    }

    @Test(dependsOnMethods = "deleteTestCaseTest")
    public void deleteProject(){
        open("/index.php?/admin/projects/overview");
        $(By.xpath("//*[. = '"+addProject.getName()+"']/following::td[2]")).click();
        $(By.xpath("//strong [. = 'Yes, delete this project (cannot be undone)']")).click();
        $(By.xpath("//div[@id='deleteDialog']//a[@class = 'button button-ok button-left button-positive dialog-action-default']")).click();
        $(By.xpath("//*[@class = 'message message-success']")).shouldBe(visible).shouldHave(text("Successfully deleted the project."));
    }
}