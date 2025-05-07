package objectRepository;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import fileUtility.ExcelUtility;

public class EditCustomerPage {
	ExcelUtility elib = new ExcelUtility();
	
	@FindBy(name = "firstname")
	private WebElement firstNameEdt;
	
	@FindBy(name = "lastname")
	private WebElement lastnameEdt;
	
	@FindBy(name = "phone")
	private WebElement phoneEdt;
	
	@FindBy(xpath = "//button[@class='btn btn-warning btn-block']")
	private WebElement updateBtn;

	public WebElement getFirstNameEdt() {
		return firstNameEdt;
	}

	public WebElement getLastnameEdt() {
		return lastnameEdt;
	}

	public WebElement getPhoneEdt() {
		return phoneEdt;
	}

	public WebElement getUpdateBtn() {
		return updateBtn;
	}
	
	WebDriver driver;
	public EditCustomerPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void editCustomerDetails() throws EncryptedDocumentException, IOException {
		String FIRSTNAME = elib.getDataFromExcel("SystemTestCase", 4, 0);
		String LASTNAME = elib.getDataFromExcel("SystemTestCase", 4, 1);
		String CONTACT = elib.getDataFromExcel("SystemTestCase", 4, 2);
		getFirstNameEdt().sendKeys(FIRSTNAME);
		getLastnameEdt().sendKeys(LASTNAME);
	    getPhoneEdt().sendKeys(CONTACT);
	    getUpdateBtn().click();
	}
	
	

}
