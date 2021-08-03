package com.Listeners;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.utils.Screenshot;


public class ListenerClass extends TestListenerAdapter
{
	public static ExtentReports extent;
	public static ExtentSparkReporter reporter;
	public static ExtentTest extentTest;
	
	public void onStart(ITestContext context) 
	{
		reporter=new ExtentSparkReporter(System.getProperty("user.dir")+"/Reports/extentreport.html");
		extent=new ExtentReports();
		extent.attachReporter(reporter);
		reporter.config().setDocumentTitle("Orange CRM Automation Test");
		reporter.config().setTheme(Theme.DARK);
		reporter.config().setReportName("Test results");

	}
	public void onTestSuccess(ITestResult result) 
	{
		extentTest = extent.createTest(result.getName());
		extentTest.log(Status.PASS, "Testcase passed is "+result.getName());
		extentTest.log(Status.PASS,"Testcase passed at "+ result.getEndMillis());
		extentTest.log(Status.PASS, "Testcase status "+result.getStatus());
	}
	public void onTestFailure(ITestResult result) 
	{
		extentTest = extent.createTest(result.getName());
		extentTest.log(Status.FAIL, "Testcase failed is "+result.getName());
		extentTest.log(Status.FAIL, "Testcase failed because of "+result.getThrowable());
		extentTest.log(Status.FAIL, "Testcase status "+result.getStatus());
		String path = Screenshot.takeSS(result.getName());
		extentTest.addScreenCaptureFromPath(path, "Failed SS Testcase taken at "+result.getEndMillis());
	}
	public void onFinish(ITestContext context) 
	{
		extent.flush();
	}

}
