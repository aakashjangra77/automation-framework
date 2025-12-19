package com.sdet.framework.pages;

import org.openqa.selenium.WebDriver;
import com.sdet.framework.driver.DriverFactory;

public class BasePage {

	protected WebDriver driver;
	
	public BasePage() {
		this.driver = DriverFactory.getDriver();
	}
}
