package generic_Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import objectRepository.HomePage;
import objectRepository.VtigetLoginPage;

public class BaseClass {
    public static WebDriver sDriver;
	public WebDriver driver;

	public File_Utility flib = new File_Utility();
	public WebDriver_Utility wlib = new WebDriver_Utility();
	public Java_Utility jlib = new Java_Utility();
	public Excel_Utility elib = new Excel_Utility();
	public DataBaseUtility dlib=new DataBaseUtility();
	
	
	@BeforeSuite(groups = {"smokeTest","regressionTest"})
	public void bs() throws Throwable {
		dlib.dataBaseConnection(driver);
		System.out.println("DataBase Connection");
	}

	@BeforeTest(groups = {"smokeTest","regressionTest"})
	public void bt() {
		{
			System.out.println("Parallel execution");
		}
	}
	

	@BeforeClass(groups = {"smokeTest","regressionTest"})
	public void bc() throws Throwable {
		// File_Utility flib = new File_Utility();
		String BROWSER = flib.getKeyAndValueData("browser");
		
//Caling from Command Prompt(instead of calling from propertyfile, here calling from cmd)
		//String BROWSER = System.getProperty("browser");
		
		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new ChromeDriver();
		}
		System.out.println("Browser launched");
		sDriver=driver; //driver is initialized to sDriver
	}

	@BeforeMethod(groups = {"smokeTest","regressionTest"})
	public void bm() throws Throwable {
		// File_Utility flib = new File_Utility();
	// File_Utility class implementation
		String URL = flib.getKeyAndValueData("url");
		String USERNAME = flib.getKeyAndValueData("username");
		String PASSWORD = flib.getKeyAndValueData("password");
		
/*Caling from Command Prompt(instead of calling from propertyfile, here calling from cmd)
		String URL = System.getProperty("url");
		String  USERNAME= System.getProperty("username");
		String PASSWORD = System.getProperty("password");*/
		

		// WebDriver_Utility wlib = new WebDriver_Utility();
		// Implementation of webdriver_Utility
		wlib.maximizeWindow(driver);
		wlib.elementsTogetLoaded(driver);

		driver.get(URL);
		VtigetLoginPage login = new VtigetLoginPage(driver);
		login.loginToApp(USERNAME, PASSWORD);
		System.out.println("login to Application");
	}

	@AfterMethod(groups = {"smokeTest","regressionTest"})
	public void am() {
		HomePage home = new HomePage(driver);
		home.logOut(driver);
		System.out.println("logout from application");
	}

	@AfterClass(groups = {"smokeTest","regressionTest"})
	public void ac() {
		driver.quit();
		System.out.println("close browser");
	}

	@AfterTest(groups = {"smokeTest","regressionTest"})
	public void at() {
		System.out.println("parallel execution done");
	}

	@AfterSuite(groups = {"smokeTest","regressionTest"})
	public void as() throws Throwable {
		dlib.dataBaseClose();
		System.out.println("close database");
	}

}
