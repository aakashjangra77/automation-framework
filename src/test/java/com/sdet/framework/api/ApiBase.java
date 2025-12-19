package com.sdet.framework.api;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeClass;

import com.sdet.framework.utils.ConfigReader;
import com.sdet.framework.utils.LoggerUtil;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;

public class ApiBase {

	protected static Logger logger = LoggerUtil.getLogger();

	@BeforeClass(alwaysRun = true)
	public static void init() {
		   LoggerUtil.getLogger().info("Initializing API configuration");

	        RestAssured.baseURI =
	                ConfigReader.getProperty("apiBaseUrl");

	        LoggerUtil.getLogger().info(
	                "API Base initialized with URI: " + RestAssured.baseURI);
	}
}
