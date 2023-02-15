package Test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Base.BaseClass;
import Pages.SearchPage;


public class SearchPageTest extends BaseClass {

	private static WebDriver driver;
	
	@BeforeClass
	public void setup() throws InterruptedException
	{
		Reporter.log("=====Browser Session Started=====", true);
		initialization();
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
	    Reporter.log("=====Browser Session End=====", true);
	}

}
