package com.sdet.framework.listeners;

import org.testng.ITestListener;


import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.sdet.framework.base.BaseTest;
import com.sdet.framework.reporting.ExtentManager;

public class TestListener implements ITestListener {

	private static ExtentReports extent = ExtentManager.getExtentReport();
	private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
	



	@Override
	public void onTestStart(ITestResult result) {
		ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
		test.set(extentTest);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.get().pass("Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testName = result.getMethod().getMethodName();

	    String screenshotPath = BaseTest.takeScreenshot(testName);

	    test.get().fail(result.getThrowable());

	    if (screenshotPath != null) {
	        test.get().addScreenCaptureFromPath(screenshotPath);
	    }
	}

	@Override
	public void onFinish(org.testng.ITestContext context) {
		extent.flush();
	}
}