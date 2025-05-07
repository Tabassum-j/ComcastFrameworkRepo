package integrationTestCase;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import objectRepository.AddNewCustomerPopup;
import objectRepository.AdminHomePage;
import objectRepository.CustomerDetailsPage;
import objectRepository.LoginPage;
import baseClassUtility.BaseClass;
@Listeners(listnerUtility.ListnerImplClass.class)
public class AddNewCustomerAndVerify extends BaseClass {
	@Test(groups="RegressionTest")
	public void verifyNewAddedCustomer() throws EncryptedDocumentException, IOException, InterruptedException {
		
		
		  //Read data from excel file 
		 String FIRSTNAME =elib.getDataFromExcel("IntegrationTestCase", 1 , 0);
		
	    LoginPage lp = new LoginPage(driver);
	    lp.loginAsAdmin();
		
		//Click on customer
		AdminHomePage ahp = new AdminHomePage(driver);
		Actions act=new Actions(driver);
		act.click(ahp.getcustomerModule()).perform();
	
		
		//click on add customer button
		CustomerDetailsPage cdp = new CustomerDetailsPage(driver);
		Thread.sleep(3000);		
		
		cdp.getaddBtn().click();
		Thread.sleep(5000);
		
		//Enter customer details
		AddNewCustomerPopup ancp = new AddNewCustomerPopup(driver);
		Thread.sleep(3000);
		
		 ancp.customerInfo();
		
		//Click on save button
		wlib.javaScriptclickOnWE(driver, ancp.getsaveBtn());
		
		//Verify
		cdp.getsearchEdt().sendKeys(FIRSTNAME, Keys.ENTER);
		String actFirstName = driver.findElement(By.xpath("//td[@class='sorting_1' and text()='"+FIRSTNAME+"']")).getText();
		//String actFirstName = cdp.getverify().getText();
		Assert.assertEquals(actFirstName, FIRSTNAME);
		ahp.logoutAsAdmin();
	}
}
