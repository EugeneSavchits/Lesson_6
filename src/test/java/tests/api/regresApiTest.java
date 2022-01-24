package tests.api;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

public class regresApiTest {
    @Test
    public void simpleStepByApiTest () {
        //Setup RestAssured
        RestAssured.baseURI = "https://regres.in";

        //Setup endPoint
        int userID = 2;
        String endpoint = "/api/user/2"+userID;

        //Setup request Object
        RequestSpecification httpRequest = RestAssured.given();

        //Setup response Object
        Response response = httpRequest.request(Method.GET, endpoint);

        //Get Response status
        int statusCode = response.getStatusCode();
        System.out.println("Status code" + statusCode);
        Assert.assertEquals(statusCode, HttpStatus.SC_OK);

        //Get Response Body
        String responseBody = response.getBody().asString();
        System.out.println("Response: " + responseBody);
    }
}
