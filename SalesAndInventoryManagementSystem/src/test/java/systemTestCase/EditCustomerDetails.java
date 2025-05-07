package systemTestCase;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.Keys;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import objectRepository.AdminHomePage;
import objectRepository.CustomerDetailsPage;
import objectRepository.EditCustomerPage;
import objectRepository.LoginPage;
import objectRepository.PointOfSalesPage;
import objectRepository.ProductCategoryPage;
import objectRepository.UserHomePage;
import baseClassUtility.BaseClass;
@Listeners(listnerUtility.ListnerImplClass.class)
public class EditCustomerDetails extends BaseClass{
	@Test(groups={"SmokeTest", "RegressionTest"})
	public void editCustomerDetailsAndVerify() throws InterruptedException, EncryptedDocumentException, IOException {
		
		LoginPage lp = new LoginPage(driver);
	    lp.loginAsAdmin();
	    
	    //Navigate to customer page
	    AdminHomePage ahp = new AdminHomePage(driver);
	    Thread.sleep(3000);
	    ahp.getcustomerModule().click();
	    
	    //Search for the customer
	    Thread.sleep(3000);
	    CustomerDetailsPage cdp = new CustomerDetailsPage(driver);
	    Thread.sleep(3000);
	    cdp.getsearchEdt().sendKeys("Tom Jerry", Keys.ENTER);
	    
	    //Click on ... icon
	    cdp.getdotsIcon().click();
	    cdp.geteditIcon().click();
	    
	    
	    //Edit the customer
	    EditCustomerPage ecp = new EditCustomerPage(driver);
		
	    ecp.editCustomerDetails();
        Thread.sleep(2000);
        wlib.switchToAlertAndAccept(driver);
        
        ahp.logoutAsAdmin();
        
        lp.loginAsUser();
        
        UserHomePage uhp = new UserHomePage(driver);
        uhp.getkeyboardModule().click();
         
        ProductCategoryPage pcp = new ProductCategoryPage(driver);
        pcp.getaddButton().click();
        
        
        PointOfSalesPage posp = new PointOfSalesPage(driver);
        wlib.select(posp.getcustomerDD(), "Vicky Veer");
        
        uhp.logoutAsUser();
        
	    
	    
	}

}
