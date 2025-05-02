package smokeTestCase;

import org.testng.annotations.Test;

import objectRepository.AdminHomePage;
import objectRepository.LoginPage;
import baseClassUtility.BaseClass;


public class AdminLogin extends BaseClass{
	@Test(groups = "smokeTest")
	public void loginAsAdmin() throws InterruptedException {
		 LoginPage lp = new LoginPage(driver);
		    lp.loginAsAdmin();
		System.out.println("Login was sucessful");
		AdminHomePage ahp = new AdminHomePage(driver);
		ahp.logoutAsAdmin();
		System.out.println("Logout was sucessful");
		}

}
