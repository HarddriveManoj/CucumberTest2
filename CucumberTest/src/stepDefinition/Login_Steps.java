package stepDefinition;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Login_Steps {
	private static WebDriver driver;
	private static String baseUrl;
	private Properties props = new Properties();

	@Given("^User is on BBC page$")
	public void user_is_on_BBC_page() throws Throwable {
		props.load(new FileInputStream("config.properties"));
		System.setProperty("webdriver.gecko.driver", props.getProperty("webdriver.gecko.driver"));
		driver = new FirefoxDriver();
		baseUrl = props.getProperty("baseURL");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseUrl + props.getProperty("extendedURL"));
	}

	@When("^User clicks on Register link$")
	public void user_clicks_on_Register_link() throws Throwable {
		// User clicks on Sign-in link
		driver.findElement(By.id("idcta-username")).click();
		driver.findElement(By.cssSelector("a.link.link--primary > span")).click();
	}

	@When("^User enters date of birth and clicks next$")
	public void user_enters_date_of_birth_and_clicks_next() throws Throwable {
		// Enter DOB Details
		driver.findElement(By.id("day-input")).clear();
		driver.findElement(By.id("day-input")).sendKeys("01");
		driver.findElement(By.id("month-input")).clear();
		driver.findElement(By.id("month-input")).sendKeys("Jan");
		driver.findElement(By.id("year-input")).clear();
		driver.findElement(By.id("year-input")).sendKeys("1960");

		// Submit DOB Details
		driver.findElement(By.id("submit-button")).click();
	}

	@When("^user enters email and password$")
	public void user_enters_email_and_password() throws Throwable {
		// Enter Email & password details
		driver.findElement(By.id("email-input")).clear();
		driver.findElement(By.id("email-input")).sendKeys(props.getProperty("user1"));
		driver.findElement(By.id("password-input")).clear();
		driver.findElement(By.id("password-input")).sendKeys(props.getProperty("pass1"));
	}

	@When("^enters postcode$")
	public void enters_postcode() throws Throwable {
		// Enter Postcode details
		driver.findElement(By.id("postcode-input")).clear();
		driver.findElement(By.id("postcode-input")).sendKeys(props.getProperty("postcode"));
	}

	@When("^selects gender$")
	public void selects_gender() throws Throwable {
		// Select Gender
		new Select(driver.findElement(By.id("gender-input"))).selectByVisibleText(props.getProperty("gender"));
	}

	@When("^unsubscribes for email updates$")
	public void unsubscribes_for_email_updates() throws Throwable {
		// Set email preferences
		driver.findElement(By.id("optOut")).click();
	}

	@When("^clicks on register$")
	public void clicks_on_register() throws Throwable {
		// Submit registration form
		driver.findElement(By.id("submit-button")).click();
	}

	@Then("^User should receive an confirmation email$")
	public void user_should_receive_an_confirmation_email() throws Throwable {
		System.out.println("User Registration Successful");
		driver.quit();

	}

	@When("^User clicks on Sign in$")
	public void user_clicks_on_Sign_in() throws Throwable {
		/*
		 * User Logs in with CORRECT Credentials
		 */
		// User clicks on Sign-in link

		System.setProperty("webdriver.gecko.driver", props.getProperty("webdriver.gecko.driver"));
		driver = new FirefoxDriver();
		baseUrl = props.getProperty("baseURL");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseUrl + props.getProperty("extendedURL"));
		driver.findElement(By.id("idcta-username")).click();

	}

	@When("^User logs in using Username as \"([^\"]*)\" and Password as \"([^\"]*)\"$")
	public void user_logs_in_using_Username_as_and_Password_as(String arg1, String arg2) throws Throwable {
		// Clear the existing user name (if any!)
		driver.findElement(By.id("username-input")).clear();

		// Enter the email id as username
		driver.findElement(By.id("username-input")).sendKeys(props.getProperty("user2"));

		// Clear existing (saved) password (if any!)
		driver.findElement(By.id("password-input")).clear();

		// Enter Correct password
		driver.findElement(By.id("password-input")).sendKeys(props.getProperty("pass2"));

		// Click on submit
		driver.findElement(By.id("submit-button")).click();
	}

	@Then("^Sign in should be successful$")
	public void sign_in_should_be_successful() throws Throwable {
		System.out.println("User Login Successful");

		driver.quit();
	}

	@When("^User enters incorrect username as \"([^\"]*)\" and password as \"([^\"]*)\"$")
	public void user_enters_incorrect_username_as_and_password_as(String arg1, String arg2) throws Throwable {
		/*
		 * User Logs in with INCORRECT Credentials
		 */
		// User clicks on Sign-in link

		System.setProperty("webdriver.gecko.driver", props.getProperty("webdriver.gecko.driver"));
		driver = new FirefoxDriver();
		baseUrl = props.getProperty("baseURL");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseUrl + props.getProperty("extendedURL"));
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

	@Then("^Sign in should not be successful$")
	public void sign_in_should_not_be_successful() throws Throwable {
		System.out.println("User Login Failed");
		driver.quit();
	}

}
