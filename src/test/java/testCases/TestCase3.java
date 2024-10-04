package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProvider2;

public class TestCase3 extends BaseClass{
    
	@Test(dataProvider="LoginData",dataProviderClass=DataProvider2.class)
	public void DDTlogin(String email,String pass,String a,String res)
	{   
		try{
		HomePage hp=new HomePage(driver);
        hp.ClickAccount();
		hp.Clicklogin();
	
		
		LoginPage lp=new LoginPage(driver);
		lp.Entermail(email);
		lp.Enterlpass(pass);
		lp.Clicklogin();
		
		MyAccountPage ap=new MyAccountPage(driver);
		boolean t1=ap.Accountlink();
		System.out.println(t1);
		
		if(res.equalsIgnoreCase("Valid"))
		{
			if(t1==true)
			{
				ap.clicklogout();
				Assert.assertTrue(true);
				
			}
			else
			{
				Assert.assertTrue(false);
				
			}
		}
		if(res.equalsIgnoreCase("invalid"))
		{
			if(t1==true)
			{
				ap.clicklogout();
				Assert.assertTrue(false);
			}
			else
			{	
				Assert.assertTrue(true);
			}
		}
		else
		{
			Assert.assertTrue(false);
		}
		}
		catch(Exception e)
		{
			Assert.fail();
		}
	}
}
