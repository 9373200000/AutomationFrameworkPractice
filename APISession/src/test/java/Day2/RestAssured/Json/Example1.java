package Day2.RestAssured.Json;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class Example1 {
	
	@Test
	public void createUser()
	{
		JSONObject obj = new JSONObject();
		obj.put("name", "Marcus");
		obj.put("job", "Testing");
		
		System.out.println(obj.toString());
		
		RestAssured.baseURI = "https://reqres.in/";
		
		RequestSpecification request = RestAssured.given()
												  .header("content-type","application/json")
												  .contentType(ContentType.JSON)
												  .accept(ContentType.JSON)
												  .body(obj.toString());
		
		Response response = request.post("api/users");
		
		response.then().statusCode(201);
		
		Assert.assertEquals(201, response.statusCode());
		
		System.out.println(response.statusCode());
		System.out.println(response.statusLine());
		System.out.println(response.body().asString());
	}

}
