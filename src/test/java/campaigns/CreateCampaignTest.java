
package campaigns;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generic_Utilities.BaseClass;
import generic_Utilities.Excel_Utility;
import generic_Utilities.File_Utility;
import generic_Utilities.Java_Utility;
import generic_Utilities.WebDriver_Utility;
import objectRepository.CreateCampaignsPage;
import objectRepository.HomePage;
import objectRepository.ValidationAndVerification;
import objectRepository.VtigetLoginPage;

@Listeners(generic_Utilities.ListenerImplementation.class)
public class CreateCampaignTest extends BaseClass{
    @Test(groups = "smokeTest")
    
	public void CreateCampaignTest() throws Throwable {

		HomePage home = new HomePage(driver);
		home.clickMoreLink();
		home.clickCampaignLink();
		
		CreateCampaignsPage campaigh = new CreateCampaignsPage(driver);
		campaigh.clickCampPlusSign();

		int ranNum = jlib.getRandomNum();

		String campaignName = elib.readExcelDataUsingDataFormatter("Campaign", 0, 0)+ranNum;
		campaigh.enterCampName(campaignName);
		
	/*	TakesScreenshot tss = (TakesScreenshot)driver;
		File src = tss.getScreenshotAs(OutputType.FILE);
		File dst=new File("./ScreeShots/"+"pic1"+".png");
		try {
			FileUtils.copyFile(src, dst);
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		} */
		
		
        campaigh.clickOnSaveButton();
		
		//******Validation****
		ValidationAndVerification campvalidate = new ValidationAndVerification(driver);
		campvalidate.campData(driver, campaignName);
        
      
		

		

	}

}
