package org.example.restTestAPIs;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Map;

public class RestAPITests {
	
	
	int id=3;
	
	@Test(priority=0, enabled=false)
	public void exampleRequest()
	{
		try {
			
			given()
			.log().all()
			.baseUri("https://api.example.com")
			.basePath("/api/v1")
			//.pathParam("", "")
			.queryParam("page", 2)
			//.formParam("", "")
			.header("Authorization", "Bearer token")
			.cookie("sessionId", "abc123")
			.contentType(ContentType.JSON)
			.body("{ \"name\": \"John\", \"age\": 30 }")
			
			
			.when()
			.post("/users")
			
			
			.then()
			.log().all()
			.statusCode(200)
			.body("name", equalTo("John"))
			.body("id", notNullValue())
			.body("age", equalTo(30));
			
		} catch (Exception e) {
			throw e;
		}
	}
	
	@Test(description = "To get the details of user with id 3", priority=1, enabled=false)
	public void verifyUser()
	{
		try {
			
			//given
			given()
			.log().all()
			.baseUri("https://reqres.in/api")
			.pathParam("id", id)
			.contentType(ContentType.JSON)
			
			//when
			.when()
			.get("/users/{id}")
			
			//then
			.then()
			.log().ifStatusCodeIsEqualTo(200)
			.statusCode(200)
			.statusLine("HTTP/1.1 200 OK")
			
			// To verify user with dynamic ID
			.body("data.email", equalTo("emma.wong@reqres.in"))
			.body("data.first_name", equalTo("Emma"))
			.body("data.last_name", equalTo("Wong"));
			
		} catch (Exception e) {
			throw e;
		}
	}
	
	@Test(priority=2, enabled=true)
	public void verifyCookies()
	{
		try {
			
			Response response= given()
			.basePath("https://api.example.com")
			.basePath("/api/v1")
			//.pathParam("", "")
			//.formParam("", "")
			.queryParam("page", 2)
			.header("Authorization", "Bearer token")
			.cookies("abcs133", "2938923dh")
			.contentType(ContentType.JSON)
			.body("{ \"name\": \"John\", \"age\": 30 }")
			.log().all()
			.when()
			.post("/users");
			
			Map<String, String> cookiess= response.getCookies();
			
			
			assertThat(cookiess.get("session_id"), notNullValue());
			assertThat(cookiess.get("user_id"), equalTo("233232"));
			assertThat(cookiess.size() , greaterThan(5));
			assertThat(cookiess.size(), lessThan(3));
			assertThat(cookiess.size(), lessThanOrEqualTo(4));
			
			// Additional assertions
	        assertThat(cookiess.containsKey("session_id"), equalTo(true)); // Check if session_id cookie exists
	        assertThat(cookiess.keySet(), hasItem("session_id")); // Check if session_id cookie key exists
	        assertThat(cookiess.values(), hasItem("12345")); // Check if "12345" value exists in any cookie
	        assertThat(cookiess, hasEntry("session_id", "expected_value")); // Check specific cookie key-value pair
			
			
		} catch (Exception e) {
			throw e;
		}
	}

}
