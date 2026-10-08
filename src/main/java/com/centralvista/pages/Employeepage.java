/**
 * @author surendragangwar
 * @since 13-Aug-2026
 * @version 1.0
 * 
 * Description: [Enter class purpose here]
 */
package com.centralvista.pages;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.centralvista.base.BaseTest;
//import com.centralvista.testBase.TestBase;
import com.centralvista.utilities.DatePickertUtil;

public class Employeepage {

	private WebDriver driver;
	private WebDriverWait wait;
	private DatePickertUtil datePicker;

	public Employeepage(WebDriver driver) {

		System.out.println("Driver = " + driver);

		if (driver == null) {
			throw new IllegalArgumentException("WebDriver is NULL while creating Employeepage");
		}

		this.driver = driver;

		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Initialize DatePickerUtil
		this.datePicker = new DatePickertUtil(driver);
		System.out.println("DatePicker = " + this.datePicker);
		PageFactory.initElements(driver, this);
	}

	public void selectDOB(String date) {

		datePicker.selectdob(date);
	}

	@FindBy(xpath = "//*[@id='fullname']")
	WebElement fullName;

	@FindBy(xpath = "//*[@id='fatherName']")
	WebElement fathername;

	@FindBy(xpath = "//*[@id='motherName']")
	WebElement mothername;

	@FindBy(xpath = "//*[@id= 'gender']")
	WebElement Gender;

	@FindBy(xpath = "//*[@id = 'dob']")
	WebElement dob;

	@FindBy(xpath = "//*[@id = 'email']")
	WebElement Email;

	@FindBy(xpath = "//*[@id= 'idType']")
	WebElement idType;

	@FindBy(xpath = "//*[@id= 'idNumber']")
	WebElement idNumber;

	@FindBy(xpath = "//*[@id= 'contactNumber']")
	WebElement contactNumber;

	@FindBy(xpath = "//*[@id= 'alternate_contact_number']")
	WebElement alternate_contact_number;

	@FindBy(xpath = "//*[@id='bloodgroup']")
	WebElement bloodgroup;

	@FindBy(xpath = "//*[@id= 'identificationMark']")
	WebElement identificationMark;

	@FindBy(xpath = "//*[@id= 'checkProfile']")
	WebElement checkProfile;

	@FindBy(xpath = "//*[@id= 'templateCategoryId']")
	WebElement templateCategoryId;

	@FindBy(xpath = "//*[@id= 'employeeTypeId']")
	WebElement employeeTypeId;

	@FindBy(xpath = "//*[@id= 'branch']")
	WebElement branch;

	@FindBy(xpath = "//*[@id= 'serialNumber']")
	WebElement serialNumber;

	@FindBy(xpath = "//*[@id= 'organizationId']")
	WebElement organizationId;

	@FindBy(xpath = "//*[@id= 'designationId']")
	WebElement designationId;

	@FindBy(xpath = "//*[@id= 'forceSpgOrCardNumber']")
	WebElement forceSpgOrCardNumber;

	@FindBy(xpath = "//*[@id= 'permanentAddress']")
	WebElement permanentAddress;

	// button[normalize-space()='Submit']

	@FindBy(xpath = "//button[normalize-space()='Submit']")
	WebElement Submit;

	@FindBy(xpath = "//input[@placeholder='Username']")
	WebElement textBoxUsername; //// *[@id="email"]

	@FindBy(xpath = "//input[@placeholder='Password']")
	WebElement textBoxPassword;

	@FindBy(xpath = "//button[@type='submit']")

	WebElement btnLogin;

	public void clickLogin() {

		btnLogin.click();
	}

	public void setUserName(String uName) {
		textBoxUsername.sendKeys(uName);
	}

	public void setPassword(String pwd) {
		textBoxPassword.sendKeys(pwd);
	}

	public void setFullName(String value) {
		fullName.sendKeys(value);

	}

	@FindBy(xpath = "//span[normalize-space()='Employees']")
	WebElement registrationsidebar;

	@FindBy(xpath = "(//span[normalize-space()='Add Employee'])[1]")
	WebElement registrrationlink;

	public WebElement getRegistrationsidebar() {
		return registrationsidebar;
	}

