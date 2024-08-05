package SerializationJavaObjectToJSON;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class SerializationExample {

	public static void main(String[] args) {
		String jsonBody="";
		int statusCode;
		Response response;
		String statusLine;
		String jsonResponse;
		UserClass class1;
		ObjectMapper mapper;
		try {
			
			class1 = new UserClass();			
			class1.setName("Dheeraj Pratap Singh");
			class1.setEmail("jsonResponse@gamilc.om");
		
			mapper=new ObjectMapper();
			
			jsonBody=mapper.writeValueAsString(class1);
			System.out.println("Serialized JSON: " + jsonBody);
		
		 response= given()
		.baseUri("https://jsonplaceholder.typicode.com")
		.basePath("/users")
		.contentType(ContentType.JSON)
		.body(jsonBody)
		.post()
		.then().log().all()
		.body("email", equalTo("jsonResponse@gamilc.om"))
		.body("name", equalTo("Dheeraj Pratap Singh"))
		.extract()
		.response();
		
		statusCode = response.getStatusCode();
		statusLine = response.getStatusLine();

		System.out.println("Response Status Code: " + statusCode);
		System.out.println("Response Status line: " + statusLine);

		jsonResponse = response.getBody().asString();
		
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
	}

}
