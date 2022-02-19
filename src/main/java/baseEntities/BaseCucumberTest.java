package baseEntities;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeSuite;

public class BaseCucumberTest {

    @BeforeSuite
    public void setup() {
        Configuration.baseUrl = ReadProperties.getUrl();
        Configuration.browser = ReadProperties.getBrowserName();
        Configuration.startMaximized = true;
    }
}
