package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage{
	  
	public AccountRegistrationPage (WebDriver driver)
	 {
		 super(driver);
	 }

	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement firstname;
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement lastname;
	@FindBy(xpath="//input[@id='input-email']")
	WebElement email;
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement telephone;
	@FindBy(xpath="//input[@id='input-password']")
	WebElement password;
	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement confirmpass;
	@FindBy(xpath="//input[@name='agree']")
	WebElement checkbox;
	@FindBy(xpath="//input[@value='Continue']")
	WebElement cont;
	
	
	
	public void Setfirstname(String fname){
		firstname.sendKeys(fname);
	}
	public void Setlastname(String lname){
		lastname.sendKeys(lname);
	}
	public void Setemail(String mail){
		email.sendKeys(mail);
	}
	public void Settele(String phone){
		telephone.sendKeys(phone);
	}
	
	public void Setpassword(String pass){
		password.sendKeys(pass);
	}
	public void Confirmpassword(String cpass){
		confirmpass.sendKeys(cpass);
	}
	public void Agreebox(){
		checkbox.click();
	}
	public void Clickcontinue(){
		cont.click();
	}
}