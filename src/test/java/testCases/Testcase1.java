package testCases;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class Testcase1 extends BaseClass{
	
   
    
    @Test(groups="Regression")
	public void testcase() 
	{   
    	//logger.info("Started Test case execution");
    	
    		HomePage hp=new HomePage(driver);
            hp.ClickAccount();
    		//logger.info("clicked on account successfully");
    		//hp.Clicklogin();
    		//logger.info("clicked on login successfully");
    		hp.ClickRegister();
    		//logger.info("clicked on register successfully");
    		AccountRegistrationPage rp= new AccountRegistrationPage(driver);
    		rp.Setfirstname("David");
    		rp.Setlastname("Abaram");
    		//rp.Setemail("JohnDavidAbraham123@gmail.com");
    		rp.Setemail(Randomstring()+"@gmail.com");
    		rp.Settele("123455678");
    		rp.Setpassword("JohnDavid123");
    		rp.Confirmpassword("JohnDavid123");
    		//logger.info("Entered all the details successfully");
    		rp.Agreebox();
    		rp.Clickcontinue(); 
    		//logger.info("Registered successfully");
    		
    		/*
    		LoginPage lp=new LoginPage(driver);
    		lp.Entermail("JohnDavidAbraham123@gmail.com");
    		lp.Enterlpass("JohnDavid123");
    		lp.Clicklogin();
    		logger.info("login successful");
    		
    		MyAccountPage ap=new MyAccountPage(driver);
    		boolean t1=ap.Accountlink();
    		Assert.assertTrue(t1);
    		ap.clicklogout();*/
    	    
    	/* catch(Exception e)
    	{   
    		logger.error("not able to register/login");
    		logger.debug("Debug logs");
    	} */
    	
    	//logger.info("Test case execution completed");
    	 
    	 
		
	}
    
    

}