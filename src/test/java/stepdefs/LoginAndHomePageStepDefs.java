package stepdefs;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import aircanadapages.LoginAndHomePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginAndHomePageStepDefs {

	WebDriver driver;
	LoginAndHomePage loginAndHomePage;
	JavascriptExecutor jse;

	@Before
	public void setup() {
		driver = new FirefoxDriver();
		jse = (JavascriptExecutor)driver; 
	}

	@After
	public void tearDown() {
		driver.quit();
	}
	
	// =====================================================================================
	
	
	@Given("I am on Air Canada Page")
	public void i_am_on_air_canada_page() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		driver.get("https://www.aircanada.com/clogin/pages/login");
		loginAndHomePage = new LoginAndHomePage(driver, jse);
		loginAndHomePage.switchToLegacy();
	}

	@When("I have entered invalid {string}")
	public void i_have_entered_invalid(String aeronumoremail) throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		Thread.sleep(1000);
		loginAndHomePage.navToLoginPage();
		loginAndHomePage.enterEmail(aeronumoremail);
	}

	@When("I move to password block to enter password {string}")
	public void i_move_to_password_block_to_enter_password(String pass) throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		loginAndHomePage.enterPassword(pass);
	}

	@Then("I should see error message indicating {string}")
	public void i_should_see_error_message_indicating(String expectedInvalAerNumOrEmailErrors) throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		String actualError = loginAndHomePage.invalidEmailOrAeroNumError();
		Assert.assertEquals(actualError, expectedInvalAerNumOrEmailErrors);
	}

	
	@When("I have click on create a new account link")
	public void i_have_click_on_create_a_new_account_link() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		Thread.sleep(1000);
		loginAndHomePage.navToLoginPage();
		loginAndHomePage.clickCreateAcc();
	}

	@Then("I should navigate to Create Account which has page title {string}")
	public void i_should_navigate_to_create_account_which_has_page_title(String expectedAccCreatePageTitle) {
	    // Write code here that turns the phrase above into concrete actions
		loginAndHomePage.wait.until(ExpectedConditions.titleContains(expectedAccCreatePageTitle));
		String acutalRedirectedPage = driver.getTitle();
		Assert.assertEquals(acutalRedirectedPage, expectedAccCreatePageTitle);
	}

	@When("I have click on forgot your password")
	public void i_have_click_on_forgot_your_password() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		Thread.sleep(1000);
		loginAndHomePage.navToLoginPage();
		loginAndHomePage.clickForgotPassword();
	}

	@Then("I should navigate to Forgot Password whose page title {string}")
	public void i_should_navigate_to_forgot_password_whose_page_title(String expectedForgotPassPageTitle) {
		// Write code here that turns the phrase above into concrete actions
		loginAndHomePage.wait.until(ExpectedConditions.titleContains(expectedForgotPassPageTitle));
		String acutalRedirectedPage = driver.getTitle();
		Assert.assertEquals(acutalRedirectedPage, expectedForgotPassPageTitle);
	}
	

	@When("I click on Book Menu in Header")
	public void i_click_on_book_menu_in_header() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
	    loginAndHomePage.openBookNavInHeader();
	}

	@Then("I should see {int} Routes and Partners under drop down menu")
	public void i_should_see_routes_and_partners_under_drop_down_menu(Integer expectedNumberOfRoutesAndPartners) throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
	    int actualNumberOfRoutesAndPartners = loginAndHomePage.routesAndPartnersCount();
	    Assert.assertEquals(actualNumberOfRoutesAndPartners, expectedNumberOfRoutesAndPartners);
	}

	@Then("I should see {int} Popular destinations under drop down menu")
	public void i_should_see_popular_destinations_under_drop_down_menu(Integer expectedNumberOfPopularDest) throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
	    int actualNumberOfPopularDest = loginAndHomePage.popularDestinationsCount();
	    Assert.assertEquals(actualNumberOfPopularDest, expectedNumberOfPopularDest);
	}


	@Then("I should see Montreal as Popular Destinations")
	public void i_should_see_Montreal_as_popular_destinations() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
	    boolean isMontrealPresent = loginAndHomePage.findMontreal();
	    Assert.assertEquals(isMontrealPresent, true);
	}
	
	


}
