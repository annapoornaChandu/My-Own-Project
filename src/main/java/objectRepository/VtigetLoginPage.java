package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VtigetLoginPage { //To initialize the webpage elements at the time of object creation
	
//*****initialization
	public VtigetLoginPage(WebDriver driver)//public then only i can do the objcet creation in different classes
	{
		PageFactory.initElements(driver, this);//pom is a java design pattern, when we mainitain all the web elements locators in well organized manner
		                                       //pagefactory is a extended design pattern of POM which is used to create the object of POM class, 
		                                       //at the time of object creation it executes all the @FindBy,@FindBys and @FindAll and initialize all the elements
	}
	
	
//*****Declaration
	@FindBy(name = "user_name")
	private WebElement userTextField;   //making webelement as private to achieve encapsulation - private means can access only within the class
	
	@FindBy(name = "user_password")
	private WebElement passwordTextField;
	
	@FindBy(id = "submitButton")
	private WebElement loginButton ;
	
//*****gettersMethods()
	public WebElement getUserTextField() {
		return userTextField;
	}
	
	public WebElement getPasswordTextField() {
		return passwordTextField;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}
	
//*******Business Logics********
	/**
	 * this method is used to launch the application
	 * @param userName
	 * @param passWord
	 * @author Annapoorna
	 */
	public void loginToApp(String userName,String passWord)
	{
		userTextField.sendKeys(userName);
		passwordTextField.sendKeys(passWord);
		loginButton.click();
		
	}
	
	
	

}
