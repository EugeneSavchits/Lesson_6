import baseEntities.BaseTest;
import baseEntities.ReadProperties;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.Project;
import pages.AddProjectPage;
import pages.LoginPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;

public class MilestonStepdefs extends BaseTest {

    Project addProject;
    AddProjectPage addProjectPage;

    @Given("browser is open")
    public void browserIsOpen() {

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
}
