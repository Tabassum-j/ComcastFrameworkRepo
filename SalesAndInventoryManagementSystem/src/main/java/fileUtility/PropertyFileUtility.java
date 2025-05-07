package fileUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileUtility {
	public String data;
	public String getDataFromPropertiesFileAsAdmin(String key) throws IOException {
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
	String data = pObj.getProperty(key);
	return data;
}
   public String getDatFromPropertiesFileUrl(String key) throws IOException {
	   FileInputStream fis = new FileInputStream("./CinfigAppData/UserLoginData.properties");
		Properties pObj = new Properties();
		pObj.load(fis);
		String data = pObj.getProperty(key);
		return data;
   }
}
