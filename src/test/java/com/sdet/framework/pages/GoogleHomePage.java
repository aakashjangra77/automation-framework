package com.sdet.framework.pages;

import org.openqa.selenium.By;
import com.sdet.framework.utils.ConfigReader;

public class GoogleHomePage extends BasePage {

	private By searchBox = By.name("q");

	public void openGoogle() {
		driver.get(ConfigReader.getProperty("baseUrl"));
	}

	public boolean isSearchBoxDisplayed() {
		return driver.findElement(searchBox).isDisplayed();
	}
}
