package DDT;

import java.io.FileInputStream;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;




public class FetchDataFromExcelUsingMap {

	public static void main(String[] args) throws Throwable {
		
		FileInputStream fis = new FileInputStream("./src\\test\\resources\\FetchDataUsingmap_TestData.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet("Sheet2");
		int rows = sheet.getLastRowNum();//50
		System.out.println(rows);//3
		
	LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();//object creation of Linkehashmap
		
		for (int i=0;i<=rows;i++)
		{
			String key = sheet.getRow(i).getCell(0).toString(); 
			String value = sheet.getRow(i).getCell(1).toString();
			map.put(key, value); ////map.put :-to insert new key-value pairs inside a map
		}
		
	for (Entry<String, String> m: map.entrySet()) 
		{
			System.out.println(m.getKey()+" "+m.getValue());
		} 
		
		
//**entryset() - create and returns a set containing all of the entries in the map
	//or The java.util.HashMap.entrySet() method in Java is used to create a set out of the same elements 
	//contained in the hash map. It basically returns a set view of the hash map or we can create a 
	//new set and store the map elements into them.
		
//**LinkedHashMap means
	//stores the values based on the unique key in insertion order.
	
//**tostring() :- used internally by Java when an object needs to be displayed as a text (like in HTML), 
	     //or when an object needs to be used as a string.
		
		
		

	}

}

