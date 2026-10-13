/**
 * @author surendragangwar
 * @since 13-Aug-2026
 * @version 1.0
 * 
 * Description: [Enter class purpose here]
 */
package com.centralvista.base;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.centralvista.utilities.ConfigReader;


public class DriverFactory {

	private static WebDriver driver;

	public static void initDriver() {

	    String browser = ConfigReader.getProperty("browser");

	    // JVM parameter takes priority over config.properties
	    String headlessValue = System.getProperty(
	            "headless",
	            ConfigReader.getProperty("headless")
	    );

	    boolean headless = Boolean.parseBoolean(
	            headlessValue == null ? "false" : headlessValue
	    );

	    if (browser.equalsIgnoreCase("chrome")) {

	        ChromeOptions options = new ChromeOptions();

	        if (headless) {
	            options.addArguments("--headless=new");
	        }

	        options.addArguments("--window-size=1920,1080");

	        driver = new ChromeDriver(options);

	    } else {

	        throw new RuntimeException(
	                "Browser not supported: " + browser
	        );
	    }
	}

	public static WebDriver getDriver() {
	    return driver;
	}

	public static void quitDriver() {

	    if (driver != null) {
	        driver.quit();
	        driver = null;
	    }
	}

	}