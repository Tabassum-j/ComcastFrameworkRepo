package smokeTestCase;

import org.testng.annotations.Test;

import objectRepository.LoginPage;
import objectRepository.PointOfSalesPage;
import objectRepository.ProductCategoryPage;
import objectRepository.SummaryPage;
import objectRepository.UserHomePage;
import baseClassUtility.BaseClass;

public class UserPurchaseProduct extends BaseClass {
	@Test(groups = "smokeTest")
	public void userPurchase() throws InterruptedException {

		LoginPage lp = new LoginPage(driver);
		lp.loginAsUser();
		// Click on Keyboard module
		UserHomePage uhp = new UserHomePage(driver);
		uhp.getkeyboardModule().click();

		// Click on add button
		ProductCategoryPage pcp = new ProductCategoryPage(driver);
		pcp.getaddButton().click();

		// click on customer drop down
		PointOfSalesPage posp = new PointOfSalesPage(driver);
		Thread.sleep(2000);

		// Select customer
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

	}

}
