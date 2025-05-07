package objectRepository;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import fileUtility.ExcelUtility;
import webDriverUtility.JavaUtility;
import webDriverUtility.WebDriverUtility;


public class AddNewCustomerPopup {
	WebDriverUtility wlib = new WebDriverUtility();
	ExcelUtility elib = new ExcelUtility();
	JavaUtility jlib = new JavaUtility();
    @FindBy( xpath =  "//div[contains(.,'Add Customer')]/following-sibling::div[@class='modal-body']/descendant::input[@name='firstname']")
    private WebElement firstNameEdt;
    
    @FindBy(xpath =  "//div[contains(.,'Add Customer')]/following-sibling::div[@class='modal-body']/descendant::input[@name='lastname']")
    private WebElement lasstNameEdt;
    
    @FindBy(xpath ="//div[contains(.,'Add Customer')]/following-sibling::div[@class='modal-body']/descendant::input[@name='phonenumber']")  
    private WebElement phoneNumberEdt;
    
    @FindBy(xpath = "//div[contains(.,'Add Customer')]/following-sibling::div[@class='modal-body']/descendant::button[@type='submit']")
    private WebElement saveBtn;

	public WebElement getFirstNameEdt() {
		return firstNameEdt;
	}

	public WebElement getLasstNameEdt() {
		return lasstNameEdt;
	}

	public WebElement getPhoneNumberEdt() {
		return phoneNumberEdt;
	}
	
	public WebElement getsaveBtn() {
		return saveBtn;
	}
    
	WebDriver driver;
    public AddNewCustomerPopup(WebDriver driver) {
    	this.driver=driver;
    	PageFactory.initElements(driver, this);
    }
    
    public void customerInfo() throws EncryptedDocumentException, IOException {
    	
    	//Read data from excel file
    			String FIRSTNAME = elib.getDataFromExcel("IntegrationTestCase", 1 , 0);
    			String LASTNAME = elib.getDataFromExcel("IntegrationTestCase", 1, 1);
    			String PHONENUMBER = elib.getDataFromExcel("IntegrationTestCase", 1, 2);
    	
    	wlib.waitForElementPresent(driver,getFirstNameEdt() );
		getFirstNameEdt().sendKeys(FIRSTNAME);
		wlib.waitForElementPresent(driver, getLasstNameEdt());
		getLasstNameEdt().sendKeys(LASTNAME);
		wlib.waitForElementPresent(driver,getPhoneNumberEdt() );
		getPhoneNumberEdt().sendKeys(PHONENUMBER+jlib.getRandomNumber());
    }
    
	public void addCustomer() throws EncryptedDocumentException, IOException {
		//Read data from excel
				String FIRSTNAME = elib.getDataFromExcel("IntegrationTestCase",9 , 0);
				String LASTNAME = elib.getDataFromExcel("IntegrationTestCase", 9, 1);
				String PHONENUMBER = elib.getDataFromExcel("IntegrationTestCase",9, 2);
				wlib.waitForElementPresent(driver,getFirstNameEdt());
				getFirstNameEdt().sendKeys(FIRSTNAME);
				wlib.waitForElementPresent(driver, getLasstNameEdt());
				getLasstNameEdt().sendKeys(LASTNAME);
				wlib.waitForElementPresent(driver,getPhoneNumberEdt());
				getPhoneNumberEdt().sendKeys(PHONENUMBER);
				wlib.javaScriptclickOnWE(driver, getsaveBtn());
	}
	
}