	public void setRegistrationsidebar(WebElement registrationsidebar) {
		this.registrationsidebar = registrationsidebar;
	}

	public WebElement getRegistrrationlink() {
		return registrrationlink;
	}

	public void setRegistrrationlink(WebElement registrrationlink) {
		this.registrrationlink = registrrationlink;
	}

	public void setFathername(String value) {
		fathername.sendKeys(value);
	}

	public void setMothername(String value) {
		mothername.sendKeys(value);
	}

	protected void selectFromNgSelect(WebElement dropdown, String value) {

		// Open dropdown
		wait.until(ExpectedConditions.elementToBeClickable(dropdown)).click();

		// Select required option
		By option = By.xpath("//div[contains(@class,'ng-option')]" + "//*[normalize-space()='" + value + "']");

		wait.until(ExpectedConditions.elementToBeClickable(option)).click();
	}

	public void setGender(String value) {

		selectFromNgSelect(Gender, value);
	}

	public void setEmail(String value) {
		Email.clear();
		Email.sendKeys(value);
	}

	public void setitype(String value) {

		selectFromNgSelect(idType, value);
	}

	public void setidnumber(String idnumber) {
		idNumber.sendKeys(idnumber);
	}

	public void setcontactNumber(String contactNumbe) {
		contactNumber.sendKeys(contactNumbe);
	}

	public void setaltcontactNumber(String altcontactNumbe) {
		alternate_contact_number.sendKeys(altcontactNumbe);
	}

	public void settbg(String value) {

		selectFromNgSelect(bloodgroup, value);
	}

	public void setidentificationMark(String identificationMak) {
		identificationMark.sendKeys(identificationMak);
	}

	public void setcheckProfile(String value) {

		selectFromNgSelect(checkProfile, value);
	}

	public void setCategoryId(String value) {

		selectFromNgSelect(templateCategoryId, value);
	}

	public void setemployeeType(String value) {

		selectFromNgSelect(employeeTypeId, value);
	}

	public void setbranchname(String value) {

		selectFromNgSelect(branch, value);
	}

	public void setserialNumber(String serialNumbe) {
		serialNumber.sendKeys(serialNumbe);
	}

	public void setorganizationId(String value) {

		selectFromNgSelect(organizationId, value);
	}

	public void setcheckProfil(String value) {

		selectFromNgSelect(designationId, value);
	}

	public void setiforceSpgOrCardNumber(String forceSpgOrCardNumbe) {
		forceSpgOrCardNumber.sendKeys(forceSpgOrCardNumbe);
	}

	public void setpermanentAddress(String permanentAdd) {
		permanentAddress.sendKeys(permanentAdd);
	}

	public void clickSubmit() {
		// Submit.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(Submit)).click();
	}

	@FindBy(xpath = "/html/body/div[2]/div/div[6]/button[1]")
	WebElement messagebox;

	public void clickmessagebo() {
		// Submit.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(messagebox)).click();
	}

	@FindBy(xpath = "//input[@type='search']")
	WebElement searchbox;

	public void setSearchlist(String value) {
		searchbox.clear();
		searchbox.sendKeys(value);
	}

	@FindBy(xpath = "(//button[@class='btn btn-outline-primary btn_wd'])[2]")
	WebElement viewverify;

