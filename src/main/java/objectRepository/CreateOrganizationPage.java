package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrganizationPage {
	
	//initilzation
			public CreateOrganizationPage(WebDriver driver)
			{
				PageFactory.initElements(driver, this);
			}
			
	//Declaration
			@FindBy(css = "[alt='Create Organization...']")
			private WebElement organizationPlusSign;
			
			@FindBy(name = "accountname")
			private WebElement organizationName;
			
			@FindBy(id = "phone")
			private WebElement organizationPhoneNum;
			
			@FindBy(id = "email1")
			private WebElement organizationEmailId;
			
			@FindBy(xpath = "//input[@title='Save [Alt+S]']")
			private WebElement saveButton;
			
			
	//getter()Method
			public WebElement getOrganizationPlusSign() {
				return organizationPlusSign;
			}

			public WebElement getOrganizationName() {
				return organizationName;
			}

			public WebElement getOrganizationPhoneNum() {
				return organizationPhoneNum;
			}

			public WebElement getOrganizationEmailId() {
				return organizationEmailId;
			}
			
			public WebElement getSaveButton() {
				return saveButton;
			}
			
	//Business Logic
			
            /**
             * This method is used to click on + sign
             */
			public void clickOrgPlusSign()
			{
				organizationPlusSign.click();
			}
			
			/**
			 * This method is used to enter organization name
			 * @param OrgName
			 */
			public void enterOrgName(String OrgName)
			{
				organizationName.sendKeys(OrgName);
			}
			/**
			 * this method is used to enter Phone Number
			 * @param phoneNum
			 */
			public void enterOrgPhoneNum(String phoneNum)
			{
				organizationPhoneNum.sendKeys(phoneNum);
			}
			
			/**
			 * This method is used to enter organization email
			 * @param Email
			 */
			public void enterOrgEmail(String Email)
			{
				organizationEmailId.sendKeys(Email);
			}
			
			/**
			 * This methods is used to enter organization data
			 * @param OrgName
			 * @param phoneNum
			 * @param Email
			 * @author Annapoorna
			 */
		    public void orgData(String OrgName,String phoneNum,String Email)
			{
				organizationName.sendKeys(OrgName);
				organizationPhoneNum.sendKeys(phoneNum);
				organizationEmailId.sendKeys(Email);
			}
			
			/**
			 * This method is used to click on save button
			 */
			public void clickSaveButton()
			{
				saveButton.click();
			}
			
	
	

}
