package pages;

import com.codeborne.selenide.SelenideElement;
import models.Project;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class AddProjectPage {


    private final By nameProjectSelector = By.id("name");
    private final By announcementSelector = By.id("announcement");
    private final By isShowAnnouncementSelector = By.id("show_announcement");
    private static By typeRadioButtonSelector = By.xpath("//*[@name = 'suite_mode' and @value='1']");
    private final By isCompletedSelector = By.id("is_completed");
    private final By addProjectButton = By.id("accept");

    public SelenideElement getNameProjectField() {
        return $(nameProjectSelector);
    }
    public SelenideElement getAnnouncementField() {
        return $(announcementSelector);
    }
    public SelenideElement getIsShowAnnouncementField() {
        return $(isShowAnnouncementSelector);
    }
    public SelenideElement getTypeRadioButtonField(){return $(typeRadioButtonSelector);}
    public SelenideElement getIsCompletedField() {
        return $(isCompletedSelector);
    }
    public SelenideElement getAddProjectButton() {
        return $(addProjectButton);
    }

    public void addProject (Project project){
        getNameProjectField().val(project.getName());
        getAnnouncementField().val(project.getAnnouncement());
        getIsShowAnnouncementField().click();
        getTypeRadioButtonField().click();
        getAddProjectButton().click();
    }
}
