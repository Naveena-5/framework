package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TestCase2 extends BaseClass{

	 @Test(groups="Sanity")
		public void testcase() 
		
		{   
	    	//logger.info("Started Test case execution");
	    	
	    		HomePage hp=new HomePage(driver);
	            hp.ClickAccount();
	    		//logger.info("clicked on account successfully");
	    		hp.Clicklogin();
	    		//logger.info("clicked on login successfully");
	    	
	    		
	    		LoginPage lp=new LoginPage(driver);
	    		lp.Entermail("JohnDavidAbraham123@gmail.com");
	    		lp.Enterlpass("JohnDavid123");
	    		lp.Clicklogin();
	    		//logger.info("login successful");
	    		
	    		MyAccountPage ap=new MyAccountPage(driver);
	    		boolean t1=ap.Accountlink();
	    		Assert.assertTrue(t1);
	    		ap.clicklogout();
	    	
	    	//logger.info("Test case execution completed");
	    	 
	    	 
			
		}
	    
	    

	}