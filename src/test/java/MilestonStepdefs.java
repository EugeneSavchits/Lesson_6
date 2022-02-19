import baseEntities.ReadProperties;
import com.codeborne.selenide.Configuration;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.Milestone;
import models.Project;
import org.openqa.selenium.By;
import pages.AddMilestonePage;
import pages.AddProjectPage;
import pages.LoginPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MilestonStepdefs  {

    Project addProject;
    AddProjectPage addProjectPage;
    Milestone addMilestone;
    AddMilestonePage addMilestonePage;
    Milestone updateMilestone;
    AddMilestonePage updateMilestonePage;

    @Given("browser is open")
    public void browserIsOpen() {
        Configuration.baseUrl = ReadProperties.getUrl();
        Configuration.browser = ReadProperties.getBrowserName();
        Configuration.startMaximized = true;
    }

    @And("login page opened user logged in")
    public void loginPageIsOpen() {
        open("/");
        LoginPage loginPage = new LoginPage();
        loginPage.getUsernameField().setValue(ReadProperties.getUsername());

        loginPage.getPasswordField().val(ReadProperties.getPassword());
        loginPage.getLoginButton().click();
    }

    @Given("Add project page is opened")
    public void addProjectPageIsOpened() {
        open("/index.php?/admin/projects/add/1");
    }

    @When("name project {string}, announcement project {string}")
    public void nameProjectAnnouncementProject(String nameProject, String announcementProject) {
        addProject = new Project();
        addProject.setName(nameProject);
        addProject.setAnnouncement(announcementProject);


        addProjectPage = new AddProjectPage();
        addProjectPage.addProject(addProject);
    }

    @Then("message {string} is displayed")
    public void messageIsDisplayed(String messageProjectAdded) {
        addProjectPage.getMessageProjectAdded().shouldBe(visible).shouldHave(text(messageProjectAdded));
    }

    @Given("Add milestone page is opened")
    public void addMilestonePageIsOpened() {
        open("/index.php?/dashboard");
        $(byText("AAA_SEA")).click();
        $("#navigation-overview-addmilestones").click();
    }

    @When("name milestone {string}, references milestone {string}, description milestone {string}")
    public void nameMilestoneReferencesMilestoneDescriptionMilestone(String nameMilestone, String referencesMilestone, String descriptionMilestone) {
        addMilestone = new Milestone();
        addMilestone.setName(nameMilestone);
        addMilestone.setReferences(referencesMilestone);
        addMilestone.setDescription(descriptionMilestone);

        addMilestonePage = new AddMilestonePage();
        addMilestonePage.addMilestone(addMilestone);
    }

    @Then("message milestone {string} is displayed")
    public void messageMilestoneIsDisplayed(String messageMilestoneAdded) {
        addMilestonePage.getMessageMilestoneAdded().shouldBe(visible).shouldHave(text(messageMilestoneAdded));
    }

    @Given("Update milestone page is opened")
    public void updateMilestonePageIsOpened() {
        $(byText("SEA_Milestone")).click();
        $(byText("Edit")).click();
    }

    @When("update name milestone {string}, references milestone {string}, description milestone {string}")
    public void updateNameMilestoneReferencesMilestoneDescriptionMilestone(String updateNameMilestone, String updateReferences, String updateDescription) {
        updateMilestone = new Milestone();
        updateMilestone.setName(updateNameMilestone);
        updateMilestone.setReferences(updateReferences);
        updateMilestone.setDescription(updateDescription);

        updateMilestonePage = new AddMilestonePage();
        updateMilestonePage.updateMilestone(updateMilestone);
    }

    @Then("message update milestone {string} is displayed")
    public void messageUpdateMilestoneIsDisplayed(String messageMilestoneUpdate) {
        updateMilestonePage.getMessageMilestoneAdded().shouldBe(visible).shouldHave(text(messageMilestoneUpdate));
    }

    @Given("Milestone page is opened")
    public void milestonePageIsOpened() {
        $(byText("Update_SEA_Milestone")).click();
        $(byText("Edit")).click();
    }

    @When("delete milestone")
    public void deleteMilestone() {
        $(By.xpath("//*[@class = 'button button-negative button-delete']")).click();
        $(byText("Yes, delete this milestone (cannot be undone)")).click();
        $(By.xpath("//div[@id='deleteDialog']//a[@class = 'button button-ok button-left button-positive dialog-action-default']")).click();
    }

    @Then("message delete milestone {string} is displayed")
    public void messageDeleteMilestoneIsDisplayed(String messageMilestoneDelete) {
        $(By.xpath("//*[@class = 'message message-success']")).shouldBe(visible).shouldHave(text(messageMilestoneDelete));
    }
}
