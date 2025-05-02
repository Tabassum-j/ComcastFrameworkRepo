package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import webDriverUtility.WebDriverUtility;


public class AdminHomePage {
	
	WebDriver driver;

	@FindBy(linkText = "Supplier")
	private WebElement supplierModule;
	
	@FindBy(xpath = "//a[@href='customer.php']")
	private WebElement customerModule;
	
	@FindBy(linkText = "Employee")
	private WebElement employeeModule;
	
	@FindBy(id = "userDropdown")
	private WebElement profileIcon;
	
	@FindBy(xpath = "//a[@data-target='#logoutModal']")
	private WebElement logoutLink;
	
	@FindBy(linkText = "Logout")
	private WebElement logoutBtn;
	
	@FindBy(linkText = "Transaction")
	private WebElement transactionModule;
	
	
	public  AdminHomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public WebElement getsupplierModule() {
		return supplierModule;
	}
	
	public WebElement getcustomerModule() {
		return customerModule;
	}
	
	public WebElement getemployeeModule() {
		return employeeModule;
	}
	
	public WebElement getprofileIcon() {
		return profileIcon;
	}
	
	public WebElement getlogoutLink() {
		return logoutLink;
	}
	
	public WebElement getlogoutBtn() {
		return logoutBtn;
	}
	
	public WebElement gettransactionModule() {
		return transactionModule;
	}
	public void logoutAsAdmin() throws InterruptedException {
		Thread.sleep(5000);
		
		WebDriverUtility wlib = new WebDriverUtility();
		wlib.waitForElementPresent(driver, profileIcon);
		Thread.sleep(4000);
		
		profileIcon.click();
		System.out.println("Clicked");
		
		wlib.waitForElementPresent(driver, logoutLink);
		//wlib.switchToAlertAndAccept(driver);
		logoutLink.click();
		logoutBtn.click();
	}

}
