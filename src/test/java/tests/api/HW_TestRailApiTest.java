package tests.api;

import Utils.Endpoints;
import baseEntities.BaseApiTest;
import enums.ProjectType;
import io.restassured.mapper.ObjectMapperType;
import models.*;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class HW_TestRailApiTest extends BaseApiTest {

    int projectID;
    int milestoneID;
    int suiteID;
    int sectionID;
    int caseID;

    @Test
    public void addProject(){
        String endpoint = "/index.php?/api/v2/add_project";

        ProjectBuilderApi project = ProjectBuilderApi.builder()
                .name("SEA_PROJECT")
                .typeOfProject(ProjectType.MULTIPLE_SUITE_MODE)
                .build();

        projectID = given()
                .body(project, ObjectMapperType.GSON)
                .log().body()
                .when()
                .post(endpoint)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .body("name", is(project.getName()))
                .body("suite_mode", is(project.getTypeOfProject()))
                .extract().jsonPath().get("id");
    }

    @Test (dependsOnMethods = "addMilestone")
    public void getMilestones () {
        String endpoint = "/index.php?/api/v2/get_milestones/{project_id}";

        given()
                .pathParam("project_id", projectID)
                .when()
                .get(endpoint)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test (dependsOnMethods = "addProject")
    public void addMilestone(){
        String endpoint = "/index.php?/api/v2/add_milestone/{project_id}";

        MilestoneBuilderApi milestone = MilestoneBuilderApi.builder()
                .name("Release 3.0")
                .description("Something")
                .build();

       milestoneID = given()
                .pathParam("project_id", projectID)
                .body(milestone, ObjectMapperType.GSON)
                .log().body()
                .when()
                .post(endpoint)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .body("name", is(milestone.getName()))
                .body("description", is(milestone.getDescription()))
                .extract().jsonPath().get("id");
    }

    @Test (dependsOnMethods = "getMilestones")
    public void updateMilestone(){
        String endpoint = "/index.php?/api/v2/update_milestone/{milestone_id}";

        MilestoneBuilderApi updateMilestone = MilestoneBuilderApi.builder()
                .name("Release 3.0 New")
                .description("Something New")
                .build();

        given()
                .pathParam("milestone_id", milestoneID)
                .body(updateMilestone, ObjectMapperType.GSON)
                .log().body()
                .when()
                .post(endpoint)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .body("name", is(updateMilestone.getName()))
                .body("description", is(updateMilestone.getDescription()));
    }

    @Test (dependsOnMethods = "updateMilestone")
    public void deleteMilestone(){
        String endpoint = "/index.php?/api/v2/delete_milestone/{milestone_id}";

        given()
                .pathParam("milestone_id", milestoneID)
                .when()
                .post(endpoint)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test (dependsOnMethods = "deleteMilestone")
    public void addSuite(){
        String endpoint = "/index.php?/api/v2/add_suite/{project_id}";

        SuiteBuilderApi suite = SuiteBuilderApi.builder()
                .name("NEW SUITE")
                .description("NEW DESCRIPTION")
                .build();

        suiteID = given()
                .pathParam("project_id", projectID)
                .body(suite, ObjectMapperType.GSON)
                .log().body()
                .when()
                .post(endpoint)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .body("name", is(suite.getName()))
                .body("description", is(suite.getDescription()))
                .extract().jsonPath().get("id");
            }

    @Test (dependsOnMethods = "addSuite")
    public void addSection(){
        String endpoint = "/index.php?/api/v2/add_section/{project_id}";

        SectionBuilderApi section = SectionBuilderApi.builder()
                .name("NEW SECTION")
                .suite_id(suiteID)
                .build();

        sectionID = given()
                .pathParam("project_id", projectID)
                .body(section, ObjectMapperType.GSON)
                .log().body()
                .when()
                .post(endpoint)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .body("name", is(section.getName()))
                .body("suite_id", is(section.getSuite_id()))
                .extract().jsonPath().get("id");
    }

    @Test (dependsOnMethods = "addSection")
    public void  addCase() {
        String endpoint = "/index.php?/api/v2/add_case/{section_id}";

        CaseBuilderApi case1 = CaseBuilderApi.builder()
                .title("NEW TEST CASE")
                .priority_id(2)
                .build();

        caseID = given()
                .pathParam("section_id", sectionID)
                .body(case1, ObjectMapperType.GSON)
                .log().body()
                .when()
                .post(endpoint)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract().jsonPath().get("id");

        CaseBuilderApi actualCase = given()
                .pathParam("case_id", caseID)
                .when()
                .get(Endpoints.GET_CASE)
                .then()
                .assertThat()
                .extract()
                .as(CaseBuilderApi.class);

        Assert.assertEquals(actualCase, case1);
    }

    @Test (dependsOnMethods = "addCase")
    public void getCase(){

        given()
                .pathParam("case_id", caseID)
                .when()
                .get(Endpoints.GET_CASE)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test (dependsOnMethods = "getCase")
    public void updateCase() {
        String endpoint = "/index.php?/api/v2/update_case/{case_id}";

        CaseBuilderApi case2 = CaseBuilderApi.builder()
                .title("UPDATE NEW TEST CASE")
                .priority_id(1)
                .build();

       CaseBuilderApi actualCase = given()
                .pathParam("case_id", caseID)
                .body(case2, ObjectMapperType.GSON)
                .log().body()
                .when()
                .post(endpoint)
                .then()
                .log().body()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .as(CaseBuilderApi.class);

       Assert.assertEquals(actualCase, case2);
    }

    @Test (dependsOnMethods = "updateCase")
    public void moveCasesToSection(){
        String endpoint = "index.php?/api/v2/move_cases_to_section/{section_id}";

        given()
                .pathParam("section_id", sectionID)
                .body(String.format("{\n" +
                        "  \"section_id\": %d,\n" +
                        "  \"suite_id\": %d,\n" +
                        "  \"case_ids\": [%d]\n" +
                        "}", sectionID, suiteID, caseID))
                .log().body()
                .when()
                .post(endpoint)
                .then()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test(dependsOnMethods = "moveCasesToSection")
    public void deleteCase(){
        String endpoint = "index.php?/api/v2/delete_case/{case_id}";

        given()
                .pathParam("case_id", caseID)
                .when()
                .post(endpoint)
                .then()
                .statusCode(HttpStatus.SC_OK);
    }


    @Test (dependsOnMethods = "deleteCase")
    public void deleteProject() {
        String endpoint = "/index.php?/api/v2/delete_project/{project_id}";

        given()
                .pathParam("project_id", projectID)
                .when()
                .post(endpoint)
                .then()
                .statusCode(HttpStatus.SC_OK);
    }
}
