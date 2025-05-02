package fileUtility;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONFileUtility {
public String getDataFromJsonFile(String key) throws IOException, ParseException {
		
		//get the java object of the physical object
		FileReader fileR = new FileReader("./CongifAppData/JsonFile.json");
		
		//Create Object of Json class
		JSONParser parser = new JSONParser();
		
		//parse the Json file into actual Json object
		Object obj = parser.parse(fileR);
		
		//Downcast to Json object
		JSONObject map = (JSONObject)obj;
		String data = (String) map.get(key);
		return data;
		
	}

}
