package DDT;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WriteMultipleDataToExcel {

	public static void main(String[] args) throws Throwable {
		
	       
	       
	    //step1:- Path Setting  
	    FileInputStream fes = new  FileInputStream("C:\\Users\\chand\\Downloads\\fetchExcelData.xlsx");
	      
	   //step2:- open the workbook in read mode
	      Workbook book = WorkbookFactory.create(fes);
	      
	    //step3:- get control to the sheet
	      Sheet sheet = book.getSheet("Data");
	     
	      WebDriver driver=new ChromeDriver(); 
	  	  driver.manage().window().maximize();
	      driver.get("https://www.amazon.in");
	      
	     List<WebElement> allLinks = driver.findElements(By.xpath("//a"));
	     int count=allLinks.size();//120
	     
	     for (int i = 0; i < count; i++) 
	     {
			Row row = sheet.createRow(i);//2
			Cell cel = row.createCell(0);//0
			cel.setCellValue(allLinks.get(i).getAttribute("href"));
		}
	     
	     FileOutputStream fos = new FileOutputStream("C:\\Users\\chand\\Downloads\\fetchExcelData.xlsx");
	     book.write(fos);
	     book.close();
	     
	}

}
