package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ValidationAndVerification {
	
	public ValidationAndVerification(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	/**
	 * this method is used validate actual data we are passing to campain name matching with expected data. //expected data is what we stored in excel data
	 * @param driver
	 * @param campaignName
	 */
	public void campData(WebDriver driver,String campaignName )
	{
		String actData = driver.findElement(By.xpath("//span[@id=\"dtlview_Campaign Name\"]")).getText();
		if (actData.contains(campaignName)) 
		{
			System.out.println("CampaignData Data is matched");
		}
		else
		{
			System.out.println("CampaignData Data is not matched");
		}
	}
	/**
	 * this method is used validate actual data we are passing to Product name is matching with expected data
	 * @param driver
	 * @param prdName
	 */
	public void productInCamp(WebDriver driver,String prdName)
	{
		String actData = driver.findElement(By.xpath("//td[@id=\"mouseArea_Product\"]")).getText();
	      	if (actData.contains(prdName)) 
			{
				System.out.println("ProductData is matched");
			}
			else
			{
				System.out.println("ProductData is not matched");
			}
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
