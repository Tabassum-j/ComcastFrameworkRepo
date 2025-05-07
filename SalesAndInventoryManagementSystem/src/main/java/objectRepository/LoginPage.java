package objectRepository;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import fileUtility.PropertyFileUtility;
import webDriverUtility.WebDriverUtility;

public class LoginPage extends WebDriverUtility {
	WebDriverUtility wlib = new WebDriverUtility();
	
	@FindBy(xpath = "//input[@class='form-control form-control-user' and @placeholder='Username']")
	private WebElement usernameEdt;
	
	@FindBy(xpath = "//input[@class='form-control form-control-user' and @placeholder='Password']")
	private WebElement passwordEdt;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement saveBtn;
	
	public WebElement getUsernameEdt() {
		return usernameEdt;
	}
	public WebElement getPasswordEdt() {
		return passwordEdt;
	}
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void loginAsAdmin() throws InterruptedException, IOException {
		maximizeWindow(driver);
		implicitWait(driver);
		 PropertyFileUtility plib = new PropertyFileUtility();
		 //String URL=System.getProperty("url", plib.getDataFromPropertiesFileAsAdmin("url"));
		 String USERNAME=System.getProperty("username", plib.getDataFromPropertiesFileAsAdmin("username"));
		 String PASSWORD= System.getProperty("password", plib.getDataFromPropertiesFileAsAdmin("password"));
		 usernameEdt.sendKeys(USERNAME);
		 passwordEdt.sendKeys(PASSWORD);
		 
		 saveBtn.click();
		 Thread.sleep(2000);
		 wlib.switchToAlertAndAccept(driver);
	}
	
	public void loginAsUser() throws InterruptedException, IOException {
		maximizeWindow(driver);
		implicitWait(driver);
	    PropertyFileUtility plib = new PropertyFileUtility();
	    // String URL=System.getProperty("url", plib.getDataFromPropertiesFileAsUser("url"));
		 String USERNAME=System.getProperty("username", plib.getDataFromPropertiesFileAsUser("username"));
		 String PASSWORD= System.getProperty("password", plib.getDataFromPropertiesFileAsUser("password"));
		 usernameEdt.sendKeys(USERNAME);
		 passwordEdt.sendKeys(PASSWORD);
		
		saveBtn.click();
		Thread.sleep(2000);
		wlib.switchToAlertAndAccept(driver);
		
	}
}
