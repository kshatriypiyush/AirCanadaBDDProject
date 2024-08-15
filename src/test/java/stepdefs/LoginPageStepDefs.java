package stepdefs;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import aircanadapages.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageStepDefs {

	WebDriver driver;
	LoginPage loginPage;
	JavascriptExecutor jse;

	@Before
	public void setup() {
		driver = new EdgeDriver();
		jse = (JavascriptExecutor)driver; 
	}

	@Given("I am on the login page of Air Canada")
	public void i_am_on_the_login_page_of_air_canada() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		driver.get("https://www.aircanada.com/clogin/pages/login");
		Thread.sleep(1000);
		loginPage = new LoginPage(driver, jse);
	}

	@Given("I have entered invalid {string}")
	public void i_have_entered_invalid(String aeronumoremail) throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		loginPage.switchToLegacy();
		Thread.sleep(1000);
		loginPage.navToLoginPage();
		loginPage.enterEmail(aeronumoremail);
	}

	@When("I move to password block to enter password")
	public void i_move_to_password_block_to_enter_password() {
		// Write code here that turns the phrase above into concrete actions
		loginPage.enterPassword("test@123");
	}

	@Then("I should see error message indicating {string}")
	public void i_should_see_error_message_indicating(String expectedInvalAerNumOrEmailErrors) throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		String actualError = loginPage.invalidEmailOrAeroNumError();
		Assert.assertEquals(actualError, expectedInvalAerNumOrEmailErrors);
	}
/*
	@Given("I have entered valid {string} and wrong {string}")
	public void i_have_entered_valid_and_wrong(String aeronumoremail, String pass) throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		loginPage.navToLoginPage();
		loginPage.enterEmail(aeronumoremail);
		loginPage.enterPassword(pass);
	}

	@When("I click on signIn button")
	public void i_click_on_sign_in_button() {
		// Write code here that turns the phrase above into concrete actions
		loginPage.clickSingInButton();
	}

	@Then("I should see error message starting with {string}")
	public void i_should_see_error_message_starting_with(String exptWrongCredErr) throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		String actualError = loginPage.wrongCredentailError();
		Assert.assertEquals(actualError.startsWith(exptWrongCredErr),true);
	}

	@When("I click on Create an account")
	public void i_click_on_create_an_account() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		loginPage.navToLoginPage();
		loginPage.clickCreateAcc();
	}

	@Then("I should be redirected to create new account page")
	public void i_should_be_redirected_to_create_new_account_page() {
		// Write code here that turns the phrase above into concrete actions
		String acutalRedirectedPage = driver.getTitle();
		String expectedAccCreatePageTitle = "Air Canada - Official website - Aeroplan - Enroll";
		Assert.assertEquals(acutalRedirectedPage, expectedAccCreatePageTitle);
	}

	@When("I click on Forgot your password?")
	public void i_click_on_forgot_your_password() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		loginPage.navToLoginPage();
		loginPage.clickForgotPassword();
	}

	@Then("I should be redirected to forgot password page")
	public void i_should_be_redirected_to_forgot_password_page() {
		// Write code here that turns the phrase above into concrete actions
		String acutalRedirectedPage = driver.getTitle();
		String expectedForgotPassPageTitle = "Forgot Password";
		Assert.assertEquals(acutalRedirectedPage, expectedForgotPassPageTitle);
	}*/

}
