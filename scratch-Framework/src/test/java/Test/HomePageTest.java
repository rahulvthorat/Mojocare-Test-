package Test;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Base.BaseClass;
import Pages.LoginPage;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

public class HomePageTest extends BaseClass {

	@BeforeClass
	public void setup() throws InterruptedException {

		Reporter.log("============================Browser Session Started=======================", true);
		initialization();

	}

	@Test(priority = 1)

	public void verifyurlTest() {
		String actualURL = driver.getCurrentUrl();
		System.out.println(actualURL);
		String expectedURL = "https://www.facebook.com/";
		Assert.assertEquals(actualURL, expectedURL);

	}

	@Test(priority = 2)
	public void VerifytitleTest() {
		String actualtitle = driver.getTitle();
		String expectedtitle = "Facebook – log in or sign up";
		Assert.assertEquals(actualtitle, expectedtitle);

	}

	@Test(priority = 3)
	public void capturelogo() throws IOException {
		WebElement actuallogo = LoginPage.logo(driver);
		File file = actuallogo.getScreenshotAs(OutputType.FILE);
		File location = new File("./Screenshots/facebook.png");
		FileUtils.copyFile(location, location);
		File f = new File("./Screenshots/facebook.png");

		if (f.exists()) {
			System.out.println("Image file captured");
		} else {
			System.out.println("Image file not exist");
		}
		
	}

	@Test(priority = 4)
	public void verifyUsernametextbox() {
		boolean emailTextbox = LoginPage.textbox_username(driver).isDisplayed();
		Assert.assertEquals(emailTextbox, true);
	}

	@Test(priority = 5)
	public void verifyPassworTextbox() {
		boolean passwordTextbox=LoginPage.textbox_password(driver).isDisplayed();
		Assert.assertEquals(passwordTextbox, true);
	}

	@Test(priority = 6)
	public void verifyLoginbutton() {
		boolean loginbutton = LoginPage.login_button(driver).isDisplayed();
		Assert.assertEquals(loginbutton, true);
	}

	@Test(priority = 7)
	public void verifyForgotpasswordlink() {
		boolean forgotpasslink = LoginPage.ForgotPass_link(driver).isDisplayed();
		Assert.assertEquals(forgotpasslink, true);
	}
	
	
	@Test(priority = 8)
	public void verifyCreateAccountbutton()
	{
		boolean createAccountbutton = LoginPage.createAccount_button(driver).isDisplayed();
		Assert.assertEquals(createAccountbutton, true);
		
	}

	@Test(priority = 9)
	public void verifyText() {
		String actualtext = LoginPage.text_link(driver).getText();
		String expectedtext = "Facebook helps you connect and share with the people in your life.";
		Assert.assertEquals(actualtext, expectedtext);
	}
	
	


	@Test(priority = 10)
	public void compareLogoTest() throws IOException, InterruptedException {
		
		BufferedImage expectedimage = ImageIO.read(new File("./Screenshots/Facebook.png"));
        WebElement logoimagelement = LoginPage.logo(driver);
        Screenshot logoimagescreenshot = new AShot().takeScreenshot(driver, logoimagelement);
        BufferedImage actulimage = logoimagescreenshot.getImage();
        ImageDiffer imgdiff = new ImageDiffer();
		ImageDiff diff = imgdiff.makeDiff(expectedimage, actulimage);
		Thread.sleep(1000);

		if (diff.hasDiff() == true)
		{
			System.out.println("image are not same");
		}
		else 
		{
			System.out.println("image are same");
		}

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
		Reporter.log("========================Browser Session End==========================", true);
	}

}
