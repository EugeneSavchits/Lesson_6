package pages;

import com.codeborne.selenide.SelenideElement;
import models.Milestone;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class AddMilestonePage {
    private final By nameMilestoneSelector = By.id("name");
    private final By referencesSelector = By.id("reference");
    private final By descriptionSelector = By.id("description_display");
    private final By isShowCompletedSelector = By.id("is_completed");
    private final By addMilestoneButton = By.id("accept");

    public SelenideElement getNameMilestoneField(){return $(nameMilestoneSelector);}
    public SelenideElement getReferencesField(){return $(referencesSelector);}
    public SelenideElement getDescriptionField(){return $(descriptionSelector);}
    public SelenideElement getIsShowCompletedField(){return $(isShowCompletedSelector);}
    public SelenideElement getAddMilestoneButton(){return $(addMilestoneButton);}

    public void addMilestone(Milestone milestone){
        getNameMilestoneField().val(milestone.getName());
        getReferencesField().val(milestone.getReferences());
        getDescriptionField().val(milestone.getDescription());
        getAddMilestoneButton().click();

    }

    public void updateMilestone(Milestone updateMilestone){
        getNameMilestoneField().clear();
        getNameMilestoneField().val(updateMilestone.getName());
        getReferencesField().clear();
        getReferencesField().val(updateMilestone.getReferences());
        getDescriptionField().clear();
        getDescriptionField().val(updateMilestone.getDescription());
        getIsShowCompletedField().click();
        getAddMilestoneButton().click();

    }
}
