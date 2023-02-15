package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	public static WebElement element = null;
	// public static WebDriver driver;

	public static WebElement textbox_username(WebDriver driver) {
		element = driver.findElement(By.xpath("//input[@name=\"email\"]"));
		return element;
	}

	public static WebElement textbox_password(WebDriver driver) {
		element = driver.findElement(By.name("pass"));
		return element;
	}

	public static WebElement login_button(WebDriver driver) {
		element = driver.findElement(By.name("login"));
		return element;
	}
	
	public static WebElement ForgotPass_link(WebDriver driver) {
		element = driver.findElement(By.xpath("//a[text()=\"Forgotten password?\"]"));
		return element;
	}
	
	public static WebElement createAccount_button(WebDriver driver) {
		element = driver.findElement(By.xpath("//a[text()=\"Create new account\"]"));
		return element;
	}
	
	public static WebElement text_link(WebDriver driver) {
		element = driver.findElement(By.xpath("//h2[@class=\"_8eso\"]"));
		return element;
	}
	
	public static WebElement logo(WebDriver driver) {
		element = driver.findElement(By.xpath("//img[@class=\"fb_logo _8ilh img\"]"));
		return element;
	}


}