	public void clickView() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		wait.until(ExpectedConditions.elementToBeClickable(viewverify)).click();
	}

	@FindBy(css = "body > app-root:nth-child(1) > app-employee-admin:nth-child(2) > div:nth-child(1) > div:nth-child(2) > main:nth-child(2) > app-emp-admin-employee-details:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(3)")

	WebElement Fullname;

	public String getFullName() {
		return Fullname.getText().trim();
	}

	@FindBy(css = "body > app-root:nth-child(1) > app-employee-admin:nth-child(2) > div:nth-child(1) > div:nth-child(2) > main:nth-child(2) > app-emp-admin-employee-details:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div:nth-child(3)")

	WebElement fatherName;

	public String getFathername() {
		return fatherName.getText().trim();
	}

	@FindBy(css = "body > app-root:nth-child(1) > app-employee-admin:nth-child(2) > div:nth-child(1) > div:nth-child(2) > main:nth-child(2) > app-emp-admin-employee-details:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(3) > div:nth-child(3)")
	WebElement motherName;

	public String getMothername() {
		return motherName.getText().trim();
	}

	@FindBy(css = "body > app-root:nth-child(1) > app-employee-admin:nth-child(2) > div:nth-child(1) > div:nth-child(2) > main:nth-child(2) > app-emp-admin-employee-details:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(4) > div:nth-child(3)")
	WebElement gender;

	public String getGender() {
		return gender.getText().trim();
	}

	@FindBy(css = "body > app-root:nth-child(1) > app-employee-admin:nth-child(2) > div:nth-child(1) > div:nth-child(2) > main:nth-child(2) > app-emp-admin-employee-details:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(5) > div:nth-child(3)")
	WebElement doB;

	public String getDob() {
		return doB.getText().trim();
	}

	@FindBy(css = "body > app-root:nth-child(1) > app-employee-admin:nth-child(2) > div:nth-child(1) > div:nth-child(2) > main:nth-child(2) > app-emp-admin-employee-details:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(6) > div:nth-child(3)")
	WebElement contactnumber;

	public String getContactNumber() {
		return contactnumber.getText().trim();
	}

	@FindBy(css = "body > app-root:nth-child(1) > app-employee-admin:nth-child(2) > div:nth-child(1) > div:nth-child(2) > main:nth-child(2) > app-emp-admin-employee-details:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(7) > div:nth-child(3)")
	WebElement alternate_contact_Number;

	public String getAlternate_contact_number() {
		return alternate_contact_Number.getText().trim();
	}

	@FindBy(css = "body > app-root:nth-child(1) > app-employee-admin:nth-child(2) > div:nth-child(1) > div:nth-child(2) > main:nth-child(2) > app-emp-admin-employee-details:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(8) > div:nth-child(3)")
	WebElement CheckProfile;

	public String getcheckProfile() {
		return CheckProfile.getText().trim();
	}

	@FindBy(css = "body > app-root:nth-child(1) > app-employee-admin:nth-child(2) > div:nth-child(1) > div:nth-child(2) > main:nth-child(2) > app-emp-admin-employee-details:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(9) > div:nth-child(3)")
	WebElement Bloodgroup;

	public String getBloodgroup() {
		return Bloodgroup.getText().trim();
	}

	@FindBy(css = "body > app-root:nth-child(1) > app-employee-admin:nth-child(2) > div:nth-child(1) > div:nth-child(2) > main:nth-child(2) > app-emp-admin-employee-details:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(10) > div:nth-child(3)")
	WebElement IdentificationMark;

	public String getIdentificationMark() {
		return IdentificationMark.getText().trim();
	}

	@FindBy(css = "body > app-root:nth-child(1) > app-employee-admin:nth-child(2) > div:nth-child(1) > div:nth-child(2) > main:nth-child(2) > app-emp-admin-employee-details:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(11) > div:nth-child(3)")
	WebElement emailz;

	public String getemailz() {
		return emailz.getText().trim();
	}

	@FindBy(css = "body > app-root:nth-child(1) > app-employee-admin:nth-child(2) > div:nth-child(1) > div:nth-child(2) > main:nth-child(2) > app-emp-admin-employee-details:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(12) > div:nth-child(3)")
	WebElement IdNumber;

	public String getIdNumber() {
		return IdNumber.getText().trim();
	}

	@FindBy(css = "body > app-root:nth-child(1) > app-employee-admin:nth-child(2) > div:nth-child(1) > div:nth-child(2) > main:nth-child(2) > app-emp-admin-employee-details:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(14) > div:nth-child(3)")
	WebElement Address;

	public String getAddress() {
		return Address.getText().trim();
	}

	@FindBy(css = "body > app-root:nth-child(1) > app-employee-admin:nth-child(2) > div:nth-child(1) > div:nth-child(2) > main:nth-child(2) > app-emp-admin-employee-details:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(6) > div:nth-child(1) > div:nth-child(3) > p:nth-child(1)")
	WebElement TemplateCategoryId;

	public String getTemplateCategoryId() {
		return TemplateCategoryId.getText().trim();
	}

	@FindBy(css = "body > app-root:nth-child(1) > app-employee-admin:nth-child(2) > div:nth-child(1) > div:nth-child(2) > main:nth-child(2) > app-emp-admin-employee-details:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(6) > div:nth-child(2) > div:nth-child(3) > p:nth-child(1)")
	WebElement EmployeeTypeId;

	public String getEmployeeTypeId() {
		return EmployeeTypeId.getText().trim();
	}

	@FindBy(css = "body > app-root:nth-child(1) > app-employee-admin:nth-child(2) > div:nth-child(1) > div:nth-child(2) > main:nth-child(2) > app-emp-admin-employee-details:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(6) > div:nth-child(4) > div:nth-child(3) > p:nth-child(1)")
	WebElement Branch;

	public String getBranch() {
		return Branch.getText().trim();
	}

	@FindBy(css = "body > app-root:nth-child(1) > app-employee-admin:nth-child(2) > div:nth-child(1) > div:nth-child(2) > main:nth-child(2) > app-emp-admin-employee-details:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(6) > div:nth-child(5) > div:nth-child(3) > p:nth-child(1)")
	WebElement SerialNumber;

	public String getSerialNumber() {
		return SerialNumber.getText().trim();
	}

	@FindBy(css = "body > app-root:nth-child(1) > app-employee-admin:nth-child(2) > div:nth-child(1) > div:nth-child(2) > main:nth-child(2) > app-emp-admin-employee-details:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(6) > div:nth-child(6) > div:nth-child(3) > p:nth-child(1)")
	WebElement OrganizationId;

	public String getOrganizationId() {
		return OrganizationId.getText().trim();
	}

	@FindBy(css = "body > app-root:nth-child(1) > app-employee-admin:nth-child(2) > div:nth-child(1) > div:nth-child(2) > main:nth-child(2) > app-emp-admin-employee-details:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(6) > div:nth-child(7) > div:nth-child(3) > p:nth-child(1)")
	WebElement DesignationId;

	public String getDesignationId() {
		return DesignationId.getText().trim();
	}

	@FindBy(css = "body > app-root:nth-child(1) > app-employee-admin:nth-child(2) > div:nth-child(1) > div:nth-child(2) > main:nth-child(2) > app-emp-admin-employee-details:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(6) > div:nth-child(8) > div:nth-child(3) > p:nth-child(1)")
	WebElement fOrceSpgOrCardNumber;

	public String getForceSpgOrCardNumber() {
		return fOrceSpgOrCardNumber.getText().trim();
	}

	@FindBy(xpath = "//tbody/tr[1]/td[12]/button")
	WebElement icarRequest;

	public void clickIcarRequest() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(icarRequest)).click();
	}

	@FindBy(xpath = "//ng-select[@id='reissuance']")
	WebElement requestType;

	public void setRequestType(String value) {
		requestType.sendKeys(value);
	}

	@FindBy(xpath = "//input[@id='document']")
	WebElement uploaocument;

	@FindBy(xpath = "//*[@id = 'remark']")
	WebElement remark;

	public void uploaddocument(String ocumentFilePath) {
		File ocumentFile = new File(ocumentFilePath);
		if (ocumentFile.exists()) {
			uploaocument.sendKeys(ocumentFile.getAbsolutePath());
		} else {
			throw new RuntimeException("Ocument file not found at: " + ocumentFilePath);
		}
	}

	public void setremark(String value) {
		remark.clear();
		remark.sendKeys(value);
	}

	@FindBy(xpath = "/html/body/app-root/app-employee-admin/div/div/main/app-emp-admin-add-pass-application-details/div/div/div[2]/div/div/form/div[2]/div[3]/div/button")
	WebElement presubmit;

	public void presubmit() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(presubmit)).click();
	}
	
	
	@FindBy(xpath = "//ng-select[@id='zoneId']")
	WebElement zoneId;
	
	@FindBy(xpath = "//ng-select[@id='buildingId']")
	WebElement buildingId;
	

    public void setzoneId(String value) {
    	// Click to focus and then type
    	WebElement zoneInput = driver.findElement(By.cssSelector("ng-select#zoneId input"));
    	zoneInput.sendKeys(value);
    	zoneInput.sendKeys(Keys.ENTER);
    }
    public void setbuildingId(String value) {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    	// 1. Wait for the ng-select to be ready
    	WebElement buildingSelect = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buildingId")));

    	// 2. Find the input using a stable CSS selector
    	WebElement input = buildingSelect.findElement(By.cssSelector("input"));

    	// 3. Interact
    	input.sendKeys(value);
    	input.sendKeys(Keys.ENTER);
    }
    
   

	@FindBy(xpath = "//button[normalize-space()='Request']")
	WebElement requesticardbutton;
	
	public void IcarRequestButton() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(requesticardbutton)).click();
	}

