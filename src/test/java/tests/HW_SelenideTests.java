package tests;


import baseEntity.BaseTest;
import models.Milestone;
import models.Project;
import models.TestCase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.AddMilestonePage;
import pages.AddProjectPage;
import pages.AddTestCasePage;
import pages.LoginPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class HW_SelenideTests extends BaseTest {

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
        open("/index.php?/admin/projects/add/1");
        addProject = new Project();
        addProject.setName("AAA_SEA");
        addProject.setAnnouncement("SEA_Announcement");


        AddProjectPage addProjectPage = new AddProjectPage();
        addProjectPage.addProject(addProject);
        $(By.xpath("//*[@class = 'message message-success']")).shouldBe(visible).shouldHave(text("Successfully added the new project."));
    }

    @Test(dependsOnMethods = "addProjectTest")
    public void addMilestonesTest() {
        open("/index.php?/dashboard");
        $(byText(addProject.getName())).click();
        $("#navigation-overview-addmilestones").click();

        addMilestone = new Milestone();
        addMilestone.setName("SEA_Milestone");
        addMilestone.setReferences("SEA_References");
        addMilestone.setDescription("SEA_Description");

        AddMilestonePage addMilestonePage = new AddMilestonePage();
        addMilestonePage.addMilestone(addMilestone);
        $(By.xpath("//*[@class = 'message message-success']")).shouldBe(visible).shouldHave(text("Successfully added the new milestone."));

    }

    @Test(dependsOnMethods = "addMilestonesTest")
    public void updateMilestoneTest() {
        $(byText(addMilestone.getName())).click();
        $(byText("Edit")).click();

        updateMilestone = new Milestone();
        updateMilestone.setName("Update_SEA_Milestone");
        updateMilestone.setReferences("Update_SEA_References");
        updateMilestone.setDescription("Update_SEA_Description");

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

        addTestCase = new TestCase();
        addTestCase.setTitle("SEA_TEST_CASE");
        addTestCase.setPreconditions("SEA_Preconditions");

        AddTestCasePage addTestCasePage = new AddTestCasePage();
        addTestCasePage.addTestCase(addTestCase);
        $(By.xpath("//*[@class = 'message message-success']")).shouldBe(visible);
        $(byText("Add another")).shouldBe(visible);

    }

    @Test(dependsOnMethods = "addTestCaseTest")
    public void updateTestCaseTest() {
        $(byText("Edit")).click();

        updateTestCase = new TestCase();
        updateTestCase.setTitle("UPDATE_SEA_TEST_CASE");
        updateTestCase.setPreconditions("UPDATE_SEA_Preconditions");

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