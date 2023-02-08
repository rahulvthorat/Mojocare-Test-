package TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Pages.SearchPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SearchPageTest {

	private static WebDriver driver;
	
	@BeforeClass
	public void setup()
	{
         WebDriverManager.chromedriver().setup();
		    driver = new ChromeDriver();
	        driver.manage().window().maximize();
		    driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get("https://agrichain.com/qa/input");
	}
		
	@Test(priority = 1)
	public void subStringTest() throws InterruptedException
	{
		SearchPage.textbox_Search(driver).sendKeys("Rahul");
		SearchPage.button_Search(driver).click();
		driver.navigate().forward();
		Thread.sleep(1000);
	}
	
	@Test(dependsOnMethods = {"subStringTest"})
	public void outputTest()
	{
	    String output= SearchPage.output_Result(driver).getAttribute("Result");
	    Assert.assertEquals(output, "123","OutPut not matched");
	
	}
	
	@Test(dependsOnMethods = {"outputTest"})
	public void urlTest()
	{
		String url=driver.getCurrentUrl();
		Assert.assertEquals(url,"https://agrichain.com/qa/result","URL notch matched");
	}
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}

}
