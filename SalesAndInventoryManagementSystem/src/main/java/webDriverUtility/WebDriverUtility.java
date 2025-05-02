package webDriverUtility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	public void minimizeWindow(WebDriver driver) {
		driver.manage().window().minimize();;
	}
	
	public void implicitWait(WebDriver driver) {
		//WebDriver is an interface in selenium
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	public void waitForElementPresent(WebDriver driver, WebElement element) {
		//WebDriverWait is a class in selenium
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		//ExpectedConditions is a class in selenium
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void browserLaunch(WebDriver driver, String BROWSER ) {
		 
	    driver = null;
		if(BROWSER.equalsIgnoreCase("chrome")) {
			
			driver=new ChromeDriver();
		}else if(BROWSER.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}else {
			driver = new ChromeDriver();
		}
	}
	
	public void switchToTabOnUrl(WebDriver driver, String partialURL) {
		//getWindoeHandle is a method in WebDriver Interface, Set is an interface in java
		Set<String> set = driver.getWindowHandles();
		//iterator is an abstract method in set interface in java(java.util package)
		Iterator<String> it = set.iterator();
		
		while(it.hasNext()) {
			String windowID = it.next();
			driver.switchTo().window(windowID);
			
			//getCurrentUrl is an WebDriver method
			String actUrl = driver.getCurrentUrl();
			if(actUrl.contains(partialURL)) {
				break;
			}
		}	
	}
	
	public void switchToTabOnTitle(WebDriver driver, String partialTitle) {
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		
		while(it.hasNext()) {
			String windowID = it.next();
			driver.switchTo().window(windowID);
			
			String actUrl = driver.getTitle();
			if(actUrl.contains(partialTitle)) {
				break;
			}
		}	
	}
	
	//OverLoaded methods
	public void switchToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}
	
	public void switchToFrame(WebDriver driver, String name) {
		driver.switchTo().frame(name);
	}
	public void switchToFrame(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}
	
	public void switchToAlertAndAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	
	public void switchToAlertAndDismiss(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	
	public void switchToAlertAndSendKeys(WebDriver driver, String charSeq, WebElement element) {
		driver.switchTo().alert().sendKeys(charSeq);
	}
	
	public void select(WebElement element, String text) {
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}
	
	public void select(WebElement element, int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}
	
	public void selectByValue(WebElement element, String value) {
	Select sel = new Select(element);
	sel.selectByValue(value);
	}
	
	public void selectByContains(WebElement element, String text) {
		Select sel = new Select(element);
		sel.deselectByVisibleText(text);
	}
	
	public void deSelectByVisibleText(WebElement element, String text) {
		Select sel = new Select(element);
		sel.deselectByVisibleText(text);
	}
	
	public void deSelectByIndex(WebElement element, int index) {
		Select sel = new Select(element);
		sel.deselectByIndex(index);
	}
	
	public void deSelectByValue(WebElement element, String value) {
		Select sel = new Select(element);
		sel.deselectByValue(value);
	}
	
	public void deSelectByContains(WebElement element, String text) {
		Select sel = new Select(element);
		sel.deselectByVisibleText(text);
	}
	
	public void deSelectAll(WebElement element) {
		Select sel = new Select(element);
		sel.deselectAll();
	}
	
	public void mousemoveToElement(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
	}
	
	public void doubleClick(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
        action.doubleClick(element).perform();
	}
	
	public void rightClick(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.contextClick(element).perform();
	}
	
	public void scrollToElement(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.scrollToElement(element).perform();
	}
	
	public void scrollByAmount(WebDriver driver, int x, int y) {
		Actions action = new Actions(driver);
		action.scrollByAmount(x, y).perform(); 
	}
	
	public void dragAndDropOfWebElements(WebDriver driver, WebElement srcElement, WebElement dstElement) {
		Actions action = new Actions(driver);
		action.dragAndDrop(srcElement, dstElement).perform();
	}
	
	public void dragAndDropBy(WebDriver driver, WebElement srcElement, int x, int y) {
		Actions action = new Actions(driver);
		action.dragAndDropBy(srcElement, x, y).perform();
	}
	
	public void sendKeys(WebDriver driver, WebElement element, String characters ) {
		Actions action = new Actions(driver);
		action.sendKeys(characters).perform();
	} 
	
	public void screenshotOfWebPage(WebDriver driver, String url, String ssName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File("./Screenshot/"+ssName+"");
		FileHandler.copy(src, dst);
	}
	 public void screenshotOfWebElement(WebDriver drvier, WebElement element, String ssname) throws IOException {
		 File src = element.getScreenshotAs(OutputType.FILE);
		 File dst = new File("./Screenshot/"+ssname+"");
		 FileHandler.copy(src, dst);
	 }
	
	public void javaScriptclickOnWE(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", element);
	}
	
	public void javaScriptExecutoeSendKeys(WebDriver driver, WebElement element, String charSeq) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeAsyncScript("arguments[0].value:'"+charSeq+"'", element);
	}

}
