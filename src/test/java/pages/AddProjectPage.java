package pages;

import baseEntities.BasePage;
import models.Project;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Collection;
import java.util.List;
import java.util.Random;

public class AddProjectPage extends BasePage {
    private static String ENDPOINT = "/admin/projects/add/1";

    private static final By PAGE_OPENED_IDENTIFIER = By.id("accept");

    protected By nameProjectSelector = By.id("name");

    protected By typeProjectSelector = By.xpath("//*[starts-with(@id, 'suite_mode_')]");

    protected By addProjectButtonSelector = By.id("accept");

    public AddProjectPage(WebDriver driver) {
        super(driver);
    }

    public AddProjectPage(WebDriver driver, boolean openPageByUrl) {
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

    public WebElement getNameProjectField() {
        return driver.findElement(nameProjectSelector);
    }

    public Collection<WebElement> getTypeProjectField() {
        return driver.findElements(typeProjectSelector);
    }

    public WebElement getAddProjectButton() {
        return driver.findElement(addProjectButtonSelector);
    }


    public void addProject (Project project)  {
        String inputChars= "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder name = new StringBuilder();
        Random rnd = new Random();
        while (name.length() < 36) {
            int index = (int) (rnd.nextFloat() * inputChars.length());
            name.append(inputChars.charAt(index));
        }
        String nameProject= name.toString();
        project.setNameProject(nameProject);


        getNameProjectField().sendKeys(project.getNameProject());
        List<WebElement> typeProject = (List<WebElement>) getTypeProjectField();
        Random random = new Random();
        int randomValue = random.nextInt(typeProject.size());
        typeProject.get(randomValue).click();
        getAddProjectButton().click();

    }

}
