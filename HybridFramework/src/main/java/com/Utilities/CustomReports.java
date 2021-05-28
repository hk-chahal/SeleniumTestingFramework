package com.Utilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.relevantcodes.extentreports.LogStatus;

public class CustomReports extends Base implements ITestListener{
	

	 public void onTestStart(ITestResult result) {  
		 report = extentreport.startTest(result.getName().toUpperCase());
		 
	 } 

	 public	void onTestSuccess(ITestResult result) { 
		 report.log(LogStatus.PASS, result.getName().toUpperCase()+" PASS");
		 extentreport.endTest(report);
		 extentreport.flush();
		 
	 } 

	 public void onTestFailure(ITestResult result) { 
		 System.setProperty("org.uncommons.reportng.escape-output","false");
			try {
				TakeScreenshots.captureScreenshot();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			report.log(LogStatus.FAIL, result.getName().toUpperCase()+" Failed with exception : "+result.getThrowable());
			report.log(LogStatus.FAIL, report.addScreenCapture(TakeScreenshots.screenshotName));
			
			
			
			/*
			 * Reporter.log("Click to see Screenshot");
			 * Reporter.log("<a target=\"_blank\" href="+TakeScreenshots.screenshotName+
			 * ">Screenshot</a>"); Reporter.log("<br>"); Reporter.log("<br>");
			 * Reporter.log("<a target=\"_blank\" href="+TakeScreenshots.
			 * screenshotName+"><img src="+TakeScreenshots.
			 * screenshotName+" height=100 width=100></img></a>");
			 */
			extentreport.endTest(report);
			extentreport.flush();
	 } 
	 
	 public void onTestSkipped(ITestResult result) {


		 	report.log(LogStatus.SKIP, result.getName().toUpperCase()+" Skipped the test as the Run mode is NO");
			extentreport.endTest(report);
			extentreport.flush();
			
		}

	 public void onStart(ITestContext context) { 
		
		 
	 } 

	 public void onFinish(ITestContext context) {  }
	 
}
