/*
 * @author surendragangwar
 * @since 13-Aug-2026
 * @version 1.0
 * 
 * Description: [This is base]
 */

package com.centralvista.base; 


import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;


import com.centralvista.utilities.ConfigReader;



public class BaseTest {

    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeClass(alwaysRun = true)
    public void setUp() {

        // Initialize browser
        DriverFactory.initDriver();

        // Get driver
        driver = DriverFactory.getDriver();

        
        // Check driver
        if (driver == null) {
            throw new RuntimeException(
                    "Driver is NULL after DriverFactory.initDriver()"
            );
        }

        // Maximize browser
        driver.manage()
                .window()
                .maximize();

        // Read explicit wait
        int explicitWait = Integer.parseInt(
                ConfigReader.getProperty("explicitWait")
        );

        // Initialize wait
        wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(explicitWait)
        );

        // Read URL
        String url =
                ConfigReader.getProperty("url");

        // Open application
        driver.get(url);
    }

//    @AfterSuite(alwaysRun = true)
//    public void tearDown() {
//
//        DriverFactory.quitDriver();
//    }
}