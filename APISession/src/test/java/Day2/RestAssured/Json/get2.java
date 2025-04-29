package Day2.RestAssured.Json;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class get2 {
	
	@Test
	public void login()
	{
		RestAssured.baseURI = "https://petstore.swagger.io/v2/user/login";
		
		RequestSpecification request = RestAssured.given()
												  .header("content-type","application/json")
												  .contentType(ContentType.JSON)
												  .accept(ContentType.JSON)
												  .param("username", "sanjana")
												  .param("password", "sanju");
		Response response = request.get();
		
		System.out.println(response.body().asString());
		
		response.then().statusCode(200);
		Assert.assertEquals(200, response.getStatusCode());
	}

}
