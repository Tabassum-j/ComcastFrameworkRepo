package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerDetailsPage {

	@FindBy(xpath = "//a[@data-target='#customerModal']")
	private WebElement addBtn;
	
	@FindBy(xpath = "//input[@class='form-control form-control-sm']")
	private WebElement searchEdt;
	
	@FindBy(xpath = "//a[@class='btn btn-primary bg-gradient-primary dropdown no-arrow']")
	
	private WebElement dotsIcon;
	
	@FindBy(xpath = "//a[@class='btn btn-warning bg-gradient-warning btn-block' ] ")
	private WebElement editIcon;
	
	
	
	WebDriver driver;
	public  CustomerDetailsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public WebElement getaddBtn() {
		return addBtn;
	}
	
	public WebElement getsearchEdt() {
		return searchEdt;
	}
	
	public WebElement getdotsIcon() {
		return dotsIcon;
	}
	
	public WebElement geteditIcon() {
		return editIcon;
	}
	
	

}
