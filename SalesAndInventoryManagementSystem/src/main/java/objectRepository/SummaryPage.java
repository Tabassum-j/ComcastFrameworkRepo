package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SummaryPage {
	
	@FindBy(id = "txtNumber")
	private WebElement amountEdt;
	
	@FindBy(xpath = "//h3[@class='font-weight-bold py-3 bg-light']")
	private WebElement amountText;
	
	@FindBy(xpath = "//button[@type='submit' and text()='PROCEED TO PAYMENT']")
	private WebElement paymentBtn;
	
	WebDriver driver;
	public SummaryPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
		this.driver=driver;
	}
	
	public WebElement amountText() {
		return amountText;
	}
	
	public WebElement getamountEdt() {
		return amountEdt;
	}
	
	public WebElement getpaymentBtn() {
		return paymentBtn;
	}

}
