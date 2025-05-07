package integrationTestCase;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import objectRepository.AddNewEmployeePopUP;
import objectRepository.AdminHomePage;
import objectRepository.EmployeeDetailsPage;
import objectRepository.LoginPage;
import baseClassUtility.BaseClass;
@Listeners(listnerUtility.ListnerImplClass.class)
public class AddNewEmployee extends BaseClass {
	@Test(groups="RegressionTest")
	public void AddNewEmployeeAndVerify() throws EncryptedDocumentException, IOException, InterruptedException {
		
		
		//Read test script data from excel
		String FIRSTNAME = elib.getDataFromExcel("IntegrationTestCase", 5, 0);
		
		 LoginPage lp = new LoginPage(driver);
		 lp.loginAsAdmin();
		 
		 AdminHomePage ahp = new AdminHomePage(driver);
		 Thread.sleep(4000);
		ahp.getemployeeModule().click();
		
		
		//Navigate to employee page and click on +
		EmployeeDetailsPage edp = new EmployeeDetailsPage(driver);
		edp.getaddEmployeeBtn().click();
		
		//Enter customer details
		
		  Thread.sleep(2000);
		  AddNewEmployeePopUP anep= new AddNewEmployeePopUP(driver);
		  Thread.sleep(2000);
		  anep.employeeData();
			
		  
		  // Search the employee detail 
		  edp.getsearchEdt().sendKeys(FIRSTNAME); 
		  String actFirstName =driver.findElement(By.xpath("//td[@class='sorting_1' and text()='"+FIRSTNAME+ "']")).getText();
		  
		  //Verify
		 boolean verify = actFirstName.contains(FIRSTNAME);
		  Assert.assertEquals(verify,true);
		  
		  ahp.logoutAsAdmin();
		 
	}

}
