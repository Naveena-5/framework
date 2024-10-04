package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
	
	public LoginPage (WebDriver driver)
	 {
		 super(driver);
	 }
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement loginmail;
    @FindBy(xpath="//input[@id='input-password']")
    WebElement loginpass;
    @FindBy(xpath="//input[@value='Login']")
    WebElement login;
	
	public void Entermail(String lmail)
	{
		loginmail.sendKeys(lmail);
	}
    
	public void Enterlpass(String lpass)
	{
		loginpass.sendKeys(lpass);
	}
	public void Clicklogin(){
		login.click();
	}
}