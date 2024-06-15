package org.example.restTestAPIs;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class CookiesValidationTest {

    @Test
    public void validateCookies() {
    	RestAssured.baseURI = "https://api.example.com";

        Response response =
            given()
                .when()
                .get("/endpoint");

        Map<String, String> cookies = response.getCookies();
        // Additional assertions on cookies
        assertThat(cookies, hasKey("session_id")); // Validate presence of session_id cookie
        assertThat(cookies, not(hasKey("expired_cookie"))); // Validate absence of expired_cookie
        assertThat(cookies.size(), greaterThanOrEqualTo(2)); // Ensure at least 2 cookies are present
       
    }
}