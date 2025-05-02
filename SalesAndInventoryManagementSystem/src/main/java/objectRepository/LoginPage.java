package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import webDriverUtility.WebDriverUtility;

public class LoginPage extends WebDriverUtility {
	WebDriverUtility wlib = new WebDriverUtility();
	
	@FindBy(name = "user")
	private WebElement usernameEdt;
	
	@FindBy(name = "password")
	private WebElement passwordEdt;
	
	@FindBy(name = "btnlogin")
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
	
	public void loginAsAdmin() throws InterruptedException {
		maximizeWindow(driver);
		implicitWait(driver);
		driver.get("http://49.249.28.218:8081/AppServer/Sales_And_Inventory_System/pages/login.php");
		usernameEdt.sendKeys("unguardable");
		passwordEdt.sendKeys("admin");
		saveBtn.click();
		Thread.sleep(2000);
		wlib.switchToAlertAndAccept(driver);
	}
	
	public void loginAsUser() throws InterruptedException {
		maximizeWindow(driver);
		implicitWait(driver);
		driver.get("http://49.249.28.218:8081/AppServer/Sales_And_Inventory_System/pages/login.php");
		usernameEdt.sendKeys("test");
		passwordEdt.sendKeys("test");
		saveBtn.click();
		Thread.sleep(2000);
		wlib.switchToAlertAndAccept(driver);
		
	}
}
