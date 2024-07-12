package generic_Utilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class WebDriver_Utility {
	
	/**
	 * this method is used for maximizing window
	 * @param driver
	 * @author Annapoorna
	 */
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	/**
	 * this method is used to wait all elements to get loaded into GUI
	 * version 3
	 * @param driver
	 * @author Annapoorna
	 */
	
	public void waitForElementToLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	
	/**
	 * this method is used to wait all elements to get loaded into GUI
	 * version 4
	 * @param driver
	 * @author Annapoorna
	 */
	public void elementsTogetLoaded(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	/**
	 * this method is used to switch windows
	 * @param driver
	 * @param partialText
	 * @author Annapoorna
	 */
	public void switchingWindows(WebDriver driver,String partialText) 
	{
		Set<String> wins = driver.getWindowHandles();
		Iterator<String> it = wins.iterator();
		while (it.hasNext()) 
		{
			String win = it.next();
			driver.switchTo().window(win);
			String currentTitle = driver.getTitle();
			if (currentTitle.contains("partialText")) 
			{
				break;
			}
		}
		
	 }
	
	/**
	 * this method is used to accept the alert popup
	 * @param driver
	 * @author Annapoorna
	 */
	public void alertAccept(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	/**
	 * this method is used to dismiss the alert popup
	 * @param driver
	 */
	public void alertDismiss(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	/**
	 * this method is used to handle dropdown using Select class(SelectByIndex)
	 * @param ele
	 * @param value
	 * @author Annapoorna
	 */
	public void selectByIndexApproach(WebElement ele,int value)
	{
		Select select = new Select(ele);
		select.selectByIndex(value);
	}
	
	/**
	 * this method is used to handle dropdown using select class(SelectByValue)
	 * @param ele
	 * @param value
	 */
	public void selectByValueApproach(WebElement ele,String value)
	{
		Select select = new Select(ele);
		select.selectByValue(value);
	}
	
	/**
	 * this method is used to handle dropdown using select class(SelectByVisibleText)
	 * @param ele
	 * @param text
	 */
	public void selectByVisibleTextApproach(WebElement ele,String text)
	{
		Select select = new Select(ele);
		select.selectByVisibleText(text);
	}
	
	public void moveToElement(WebDriver driver,WebElement ele) 
	{
	    Actions act = new Actions(driver);
	    act.moveToElement(ele).perform();
	}
	
	public static String takeScreenShot(WebDriver driver,String screenShotName) throws Throwable
	{
		 TakesScreenshot ts = (TakesScreenshot)driver;
		 File src = ts.getScreenshotAs(OutputType.FILE);
		 File dst = new File("./ScreeShots/"+screenShotName+".png");
		 FileUtils.copyFile(src, dst);
		 return dst.getAbsolutePath(); //each time when we generate screenshot it takes same path - getAbosulutepath()
		 
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
