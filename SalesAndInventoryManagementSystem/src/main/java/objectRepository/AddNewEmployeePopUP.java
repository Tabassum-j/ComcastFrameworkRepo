package objectRepository;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import fileUtility.ExcelUtility;
import webDriverUtility.JavaUtility;
import webDriverUtility.WebDriverUtility;

public class AddNewEmployeePopUP {
	
	ExcelUtility elib = new ExcelUtility();
	WebDriverUtility wlib = new WebDriverUtility();
	JavaUtility jlib = new JavaUtility();

	@FindBy(xpath = "//h5[text()='Add Employee']/ancestor::div[@class=\"modal-header\"]/following-sibling::div[@class=\"modal-body\"]/descendant::input[@name='firstname']")
	private WebElement firstNameEdt;
	
	@FindBy(xpath = "//h5[text()='Add Employee']/ancestor::div[@class='modal-header']/following-sibling::div[@class='modal-body']/descendant::input[@name='lastname']")
	private WebElement lastNameEdt;
	
	@FindBy(xpath = "//h5[text()='Add Employee']/ancestor::div[@class='modal-header']/following-sibling::div[@class='modal-body']/descendant::select[@name='gender']")
	private WebElement genderDD;
	
	@FindBy(xpath = "//h5[text()='Add Employee']/ancestor::div[@class='modal-header']/following-sibling::div[@class='modal-body']/descendant::input[@name='email']")
	private WebElement emailEdt;
	
	@FindBy(xpath="//h5[text()='Add Employee']/ancestor::div[@class='modal-header']/following-sibling::div[@class='modal-body']/descendant::input[@name='phonenumber']")
	private WebElement phonenumberEdt;
	
	@FindBy(xpath = "//h5[text()='Add Employee']/ancestor::div[@class='modal-header']/following-sibling::div[@class='modal-body']/descendant::select[@name='jobs']")
	private WebElement jobsDD;
	
	@FindBy(xpath =  "//h5[text()='Add Employee']/ancestor::div[@class='modal-header']/following-sibling::div[@class='modal-body']/descendant::input[@name='hireddate']")
	private WebElement hireddateEdt;
	
	@FindBy(xpath  = "//h5[text()='Add Employee']/ancestor::div[@class='modal-header']/following-sibling::div[@class='modal-body']/descendant::select[@name='province']")
	private WebElement provinceDD;
	
	@FindBy(xpath =  "//h5[text()='Add Employee']/ancestor::div[@class='modal-header']/following-sibling::div[@class='modal-body']/descendant::select[@name='city']")
	private WebElement cityDD;
	
	@FindBy(xpath = "//h5[text()='Add Employee']/ancestor::div[@class='modal-header']/following-sibling::div[@class='modal-body']/descendant::button[@type='submit']")
	private WebElement saveBtn;

	public WebElement getFirstNameEdt() {
		return firstNameEdt;
	}

	public WebElement getLastNameEdt() {
		return lastNameEdt;
	}

	public WebElement getGenderDD() {
		return genderDD;
	}

	public WebElement getEmailEdt() {
		return emailEdt;
	}

	public WebElement getPhonenumberEdt() {
		return phonenumberEdt;
	}

	public WebElement getJobsDD() {
		return jobsDD;
	}

	public WebElement getHireddateEdt() {
		return hireddateEdt;
	}

	public WebElement getProvinceDD() {
		return provinceDD;
	}

	public WebElement getCityDD() {
		return cityDD;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	WebDriver driver;
	public AddNewEmployeePopUP(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void employeeData() throws EncryptedDocumentException, IOException, InterruptedException {
		//Read test script data from excel
		String FIRSTNAME = elib.getDataFromExcel("IntegrationTestCase", 5, 0);
		String LASTNAME = elib.getDataFromExcel("IntegrationTestCase", 5, 1);
		String EMAIL = elib.getDataFromExcel("IntegrationTestCase", 5, 2);
		String PHONENUMBER = elib.getDataFromExcel("IntegrationTestCase", 5, 3);
		String HIREDATE = elib.getDataFromExcel("IntegrationTestCase",5 ,4 );
		 wlib.waitForElementPresent(driver,getFirstNameEdt()); 
		  getFirstNameEdt().sendKeys(FIRSTNAME);
		  wlib.waitForElementPresent(driver,getLastNameEdt());
		  getLastNameEdt().sendKeys(LASTNAME);
		  wlib.waitForElementPresent(driver,getGenderDD());
		  wlib.select(getGenderDD(),"Male");
		  wlib.waitForElementPresent(driver,getEmailEdt());
		  getEmailEdt().sendKeys(EMAIL);
		  wlib.waitForElementPresent(driver,getPhonenumberEdt());
		  getPhonenumberEdt().sendKeys(PHONENUMBER+jlib.getRandomNumber());
		  wlib.waitForElementPresent(driver,getJobsDD());
		  wlib.select(getJobsDD(),"Manager");
		  getJobsDD().sendKeys(Keys.TAB);
		  Thread.sleep(3000);
		  wlib.waitForElementPresent(driver,getHireddateEdt());
		  getHireddateEdt().sendKeys(HIREDATE.toString());
		  wlib.waitForElementPresent(driver,getProvinceDD());
		  wlib.select(getProvinceDD(), "Abra");
		  wlib.waitForElementPresent(driver,getCityDD());
		  wlib.select(getCityDD(),"Pilar"); 
		  getSaveBtn().click();
	}
	
}
