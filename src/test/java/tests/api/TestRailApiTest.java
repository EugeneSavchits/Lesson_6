package tests.api;

import baseEntities.BaseApiTest;
import core.ReadProperties;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.apache.http.protocol.HTTP;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TestRailApiTest extends BaseApiTest {
    @Test //пошаговый
    public void getAllUsers() {
        //Setup RestAssured
        RestAssured.baseURI = ReadProperties.getUrl();

        //Setup endPoint
        String endpoint = "/index.php?/api/v2/get_users";

        //Setup request Object
        RequestSpecification httpRequest = given();
        httpRequest.header(HTTP.CONTENT_TYPE, ContentType.JSON); //указание в каком формате будут приходить данные
        httpRequest.auth().preemptive().basic(ReadProperties.getUsername(), ReadProperties.getPassword()); //метод preemptive() для старых сайтов, для новых только basic()

        //Setup response Object
        Response response = httpRequest.request(Method.GET, endpoint);

        //Get Response status
        int statusCode = response.getStatusCode();
        System.out.println("Status code: " + statusCode);
        Assert.assertEquals(statusCode, 200);
        Assert.assertEquals(statusCode, HttpStatus.SC_OK);//аналог

        //Get Response Body
        String responseBody = response.getBody().asString();
        System.out.println("Response body: " + responseBody);
    }

    @Test
    public void getAllUsersWithBaseApiTest() {

        //Setup endPoint
        String endpoint = "/index.php?/api/v2/get_users";

        //предыдущий тест на языке Gherkin
        given()
                .when()
                .get(endpoint)
                .then()
                .log().status()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
           }


}
