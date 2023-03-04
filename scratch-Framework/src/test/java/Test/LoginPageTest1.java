package Test;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.BaseClass;
import Pages.LoginPage;

public class LoginPageTest1 extends BaseClass {

	@BeforeClass
	public void setup() throws InterruptedException {
		Reporter.log("============================Browser Session Started=======================", true);
		initialization();
	}

	@Test(dataProvider = "testdata")
	public void LoginTest(String username, String password) throws InterruptedException {
		LoginPage.textbox_username(driver).sendKeys(username);
		LoginPage.textbox_password(driver).sendKeys(password);
		LoginPage.login_button(driver).click();
	}
	
	    @DataProvider(name="testdata")
	  	public Object [][] tData(){
	  		return new Object[][] {
	  		{"7517476426","Rahul@123"},// valid username and invalid password
	  		{"thorat959@gmail.com","Zxcvbnm1"},// invalid username and valid password
	  		{"thorat959@gmail.com","Rahul@123"},//invalid username and password
	  		{"7517476426","Zxcvbnm1"},// valid username and password
	  	   };
	  	}

	@AfterClass
	public void tearDown() {
		driver.quit();
		Reporter.log("========================Browser Session End==========================", true);
	}
}
