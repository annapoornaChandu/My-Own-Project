package generic_Utilities;

import java.sql.Connection;
import java.sql.DriverManager;


import org.openqa.selenium.WebDriver;

import com.mysql.jdbc.Driver;

public class DataBaseUtility 
{

	public void dataBaseConnection(WebDriver driver) throws Throwable
	{
		//step1:- register/load the mysql database
				Driver driverRef = new Driver();
				DriverManager.registerDriver(driverRef);
	}
	
	public void dataBaseClose() throws Throwable
	{
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jspiders","root","root");
		con.close();
	}
}
