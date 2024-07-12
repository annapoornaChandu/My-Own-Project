	package campaigns;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import generic_Utilities.BaseClass;
import generic_Utilities.Excel_Utility;
import generic_Utilities.File_Utility;
import generic_Utilities.Java_Utility;
import generic_Utilities.WebDriver_Utility;
import objectRepository.CreateCampaignsPage;
import objectRepository.CreateProductPage;
import objectRepository.HomePage;
import objectRepository.ValidationAndVerification;
import objectRepository.VtigetLoginPage;
import objectRepository.WindowSwitchingToProductPage;


public class CreateCapmpaignsWithProductTest extends BaseClass{
    @Test(groups = "regressionTest")
	public void CreateCapmpaignsWithProductTest()  throws Throwable {
		
		
		int ranNum = jlib.getRandomNum();
		
		
		HomePage home = new HomePage(driver);
		home.clickProductLink();
		
		CreateProductPage prdPage = new CreateProductPage(driver);//object creation of createProductPage
		prdPage.clickOnPlusSign();
		
	
		String productData = elib.getExcelData("Product", 0, 0)+ranNum;
		
		prdPage.enterProductName(productData);
		prdPage.clickSaveButton();
		home.clickMoreLink();
		home.clickCampaignLink();
		
		CreateCampaignsPage campPage = new CreateCampaignsPage(driver);
		campPage.clickCampPlusSign();
       
        String campaignData=elib.getExcelData("Campaign", 0, 0)+ranNum;
		
		
		campPage.enterCampName(campaignData);
		driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")).click();
		campPage.clickProductPlusSign();
		
	
       wlib.switchingWindows(driver,"Products&action");  //SWITCHING WINDOW
		
		WindowSwitchingToProductPage campPrdPage = new WindowSwitchingToProductPage(driver);//object creation
		campPrdPage.enterProductName(productData);
		campPrdPage.searchPrdName();
		campPrdPage.prdNamePresent(driver, productData);
		
		
        wlib.switchingWindows(driver,"Campaigns&action");
		
	    CreateCampaignsPage campaigh = new CreateCampaignsPage(driver);
		campaigh.clickOnSaveButton();

		ValidationAndVerification campProdValidation = new ValidationAndVerification(driver);
		campProdValidation.campData(driver, campaignData);
		campProdValidation.productInCamp(driver, productData);
		
	   
      		
        
       
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

			}
}
