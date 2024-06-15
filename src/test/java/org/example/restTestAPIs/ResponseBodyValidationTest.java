package org.example.restTestAPIs;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class ResponseBodyValidationTest {
	
	@Test
    public void validateResponseBody() {
        RestAssured.baseURI = "https://api.example.com";

        given()
            .when()
            .get("/endpoint")
            .then()
            .body("key", equalTo("value")); // Replace "key" and "value" with expected JSON key-value pair
    }

}
