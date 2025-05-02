package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TransactionPage {
	
	@FindBy(xpath = "//input[@class='form-control form-control-sm']")
	private WebElement searchEdt;
	
	@FindBy(linkText = " View")
	private WebElement viewBtn;
	
	public WebElement getsearchEdt() {
		return searchEdt;
	}
	
	public WebElement getviewBtn() {
		return viewBtn;
	}
	
	WebDriver driver;
	public TransactionPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

}
