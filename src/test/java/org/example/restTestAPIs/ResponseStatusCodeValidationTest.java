package org.example.restTestAPIs;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class ResponseStatusCodeValidationTest {

    @Test
    public void validateStatusCode() {
        RestAssured.baseURI = "https://api.example.com";

        given()
            .when()
            .get("/endpoint")
            .then()
            .statusCode(200); // Replace 200 with expected status code
    }
}
