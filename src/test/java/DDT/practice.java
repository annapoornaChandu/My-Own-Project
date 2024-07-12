package DDT;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Properties;

import javax.swing.plaf.synth.SynthStyleFactory;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysql.jdbc.Driver;

import generic_Utilities.WebDriver_Utility;
import lombok.ToString;

public class practice {
	
	public static void main(String[] args) throws Throwable
	{
		FileInputStream fis=new FileInputStream("C:\\AdvancedSelenium\\AdvSelSHPBHAMAMrelatedfiles\\FetchDataUsingmap_TestData .xlsx");
		Workbook book=WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet("Sheet2");
		int rowNum=sheet.getLastRowNum();

		LinkedHashMap<String,String> map=new LinkedHashMap<String,String>();

		for(int i=0;i<rowNum;i++)
		{
		    String key=sheet.getRow(i).getCell(0).toString();
		    String value=sheet.getRow(i).getCell(1).toString();
		    map.put(key,value);
		}

		for(Entry<String,String> m:map.entrySet())
		{
		System.out.println(m.getKey()+" "+m.getValue());
		}

	}
}
	
	
	

