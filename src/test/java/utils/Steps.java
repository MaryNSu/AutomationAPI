package utils;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;


public class Steps {
    @Step
    public static Response GET(String endpoint){

        Allure.addAttachment("URL", baseURI + endpoint);

        Response response = get(endpoint);

        Allure.addAttachment("Response body", response.body().prettyPrint());

        Allure.addAttachment("Status Code", String.valueOf(response.statusCode()));

        return response;
    }


    @Step
    public static void isStatusCodeValid(Response response, int expectedStatusCode) {
        response.then().assertThat().statusCode(expectedStatusCode);

    }

    public static Response POST(String body, String endpoint){

        Allure.addAttachment("URL", baseURI + endpoint);

        Allure.addAttachment("Request body ", body);

        Response response =  given().body(body).post(endpoint);

        Allure.addAttachment("Status Code", String.valueOf(response.statusCode()));

        Allure.addAttachment("Response Body", response.body().prettyPrint());

        return response;
    }

}
