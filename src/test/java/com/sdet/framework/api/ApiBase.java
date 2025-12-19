package com.sdet.framework.api;

import org.apache.logging.log4j.Logger;

import com.sdet.framework.utils.LoggerUtil;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;

public class ApiBase {

	protected static Logger logger = LoggerUtil.getLogger();

	public static void init() {
		RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

		// log request & response automatically
		RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());

		logger.info("API Base initialized with URI: " + RestAssured.baseURI);
	}
}
