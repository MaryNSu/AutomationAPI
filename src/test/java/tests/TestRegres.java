package tests;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TestRegres {

    @Test
    public void testTestNG() {
        given()
                .when()
                .get("https://reqres.in/api/users?page=2")
                .then()
                .assertThat()
                .statusCode(200);


    }
}
