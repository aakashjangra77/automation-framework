package com.sdet.framework.base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.sdet.framework.driver.DriverFactory;

public class BaseTest {

	@BeforeMethod
	public void setup() {
		DriverFactory.getDriver().manage().window().maximize();
	}

	@AfterMethod
	public void tearDown() {
		DriverFactory.quitDriver();
	}
}