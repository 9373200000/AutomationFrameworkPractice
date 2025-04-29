package Day2.RestAssured.Json;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class post1 {
	
	@Test
	public void createListOfUser()
	{
		JSONObject obj = new JSONObject();
		obj.put("id", 22);
		obj.put("username", "sanjana");
		obj.put("firstName", "sanjan");
		obj.put("lastName", "sanja");
		obj.put("email", "sanjana@gmail.com");
		obj.put("password", "sanju");
		obj.put("phone", "1234567890");
		obj.put("userStatus", 1);
		System.out.println(obj.toString());
		JSONArray arr = new JSONArray();
		arr.put(obj);
		System.out.println(arr.toString());
		
		RestAssured.baseURI = "https://petstore.swagger.io/v2";
		
		RequestSpecification request = RestAssured.given()
												  .header("content-type","application/json")
												  .contentType(ContentType.JSON)
												  .accept(ContentType.JSON)
												  .body(arr.toString());
		
		Response response = request.post("/user/createWithList");
		
		System.out.println(response.body().asString());
		response.then().statusCode(200);
		
		Assert.assertEquals(200, response.statusCode());
		
		
	}

}
