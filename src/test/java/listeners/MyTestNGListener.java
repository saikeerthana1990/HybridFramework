package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import base.BaseTest;
import utils.UtilKit;

public class MyTestNGListener extends BaseTest  implements ITestListener  {

	public void onTestStart(ITestResult result) {
		
	}

	public void onTestSuccess(ITestResult result) {
		
		String testcaseName=result.getMethod().getMethodName();
		
		test.pass(testcaseName +" is passed ....");
		
		test.addScreenCaptureFromPath(UtilKit.getScreenshot(testcaseName));
		
	}

	public void onTestFailure(ITestResult result) {
		
		String testcaseName=result.getMethod().getMethodName();
		
		test.addScreenCaptureFromPath(UtilKit.getScreenshot(testcaseName));
		
		test.fail(testcaseName+" is failed ...");
		
		
	}

	public void onTestSkipped(ITestResult result) {
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		
	}

	public void onFinish(ITestContext context) {
		
	}
	
	

}
