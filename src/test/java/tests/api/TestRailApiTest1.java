package tests.api;

import baseEntities.BaseApiTest;
import enums.ProjectType;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import models.ProjectBuilderApi;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class TestRailApiTest1 extends BaseApiTest {

    int projectID;

    @Test
    public void getAllProjects(){
        String endPoint = "/index.php?/api/v2/get_projects";

               given()
                .when()
                .get(endPoint)
                .then().log().body()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test //прописование json вручную
    public void addProject1(){
        String endpoint = "/index.php?/api/v2/add_project";

        ProjectBuilderApi project = ProjectBuilderApi.builder()
                .name("SEA")
                .announcement("This is the description for the project")
                .isShowAnnouncement(true)
                .typeOfProject(ProjectType.SINGLE.getProjectType())
                .build();

        given()
                .body(String.format("{\n" +
                                "  \"name\": \"%s\",\n" +
                                "  \"announcement\": \"%s\",\n" +
                                "  \"show_announcement\": %b,\n" +
                                "  \"suite_mode\": %d\n" +
                                "}", project.getName(),
                        project.getAnnouncement(),
                        project.isShowAnnouncement(),
                        project.getTypeOfProject()))
                .when()
                .post(endpoint)
                .then().log().body()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test //моделирование json в автомате исходя из параметров с использованием Map
    public void addProject2(){
        String endpoint = "/index.php?/api/v2/add_project";

        ProjectBuilderApi project = ProjectBuilderApi.builder()
                .name("SEA_2")
                .typeOfProject(ProjectType.SINGLE.getProjectType())
                .build();

        Map<String, Object> jsonAsMap = new HashMap<>();
        jsonAsMap.put("name", project.getName());
        jsonAsMap.put("suite_mod", project.getTypeOfProject());

        given()
                .body(jsonAsMap)
                .when()
                .post(endpoint)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test//с использованием пасивной сериализации по средствам RestAssured ObjectMapperType.GSON
    public void addProject3(){
        String endpoint = "/index.php?/api/v2/add_project";

        ProjectBuilderApi project = ProjectBuilderApi.builder()
                .name("SEA_3")
                .typeOfProject(ProjectType.SINGLE_WITH_BASELINE.getProjectType())
                .build();

        given()
                .body(project, ObjectMapperType.GSON)
                .log().body() //body который мы отправляем
                .when()
                .post(endpoint)
                .then().log().body()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test//получения значения из json с использованеим jsonPath
    public void addProject4(){
        String endpoint = "/index.php?/api/v2/add_project";

        ProjectBuilderApi project = ProjectBuilderApi.builder()
                .name("SEA_3")
                .typeOfProject(ProjectType.SINGLE_WITH_BASELINE.getProjectType())
                .build();

        projectID = given()
                .body(project, ObjectMapperType.GSON)
                .log().body() //body который мы отправляем
                .when()
                .post(endpoint)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract().jsonPath().get("id");

        System.out.println(projectID);
    }

    @Test(dependsOnMethods = "addProject4")
    public void updateProject(){

        String endpoint = "/index.php?/api/v2/update_project/{project_id}";

        ProjectBuilderApi projectUpdate = ProjectBuilderApi.builder()
                .name("SEA_Update")
                .announcement("Test_SEA!")
                .isCompleted(true)
                .build();

        //получение целого ответа по средствам ввода переменной response
        Response response = given()
                .pathParam("project_id", projectID) //параметр в пути для автоподстановки {project_id}
                .body(projectUpdate, ObjectMapperType.GSON)
                .when()
                .post(endpoint)
                .then()
                .log().body()
                .extract().response(); //извлечение ответа

        Assert.assertEquals(response.getBody().jsonPath().get("name"), projectUpdate.getName()); //полученик измененного имени из переменной response и проверка его соответствия


    }

    @Test (dependsOnMethods = "addProject4")
    public void deleteProject() {
        String endpoint = "/index.php?/api/v2/delete_project/{project_id}";

        given()
                .pathParam("project_id", projectID)
                .when()
                .post(endpoint)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }
}
