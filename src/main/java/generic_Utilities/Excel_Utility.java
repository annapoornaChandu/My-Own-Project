package generic_Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_Utility {

	/**
	 * It is used to read data from excel
	 * 
	 * @param sheetName
	 * @param rowNum
	 * @return
	 * @throws Throwable
	 * @author Annapoorna
	 */
	public String getExcelData(String sheetName, int rowNum,int cellNum) throws Throwable {

		FileInputStream fis2 = new FileInputStream(
				"C:\\AdvancedSelenium\\AdvSelSHPBHAMAMrelatedfiles\\createcampaignwithproduct.xlsx");
		Workbook book = WorkbookFactory.create(fis2);
		Sheet sheet = book.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(cellNum);
		String ExcelData = cell.getStringCellValue();
		return ExcelData;
	}

	/**
	 * This method is used to read data from excel using DataFormatter approach
	 * 
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return
	 * @throws Throwable
	 * @author Annapoorna
	 */
	public String readExcelDataUsingDataFormatter(String sheetName, int rowNum, int cellNum) throws Throwable {

		FileInputStream fis2 = new FileInputStream(
				"C:\\AdvancedSelenium\\AdvSelSHPBHAMAMrelatedfiles\\createcampaignwithproduct.xlsx");
		Workbook book = WorkbookFactory.create(fis2);
		Sheet sheet = book.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(cellNum);
		DataFormatter format = new DataFormatter();
		String ExcelData = format.formatCellValue(cell);
		return ExcelData;
	}

	/**
	 * This method is used to write data to Excel
	 * 
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @param data
	 * @throws Throwable
	 * @author Annapoorna
	 */
	public void insertDataToExcel(String sheetName, int rowNum, int cellNum, String data) throws Throwable {

		FileInputStream fis = new FileInputStream(
				"C:\\ADVANCEDseleniumVideos\\\\AdvSelSHPBHAMAMrelatedfiles\\\\FestchSingledata.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet(sheetName);
		Row row = sheet.createRow(rowNum);
		Cell cell = row.createCell(cellNum);
		cell.setCellValue(data);
		FileOutputStream fos = new FileOutputStream(
				"C:\\ADVANCEDseleniumVideos\\\\AdvSelSHPBHAMAMrelatedfiles\\\\FestchSingledata.xlsx");
		book.write(fos);
		book.close();
	}
	
	public Object[][] readDataUsingDataProvider(String sheetName) throws Throwable
	{
		FileInputStream fis = new FileInputStream("C:\\Users\\chand\\Downloads\\DataproviderEx4.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet(sheetName);
		int lastRow = sheet.getLastRowNum()+1;//not read the last set data if we wonot give +1
		int lastcell = sheet.getRow(0).getLastCellNum();
		
		Object[][] objArr = new Object[lastRow][lastcell];
		
		for (int i=0;i<lastRow;i++)
		{
			for(int j=0;j<lastcell;j++)
			{
				objArr[i][j]=sheet.getRow(i).getCell(j).toString();
					
			}
			
		}
		return objArr;
		
	} 
	
	
	
	

}
