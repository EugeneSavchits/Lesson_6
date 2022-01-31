package steps;

import baseEntities.BaseStep;
import io.qameta.allure.Step;
import models.Project;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.AddProjectPage;

public class ProjectSteps extends BaseStep {
    private AddProjectPage addProjectPage;


    public ProjectSteps(WebDriver driver) {
        super(driver);
    }


    @Step
    public void addProject (Project project) {
        System.out.println("Шаг степа");
        Assert.assertTrue(true);
    }

    public void updateProject(Project currentProject, Project newProject){

    }

    public void deleteProject(Project project) {

    }
}
