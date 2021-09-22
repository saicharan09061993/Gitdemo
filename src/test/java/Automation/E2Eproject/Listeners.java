package Automation.E2Eproject;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;

import resources.Base;
import resources.Commondriver;
import resources.ExtentReportsNg;

public class Listeners   implements ITestListener {

   ExtentTest test;
	ExtentReports extent=ExtentReportsNg.config();
	ThreadLocal<ExtentTest> extenttest=new ThreadLocal<ExtentTest>();
   
	@Override
	public void onTestStart(ITestResult result) {
		 test= extent.createTest(result.getMethod().getMethodName());
		 extenttest.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		extenttest.get().log(Status.PASS,"Test Passed");
		
	}

	@Override
	public void onTestFailure(ITestResult result)  {
		extenttest.get().fail(result.getThrowable());
		
		 WebDriver driver=null;
	
		String testMethodName=result.getMethod().getMethodName();
		
		
			try {
				driver=(WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
			} 
			catch(Exception e) {}
			 
			try {
				
				
				Commondriver cmn = new Commondriver();
				cmn.getScreenShot(testMethodName,driver);
			extenttest.get().addScreenCaptureFromPath(cmn.getScreenShot(testMethodName,driver),result.getMethod().getMethodName());}
			catch (Throwable e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	
		
	}



	
	

	@Override
	public void onTestSkipped(ITestResult result) {
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {

	}

	@Override
	public void onFinish(ITestContext context) {
    extent.flush();
	}

}
