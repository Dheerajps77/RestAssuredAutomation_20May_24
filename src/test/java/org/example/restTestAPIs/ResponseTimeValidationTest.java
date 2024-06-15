package org.example.restTestAPIs;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class ResponseTimeValidationTest {
	
	@Test
    public void validateResponseTime() {
        RestAssured.baseURI = "https://api.example.com";

        given()
            .when()
            .get("/endpoint")
            .then()
            .time(lessThan(1000L))// Validate response time less than 1000 milliseconds
            .time(greaterThan(500L)) // Validate response time greater than 500 milliseconds
            .time(lessThanOrEqualTo(2000L)) // Validate response time less than or equal to 2000 milliseconds
            .time(greaterThanOrEqualTo(1000L)); // Validate response time greater than or equal to 1000 milliseconds
    }

}
