package objectRepository;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmployeeDetailsPage {
	
	@FindBy(xpath = "//a[@data-target='#employeeModal']")
	private WebElement addEmployeeBtn;
	
	@FindBy(xpath = "//input[@class='form-control form-control-sm']")
	private WebElement searchEdt;
	
	public WebElement getsearchEdt() {
		return searchEdt;
	}
	
	public WebElement getaddEmployeeBtn() {
		return addEmployeeBtn;
	}
	
	WebDriver driver;
	public EmployeeDetailsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
}
