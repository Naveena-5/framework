package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	
	

	 

	public WebDriver  driver;
	public Logger logger; 
	public Properties p;

	
	@BeforeClass(groups={"Sanity","Regression"})
	@Parameters({"os","browser"})
	public void launch(String os,String br) throws IOException, URISyntaxException
	{   
		
			FileReader file=new FileReader("./src//test//resources//config.properties");
		    p=new Properties();
		    p.load(file);
		logger=LogManager.getLogger(this.getClass()); 
		if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
		{   
			
			 DesiredCapabilities capabilities=new DesiredCapabilities();
			
			if(os.equalsIgnoreCase("windows"))
			{
				capabilities.setPlatform(Platform.WIN11);
			}
			else if(os.equalsIgnoreCase("mac"))
			{
				capabilities.setPlatform(Platform.MAC);
			}
			else if(os.equalsIgnoreCase("linux"))
			{
				capabilities.setPlatform(Platform.LINUX);
			}
			else
			{
				System.out.println("No matching OS");
				return;
			}
			
	
			switch(br.toLowerCase())
			{
			case "chrome": capabilities.setBrowserName("chrome"); break;
			case "edge": capabilities.setBrowserName("MicrosoftEdge"); break;
			default: System.out.println("No matching browser"); return;
		
			} 
			
			URI url = new URI ("http://localhost:4444/wd/hub");
			
			driver=new RemoteWebDriver(url.toURL(),capabilities);	
			    
			
			
		}
		
		if(p.getProperty("execution_env").equalsIgnoreCase("local"))
		{
			switch(br.toLowerCase())
			{
			case "chrome" : driver=new ChromeDriver(); break;
			case "edge": driver=new EdgeDriver(); break;
			case "Firefox" : driver=new FirefoxDriver(); break;
			case "default": System.out.println("Invalid browser"); return;
			}
		}
		
	    driver.get(p.getProperty("appURL"));
		//driver.get("https://tutorialsninja.com/demo/");
		driver.manage().window().maximize();
	
		
	}
	 @AfterClass(groups={"Sanity","Regression"})
	 public void close()
	{
		driver.close();
	}
   
	public String Randomstring()
   {
   	String value=RandomStringUtils.randomAlphabetic(5);
   	return value;
   }
   public String RandomNumber()
   {
   	String number=RandomStringUtils.randomNumeric(10);
   	return number;
   }
   public String RandomAlphanumeric()
   {   
   	String value=RandomStringUtils.randomAlphabetic(3);
   	String number=RandomStringUtils.randomNumeric(2);
   	return (value+number);
   }
   
   public String captureScreen(String tname) throws IOException
   {
	   String timeStamp=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
	   TakesScreenshot takesScreenshot=(TakesScreenshot) driver;
	   File sourceFile=takesScreenshot.getScreenshotAs(OutputType.FILE);
	   
	   String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\"+ tname + "_" +timeStamp+".png";
	   File targetFile=new File(targetFilePath);
	   
	   sourceFile.renameTo(targetFile);
	   return targetFilePath;
	   
   }

}
