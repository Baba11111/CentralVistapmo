/**
 * @author surendragangwar
 * @since 14-Aug-2026
 * @version 1.0
 * 
 * Description: [Enter class purpose here]
 */
package com.centralvista.tests;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.postgresql.Driver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.centralvista.base.BaseTest;
import com.centralvista.base.DriverFactory;
import com.centralvista.excelreader.ExcelReader;
import com.centralvista.pages.Employeepage;
import com.centralvista.utilities.ConfigReader;
//import com.centralvista.testBase.TestBase;
import com.centralvista.utilities.DatePickertUtil;
import com.centralvista.utilities.ScrollUtility;
import com.centralvista.utilities.ToastUtil;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import com.centralvista.utilities.RunHomeNavigation;


public class EmployeeTest extends BaseTest {
	
	Employeepage emppage;
	ExcelReader reader;
	DatePickertUtil datePicker;
	JavascriptExecutor js;
	
	private static final Logger LOGGER = LogManager.getLogger(Employeepage.class);

	private static final String SHEET_NAME = "Employee";

	

	@BeforeClass(alwaysRun = true)
	public void setUpAndSwitchRole() throws IOException, InterruptedException {
		 emppage = new Employeepage(driver);
		 datePicker = new DatePickertUtil(driver);
		reader = new ExcelReader("G:\\stsworkspac\\CentralVistapmo\\src\\test\\java\\com\\centralvista\\testdata\\pmotest.xlsx");
		int row = 56;
		emppage.setUserName(reader.getCellvalue(SHEET_NAME, row, 0).trim());
		emppage.setPassword(reader.getCellvalue(SHEET_NAME, row, 1).trim());
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(10));
		emppage.clickLogin();
		System.out.println("Login successful. Role dropdown displayed.");
		//wait = new  WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(10));
		WebElement roleDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userRole")));
		new Select(roleDropdown).selectByValue("EMP_ADM");

		
	}
	
	
	@BeforeMethod(alwaysRun = true)
	public void returnToHomePage(Method method) throws InterruptedException {
		

	    if (!method.isAnnotationPresent(RunHomeNavigation.class)) {
	        return;
	    }
Thread.sleep(1000);
	    DriverFactory.getDriver().navigate().to(
	    		 ConfigReader.getProperty("homeURL")
	    );
	}
	
	public void registrationpage() {
		DriverFactory.getDriver().navigate().refresh();
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(10));
		wait.until(
				ExpectedConditions.elementToBeClickable(emppage.getRegistrationsidebar()))
				.click();
		wait.until(ExpectedConditions
				.elementToBeClickable(emppage.getRegistrrationlink())).click();
		System.out.println("Logger class = " + LOGGER.getClass());
	}
	
	
	public void fillFormData(int row) throws Exception {
		 try {
			 
			 Actions act = new Actions(DriverFactory.getDriver());
		        act.sendKeys(Keys.ESCAPE).perform();
		        LOGGER.info("Filling form for row: " + row);
		        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(10));
		        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("fullname")));
		        emppage.setFullName(reader.getCellvalue(SHEET_NAME, row, 0).trim().trim());
		        emppage.setFathername(reader.getCellvalue(SHEET_NAME, row, 1).trim());
		        emppage.setMothername(reader.getCellvalue(SHEET_NAME, row, 2).trim());
		        emppage.setGender(reader.getCellvalue(SHEET_NAME, row, 3).trim());
		        

		        act.sendKeys(Keys.ESCAPE).perform();

		        emppage.selectDOB(
		                reader.getdatevalue(SHEET_NAME, row, 4).trim());

		        act.sendKeys(Keys.ESCAPE).perform();
		        emppage.setEmail(reader.getCellvalue(SHEET_NAME, row, 5).trim());
		        emppage.setitype(reader.getCellvalue(SHEET_NAME, row, 6));
		        act.sendKeys(Keys.ESCAPE).perform();
		        emppage.setidnumber(reader.getCellvalue(SHEET_NAME, row, 7).trim());
		        emppage.setcontactNumber(reader.getCellvalue(SHEET_NAME, row, 8).trim());
		        emppage.setaltcontactNumber(reader.getCellvalue(SHEET_NAME, row, 9).trim());
		        emppage.settbg(reader.getdatevalue(SHEET_NAME, row, 10).trim());
		        //act.sendKeys(Keys.ESCAPE).perform();
		        emppage.setidentificationMark(reader.getCellvalue(SHEET_NAME, row, 11).trim());
		        emppage.setcheckProfile(reader.getCellvalue(SHEET_NAME, row, 12).trim());
		        act.sendKeys(Keys.ESCAPE).perform();
		        emppage.setCategoryId(reader.getCellvalue(SHEET_NAME, row, 13).trim());
		        act.sendKeys(Keys.ESCAPE).perform();
		        emppage.setemployeeType(reader.getCellvalue(SHEET_NAME, row, 14).trim());
		        act.sendKeys(Keys.ESCAPE).perform();
		        emppage.setbranchname(reader.getCellvalue(SHEET_NAME, row, 15).trim());
		        act.sendKeys(Keys.ESCAPE).perform();
		        emppage.setserialNumber(reader.getCellvalue(SHEET_NAME, row, 16).trim());
		        emppage.setorganizationId(reader.getCellvalue(SHEET_NAME, row, 17).trim());
		        act.sendKeys(Keys.ESCAPE).perform();
		        emppage.setcheckProfil(reader.getCellvalue(SHEET_NAME, row, 18).trim());
		        act.sendKeys(Keys.ESCAPE).perform();
		        emppage.setiforceSpgOrCardNumber(reader.getCellvalue(SHEET_NAME, row, 19).trim());
		        emppage.setpermanentAddress(reader.getCellvalue(SHEET_NAME, row, 20).trim());
		        LOGGER.info("Form filled successfully for row: " + row);

		    } catch (Exception e) {
		        LOGGER.error("❌ Error at row " + row + ": " + e.getMessage(), e);

		        Assert.fail("Form filling failed at row " + row + ": " + e.getMessage());
		    }
		}
	
	
	@Test(priority = 1, groups = { "sanity", "regression" }) 
	@RunHomeNavigation
	@Description("Verify that Employee is registered with correct data or not by passing all value")
	@Epic("Employee Admin")
	@Feature("Registration of Employee")
	@Severity(SeverityLevel.CRITICAL)
	public void valid_registrationallvalue() throws Exception {
		int row = 1;
        registrationpage();
		 WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("fullname")));
      
	       fillFormData(1);
	       emppage.clickSubmit();
	       emppage.clickmessagebo();
	       Thread.sleep(2000);
	       String expected =  reader.getCellvalue(SHEET_NAME, row, 21);
			System.out.println(expected);
			ToastUtil.validateToastMessage(DriverFactory.getDriver(), expected);
	}
	
	@Test(priority=2, groups= {"sanity", "regression"})
	@RunHomeNavigation
	@Description("Verify that Employee is registered with existing mobile number")
	@Epic("Employee Admin")
	@Feature("Registration of Employee")
	@Severity(SeverityLevel.CRITICAL)
	public void registration_existingmobile() throws Exception {
		int row = 2;
		registrationpage();
		 WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("fullname")));
      
	       fillFormData(2);
	       emppage.clickSubmit();
	       String expected =  reader.getCellvalue(SHEET_NAME, row, 21);
			System.out.println(expected);
			ToastUtil.validateToastMessage(DriverFactory.getDriver(), expected);
	}
	
	@Test(priority=3, groups= {"sanity", "regression"})
	@RunHomeNavigation
	@Description("Verify that Employee is registered with existing I Number")
	@Epic("Employee Admin")
	@Feature("Registration of Employee")
	@Severity(SeverityLevel.CRITICAL)
	public void registration_existingnumber() throws Exception {
		int row = 3;
		registrationpage();
		 WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("fullname")));
      
	       fillFormData(3);
	       emppage.clickSubmit();
	       String expected =  reader.getCellvalue(SHEET_NAME, row, 21);
			System.out.println(expected);
			ToastUtil.validateToastMessage(DriverFactory.getDriver(), expected);
	}
	
	@Test(priority=4, groups= {"sanity", "regression"})
	@RunHomeNavigation
	@Description("Verify that Employee is registered with existing emails")
	@Epic("Employee Admin")
	@Feature("Registration of Employee")
	@Severity(SeverityLevel.CRITICAL)
	public void registration_existingemails() throws Exception {
		int row = 4;
		registrationpage();
		 WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("fullname")));
      
	       fillFormData(4);
	       emppage.clickSubmit();
	       String expected =  reader.getCellvalue(SHEET_NAME, row, 21);
			System.out.println(expected);
			ToastUtil.validateToastMessage(DriverFactory.getDriver(), expected);
	}
	
