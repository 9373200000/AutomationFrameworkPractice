package Day2.Practice;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Example1 {

	@Test 
	void POST1()
	{
		JSONObject obj = new JSONObject();
		obj.put("id", 111);
		obj.put("username", "Poora");
		obj.put("firstName", "Poora");
		obj.put("lastName", "Poora");
		obj.put("email", "Poora@gmail.com");
		obj.put("password", "Poora");
		obj.put("phone", "1234567890");
		obj.put("userStatus", 1);
		JSONArray arr = new JSONArray();
		arr.put(obj);
		
		RestAssured.baseURI = "https://petstore.swagger.io/v2";
		
		RequestSpecification request = RestAssured.given()
												  .header("content-type","application/json")
												  .contentType(ContentType.JSON)
												  .accept(ContentType.JSON)
												  .body(arr.toString());
		Response response = request.post("/user/createWithList");
		response.then().statusCode(200);
		Assert.assertEquals(200, response.getStatusCode());
		System.out.println("----"+response.body().asString());
		
	}
	
}
