package Day2.RestAssured.JsonFromFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.annotations.Test;

public class Example1 {
	
	@Test
	public void createUserByFileData()
	{
		//byte[] data = null;
		
		try {
//			data = Files.readAllBytes(Paths.get(".\\src\\test\\resources\\testData\\data.json"));
//			String payload = new String(data);

			byte[] data = Files.readAllBytes(Paths.get(".\\src\\test\\resources\\testData\\data.json"));
			String payload = new String(data);
			
			System.out.println(payload);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
