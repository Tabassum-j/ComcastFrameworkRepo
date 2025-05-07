package smokeTestCase;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import objectRepository.AdminHomePage;
import objectRepository.LoginPage;
import baseClassUtility.BaseClass;
@Listeners(listnerUtility.ListnerImplClass.class)
public class AdminSupplierModule extends BaseClass {
	@Test(groups = "SmokeTest")
	public void adminSupplierModule() throws InterruptedException, IOException {
		LoginPage lp = new LoginPage(driver);
		lp.loginAsAdmin();
		System.out.println("Login was sucessful");

		// Navigate to supplier module
		AdminHomePage ahp = new AdminHomePage(driver);
		ahp.getsupplierModule().click();
		System.out.println("Clicked");
		//Thread.sleep(5000);
		ahp.logoutAsAdmin();
		System.out.println("Logout was sucessful");
	}

}
