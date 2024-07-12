package product;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import generic_Utilities.BaseClass;
import generic_Utilities.Excel_Utility;
import generic_Utilities.File_Utility;
import generic_Utilities.Java_Utility;
import generic_Utilities.WebDriver_Utility;
import objectRepository.CreateProductPage;
import objectRepository.DeletePrdValidationPage;
import objectRepository.HomePage;
import objectRepository.VtigetLoginPage;

public class CreateProductandDeletePrdTest extends BaseClass {
    @Test
	public void createProductandDeletePrdTest() throws Throwable {

		
	
		HomePage home = new HomePage(driver);
		home.clickProductLink();
		
        CreateProductPage prdPage = new CreateProductPage(driver);//object creation of createProductPage
		prdPage.clickOnPlusSign();

	    int ranNum = jlib.getRandomNum();
		
	    String productData = elib.getExcelData("Product", 1, 1)+ranNum;
		System.out.println(productData);
        
        prdPage.enterProductName(productData);
        
        prdPage.clickSaveButton();
        
        home.clickProductLink();
        
        DeletePrdValidationPage prdValidate = new DeletePrdValidationPage(driver);
	    prdValidate.deleteProduct(driver, productData);
	
	    prdValidate.validateProductDeleted(driver, productData);
		 
		
		
		

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
