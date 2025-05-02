package integrationTestCase;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import objectRepository.AddNewCustomerPopup;
import objectRepository.AdminHomePage;
import objectRepository.CustomerDetailsPage;
import objectRepository.LoginPage;
import objectRepository.PointOfSalesPage;
import objectRepository.ProductCategoryPage;
import objectRepository.UserHomePage;
import baseClassUtility.BaseClass;

public class AddNewCustomerAndVerifyInUserPage extends BaseClass{
	
	@Test (groups="RegressionTest")
	public void addNewCustomerAndVeerifyInUser() throws EncryptedDocumentException, IOException, InterruptedException {
		
		
		 LoginPage lp = new LoginPage(driver);
		    lp.loginAsAdmin();
		
		//Read data from excel
		String FIRSTNAME = elib.getDataFromExcel("IntegrationTestCase",9 , 0);
		String LASTNAME = elib.getDataFromExcel("IntegrationTestCase", 9, 1);
		String PHONENUMBER = elib.getDataFromExcel("IntegrationTestCase",9, 2);
		
		//Navigate to customer page
		AdminHomePage ahp = new AdminHomePage(driver);
		Thread.sleep(3000);
		Actions act=new Actions(driver);
		act.click(ahp.getcustomerModule()).perform();
		
		//click on add customer button
		CustomerDetailsPage cdp = new CustomerDetailsPage(driver);
		Thread.sleep(3000);	
		cdp.getaddBtn().click();
		Thread.sleep(5000);
		
		//Enter Customer details 
		AddNewCustomerPopup ancp = new AddNewCustomerPopup(driver);
		wlib.waitForElementPresent(driver,ancp.getFirstNameEdt());
		ancp.getFirstNameEdt().sendKeys(FIRSTNAME);
		wlib.waitForElementPresent(driver, ancp.getLasstNameEdt());
		ancp.getLasstNameEdt().sendKeys(LASTNAME);
		wlib.waitForElementPresent(driver,ancp.getPhoneNumberEdt());
		ancp.getPhoneNumberEdt().sendKeys(PHONENUMBER);
		wlib.javaScriptclickOnWE(driver, ancp.getsaveBtn());
		
		
		ahp.logoutAsAdmin();
		System.out.println("Logout done as admin");
		
		//Login as user
		lp.loginAsUser();
		
		//Navigate to keyboard module
		UserHomePage uhp = new UserHomePage(driver);
		uhp.getkeyboardModule().click();
		
		//Click on add button
		ProductCategoryPage pcp = new ProductCategoryPage(driver);
		pcp.getaddButton().click();
		
		//click on the customer added 
		PointOfSalesPage posp = new PointOfSalesPage(driver);
		Thread.sleep(2000);
	    wlib.select(posp.getcustomerDD(), "Vicky Veer");
	    uhp.logoutAsUser();
	    
	}

}
