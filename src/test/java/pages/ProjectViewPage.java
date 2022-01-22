package pages;

import baseEntities.BasePage;
import enums.ProjectType;
import models.Project;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProjectViewPage extends BasePage {

    private static String ENDPOINT = "/admin/projects/overview";
    private static final By PAGE_OPENED_IDENTIFIER = By.xpath("//*[@class = 'content-header-title page_title display-inline-block']");

    private static String openCurrentProjectSelector = "//*[. = 'replace']";

    private static String typeRadioButtonSelector = "//*[@name = 'suite_mode' and @value='replace']";

    protected By nameProjectSelector = By.id("name");
    protected By announcementSelector = By.id("announcement");
    protected By isShowAnnouncementSelector = By.id("show_announcement");
    protected By isCompletedSelector = By.id("is_completed");
    protected By saveProjectButton = By.id("accept");

    public ProjectViewPage(WebDriver driver) {
        super(driver);
    }

    public ProjectViewPage(WebDriver driver, boolean openPageByUrl) {
        super(driver, openPageByUrl);
    }

    @Override
    protected void openPage() {
        driver.get(BASE_URL+ENDPOINT);
    }

    @Override
    protected boolean isPageOpened() {
        return waits.waitForVisibility(PAGE_OPENED_IDENTIFIER).isDisplayed();
    }

    public WebElement getOpenCurrentProject (Project currentProject) {
        return driver.findElement(By.xpath(openCurrentProjectSelector.replace("replace", currentProject.getName())));
    }


    public void setType (ProjectType type) {
        driver.findElement(By.xpath(typeRadioButtonSelector.replace("replace", String.valueOf(type)))).click();
    }
    public WebElement getNameProjectField() {
        return driver.findElement(nameProjectSelector);
    }

    public WebElement getAnnouncementSelectorField() {
        return driver.findElement(announcementSelector);
    }

    public WebElement getIsShowAnnouncementField () {
        return driver.findElement(isShowAnnouncementSelector);
    }

    public WebElement getIsCompletedField () {
        return driver.findElement(isCompletedSelector);
    }

    public WebElement getSaveProjectButton () {
        return driver.findElement(saveProjectButton);
    }

    public void updateProject (Project currentProject, Project newProject)  {
        getNameProjectField().clear();
        getNameProjectField().sendKeys(newProject.getName());
        getAnnouncementSelectorField().clear();
        getAnnouncementSelectorField().sendKeys(newProject.getAnnouncement());
        if (currentProject.isShowAnnouncement() == false) {

        } else {getIsShowAnnouncementField().click();}
        setType(newProject.getTypeOfProject());
        getIsCompletedField().click();
        getSaveProjectButton().click();

    }

    public void deleteProject (Project updateProject) {
        driver.findElement(By.xpath("//*[. = '"+updateProject.getName()+"']/following::td[2]")).click();
        driver.findElement(By.xpath("//strong [. = 'Yes, delete this project (cannot be undone)']")).click();
        driver.findElement(By.xpath("//div[@id='deleteDialog']//a[@class = 'button button-ok button-left button-positive dialog-action-default']")).click();
    }
}
