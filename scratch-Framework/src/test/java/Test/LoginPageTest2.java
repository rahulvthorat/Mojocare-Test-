package Test;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Base.BaseClass;
import Pages.LoginPage;
import Utility.Log;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

public class LoginPageTest2 extends BaseClass {

	@BeforeClass
	public void setup() throws InterruptedException {
		Reporter.log("============================Browser Session Started=======================", true);
		initialization();
	}

	@Test(priority = 1)
	public void VerifyUrl() throws Throwable {
		String expectedURL = "https://www.facebook.com/";
		Log.startTestCase("VerifyUrl");
		// Actions.getCurrentURL(driver);
		String actualURL = driver.getCurrentUrl();
		Assert.assertEquals(actualURL, expectedURL, "URL is not matched");
		Log.endTestCase("Url verification Completed");
	}

	@Test(priority = 2)
	public void VerifyTitle() {
		String expectedtitle = "Facebook – log in or sign up";
		Log.startTestCase("verifyTitle");
		String actualtitle = driver.getTitle();
		Assert.assertEquals(actualtitle, expectedtitle, "Title is not matched");
		Log.endTestCase("verifyTitle is Completed");
	}

	@Test(priority = 3)
	public void verifyUsernametextbox() {
		Log.startTestCase("verifyUsernametextbox");
		boolean emailTextbox = LoginPage.textbox_username(driver).isDisplayed();
		Assert.assertEquals(emailTextbox, true);
		Log.endTestCase("verifyUsernametextbox");
	}

	@Test(priority = 4)
	public void verifyPassworTextbox() {
		Log.startTestCase("verifyUsernametextbox");
		boolean passwordTextbox = LoginPage.textbox_password(driver).isDisplayed();
		Assert.assertEquals(passwordTextbox, true);
		Log.endTestCase("verifyPassworTextbox");
	}

	@Test(priority = 5)
	public void verifyLoginbutton() {
		Log.startTestCase("verifyUsernametextbox");
		boolean loginbutton = LoginPage.login_button(driver).isDisplayed();
		Assert.assertEquals(loginbutton, true);
		Log.endTestCase("verifyLoginbutton");
	}

	@Test(priority = 6)
	public void verifyForgotpasswordlink() {
		Log.startTestCase("verifyForgotpasswordlink");
		boolean forgotpasslink = LoginPage.ForgotPass_link(driver).isDisplayed();
		Assert.assertEquals(forgotpasslink, true);
		Log.endTestCase("verifyForgotpasswordlink");
	}

	@Test(priority = 7)
	public void verifyCreateAccountbutton() {
		Log.startTestCase("verifyCreateAccountbutton");
		boolean createAccountbutton = LoginPage.createAccount_button(driver).isDisplayed();
		Assert.assertEquals(createAccountbutton, true);
		Log.endTestCase("verifyCreateAccountbutton");
	}

	@Test(priority = 8)
	public void verifyText() {
		Log.startTestCase("verifyText");
		String actualtext = LoginPage.text_link(driver).getText();
		String expectedtext = "Facebook helps you connect and share with the people in your life.";
		Assert.assertEquals(actualtext, expectedtext);
		Log.endTestCase("verifyText");
	}

//	@Test(retryAnalyzer = Utility.IRetry.class, priority = 9)
	@Test(priority = 9)
	public void compareLogoTest() throws IOException, InterruptedException {
		Log.startTestCase("compareLogoTest");

		BufferedImage expectedimage = ImageIO.read(new File("./Logo/Facebook.png"));
		WebElement logoimagelement = LoginPage.logo(driver);
		Screenshot logoimagescreenshot = new AShot().takeScreenshot(driver, logoimagelement);

		BufferedImage actulimage = logoimagescreenshot.getImage();
		ImageDiffer imgdiff = new ImageDiffer();
		ImageDiff diff = imgdiff.makeDiff(expectedimage, actulimage);
		Thread.sleep(1000);

		if (diff.hasDiff() == true) {
			System.out.println("image are not same");
		} else {
			System.out.println("image are same");
		}
		Log.endTestCase("Compare logo Completed");

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
		Reporter.log("========================Browser Session End==========================", true);
	}

}
