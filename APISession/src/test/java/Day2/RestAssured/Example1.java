package Day2.RestAssured;

import org.testng.annotations.Test;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Example1 {
	
	@Test
	public void createUser()
	{
		String payload = "{\"name\": \"Marcus\",\"job\": \"Testing\"}";
		
		RestAssured.baseURI = "https://reqres.in/";
		
		//given
		RequestSpecification request = RestAssured.given()
												  .header("content-type","application/json")
												  .contentType(ContentType.JSON)
												  .accept(ContentType.JSON)
												  .body(payload);
		//when
		Response response = request.post("api/users");
		
		//then
		String statusLine = response.getStatusLine();
		int statusCode = response.getStatusCode();
		String responseBody = response.getBody().asString();
		
		System.out.println(statusLine);
		System.out.println(statusCode);
		System.out.println(responseBody);
		
		response.then().statusCode(201);
		
	}

}
