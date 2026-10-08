/**
 * @author surendragangwar
 * @since 17-Aug-2026
 * @version 1.0
 * 
 * Description: [Enter class purpose here]
 */
package com.centralvista.utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.centralvista.base.BaseTest;
import com.centralvista.base.DriverFactory;



/**
 * 
 */
public class ScrollUtility{

	public  static void scrollToTopPage(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		long currentScroll = (long) js.executeScript("return window.pageYOffset;");
		while (currentScroll > 0) {
			js.executeScript("window.scrollBy(0, -500);"); // scroll up 500px
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
			currentScroll = (long) js.executeScript("return window.pageYOffset;");
		}
	}
	
	// Scroll to bottom page of the window
	public static void scrollToBottomPage(WebDriver driver) throws InterruptedException {
		long lastHeight = (long) ((JavascriptExecutor) driver).executeScript("return document.body.scrollHeight");

		while (true) {
			((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
			Thread.sleep(1000); // allow time for loading
			long newHeight = (long) ((JavascriptExecutor) driver).executeScript("return document.body.scrollHeight");
			if (newHeight == lastHeight) {
				break;
			}
			lastHeight = newHeight;
		}
	}
	
	public static void setPageZoomOut(WebDriver driver, int percent) {
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("document.body.style.zoom='" + percent + "%';");
	}
	
	
	public static void scrollUntilElementVisible(WebDriver driver, By locator) {
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    int maxScrolls = 10; // safety limit
	    int scrollCount = 0;

	    // Scroll DOWN first
	    while (scrollCount < maxScrolls) {
	        try {
	            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	            WebElement element = driver.findElement(locator);
	            js.executeScript("arguments[0].scrollIntoView(true);", element);
	            return; // ✅ found, stop execution
	        } catch (TimeoutException e) {
	            js.executeScript("window.scrollBy(0, 300);"); // scroll down
	            scrollCount++;
	        }
	    }

	    // If not found, try scrolling UP
	    scrollCount = 0;
	    while (scrollCount < maxScrolls) {
	        try {
	            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	            WebElement element = driver.findElement(locator);
	            js.executeScript("arguments[0].scrollIntoView(true);", element);
	            return; // ✅ found, stop execution
	        } catch (TimeoutException e) {
	            js.executeScript("window.scrollBy(0, -300);"); // scroll up
	            scrollCount++;
	        }
	    }

	    throw new RuntimeException("❌ Element not found after scrolling up & down: " + locator);
	}
	
	public static void scrollToTop(WebDriver driver) {
	    ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");
	}
	
	public static void scrollToBottom(WebDriver driver) {
	    ((JavascriptExecutor) driver).executeScript(
	        "window.scrollTo({ top: document.body.scrollHeight, behavior: 'smooth' });"
	    );
	}
	
	public static WebElement scrollToElement(WebDriver driver, By locator) {

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

	    WebElement element = wait.until(
	            ExpectedConditions.presenceOfElementLocated(locator));

	    ((JavascriptExecutor) driver).executeScript(
	            "arguments[0].scrollIntoView({behavior:'smooth', block:'center'});",
	            element);

	    wait.until(ExpectedConditions.visibilityOf(element));

	    return element;
	}
	
	public static void scrollUntilVisible(WebElement sidebar, By locator) {

	    JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getDriver();

	    int maxScroll = 20;

	    for (int i = 0; i < maxScroll; i++) {

	        try {

	            WebElement element = DriverFactory.getDriver().findElement(locator);

	            if (element.isDisplayed()) {

	                js.executeScript(
	                    "arguments[0].scrollIntoView({block:'center'});",
	                    element);

	                System.out.println("Element found");
	                break;
	            }

	        } catch (Exception e) {

	            // scroll sidebar little down
	            js.executeScript(
	                "arguments[0].scrollTop += 300",
	                sidebar);

	            try {
	                Thread.sleep(500);
	            } catch (InterruptedException ex) {
	                ex.printStackTrace();
	            }
	        }
	    }
	}
	
	
}
