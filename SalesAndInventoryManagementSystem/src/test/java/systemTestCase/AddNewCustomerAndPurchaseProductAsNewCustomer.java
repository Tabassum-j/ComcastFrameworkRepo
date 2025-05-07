package systemTestCase;

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
import objectRepository.SummaryPage;
import objectRepository.UserHomePage;
import baseClassUtility.BaseClass;
@Listeners(listnerUtility.ListnerImplClass.class)
public class AddNewCustomerAndPurchaseProductAsNewCustomer extends BaseClass {
	
	@Test(groups={"SmokeTest", "RegressionTest"})
	public void addNewCustomer() throws EncryptedDocumentException, IOException, InterruptedException {
		
				LoginPage lp = new LoginPage(driver);
			    lp.loginAsAdmin();
				
				//Navigate to customer page
				AdminHomePage ahp = new AdminHomePage(driver);
				Thread.sleep(2000);	
				ahp.getcustomerModule().click();
				Actions act=new Actions(driver);
				act.click(ahp.getcustomerModule()).perform();
				
				//click on add customer button
				CustomerDetailsPage cdp = new CustomerDetailsPage(driver);
				Thread.sleep(5000);	
				cdp.getaddBtn().click();
				Thread.sleep(5000);
				
				//Click on add new Customer
				AddNewCustomerPopup ancp = new AddNewCustomerPopup(driver);
				/*
				 * wlib.waitForElementPresent(driver,ancp.getFirstNameEdt() );
				 * ancp.getFirstNameEdt().sendKeys(FIRSTNAME);
				 * wlib.waitForElementPresent(driver, ancp.getLasstNameEdt());
				 * ancp.getLasstNameEdt().sendKeys(LASTNAME);
				 * wlib.waitForElementPresent(driver,ancp.getPhoneNumberEdt() );
				 * ancp.getPhoneNumberEdt().sendKeys(PHONENUMBER);
				 */
				ancp.customerInfo();
				wlib.javaScriptclickOnWE(driver, ancp.getsaveBtn());
				
				ahp.logoutAsAdmin();
				

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
				
				// Select customer
				wlib.select(posp.getcustomerDD(), "Vicky Veer");
				Thread.sleep(2000);
				wlib.javaScriptclickOnWE(driver, posp.getsubmitBtn());
			   
			    
			    //Enter the amount displayed
			    SummaryPage sp = new SummaryPage(driver);
			    String amount = sp.amountText().toString();
			    System.out.println(amount);
			    sp.getamountEdt().sendKeys("5000");
			    wlib.waitForElementPresent(driver, sp.getpaymentBtn());
			  
			    //Click on save button
				sp.getpaymentBtn().click();
				Thread.sleep(5000);
				wlib.switchToAlertAndAccept(driver);

				uhp.logoutAsUser();
			    
			   
			}

	}

