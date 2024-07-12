package generic_Utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportImplementation implements ITestListener{
	
	ExtentReports report;
	ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) 
	{
		test=report.createTest(result.getMethod().getMethodName());
		
	}

	@Override
	public void onTestSuccess(ITestResult result) 
	{
	   test.log(Status.PASS,result.getMethod().getMethodName() );
	   test.log(Status.PASS,result.getThrowable() );//getThrowable() method will handle if any exception comes
	}

	@Override
	public void onTestFailure(ITestResult result)
	{
		 test.log(Status.FAIL,result.getMethod().getMethodName() );
		 test.log(Status.FAIL,result.getThrowable() );
		 
		 System.out.println("<------------I am Listening,Test Script has failed------------>");
		 
		 String screenShot = null;
		 
			 try {
				screenShot=WebDriver_Utility.takeScreenShot(BaseClass.sDriver,result.getMethod().getMethodName() );
			} catch (Throwable e) {
				
				e.printStackTrace();
			}
			 
              test.addScreenCaptureFromPath(screenShot);
			
		}

	@Override
	public void onTestSkipped(ITestResult result) 
	{
	   test.log(Status.SKIP, result.getMethod().getMethodName());
	   test.log(Status.SKIP,result.getThrowable() );
	   
	}

	@Override
	public void onStart(ITestContext context)
	{
		Java_Utility jlib = new Java_Utility();
		int ranNum = jlib.getRandomNum(); //every execution i donot want to override the screenshot taken previously soo randaon Class addedd 
		
	    ExtentSparkReporter spark = new ExtentSparkReporter("ExtentReports/Report.html"+ranNum);
	    spark.config().setTheme(Theme.STANDARD);
	    spark.config().setDocumentTitle("Testing");
	    spark.config().setReportName("Annapoorna");
	    
	    report=new ExtentReports();
	    report.attachReporter(spark);
	    report.setSystemInfo("platform","windows10");
	    report.setSystemInfo("executed by", "Annapoorna");
	    report.setSystemInfo("reviwed by", "Chandu Mylavaram");
	}

	@Override
	public void onFinish(ITestContext context) 
	{
		report.flush();
	}


	
}
