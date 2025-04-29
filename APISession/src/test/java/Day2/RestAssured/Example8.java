package Day2.RestAssured;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Example8 {
	
	@Test
	public void CreateUser()
	{
		String payload = "{\"name\": \"Marcus\",\"job\": \"Testing\"}";

		RestAssured.baseURI = "https://reqres.in/";
		
		RequestSpecification request = RestAssured.given()
												  .header("content-type","application/json")
												  .contentType(ContentType.JSON)
												  .accept(ContentType.JSON)
												  .body(payload);
		
		Response response = request.post("api/users");
		
		response.then().statusCode(201);
		
		System.out.println(response.body().asString());
		
		Assert.assertEquals(201, response.getStatusCode());
		
	}

}
