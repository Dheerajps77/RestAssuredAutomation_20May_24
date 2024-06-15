package org.example.restTestAPIs;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class ResponseHeadersValidationTest {

    @Test
    public void validateResponseHeaders() {
        RestAssured.baseURI = "https://api.example.com";

        given()
        .when()
        .get("/endpoint")
        .then()
        .header("Content-Type", "application/json") // Validate Content-Type header
        .header("Server", "nginx") // Validate Server header
        .header("Cache-Control", containsString("max-age=")); // Validate Cache-Control header contains max-age
    }
}