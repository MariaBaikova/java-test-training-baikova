package com.example.tests;

import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestBase {

	private static WebDriver driver;
	private static String baseUrl;
	private static boolean acceptNextAlert = true;
	private static StringBuffer verificationErrors = new StringBuffer();

	@BeforeTest 
	public void setUp() throws Exception {
	    driver = new FirefoxDriver();
	    baseUrl = "http://localhost/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }
	
	@AfterTest 
	public void tearDown() throws Exception {
	    driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
	  }
	
	protected void returnToGroupsPage() {
		driver.findElement(By.linkText("group page")).click();
	}

	protected void submitGroupCreation() {
		driver.findElement(By.name("submit")).click();
	}

	protected void fillGroupForm(GroupData group) {
		WebElement groupName = driver.findElement(By.name("group_name"));
		WebElement groupHeader =  driver.findElement(By.name("group_header"));
		WebElement groupFooter =  driver.findElement(By.name("group_footer"));
		groupName.clear();
		groupName.sendKeys(group.groupName);
		groupHeader.clear();
		groupHeader.sendKeys(group.header);
		groupFooter.clear();
		groupFooter.sendKeys(group.footer);
	}
	
	protected void fillFormContact(ContactData contact) {
		WebElement lastnameField = driver.findElement(By.name("lastname"));
		WebElement firstnameField = driver.findElement(By.name("firstname"));
		WebElement addressField = driver.findElement(By.name("address"));
		WebElement homeTelephoneField = driver.findElement(By.name("home"));
		WebElement mobileTelephoneField = driver.findElement(By.name("mobile"));
		WebElement workTelephoneField = driver.findElement(By.name("work"));
		WebElement emailField = driver.findElement(By.name("email"));
		WebElement email2Field = driver.findElement(By.name("email2"));
		WebElement bDayField = driver.findElement(By.name("bday"));
		WebElement bMonthField = driver.findElement(By.name("bmonth"));
		WebElement byearField = driver.findElement(By.name("byear"));
		WebElement groupField = driver.findElement(By.name("new_group"));
		WebElement homeTelphone2Field = driver.findElement(By.name("address2"));
		WebElement address2Field = driver.findElement(By.name("phone2"));
		
		fillTextField(lastnameField,contact.lastName);
		fillTextField(firstnameField,contact.firstName);
		fillTextField(addressField,contact.address);
		fillTextField(homeTelephoneField,contact.homeTelephone);
		fillTextField(mobileTelephoneField,contact.mobileTelephone);
		fillTextField(workTelephoneField,contact.workTelephone);
		fillTextField(emailField,contact.email);
		fillTextField(email2Field,contact.email_2);
		
	    new Select(bDayField).selectByVisibleText(contact.bDay);
	    new Select(bMonthField).selectByVisibleText(contact.bMonth);
	    
	    fillTextField(byearField,contact.bYear);
	       
	    new Select(groupField).selectByVisibleText(contact.group);
	    
	    fillTextField(address2Field,contact.address_2);
	    fillTextField(homeTelphone2Field,contact.home);
	    
	}

	protected void initGroupCreation() {
		driver.findElement(By.name("new")).click();
	}

	protected void changeGroupsPage() {
		driver.findElement(By.linkText("groups")).click();
	}

	protected void openMainPage() {
		driver.get(baseUrl + "/addressbookv4.1.4/");
	}

	private boolean isElementPresent(By by) {
	    try {
	      driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }

	private boolean isAlertPresent() {
	    try {
	      driver.switchTo().alert();
	      return true;
	    } catch (NoAlertPresentException e) {
	      return false;
	    }
	  }

	private String closeAlertAndGetItsText() {
	    try {
	      Alert alert = driver.switchTo().alert();
	      String alertText = alert.getText();
	      if (acceptNextAlert) {
	        alert.accept();
	      } else {
	        alert.dismiss();
	      }
	      return alertText;
	    } finally {
	      acceptNextAlert = true;
	    }
	  }

	protected void returnToHomePage() {
		driver.findElement(By.linkText("home page")).click();
	}

	protected void submitContactCreation() {
		driver.findElement(By.name("submit")).click();
	}

	protected void initContactCreation() {
		driver.findElement(By.linkText("add new")).click();
	}

	protected void fillTextField(WebElement textField, String value){
		textField.clear();
		textField.sendKeys(value);
	}
}
