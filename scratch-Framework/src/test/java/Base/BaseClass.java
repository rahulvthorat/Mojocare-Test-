package Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;

import Utility.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass extends Actions {

	      public static WebDriver driver;
	      public static Properties prop;{
		  try {
			       prop = new Properties();
			       FileInputStream ip = new FileInputStream(".\\Configuration\\config.properties");
			       prop.load(ip);
			   }
		  catch(FileNotFoundException e) 
		      {e.printStackTrace();
		      }
		  catch(IOException e)
		     {e.printStackTrace();
	         }
}
            
	      public static void initialization() throws InterruptedException {
	      String browserName =  prop.getProperty("browser");
	         if(browserName.equals("firefox")) {
	        	 WebDriverManager.firefoxdriver().setup();
	             driver = new FirefoxDriver();
	           }
	        else if(browserName.equals("chrome")){
	        	WebDriverManager.chromedriver().setup();
		        driver = new ChromeDriver();
		       }	
	
	      driver.manage().window().maximize();
	      driver.manage().deleteAllCookies();
	      driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	      driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	      driver.get(prop.getProperty("url"));
	      Thread.sleep(1000);
 }
	     
	      
	    @DataProvider(name="testdata")
	  	public Object [][] tData()
	  	{
	  		return new Object[][]
	  	   {
	  		
	  		{"7517476426","Rahul@123"},// valid username and invalid password
	  		{"thorat959@gmail.com","Zxcvbnm1"},// invalid username and valid password
	  		{"thorat959@gmail.com","Rahul@123"},//invalid username and password
	  		{"7517476426","Zxcvbnm1"},// valid username and password
	  		
	  	   };
	  	}
  
  
	  
}

