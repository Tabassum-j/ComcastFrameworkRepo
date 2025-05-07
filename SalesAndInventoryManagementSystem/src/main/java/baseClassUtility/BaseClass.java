package baseClassUtility;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import databaseUtility.DatabaseUtility;
import fileUtility.ExcelUtility;
import fileUtility.PropertyFileUtility;
import webDriverUtility.JavaUtility;
import webDriverUtility.UtilityClassObject;
import webDriverUtility.WebDriverUtility;



public class BaseClass {
	public DatabaseUtility dlib = new DatabaseUtility();
	public PropertyFileUtility flib = new PropertyFileUtility();
	public ExcelUtility elib = new ExcelUtility();
	public WebDriverUtility wlib = new WebDriverUtility();
	public JavaUtility jlib = new JavaUtility();
	public WebDriver driver;
	public static WebDriver sdriver;
	
	@BeforeSuite(groups= {"SmokeTest", "RegressionTest"})
	public void configBeforeSuite() throws SQLException {
		dlib.getDbConnection();
		System.out.println("Database connected");
	}
	@Parameters("BROWSER")
	@BeforeClass(groups= {"SmokeTest", "RegressionTest"})
	public void configBeforeClass(@Optional("chrome")String browser) throws IOException {
		String BROWSER = browser;//flib.getDataFromPropertiesFile("browser");
		if(BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}else if(BROWSER.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}else {
			driver = new ChromeDriver();
		}
		System.out.println("Browser launched");
		 sdriver=driver;
         UtilityClassObject.setDriver(driver);
	}
	
	@BeforeMethod(groups = {"SmokeTest", "RegressionTest"})
	public void configBeforeMethod() throws IOException, InterruptedException {
		//flib.getDatFromPropertiesFileUrl()
		String URL=flib.getDatFromPropertiesFileUrl("url");
		System.out.println("Login to application");	
		System.out.println(URL);
		driver.get(URL);
	}
	@AfterMethod(groups = {"SmokeTest", "RegressionTest"})
	public void configAfterMethod() throws InterruptedException {

		System.out.println("Logout of application");
	}
	
	@AfterClass(groups = {"SmokeTest", "RegressionTest"})
	public void configAfterClass() {
	driver.quit();
		System.out.println("Close Browser");
	}
	
	@AfterSuite(groups = {"SmokeTest", "RegressionTest"})
	public void configAfterSuite() throws SQLException {
		dlib.closeDbConnection();
		System.out.println("Close database connection ");
	}
}
