package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WindowSwitchingToProductPage {

	public WindowSwitchingToProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@name=\"search_text\"]")
	private WebElement productName;

	@FindBy(xpath = "//input[@name='search']")
	private WebElement productSearch;

	public WebElement getProductName() {
		return productName;
	}

	public WebElement getProductSearch() {
		return productSearch;
	}

//Business Logics
	/**
	 * this method is used to send product name to search textfield
	 * 
	 * @param prdName
	 */
	public void enterProductName(String prdName) {
		productName.sendKeys(prdName);
	}

	/**
	 * this method is used to click on searchNow button
	 */
	public void searchPrdName() {
		productSearch.click();
	}

	/**
	 * this method is used to click on product created
	 * 
	 * @param driver
	 * @param productData
	 */
	public void prdNamePresent(WebDriver driver, String productData) {
		driver.findElement(By.xpath("//a[text()='" + productData + "']")).click();
	}

}
