package baseEntity;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import core.DataBaseService;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    String url = "https://qa1507.testrail.io";
    protected String username = "atrostyanko+0401@gmail.com";
    protected String password = "QqtRK9elseEfAk6ilYcJ";
    protected DataBaseService dataBaseService;

    @BeforeSuite
    public void setupAllureReports() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(false)
                .savePageSource(true)
        );

         Configuration.baseUrl = url;
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;

    }
    @BeforeTest
    public void setupConnection() {
        org.apache.log4j.BasicConfigurator.configure();

        dataBaseService = new DataBaseService();
    }

    @AfterTest
    public void closeConnection() {
        dataBaseService.closeConnection();
    }
}