package tests.api;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;


public class reqresApiTest {
    //пошаговый вариант создания запроса
    @Test
    public void simpleStepByStepApiTest () {
        //Setup RestAssured
        RestAssured.baseURI = "https://reqres.in";

        //Setup endPoint
        int userID = 2;
        String endpoint = "/api/user/"+userID;

        //Setup request Object
        RequestSpecification httpRequest = given();

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
    public void simpleShortByStepApiTest () {
        //Setup RestAssured
        RestAssured.baseURI = "https://reqres.in";

        //Setup endPoint
        int userID = 2;
        String endpoint = "/api/user/"+userID;

        given()
                .when()
                .get(endpoint)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .log().body();
    }
}
