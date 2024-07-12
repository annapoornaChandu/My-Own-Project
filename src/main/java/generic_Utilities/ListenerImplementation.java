package generic_Utilities;

import java.io.File;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerImplementation implements ITestListener
{

	@Override
	public void onTestStart(ITestResult result) {
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
	
	}

	@Override
	public void onTestFailure(ITestResult result)
	{
		System.out.println("<------I am Listening------>");
		System.out.println("<------I am Listening------>");
		
		TakesScreenshot ts = (TakesScreenshot)BaseClass.sDriver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		LocalDateTime dateTime = LocalDateTime.now();
		String currentDateTime = dateTime.toString().replace(":", "").replace(" ", "");
		File dst = new File("./ScreeShots/"+"screenShotName"+currentDateTime+".png");
		try {
			FileUtils.copyFile(src, dst);
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		
	}

	@Override
	public void onFinish(ITestContext context) {
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
