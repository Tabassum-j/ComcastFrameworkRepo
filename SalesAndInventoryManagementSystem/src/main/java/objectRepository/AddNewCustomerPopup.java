package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class AddNewCustomerPopup {
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
    
	
	
}
