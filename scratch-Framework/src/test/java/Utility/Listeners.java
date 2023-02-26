package Utility;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import Base.BaseClass;

public class Listeners extends ExtentManager implements ITestListener {

	public void onTestStart(ITestResult Result) {
		System.out.println("Test case is starting");
		test = extent.createTest(Result.getName());
		test.createNode(Result.getName());
	}

	public void onTestSuccess(ITestResult Result) {
		if (Result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, "Pass Test case is: " + Result.getName());
		}
	}

	public void onTestFailure(ITestResult Result) {
	    System.out.println("Test Failed-Screenshot Captured");
		if (Result.getStatus() == ITestResult.FAILURE) {
			try {
				test.log(Status.FAIL,
						MarkupHelper.createLabel(Result.getName() + " - Test Case Failed", ExtentColor.RED));
				test.log(Status.FAIL,
						MarkupHelper.createLabel(Result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
				String imgPath = Actions.screenShot(BaseClass.driver, Result.getName());

				test.fail("ScreenShot is Attached", MediaEntityBuilder.createScreenCaptureFromPath(imgPath).build());

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void onTestSkipped(ITestResult Result) {

		if (Result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, "Skipped Test case is: " + Result.getName());

		}

	}
}
