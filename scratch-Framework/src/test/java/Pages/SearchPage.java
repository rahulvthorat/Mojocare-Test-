package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage {
	
	public static WebElement element=null;
	//public static WebDriver driver;
	
	public static WebElement textbox_Search(WebDriver driver)
	{
		element=driver.findElement(By.name("q"));
		return element;
	}
	

	public static WebElement button_Search(WebDriver driver)
	{
		element=driver.findElement(By.name("btnK"));
		return element;
	}
	
	public static WebElement output_Result(WebDriver driver)
	{
		element=driver.findElement(By.name("btnK"));
		return element;
	}

}
