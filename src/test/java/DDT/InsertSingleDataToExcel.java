package DDT;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class InsertSingleDataToExcel {

	public static void main(String[] args) throws Throwable {
		 
		//step1:- path connections
		FileInputStream fis = new FileInputStream("C:\\ADVANCEDseleniumVideos\\\\AdvSelSHPBHAMAMrelatedfiles\\\\FestchSingledata.xlsx");
		 
		//step2:-open workbook in read mode
		Workbook book = WorkbookFactory.create(fis);
		
		//step3:-get the control of the Sheet
		Sheet sheet = book.getSheet("Sheet1");
		
		//step4:-get the control of the row
		Row row = sheet.createRow(1);
		
		//step5:-get the control of the cell
		Cell cell = row.createCell(2);
		
		//step6:- insert /create value
		cell.setCellValue("I will be the expert in java and selenium");
		
		//step7:- keep work book in write mode
		FileOutputStream fos = new FileOutputStream("C:\\ADVANCEDseleniumVideos\\\\AdvSelSHPBHAMAMrelatedfiles\\\\FestchSingledata.xlsx");
		book.write(fos);
		book.close();
		

	}

}
