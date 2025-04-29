package Day2.RestAssured.Json;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class post3 {
	
	@Test
	public void createUser(){
		
		JSONObject obj = new JSONObject();
		obj.put("id", 111);
		obj.put("username", "ggg");
		obj.put("firstName", "ggg");
		obj.put("lastName", "ggg");
		obj.put("email", "ggg@test.com");
		obj.put("password", "ggg");
		obj.put("phone", "1234567890");
		obj.put("userStatus", 1);
		
		RestAssured.baseURI = "https://petstore.swagger.io/v2";
		
		RequestSpecification request = RestAssured.given()
												  .header("content-type","application/json")
												  .contentType(ContentType.JSON)
												  .accept(ContentType.JSON)
												  .body(obj.toString());
		Response response = request.post("/user");
		
		response.then().statusCode(200);
		Assert.assertEquals(200, response.statusCode());
		
		System.out.println(response.body().asString());
		
		
	}

}
