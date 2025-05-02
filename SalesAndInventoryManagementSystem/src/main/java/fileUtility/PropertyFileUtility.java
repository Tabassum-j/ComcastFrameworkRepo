package fileUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileUtility {
	public String data;
	public String getDataFromPropertiesFile(String key) throws IOException {
		FileInputStream fis = new FileInputStream("./CinfigAppData/AdminLoginData.properties");
		Properties pObj = new Properties();
		pObj.load(fis);
		data = pObj.getProperty(key);
		return data;
	}
	
	public String getDataFromPropertiesFileAsUser(String key) throws IOException {
	FileInputStream fis = new FileInputStream("./CinfigAppData/UserLoginData.properties");
	Properties pObj = new Properties();
	pObj.load(fis);
    data = pObj.getProperty(key);
	return data;
}
}
