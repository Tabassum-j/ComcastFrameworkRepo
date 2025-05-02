package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PointOfSalesPage {
	@FindBy(xpath = "//select[@name='customer']")
	private WebElement customerDD;
	
	@FindBy(xpath = "//button[@type='button' and text()='SUBMIT']")
	private WebElement submitBtn;
	
	WebDriver driver;
	public PointOfSalesPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	public WebElement getcustomerDD() {
		return customerDD;
	}
	
	public WebElement getsubmitBtn() {
		return submitBtn;
	}

}
