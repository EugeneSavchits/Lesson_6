package steps;

import baseEntity.BaseCucumberTest;
import io.cucumber.java.en.Given;

public class SecondStepdefs extends BaseCucumberTest {
    private BaseCucumberTest baseCucumberTest;

    public SecondStepdefs(BaseCucumberTest baseCucumberTest) {
        this.baseCucumberTest = baseCucumberTest;
    }

    @Given("browser is started")
    public void browserIsStarted() {
    }
}
