package com.sdet.framework.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerUtil {

    private static final Logger logger = LogManager.getLogger();

    private LoggerUtil() {
        // prevent object creation
    }

    public static Logger getLogger() {
        return logger;
    }
}
