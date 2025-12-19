package com.sdet.framework.ui;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.sdet.framework.base.BaseTest;
import com.sdet.framework.driver.DriverFactory;
import com.sdet.framework.pages.GoogleHomePage;

public class FirstSeleniumTest extends BaseTest {

	@Test
	public void launchBrowserUsingFramework() {
		DriverFactory.getDriver().get("https://www.google.com");
		System.out.println("Title" + DriverFactory.getDriver().getTitle());
	}

	@Test
	public void verifyGoogleSearchBox() {
		GoogleHomePage google = new GoogleHomePage();
		google.openGoogle();
		Assert.assertTrue(google.isSearchBoxDisplayed(), "Search box not visible");
	}
}