//	@Test(priority=5, groups= {"sanity", "regression"})
//	@Description("Verify that Employee is registered with existing serial number")
//	@Epic("Employee Admin")
//	@Feature("Registration of Employee")
//	@Severity(SeverityLevel.CRITICAL)
//	public void registration_existingsno() throws Exception {
//		int row = 5;
//		registrationpage();
//		 WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(10));
//	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("fullname")));
//      
//	       fillFormData(5);
//	       emppage.clickSubmit();
//	       String expected =  reader.getCellvalue(SHEET_NAME, row, 21);
//			System.out.println(expected);
//			ToastUtil.validateToastMessage(DriverFactory.getDriver(), expected);
//	}
	
	@Test(priority=5, groups= {"sanity", "regression"})
	@RunHomeNavigation
	@Description("Verify that Employee is registered with existing spgs number")
	@Epic("Employee Admin")
	@Feature("Registration of Employee")
	@Severity(SeverityLevel.CRITICAL)
	public void registration_existingspg() throws Exception {
		int row = 6;
		registrationpage();
		 WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("fullname")));
      
	       fillFormData(6);
	       emppage.clickSubmit();
	       String expected =  reader.getCellvalue(SHEET_NAME, row, 21);
			System.out.println(expected);
			ToastUtil.validateToastMessage(DriverFactory.getDriver(), expected);
	}
	
	@Test(priority = 6, groups = { "sanity", "regression" })

	@Description("Verify that searching by Employee name works correctly in the Employee list after successful registration")
	@Epic("Employee Admin")
	@Feature("Employee Admin-Available in List")
	@Severity(SeverityLevel.CRITICAL)
	public void employee_list() throws Exception {
		
		
		int row = 1;
		DriverFactory.getDriver().findElement(By.xpath("(//i[@class='fa fa-arrow-left'])[1]")).click();
		DriverFactory.getDriver().navigate().refresh();
		By sidebarLocator = By.xpath("//*[@id='sidebar']/div/div/ul/li[2]/a/div/span");
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(10));
		WebElement sidebarItem = wait.until(ExpectedConditions.elementToBeClickable(sidebarLocator));
		((JavascriptExecutor) DriverFactory.getDriver()).executeScript("window.scrollTo(0, 0);");
		Thread.sleep(300);
		((JavascriptExecutor) DriverFactory.getDriver()).executeScript("arguments[0].scrollIntoView(true);", sidebarItem);
		Thread.sleep(300);
		try {
		    sidebarItem.click();
		} catch (ElementClickInterceptedException e) {
		    ((JavascriptExecutor) DriverFactory.getDriver()).executeScript("arguments[0].click();", sidebarItem);
		}
		//driver.findElement(By.xpath("//*[@id=\"sidebar\"]/div/div/ul/li[2]/a/div/span")).click();   This line must uncomment if run sanity
		DriverFactory.getDriver().findElement(By.xpath("//*[@id=\"sidebar\"]/div/div/ul/li[2]/div/a[2]/div/span")).click();
		String searchValue = reader.getCellvalue(SHEET_NAME, row, 0);
		emppage.setSearchlist(searchValue);
		Thread.sleep(2000);
		List<WebElement> nameCells = DriverFactory.getDriver().findElements(By.xpath("//*[@id=\"DataTables_Table_0\"]/tbody/tr[1]/td[2]"));
		System.out.println(nameCells + "Search succw=essfull");
		Assert.assertTrue(nameCells.size() > 0, "No rows displayed after search!");
		boolean found = false;
		for (WebElement nameCell : nameCells) {
			if (nameCell.getText().trim().equalsIgnoreCase(searchValue.trim())) {
				found = true;
				break;
			}
		}

		Assert.assertTrue(found, "Expected name '" + searchValue + "' not found in filtered results.");
	}
	
	@Test(priority = 7, groups = { "sanity", "regression" })
	@Description("Verify that the Employee details displayed match the information entered during registrationn")
	@Epic("Employee Admin")
	@Feature("Employee Admin-Verify Information")
	@Severity(SeverityLevel.CRITICAL)
	public void emp_amn_verifyemployeeinfo() throws Exception {
		int row = 1;
		Thread.sleep(5000);
		emppage.clickView();
		
		String expectFullName = reader.getCellvalue(SHEET_NAME, row, 0);
		String expectFatherName = reader.getCellvalue(SHEET_NAME, row, 1);
		String expectMotherName = reader.getCellvalue(SHEET_NAME, row, 2);
		String expectGender = reader.getCellvalue(SHEET_NAME, row, 3);
		String expectDOB = reader.getdatevalue(SHEET_NAME, row, 4);
		String expectEmail = reader.getCellvalue(SHEET_NAME, row, 5);
		String expectidnumber = reader.getCellvalue(SHEET_NAME, row, 7);
		
		String expectMobile = reader.getCellvalue(SHEET_NAME, row, 8);
		String expectAltMobile = reader.getCellvalue(SHEET_NAME, row, 9);
		String expectcheckprofile = reader.getCellvalue(SHEET_NAME, row, 12);
		String expectBloodGroup = reader.getCellvalue(SHEET_NAME, row, 10);
		String expectIdMark = reader.getCellvalue(SHEET_NAME, row, 11);
		
		
		
		
		String expectCategory = reader.getCellvalue(SHEET_NAME, row, 13);
		String expectEmployeeType = reader.getCellvalue(SHEET_NAME, row, 14);
		String expectBranchName = reader.getCellvalue(SHEET_NAME, row, 15);
		String expectSerialNumber = reader.getCellvalue(SHEET_NAME, row, 16);
		String expectOrganisation = reader.getCellvalue(SHEET_NAME, row, 17);
		String expectDesignation = reader.getCellvalue(SHEET_NAME, row, 18);
		String expectspgnumber = reader.getCellvalue(SHEET_NAME, row, 19);
		String expectAddress = reader.getCellvalue(SHEET_NAME, row, 20);
		
		
		String actualFullName = emppage.getFullName();
		String actualFatherName = emppage.getFathername();
		String actualMotherName = emppage.getMothername();
		String actualGender = emppage.getGender();
		String actualDOB = emppage.getDob();
		String actualEmail = emppage.getemailz();
		String actualidnumber = emppage.getIdNumber();
		
		String actualMobile = emppage.getContactNumber();
		String actualAltMobile = emppage.getAlternate_contact_number();
		String actualcheckprofile = emppage.getcheckProfile();
		String actualBloodGroup = emppage.getBloodgroup();
		String actualIdMark = emppage.getIdentificationMark();
		
		
		
		
		String actualCategory = emppage.getTemplateCategoryId();
		String actualEmployeeType = emppage.getEmployeeTypeId();
		String actualBranchName = emppage.getBranch();
		String actualSerialNumber = emppage.getSerialNumber();
		String actualOrganisation = emppage.getOrganizationId();
		String actualDesignation = emppage.getDesignationId();
		String actualspgnumber = emppage.getForceSpgOrCardNumber();
		String actualAddress = emppage.getAddress();

		// Validate each field
		validateField("Full Name", expectFullName, actualFullName);
		
		validateField("Father's Name", expectFatherName, actualFatherName);
		validateField("Mother's Name", expectMotherName, actualMotherName);
		validateField("Gender", expectGender, actualGender);
		validateField("Date of Birth", expectDOB, actualDOB);
		validateField("Mobile Number", expectMobile, actualMobile);
		validateField("Alternate Mobile", expectAltMobile, actualAltMobile);
		validateField("Check Profile", expectcheckprofile, actualcheckprofile);
		
		
		validateField("Blood Group", expectBloodGroup, actualBloodGroup);
		validateField("Identification Mark", expectIdMark, actualIdMark);
		validateField("Email", expectEmail, actualEmail);
		validateField("idnumber", expectidnumber, actualidnumber);
		
		validateField("Categoryr", expectCategory, actualCategory);
		validateField("EmployeeType", expectEmployeeType, actualEmployeeType);
		validateField("BranchName", expectBranchName, actualBranchName);
		validateField("SerialNumbers", expectSerialNumber, actualSerialNumber);
		validateField("Organisation", expectOrganisation, actualOrganisation);
		validateField("designation", expectDesignation, actualDesignation);
		validateField("spgnumber", expectspgnumber, actualspgnumber);
		validateField("Address", expectAddress, actualAddress);

	}

	public void validateField(String label, String expected, String actual) {
		if (!expected.equalsIgnoreCase(actual)) {
			throw new AssertionError(label + " mismatch! Expected: " + expected + ", Found: " + actual);
		}
	}
	
	
	@Test(priority = 8, groups = { "sanity", "regression" })
	@Description("Verify that user is able to send the icar request  by passing all correct  value")
	@Epic("Employee Admin")
	@Feature("Employee Admin -I Card Request")
	@Severity(SeverityLevel.CRITICAL)
	public void emp_amn_requestcar() throws Exception {
		LOGGER.info("icar request for employee starts");
		int row =1;
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(10));
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//span[normalize-space()='Employees List']"))).click();
		String searchValue = reader.getCellvalue(SHEET_NAME, row, 0);
		emppage.setSearchlist(searchValue);
		System.out.println(searchValue);
		Thread.sleep(2000);
		emppage.clickIcarRequest();
		datePicker.selectpassValidUptoDate("08-09-2059");
		String photoPath = "G:\\stsworkspac\\CentralVistapmo\\src\\test\\java\\com\\centralvista\\testdata\\photo.jpg";
		emppage.uploaddocument(photoPath);
		emppage.setremark("request Initiate");
		emppage.presubmit();
		Thread.sleep(10000);
		emppage.selectapprovingAuthority("260047");
		emppage.setremarks("request Initiate");
		emppage.setzoneId("Zone A");
		emppage.setbuildingId("Anusandhan Bhawan"); 
		emppage.IcarRequestButton();
		WebElement toast = wait.until(
			    ExpectedConditions.visibilityOfElementLocated(
			        By.xpath("//div[@id='toast-container']")
			    )
			);

			String actual = toast.getText();

			String expectedMessage1 =
			    "Employee pass details added successfully";

			String expectedMessage2 =
			    "Pass requested successfully";

			Assert.assertTrue(
			    actual.contains(expectedMessage1)
			        || actual.contains(expectedMessage2),
			    "Toast message mismatch. Actual: " + actual
			);

			wait.until(ExpectedConditions.elementToBeClickable(
			    By.xpath("//span[normalize-space()='Employees List']")
			)).click();
	}
	
	

	@Test(priority = 9, groups = { "sanity", "regression" })
	@Description("Verify that the Employee appears in the “Requested ICAR” list after successfully initiating the ICAR request")
	@Epic("Employee Admin")
	@Feature("Employee Admin-I Card Request List")
	@Severity(SeverityLevel.CRITICAL)
	public void emp_admin_requestverify() throws Exception {
		 LOGGER.info("verify icar request for Employee starts");
		 int row = 1;
			String searchValue = reader.getCellvalue(SHEET_NAME, row, 0);
			emppage.setSearchlist(searchValue);
			WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(10));
			
	        Thread.sleep(5000);
			
			List<WebElement> rows = DriverFactory.getDriver().findElements(
				    By.cssSelector("tbody tr.ng-star-inserted")
				);
			Thread.sleep(5000);
				
				int rowCount = rows.size();
				System.out.println("Total TR count: " + rowCount);
			
			Assert.assertTrue(rowCount > 0, "No rows displayed after search for: " + searchValue);

			// Verify if search value exists in any row
			boolean found = rows.stream()
			    .map(e -> e.getText().trim().toLowerCase())
			    .anyMatch(text -> text.contains(searchValue.trim().toLowerCase()));

			Assert.assertTrue(found,
			    "No row contains the text '" + searchValue + "'. Found values: " +
			        rows.stream().map(WebElement::getText).toList());
		}
	
	@Test(priority=10 , groups = {"sanity","regression"})
	@Description("Verify that the employee admin is logout or not after requesting Pass")
	@Epic("Employee Admin")
	@Feature("Employee Admin-Logout")
	@Severity(SeverityLevel.CRITICAL)
	public void employeeadmin_logout() throws Exception
	{
		emppage.logout();
		WebElement toast = driver.findElement(By.xpath("//div[@id='toast-container']"));
		String actual = toast.getText();
		String exceptMessage = "Logged out successfully!";
		ToastUtil.validateToastMessage(DriverFactory.getDriver(), exceptMessage);
		
	}
	
	@Test(priority= 11, groups = {"sanity","regression"})
	@Description("Verify that recommender/ Approver is able to login after passing coorect value")
	@Epic("Recommender/Approver")
	@Feature("Recommender/Approver- Login")
	@Severity(SeverityLevel.CRITICAL)
	public void loginapprover() throws IOException
	{
		reader = new ExcelReader("G:\\stsworkspac\\CentralVistapmo\\src\\test\\java\\com\\centralvista\\testdata\\pmotest.xlsx");
		int row = 59;
		emppage.setUserName(reader.getCellvalue(SHEET_NAME, row, 0).trim());
		emppage.setPassword(reader.getCellvalue(SHEET_NAME, row, 1).trim());
		emppage.clickLogin();
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(10));
		WebElement roleDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userRole")));
		new Select(roleDropdown).selectByValue("RECOMMENDER_APPROVER");
		
	}
	
	@Test(priority= 12, groups= {"sanity","regression"})
	@Description("Verify thats the Employee pass request is reached to the selected Recommending/ Approving Authority")
	@Epic("Recommender/Approver")
	@Feature("Recommender/Approver- Verify Request")
	@Severity(SeverityLevel.CRITICAL)
	public void verifyreq_approver() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(10));
		wait.until(
				ExpectedConditions.elementToBeClickable(emppage.getemployeesidebar()))
				.click();
		wait.until(ExpectedConditions
				.elementToBeClickable(emppage.getemployeeslistlink())).click();
		
		 LOGGER.info("verify  request presents in Pending List");
		 int row = 1;
			String searchValue = reader.getCellvalue(SHEET_NAME, row, 0);
			emppage.setSearchlist(searchValue);
			
	        Thread.sleep(5000);
			
			List<WebElement> rows = DriverFactory.getDriver().findElements(
				    By.cssSelector("tbody tr.ng-star-inserted")
				);
			Thread.sleep(5000);
				
				int rowCount = rows.size();
				System.out.println("Total TR count: " + rowCount);
			
			Assert.assertTrue(rowCount > 0, "No rows displayed after search for: " + searchValue);

			// Verify if search value exists in any row
			boolean found = rows.stream()
			    .map(e -> e.getText().trim().toLowerCase())
			    .anyMatch(text -> text.contains(searchValue.trim().toLowerCase()));

			Assert.assertTrue(found,
			    "No row contains the text '" + searchValue + "'. Found values: " +
			        rows.stream().map(WebElement::getText).toList());
	}
	
	@Test(priority= 13, groups= {"sanity","regression"})
	@Description("Verify thats the Recommending/ Approving Authority is able to forward Employee pass request to Issuing Authority")
	@Epic("Recommender/Approver")
	@Feature("Recommender/Approver- Forward to issuer")
	@Severity(SeverityLevel.CRITICAL)
	public void reqforw_issuer() throws InterruptedException
	{
		emppage.fortoissuer();
		emppage.selectAction();
		emppage.setapproveremarks("approve");
		emppage.clickSubmit();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(
		    By.cssSelector("#toast-container .toast-message") 
		));
		String actual = toast.getText();
		String exceptMessage = "Application status changed successfully.";
		ToastUtil.validateToastMessage(DriverFactory.getDriver(), exceptMessage);
		
	}
	

	@Test(priority= 14, groups= {"sanity","regression"})
	@Description("Verify thats the Employee pass request move to Icar status list after  Recommending/ Approving Authority forward  it to Issuing Authority")
	@Epic("Recommender/Approver")
	@Feature("Recommender/Approver- Forward to issuer")
	@Severity(SeverityLevel.CRITICAL)
	public void reqfmove_statuslist() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(10));
		wait.until(
				ExpectedConditions.elementToBeClickable(emppage.getemployeesidebar()))
				.click();
		wait.until(ExpectedConditions
				.elementToBeClickable(emppage.getemployeesstatuslistlink())).click();
		
		 LOGGER.info("verify  request presents in Pending List");
		 int row = 1; 
			String searchValue = reader.getCellvalue(SHEET_NAME, row, 0);
			emppage.setSearchlist(searchValue);
			
	        Thread.sleep(5000);      
			
			List<WebElement> rows = DriverFactory.getDriver().findElements(
				    By.cssSelector("tbody tr.ng-star-inserted")
				);
			Thread.sleep(5000);
				
				int rowCount = rows.size();
				System.out.println("Total TR count: " + rowCount);
			
			Assert.assertTrue(rowCount > 0, "No rows displayed after search for: " + searchValue);

			// Verify if search value exists in any row
			boolean found = rows.stream()
			    .map(e -> e.getText().trim().toLowerCase())
			    .anyMatch(text -> text.contains(searchValue.trim().toLowerCase()));

			Assert.assertTrue(found,
			    "No row contains the text '" + searchValue + "'. Found values: " +
			        rows.stream().map(WebElement::getText).toList());
	}

	@Test(priority= 19, groups= {"sanity","regression"})
	@Description("Verify that the Recommender/Approver is logout or not after Approving Pass request")
	@Epic("Recommender/Approver")
	@Feature("Recommender/Approver- Forward to issuer")
	@Severity(SeverityLevel.CRITICAL)
	public void logout_approver() throws InterruptedException
	{
		emppage.logout();
		WebElement toast = driver.findElement(By.xpath("//div[@id='toast-container']"));
		String actual = toast.getText();
		String exceptMessage = "Logged out successfully!";
		ToastUtil.validateToastMessage(DriverFactory.getDriver(), exceptMessage);
		
	}
	

}