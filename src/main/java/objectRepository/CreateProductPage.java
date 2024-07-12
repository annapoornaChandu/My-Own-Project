package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateProductPage {

		public CreateProductPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		
		//Declaration
		@FindBy(xpath = "//img[@alt='Create Product...']")
		private WebElement productPlusSign;
	  
		@FindBy(name="productname")
		private WebElement productNameTextField;
		
		@FindBy(xpath = "//input[@title='Save [Alt+S]']")
		private WebElement saveButton;
		
//getters
		public WebElement getProductPlusSign() {
			return productPlusSign;
		}

		public WebElement getProductNameTextField() {
			return productNameTextField;
		}

		public WebElement getSaveButton() {
			return saveButton;
		}
		
		//Business Library
		
		/**
		 * This method is used to click on Product plus sign
		 * @author Annapoorna
		 */
		public void clickOnPlusSign()
		{
			productPlusSign.click();
		}
		
		/**
		 * This method is used to enter productname 
		 * @param prdName
		 * @author Annapoorna
		 */
		public void enterProductName(String prdName)
		{
			productNameTextField.sendKeys(prdName);
		}
		
		/**
		 * this method is used to click on save button
		 * @author Annapoorna
		 */
		public void clickSaveButton()
		{
			saveButton.click();
		}
		
	}


