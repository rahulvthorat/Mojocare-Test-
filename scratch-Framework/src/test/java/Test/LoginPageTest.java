package Test;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Base.BaseClass;
import Pages.LoginPage;

public class LoginPageTest extends BaseClass {

	
	
	
	@BeforeClass
	public void setup() throws InterruptedException {

		Reporter.log("============================Browser Session Started=======================", true);
		initialization();

	}
	
	
	@Test(dataProvider = "testdata")
	public void LoginTest(String username, String password) throws InterruptedException
	{
		LoginPage.textbox_username(driver).sendKeys(username);
		LoginPage.textbox_password(driver).sendKeys(password);
		LoginPage.login_button(driver).click();
		
	}
	
	
	
	
	
	
	@AfterClass
	public void tearDown() {
		driver.quit();
		Reporter.log("========================Browser Session End==========================", true);
	}


}
