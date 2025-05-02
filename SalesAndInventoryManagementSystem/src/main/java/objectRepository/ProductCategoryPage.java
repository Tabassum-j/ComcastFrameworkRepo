package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductCategoryPage {
	@FindBy(xpath = "//h6[@class='text-info' and text()='Lenovo']/../input[@name='addpos'][1]")
	private WebElement addButton;
	
	
	WebDriver driver;
	public ProductCategoryPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getaddButton() {
		return addButton;
	}

}
