package Day2.RestAssured;

import org.eclipse.jetty.websocket.api.StatusCode;
import org.testng.Assert;
import org.testng.annotations.Test;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Example2 {
	
	@Test
	public void CreateUser()
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
		System.out.println(response.statusCode());
		System.out.println(response.statusLine());
		System.out.println(response.getBody().asString());
		Assert.assertEquals(response.statusCode(), 201);
	}

}
