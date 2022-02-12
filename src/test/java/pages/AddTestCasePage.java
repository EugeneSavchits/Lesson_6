package pages;

import com.codeborne.selenide.SelenideElement;
import models.TestCase;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class AddTestCasePage {
    private final By titleTestCaseSelector = By.id("title");
    private final By preconditionsSelector = By.id("custom_preconds_display");
    private final By addTestCaseButton = By.id("accept");

    public SelenideElement getTitleTestCaseField() {
        return $(titleTestCaseSelector);
    }
    public SelenideElement getPreconditionsField() {
        return $(preconditionsSelector);
    }
    public SelenideElement getAddTestCaseButton() {
        return $(addTestCaseButton);
    }

    public void addTestCase(TestCase testCase){
        sleep(500);
        getTitleTestCaseField().val(testCase.getTitle());
        getPreconditionsField().val(testCase.getPreconditions());
        getAddTestCaseButton().click();

    }

    public void updateTestCase(TestCase updateTestCase){
        getTitleTestCaseField().clear();
        sleep(500);
        getTitleTestCaseField().val(updateTestCase.getTitle());
        getPreconditionsField().clear();
        getPreconditionsField().val(updateTestCase.getPreconditions());
        getAddTestCaseButton().click();

    }
}