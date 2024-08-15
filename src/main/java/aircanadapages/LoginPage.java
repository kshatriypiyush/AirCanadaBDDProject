package aircanadapages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	private WebDriver driver;
	JavascriptExecutor jse;
	WebDriverWait wait;

	// Page Factory - PO
	@FindBy(xpath = "//input[@data-gigya-name='loginID']")
	WebElement aeroNumorEmail;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(className = "gigya-input-submit")
	WebElement signInButton;

	@FindBy(linkText = "Forgot your password?")
	WebElement forgotPassword;

	@FindBy(linkText = "Create an account")
	WebElement createAccount;

	@FindBy(css = ".gigya-error-msg.gigya-error-msg-active")
	WebElement errorInvalidAeroNumEmail;

	@FindBy(xpath = "//div[@class='gigya-error-msg gigya-form-error-msg gigya-error-code-403042 gigya-error-msg-active']")
	WebElement errorWrongCredentials;

	@FindBy(xpath = "//abc-toggle[@data-analytics-val='toggle to legacy']")
	WebElement switchToLegacy;

	@FindBy(id = "acUserMenu-aco")
	WebElement singInDropDown;


	public LoginPage(WebDriver driver, JavascriptExecutor setJse) {
		this.driver = driver;
		this.jse = setJse;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	}

	public void enterEmail(String aeronumoremail) throws InterruptedException {
		Thread.sleep(6000);
		driver.findElement(By.xpath("//span[contains(text(),'Aeroplan number or email')]")).click();
		Thread.sleep(3000);
		aeroNumorEmail.sendKeys(aeronumoremail);
	}

	public void switchToLegacy() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.id("onetrust-accept-btn-handler")).click();
		wait.until(ExpectedConditions.visibilityOf(switchToLegacy));
		switchToLegacy.click();
	}

	public void navToLoginPage() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOf(singInDropDown));
		singInDropDown.click();
		Thread.sleep(3000);
		if (driver.findElements(By.id("acUserMenu-signIn")).size() > 0) {
			driver.findElement(By.id("acUserMenu-signIn")).click();
		}
	}

	public void enterPassword(String pass) {
		password.sendKeys(pass);
	}

	public void clickSingInButton() {
		signInButton.click();
	}

	public void clickForgotPassword() {
		forgotPassword.click();
	}

	public void clickCreateAcc() {
		createAccount.click();
	}

	public String invalidEmailOrAeroNumError() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOf(errorInvalidAeroNumEmail));
		return errorInvalidAeroNumEmail.getText();
	}

	public String wrongCredentailError() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOf(errorWrongCredentials));
		return errorWrongCredentials.getText();
	}

	public void login(String aeronumoremail, String pass) throws InterruptedException {
		enterEmail(aeronumoremail);
		enterPassword(pass);
		clickSingInButton();
	}
}
