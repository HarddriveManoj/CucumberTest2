/*
 * This is a standalone class for Selenium Test methods
 */
package bbc;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class SelTest {
	private static WebDriver driver;
	private static String baseUrl;

	// Opens BBC Test page URL
	public void openBBCURL() {
		System.setProperty("webdriver.gecko.driver", "D:\\Java\\selenium\\geckodriver.exe");
		driver = new FirefoxDriver();
		baseUrl = "http://www.bbc.co.uk/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(baseUrl + "/blogs/test/entries/f5f3031a-1a29-44ee-b2f8-86e78bfd57b0");
	}

	/**
	 * Register user.
	 */
	public void registerUser() {

		// User clicks on Sign-in link
		driver.findElement(By.id("idcta-username")).click();
		driver.findElement(By.cssSelector("a.link.link--primary > span")).click();

		// Enter DOB Details
		driver.findElement(By.id("day-input")).clear();
		driver.findElement(By.id("day-input")).sendKeys("01");
		driver.findElement(By.id("month-input")).clear();
		driver.findElement(By.id("month-input")).sendKeys("Jan");
		driver.findElement(By.id("year-input")).clear();
		driver.findElement(By.id("year-input")).sendKeys("1960");

		// Submit DOB Details
		driver.findElement(By.id("submit-button")).click();

		// Enter Email & password details
		driver.findElement(By.id("email-input")).clear();
		driver.findElement(By.id("email-input")).sendKeys("geno02@bbc.co.uk");
		driver.findElement(By.id("password-input")).clear();
		driver.findElement(By.id("password-input")).sendKeys("test@123");

		// Enter Postcode details
		driver.findElement(By.id("postcode-input")).clear();
		driver.findElement(By.id("postcode-input")).sendKeys("m502bh");

		// Select Gender
		new Select(driver.findElement(By.id("gender-input"))).selectByVisibleText("Male");

		// Set email preferences
		driver.findElement(By.id("optOut")).click();

		// Submit registration form
		driver.findElement(By.id("submit-button")).click();
	}

	public void correctCredentials() {
		/*
		 * User Logs in with CORRECT Credentials
		 */
		// User clicks on Sign-in link
		driver.findElement(By.id("idcta-username")).click();

		// Clear the existing user name (if any!)
		driver.findElement(By.id("username-input")).clear();

		// Enter the email id as username
		driver.findElement(By.id("username-input")).sendKeys("harddrive.manoj@gmail.com");

		// Clear existing (saved) password (if any!)
		driver.findElement(By.id("password-input")).clear();

		// Enter Correct password
		driver.findElement(By.id("password-input")).sendKeys("sQTyu3MC");

		// Click on submit
		driver.findElement(By.id("submit-button")).click();
	}

	public void incorrectCredentials() {

		/*
		 * User Logs in with INCORRECT Credentials
		 */
		// User clicks on Sign-in link
		driver.findElement(By.id("idcta-username")).click();

		// Clear the existing user name (if any!)
		driver.findElement(By.id("username-input")).clear();

		// Enter the email id as username
		driver.findElement(By.id("username-input")).sendKeys("harddrive.manoj@gmail.com");

		// Clear existing (saved) password (if any!)
		driver.findElement(By.id("password-input")).clear();

		// Enter Correct password
		driver.findElement(By.id("password-input")).sendKeys("Random_and_Incorrect_Password");

		// Click on submit
		driver.findElement(By.id("submit-button")).click();

	}

}
