package com.sdet.framework.driver;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.sdet.framework.utils.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void initDriver() {
        if (driver.get() == null) {
            String browser = ConfigReader.getProperty("browser");

            if (browser.equalsIgnoreCase("chrome")) {
                WebDriverManager.chromedriver().setup();
                driver.set(new ChromeDriver());
            }

            driver.get().manage().window().maximize();
        }
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
