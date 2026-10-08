/**
 * @author surendragangwar
 * @since 17-Aug-2026
 * @version 1.0
 * 
 * Description: [Enter class purpose here]
 */
package com.centralvista.utilities;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.centralvista.base.DriverFactory;



public class SafeclickUtil {
	
	public void safeClick(WebElement element) {

	    WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(15));

	    try {

	        // wait until clickable
	        wait.until(ExpectedConditions.elementToBeClickable(element));

	        // scroll to element
	        ((JavascriptExecutor) DriverFactory.getDriver())
	                .executeScript("arguments[0].scrollIntoView({block:'center'});", element);

	        // small wait for animation
	        Thread.sleep(500);

	        // normal click
	        element.click();

	    } catch (Exception e) {

	        // fallback JS click
	        ((JavascriptExecutor) DriverFactory.getDriver())
	                .executeScript("arguments[0].click();", element);
	    }
	}

}