//			    public void setrequestType(String value) {
//			        Select select = new Select(requestType);
//			        select.selectByVisibleText(value);
//			    } 
//			    

	public void selectapprovingAuthority(String authority) {
		
		// 1. Wait for the ng-select container itself first
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement selectContainer = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("ng-select#approvingAuthority")));
		WebElement input = wait.until(ExpectedConditions.presenceOfElementLocated(
		    By.cssSelector("ng-select#approvingAuthority input[role='combobox'], ng-select#approvingAuthority input[type='text']")
		));

		input.sendKeys(authority);
		input.sendKeys(Keys.ENTER);
	}

	@FindBy(xpath = "//*[@id = 'remarks']")
	WebElement remarks;

	public void setremarks(String value) {
		remarks.clear();
		remarks.sendKeys(value);
	}

	@FindBy(xpath = "//div[@class='text-dark show_submenu']")
	WebElement submenu;
	
	@FindBy(xpath= "//a[normalize-space()='Logout']")
	WebElement logout;
	public void logout() {
		
		submenu.click();
		logout.click();
		
	}
	
	@FindBy(xpath = "//span[normalize-space()='Employee']")
	WebElement employeesidebar;

	@FindBy(xpath = "//span[normalize-space()='Pending List']")
	WebElement employeeslistlink;

	
	public WebElement getemployeesidebar() {
		return employeesidebar;
	}

	public void setemployeesidebar(WebElement employeesidebar) {
		this.employeesidebar = employeesidebar;
	}

	public WebElement getemployeeslistlink() {
		return employeeslistlink;
	}

	public void setemployeeslistlink(WebElement employeeslistlink) {
		this.employeeslistlink = employeeslistlink;
	}
	
	@FindBy(xpath = "//span[normalize-space()='ID-Card Status List']")
	WebElement employeesstatuslistlink;
	
	public WebElement getemployeesstatuslistlink() {
		return employeesstatuslistlink;
	}

	public void setemployeesstatuslistlink(WebElement employeeslistlink) {
		this.employeesstatuslistlink = employeeslistlink;
	}
	
	@FindBy(xpath = "(//button[@title='View'])[1]")
	WebElement viewbuttons;

	public void fortoissuer() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		wait.until(ExpectedConditions.elementToBeClickable(viewbuttons)).click();
		wait.until(ExpectedConditions.elementToBeClickable(accesspermission)).click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.elementToBeClickable(submitaccesspermission)).click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.elementToBeClickable(clickapprove)).click();
		Thread.sleep(5000);
		
	}
	
	@FindBy(xpath = "//button[normalize-space()='Update Access Permission']")
	WebElement accesspermission;
	
	@FindBy(xpath = "//button[normalize-space()='Update']")
	WebElement submitaccesspermission;
	
	@FindBy(xpath = "//button[normalize-space()='Approve/Reject Request']")
	WebElement clickapprove;

public void selectAction() {
		
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	// 1. Click the container div to focus and open the ng-select
	WebElement container = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='applicationStatus']/div")));
	container.click();

	// 2. The input field is nested inside the .ng-input class. 
	// This is where you actually send the text.
	WebElement input = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#applicationStatus .ng-input input")));

	// 3. Clear (if needed) and send the tex
	input.sendKeys("Approve and forward to issuer");
	input.sendKeys(Keys.ENTER);
	}


	@FindBy(xpath = "//textarea[@placeholder='Remarks']")
	WebElement approveremarks;

	public void setapproveremarks(String value) {
		approveremarks.clear();
		approveremarks.sendKeys(value);
	}
	
	@FindBy(xpath= "(//button[normalize-space()='Submit'])[1]")
	WebElement submitreqest;
	public void submitreqqest() {
		
		submitreqest.click();
		
	}
	//button[normalize-space()='Submit']

	
	//span[normalize-space()='ID-Card Status List']

}