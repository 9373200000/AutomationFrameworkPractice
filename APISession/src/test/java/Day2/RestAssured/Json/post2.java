package Day2.RestAssured.Json;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class post2 {
	
	@Test
	public void createWithArray()
	{
		JSONObject obj = new JSONObject();
		obj.put("id", 33);
		obj.put("username", "nam");
		obj.put("firstName", "nam");
		obj.put("lastName", "nam");
		obj.put("email", "nam@gmail.com");
		obj.put("password", "nam");
		obj.put("phone", "1234567890");
		obj.put("userStatus", 1);
		JSONArray jsonArray = new JSONArray();
		jsonArray.put(obj);
		
		RestAssured.baseURI = "https://petstore.swagger.io/v2";
		
		RequestSpecification request = RestAssured.given()
												  .header("content-type","application/json")
												  .contentType(ContentType.JSON)
												  .accept(ContentType.JSON)
												  .body(jsonArray.toString());
		Response response = request.post("/user/createWithArray");
		response.then().statusCode(200);
		Assert.assertEquals(200, response.statusCode());
		System.out.println(response.body().asString());
		
		
	}

}
