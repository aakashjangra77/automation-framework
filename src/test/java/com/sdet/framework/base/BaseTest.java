package com.sdet.framework.base;

import com.sdet.framework.api.ApiBase;
import com.sdet.framework.driver.DriverFactory;
import com.sdet.framework.utils.LoggerUtil;
import org.apache.logging.log4j.Logger;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.Files;

public class BaseTest {

	protected Logger logger = LoggerUtil.getLogger();

	@BeforeMethod(alwaysRun = true)
	public void setUp(Method method) {
		logger.info("=======================================");
		logger.info("STARTING TEST : " + method.getName());

		DriverFactory.initDriver();
		ApiBase.init();
		logger.info("Browser launched successfully");
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown(ITestResult result) {

		if (result.getStatus() == ITestResult.SUCCESS) {
			logger.info("TEST PASSED : " + result.getName());
		} else if (result.getStatus() == ITestResult.FAILURE) {
			logger.error("TEST FAILED : " + result.getName());
			logger.error("REASON : ", result.getThrowable());
		} else if (result.getStatus() == ITestResult.SKIP) {
			logger.warn("TEST SKIPPED : " + result.getName());
		}

		DriverFactory.quitDriver();
		logger.info("Browser closed");
		logger.info("=======================================");
	}

	public static String takeScreenshot(String testName) {
		try {
			TakesScreenshot ts = (TakesScreenshot) DriverFactory.getDriver();
			File source = ts.getScreenshotAs(OutputType.FILE);

			String destPath = "test-output/screenshots/" + testName + ".png";
			File destination = new File(destPath);

			destination.getParentFile().mkdirs(); // ensure folder exists
			Files.copy(source.toPath(), destination.toPath());

			return destPath;

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}
