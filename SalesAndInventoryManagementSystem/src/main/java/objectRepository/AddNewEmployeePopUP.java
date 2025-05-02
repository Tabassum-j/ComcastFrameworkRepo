package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewEmployeePopUP {

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
	
}
