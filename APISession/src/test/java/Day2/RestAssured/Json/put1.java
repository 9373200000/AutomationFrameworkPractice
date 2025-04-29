package Day2.RestAssured.Json;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class put1 {
	
	@Test
	public void updateuser() {
		
		String username = "sanjana";
		
		JSONObject obj = new JSONObject();
		obj.put("id", 88);
		obj.put("username", "sanjana");
		obj.put("firstName", "sanjana");
		obj.put("lastName", "sanjana");
		obj.put("email", "sanjana@gmail.com");
		obj.put("password", "sanjana");
		obj.put("phone", "1234567890");
		obj.put("userStatus", 6);
		
		
		RestAssured.baseURI = "https://petstore.swagger.io/v2/user/";
		
		RequestSpecification request = RestAssured.given()
												  .header("content-type","application/json")
												  .contentType(ContentType.JSON)
												  .accept(ContentType.JSON)
												  .body(obj.toString());
													
		Response response = request.put(username);
		
		response.then().statusCode(200);
		Assert.assertEquals(200, response.getStatusCode());
		
		System.out.println(response.body().asString());
		
	}

}
