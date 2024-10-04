package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePage extends BasePage{
	
	public HomePage(WebDriver driver)
	 {
		 super(driver);
	 }
	
	@FindBy(xpath="//span[normalize-space()='My Account']")
	WebElement Account;
	
	@FindBy(xpath="//a[normalize-space()='Register']")
	WebElement Register;
    
	@FindBy(xpath="//a[normalize-space()='Login']")
	WebElement login;
	
	public void ClickAccount()
	{
		Account.click();
	}
	
	public void ClickRegister()
	{
		Register.click();
	}
	
	public void Clicklogin()
	{
		login.click();
	}
	
}