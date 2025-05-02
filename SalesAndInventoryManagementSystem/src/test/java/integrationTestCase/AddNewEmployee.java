package integrationTestCase;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import objectRepository.AddNewEmployeePopUP;
import objectRepository.AdminHomePage;
import objectRepository.EmployeeDetailsPage;
import objectRepository.LoginPage;
import baseClassUtility.BaseClass;

public class AddNewEmployee extends BaseClass {
	@Test(groups="RegressionTest")
	public void AddNewEmployeeAndVerify() throws EncryptedDocumentException, IOException, InterruptedException {
		
		
		//Read test script data from excel
		String FIRSTNAME = elib.getDataFromExcel("IntegrationTestCase", 5, 0);
		String LASTNAME = elib.getDataFromExcel("IntegrationTestCase", 5, 1);
		String EMAIL = elib.getDataFromExcel("IntegrationTestCase", 5, 2);
		String PHONENUMBER = elib.getDataFromExcel("IntegrationTestCase", 5, 3);
		String HIREDATE = elib.getDataFromExcel("IntegrationTestCase",5 ,4 );
		
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
		  wlib.waitForElementPresent(driver,anep.getFirstNameEdt()); 
		  anep.getFirstNameEdt().sendKeys(FIRSTNAME);
		  wlib.waitForElementPresent(driver,anep.getLastNameEdt());
		  anep.getLastNameEdt().sendKeys(LASTNAME);
		  wlib.waitForElementPresent(driver,anep.getGenderDD());
		  wlib.select(anep.getGenderDD(),"Male");
		  wlib.waitForElementPresent(driver,anep.getEmailEdt());
		  anep.getEmailEdt().sendKeys(EMAIL);
		  wlib.waitForElementPresent(driver,anep.getPhonenumberEdt());
		  anep.getPhonenumberEdt().sendKeys(PHONENUMBER+jlib.getRandomNumber());
		  wlib.waitForElementPresent(driver,anep.getJobsDD());
		  wlib.select(anep.getJobsDD(),"Manager");
		  anep.getJobsDD().sendKeys(Keys.TAB);
		  Thread.sleep(3000);
		  wlib.waitForElementPresent(driver,anep.getHireddateEdt());
		  anep.getHireddateEdt().sendKeys(HIREDATE.toString());
		  wlib.waitForElementPresent(driver,anep.getProvinceDD());
		  wlib.select(anep.getProvinceDD(), "Abra");
		  wlib.waitForElementPresent(driver,anep.getCityDD());
		  wlib.select(anep.getCityDD(),"Pilar"); 
		  anep.getSaveBtn().click();
		  
		  // Search the employee detail 
		  edp.getsearchEdt().sendKeys(FIRSTNAME); 
		  String actFirstName =driver.findElement(By.xpath("//td[@class='sorting_1' and text()='"+FIRSTNAME+ "']")).getText();
		  
		  //Verify
		 boolean verify = actFirstName.contains(FIRSTNAME);
		  Assert.assertEquals(verify,true);
		  
		  ahp.logoutAsAdmin();
		 
	}

}
