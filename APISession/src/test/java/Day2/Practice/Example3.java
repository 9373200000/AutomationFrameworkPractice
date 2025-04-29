package Day2.Practice;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Example3 {
	
	@Test
	void updateData()
	{
		String username = "Poora";
		
		JSONObject obj = new JSONObject();
		obj.put("id", 111);
		obj.put("username", "Pooma");
		obj.put("firstName", "Pooma");
		obj.put("lastName", "Pooma");
		obj.put("email", "Pooma@gmail.com");
		obj.put("password", "Pooma");
		obj.put("phone", "1234567890");
		obj.put("userStatus", 1);
		
		
		RestAssured.baseURI = "https://petstore.swagger.io/v2";
		
		RequestSpecification request = RestAssured.given()
												  .header("content-type","application/json")
												  .contentType(ContentType.JSON)
												  .accept(ContentType.JSON)
												  .body(obj.toString());
		Response response = request.put("/user/"+username);
		response.then().statusCode(200);
		Assert.assertEquals(200, response.getStatusCode());
		
		System.out.println(response.body().asString());
	}

}
