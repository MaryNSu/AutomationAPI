package tests;


import io.restassured.response.Response;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static utils.Steps.*;

public class TestRegres {

    @BeforeSuite
    public void setUp() {
        baseURI = "https://reqres.in/api";
    }

    @Test
    public void testListUsers() {

        String url = "/users?page=2";

        Response response = GET(url);

        isStatusCodeValid(response, 200);

    }

    @Test
    public void testSingleUser() {

        String url = "/users/2";

        Response response = GET(url);

        isStatusCodeValid(response, 200);

        isBodyContainsValue(response, "data.first_name", "Janet");
    }

    @Test
    public void testCreate() {
        String url = "/users";

        String body = "{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"leader\"\n" +
                "}";

        Response response = POST(body, url);

        isStatusCodeValid(response, 201);

        isBodyContains(response, "id");

    }
}