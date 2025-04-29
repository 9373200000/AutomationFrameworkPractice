package Day2.Practice;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Example7 {
	
	@Test
	void CreateUser()
	{

		byte[] data = null;
		try {
			data = Files.readAllBytes(Paths.get("C:\\Automation_Sessions\\Workspace\\APISession\\example.json"));
			String payload = new String(data);

			RestAssured.baseURI = "https://petstore.swagger.io/v2";
			
			RequestSpecification request = RestAssured.given()
													  .header("content-type","application/json")
													  .contentType(ContentType.JSON)
													  .accept(ContentType.JSON)
													  .body(payload);
			Response response = request.post("/user");
			
			response.then().statusCode(200);
			Assert.assertEquals(200, response.statusCode());
			
			System.out.println(response.body().asString());
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}

}
