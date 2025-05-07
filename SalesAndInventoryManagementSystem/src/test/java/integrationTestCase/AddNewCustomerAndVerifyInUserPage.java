package integrationTestCase;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import objectRepository.AddNewCustomerPopup;
import objectRepository.AdminHomePage;
import objectRepository.CustomerDetailsPage;
import objectRepository.LoginPage;
import objectRepository.PointOfSalesPage;
import objectRepository.ProductCategoryPage;
import objectRepository.UserHomePage;
import baseClassUtility.BaseClass;
@Listeners(listnerUtility.ListnerImplClass.class)
public class AddNewCustomerAndVerifyInUserPage extends BaseClass{
	
	@Test (groups="RegressionTest")
	public void addNewCustomerAndVeerifyInUser() throws EncryptedDocumentException, IOException, InterruptedException {
		
		
		 LoginPage lp = new LoginPage(driver);
		    lp.loginAsAdmin();
		
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
		
		ancp.addCustomer();
		
		
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
