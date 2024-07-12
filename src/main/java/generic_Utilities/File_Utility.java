package generic_Utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class File_Utility {
	
	/**
	 * its used to return the value from property file based on key
	 * @param key
	 * @return
	 * @throws Throwable
	 * @author Annapoorna
	 */
	public String getKeyAndValueData(String key) throws Throwable {
		
		FileInputStream fis = new FileInputStream("./src\\test\\resources\\CommonData.properties");
		Properties pro = new Properties();
		pro.load(fis);
		return pro.getProperty(key);
	}
	
}
