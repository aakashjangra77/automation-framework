package com.sdet.framework.utils;

import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties = new Properties();

    static {
        try {
            String env = System.getProperty("env", "qa");
            String fileName = "config/" + env + ".properties";

            InputStream input = ConfigReader.class
                    .getClassLoader()
                    .getResourceAsStream(fileName);

            if (input == null) {
                throw new RuntimeException("Config file not found: " + fileName);
            }

            properties.load(input);

        } catch (Exception e) {
            throw new RuntimeException("Failed to load config file", e);
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
