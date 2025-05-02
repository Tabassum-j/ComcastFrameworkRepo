package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class UserHomePage {
	@FindBy(linkText = "Keyboard")
	private WebElement keyboardModule;
	
	@FindBy(xpath = "//img[@class='img-profile rounded-circle']")
	private WebElement userProfileIcon;
	
	@FindBy(xpath = "//a[@data-target='#logoutModal']")
	private WebElement logoutLink;
	
	@FindBy(linkText = "Logout")
	private WebElement logoutBtn;
	
	WebDriver driver;
	
	public UserHomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	
	public WebElement getuserProfileIcon() {
		return userProfileIcon;
	}
	
	public WebElement getkeyboardModule() {
		return keyboardModule;
	}
	
	public WebElement getlogoutLink () {
		return logoutLink;
	}

	public WebElement getlogoutBtn() {
		return logoutBtn;
	}
public void logoutAsUser() throws InterruptedException {
	Actions act = new Actions(driver);
	act.click(userProfileIcon).perform();
	System.out.println("Clicked");
	Thread.sleep(3000);
	logoutLink.click();
	logoutBtn.click();
	
	
}

}
