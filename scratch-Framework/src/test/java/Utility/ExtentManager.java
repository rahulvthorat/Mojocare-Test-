package Utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
	
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	
	
	public static void setExtent() {
		
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/ExtentReport/"+"myReport.html");
		htmlReporter.config().getDocumentTitle();
		htmlReporter.config().setReportName("FunctionalReport");
		htmlReporter.config().setTheme(Theme.DARK);
		
		extent=new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		extent.setSystemInfo("hostName", "localHost");
		extent.setSystemInfo("OS", "WINDOWS");
		extent.setSystemInfo("Tester", "Rahul");
		extent.setSystemInfo("Browser", "Chrome");
		
		
	}
	
	
	public static void endReport() {
		extent.flush();
	}

}
