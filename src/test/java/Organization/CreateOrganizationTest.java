package Organization;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import generic_Utilities.BaseClass;
import generic_Utilities.Excel_Utility;
import generic_Utilities.File_Utility;
import generic_Utilities.Java_Utility;
import generic_Utilities.WebDriver_Utility;
import objectRepository.CreateCampaignsPage;
import objectRepository.CreateOrganizationPage;
import objectRepository.CreateProductPage;
import objectRepository.HomePage;
import objectRepository.ValidationAndVerification;
import objectRepository.VtigetLoginPage;
//@Listeners(generic_Utilities.ListenerImplementation.class)
//@Listeners(generic_Utilities.ExtentReportImplementation.class)
public class CreateOrganizationTest extends BaseClass {

	// Scenario-1 Login to vtiger application->click on organizations link->click on
	// create organization lookup image->
	// Enter organisation name,phone number and email->click on save Btn->verify
	// whether the organization
	// is created in Organization Information page and Logout from the application.
	
   @Test(groups = {"smokeTest","regressionTest"})
	//@Test(retryAnalyzer = generic_Utilities.RetryImplementation.class)
	//@Test
	public void CreateOrganizationTest() throws Throwable {
		
	
		HomePage home = new HomePage(driver);
		home.clickOrganizationLink();
		
		CreateOrganizationPage orgPage = new CreateOrganizationPage(driver);//object creation of CreateOrganizationPage(POM class)
		orgPage.clickOrgPlusSign();
		
		//Assert.assertEquals(false, true);
		
		int ranNum = jlib.getRandomNum();
		
		String organizationData = elib.readExcelDataUsingDataFormatter("Organization", 0, 0)+ranNum;
		String phoneNum = elib.readExcelDataUsingDataFormatter("Organization", 2, 1);
	    String emailId = elib.readExcelDataUsingDataFormatter("Organization", 3, 1);	
	    orgPage.orgData(organizationData, phoneNum, emailId);
	    
	   // Assert.fail();
	    
	    orgPage.clickSaveButton();
	    Thread.sleep(2000);
  
	        
	    
   }
}



