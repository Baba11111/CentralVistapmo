/**
 * @author surendragangwar
 * @since 14-Aug-2026
 * @version 1.0
 * 
 * Description: [Enter class purpose here]
 */
package com.centralvista.utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.centralvista.base.BaseTest;

public class ToastUtil {

	public static void validateToastMessage(WebDriver driver, String expectedMessage) {
		try {

			By toastLocator = By.cssSelector(".toast-message.ng-star-inserted");

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

			WebElement toastElement = wait.until(ExpectedConditions.visibilityOfElementLocated(toastLocator));

			String actualMessage = toastElement.getText().trim();

			System.out.println("Toast text: " + actualMessage);

			// Assert message
			Assert.assertEquals(actualMessage, expectedMessage.trim(), "❌ Toast message mismatch!");
			wait.until(ExpectedConditions.invisibilityOfElementLocated(toastLocator));

		} catch (TimeoutException e) {
			Assert.fail("❌ Toast not found or disappeared too quickly.");
		} catch (Exception e) {
			Assert.fail("❌ Error during toast validation: " + e.getMessage());
		}

	}

	public static void validateTextMatch(String actual, String expected, String fieldName) {
		try {
			Assert.assertEquals(actual.trim(), expected.trim(), "❌ Mismatch in field: " + fieldName);
			System.out.println("✅ " + fieldName + " matched: " + actual);

		} catch (AssertionError e) {
			Assert.fail("❌ " + fieldName + " mismatch! Expected: [" + expected + "], but found: [" + actual + "]");
		} catch (Exception e) {
			Assert.fail("❌ Exception while validating " + fieldName + ": " + e.getMessage());
		}
	}
}
