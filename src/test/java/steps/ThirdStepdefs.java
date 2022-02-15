package steps;

import baseEntity.BaseCucumberTest;
import io.cucumber.java.en.When;
import pages.LoginPage;

public class ThirdStepdefs extends BaseCucumberTest {
    private BaseCucumberTest baseCucumberTest;

    public ThirdStepdefs(BaseCucumberTest baseCucumberTest) {
        this.baseCucumberTest = baseCucumberTest;
    }

    @When("login page is opened")
    public void loginPageIsOpened() {
        LoginPage loginPage = new LoginPage(baseCucumberTest.driver, true);
    }
}














