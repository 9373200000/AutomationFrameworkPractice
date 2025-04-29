package Day2.Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Example5 {
	
	@Test 
	void logout()
	{
		RestAssured.baseURI = "https://petstore.swagger.io/v2";
		
		RequestSpecification request = RestAssured.given()
												  .header("content-type","application/json")
												  .contentType(ContentType.JSON)
												  .accept(ContentType.JSON);
		Response response = request.get("/user/logout");
		
		System.out.println(response.body().asString());
		
		response.then().statusCode(200);
		Assert.assertEquals(200, response.getStatusCode());
	}

}
