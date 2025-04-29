package Day1;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.json.simple.JSONValue;
import org.testng.annotations.Test;

public class example1 {
	
	@Test(enabled = false)
	void workWithJsonObj()
	{
		JSONObject obj = new JSONObject();
		obj.put("work","projection");
		obj.put("name", "lily");

		System.out.println(obj);
		
		System.out.println(obj.get("name"));
		
		System.out.println(obj.keySet());
		
		//System.out.println(obj.values());
	}
	
	@Test(enabled = true)
	void MapToJson()
	{
		Map map = new HashMap();
		map.put("work","projection");
		map.put("name", "lily");
		
		String jsonString = JSONValue.toJSONString(map);
		
		System.out.println(map);
		System.out.println(jsonString);

	}

}
