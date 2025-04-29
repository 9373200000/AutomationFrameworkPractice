package Day2.RestAssured.Json;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class delete1 {
	
	@Test
	public void deleteUser()
	{
		String username = "sanjana";
		RestAssured.baseURI = "https://petstore.swagger.io/v2/user/";
		
		RequestSpecification request = RestAssured.given()
												  .header("content-type","application/json")
												  .contentType(ContentType.JSON)
												  .accept(ContentType.JSON);
		Response response = request.delete(username);
		
		System.out.println(response.body().asString());
		response.then().statusCode(200);
		Assert.assertEquals(200, response.getStatusCode());
		
	}

}
