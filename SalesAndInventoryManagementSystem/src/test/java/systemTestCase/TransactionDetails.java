package systemTestCase;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import objectRepository.AdminHomePage;
import objectRepository.LoginPage;
import objectRepository.PointOfSalesPage;
import objectRepository.ProductCategoryPage;
import objectRepository.SummaryPage;
import objectRepository.TransactionPage;
import objectRepository.UserHomePage;
import baseClassUtility.BaseClass;


public class TransactionDetails extends BaseClass {
	@Test(groups="RegressionTest")
	public void verifyTransactionDetails() throws InterruptedException {
		
		//Login as user
		LoginPage lp = new LoginPage(driver);
		lp.loginAsUser();
		
		//Click on keyboard module
		UserHomePage uhp = new UserHomePage(driver);
		uhp.getkeyboardModule().click();
		
		//Click on add
		ProductCategoryPage pcp = new ProductCategoryPage(driver);
		pcp.getaddButton().click();
		
		//Select customer and submit
		PointOfSalesPage posp = new PointOfSalesPage(driver);
		wlib.select(posp.getcustomerDD(), "Vicky Veer");
		Thread.sleep(2000);
		wlib.javaScriptclickOnWE(driver, posp.getsubmitBtn());

		// Enter the amount visible
		SummaryPage sp = new SummaryPage(driver);
		sp.getamountEdt().sendKeys("5000");
		wlib.waitForElementPresent(driver, sp.getpaymentBtn());

		// Click on save button
		sp.getpaymentBtn().click();
		Thread.sleep(5000);
		wlib.switchToAlertAndAccept(driver);

		uhp.logoutAsUser();

		    lp.loginAsAdmin();
		    AdminHomePage ahp = new AdminHomePage(driver);
		    ahp.gettransactionModule().click();
		    
		    TransactionPage tp = new TransactionPage(driver);
		    tp.getsearchEdt().sendKeys("Vicky Veer", Keys.ENTER);
		    driver.findElement(By.xpath("//td[text()='Vicky Veer']"));
		    System.out.println("Transaction done--->PASS");
	}

}
