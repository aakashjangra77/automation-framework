package com.sdet.framework.reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

	private static ExtentReports extent;

	public static ExtentReports getExtentReport() {
		if (extent == null) {
			ExtentSparkReporter reporter = new ExtentSparkReporter("test-output/ExtentReport.html");

			reporter.config().setReportName("SDET Automation Report");
			reporter.config().setDocumentTitle("Automation Execution");

			extent = new ExtentReports();
			extent.attachReporter(reporter);
		}
		return extent;
	}

}