package com.sdet.framework.base;

import com.sdet.framework.driver.DriverFactory;
import com.sdet.framework.utils.LoggerUtil;
import org.apache.logging.log4j.Logger;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;

public class BaseTest {

    protected Logger logger = LoggerUtil.getLogger();

    @BeforeMethod
    public void setUp(Method method) {
        logger.info("=======================================");
        logger.info("STARTING TEST : " + method.getName());

        DriverFactory.initDriver();
        logger.info("Browser launched successfully");
    }

    @AfterMethod
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
}
