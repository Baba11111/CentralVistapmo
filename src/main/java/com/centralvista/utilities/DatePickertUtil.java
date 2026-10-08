/**
 * @author surendragangwar
 * @since 14-Aug-2026
 * @version 1.0
 * 
 * Description: [Enter class purpose here]
 */
package com.centralvista.utilities;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class DatePickertUtil  {
	private WebDriver driver;
	private WebDriverWait wait;
JavascriptExecutor js;

public DatePickertUtil(WebDriver driver) {
    this.driver = driver;
    this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    this.js = (JavascriptExecutor) driver;
}

public void selectdob(String dateStr) {
	
    selectDate(By.id("dob"), dateStr);
}

public void selectpassValidUptoDate(String dateStr) {
    selectDate(By.id("passValidUptoDate"), dateStr);
}

public void selectenddate(String dateStr) {
    selectDate(By.id("serviceEndDate"), dateStr);
}

public void selectfromdate(String dateStr) {
    selectDate(By.id("fromDate"), dateStr);
}

public void selecttodate(String dateStr) {
    selectDate(By.id("toDate"), dateStr);
}


public void selectDate(By dateInputLocator, String dateStr) {
    try {
    	
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate targetDate = LocalDate.parse(dateStr, formatter);

        int targetDay = targetDate.getDayOfMonth();
        int targetMonth = targetDate.getMonthValue();
        int targetYear = targetDate.getYear();

        Actions actions = new Actions(driver);

        // Click on date input using Actions
        WebElement input = wait.until(ExpectedConditions.elementToBeClickable(dateInputLocator));
        actions.moveToElement(input).click().perform();
        sleep(300);

        // Loop to reach correct month/year
        while (true) {
            String currentMonthText = driver.findElement(By.xpath("//bs-datepicker-navigation-view/button[@class='current ng-star-inserted']")).getText();
            String currentYearText = driver.findElement(By.xpath("//bs-datepicker-navigation-view/button[@class='current']")).getText();

            DateTimeFormatter monthFormatter = DateTimeFormatter.ofPattern("MMMM", Locale.ENGLISH);
            Month currentMonthEnum = Month.from(monthFormatter.parse(currentMonthText));
            int currentMonth = currentMonthEnum.getValue();
            int currentYear = Integer.parseInt(currentYearText);

            if (currentYear == targetYear && currentMonth == targetMonth) {
                break;
            }

            WebElement navButton;
            if (currentYear < targetYear || (currentYear == targetYear && currentMonth < targetMonth)) {
                navButton = driver.findElement(By.cssSelector(".bs-datepicker-head button.next"));
            } else {
                navButton = driver.findElement(By.cssSelector(".bs-datepicker-head button.previous"));
            }

            actions.moveToElement(navButton).click().perform();
            sleep(300);
        }

        // Select day using Actions
        String dayXPath = "//span[@class='ng-star-inserted' and normalize-space(text())='" + targetDay + "']";
        WebElement dayElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(dayXPath)));
        actions.moveToElement(dayElement).click().perform();
    } catch (Exception e) {
        throw new RuntimeException("Failed to select date: " + dateStr, e);
    }
}
private void sleep(long millis) {
    try {
        Thread.sleep(millis);
    } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
    }
}

public void selectvalidFrom(String dateStr) 
{
	System.out.println("I am value from excel "+dateStr);
	selectDate(By.id("appointedFromDate"), dateStr);
}


public void selectvalidTo(String dateStr) 
{
	
    selectDate(By.id("appointedUpto"), dateStr);
 }
}