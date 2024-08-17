package aircanadapages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginAndHomePage {

	private WebDriver driver;
	JavascriptExecutor jse;
	public WebDriverWait wait;

	// Page Factory - PO
	@FindBy(xpath = "//input[@id='gigya-loginID-36809123729262220']")
	WebElement aeroNumorEmail;

	@FindBy(xpath = "//input[@id='gigya-password-70610748058497410']")
	WebElement password;

	@FindBy(linkText = "Forgot your password?")
	WebElement forgotPassword;

	@FindBy(linkText = "Create an account")
	WebElement createAccount;

	@FindBy(xpath = "//div[@class='gigya-composite-control gigya-composite-control-textbox gigya-composite-control--is-filled gigya-composite-control--has-error']/span")
	WebElement errorInvalidAeroNumEmail;


	@FindBy(xpath = "//abc-toggle[@class='ng-valid abc-form-element ng-touched ng-dirty']")
	WebElement switchToLegacy;

	@FindBy(id = "acUserMenu-aco")
	WebElement singInDropDown;
	
	@FindBy(xpath ="//button[@id='acMegaNavButton-book']")
	WebElement bookInNav;

	@FindBy(xpath = "//div[@class='ngx-ac-mega-nav-section ng-star-inserted']/ul[@aria-label='Routes and partners']/li")
	List<WebElement> routesAndPartners;
	
	@FindBy(xpath = "//ul[@class='ng-star-inserted']/li")
	List<WebElement> popularDestinations;

	public LoginAndHomePage(WebDriver driver, JavascriptExecutor setJse) {
		this.driver = driver;
		this.jse = setJse;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(60));

	}

	public void enterEmail(String aeronumoremail) throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOf(aeroNumorEmail));
		driver.findElement(By.xpath("//span[contains(text(),'Aeroplan number or email')]")).click();
		aeroNumorEmail.sendKeys(aeronumoremail);
	}

	public void switchToLegacy() throws InterruptedException {	
		//Thread.sleep(3000);
		//driver.findElement(By.id("onetrust-accept-btn-handler")).click();
		wait.until(ExpectedConditions.visibilityOf(switchToLegacy));
		Thread.sleep(1000);
		switchToLegacy.click();
	}

	public void navToLoginPage() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOf(singInDropDown));
		singInDropDown.click();
		Thread.sleep(2000);
		if (driver.findElements(By.id("acUserMenu-signIn")).size() > 0) {
			driver.findElement(By.id("acUserMenu-signIn")).click();
		}
	}

	public void enterPassword(String pass) throws InterruptedException {
		driver.findElement(By.xpath("//span[contains(text(),'Password')]")).click();
		password.sendKeys(pass);
	}


	public void clickForgotPassword() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOf(forgotPassword));
		driver.findElement(By.id("onetrust-accept-btn-handler")).click();
		Thread.sleep(3000);
		forgotPassword.click();
	}

	public void clickCreateAcc() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOf(createAccount));
		driver.findElement(By.id("onetrust-accept-btn-handler")).click();
		Thread.sleep(3000);
		createAccount.click();
	}

	public String invalidEmailOrAeroNumError() throws InterruptedException {
		return errorInvalidAeroNumEmail.getText();
	}


	public void openBookNavInHeader() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(bookInNav));
		bookInNav.click();
	}
	
	public int routesAndPartnersCount() throws InterruptedException {
		Thread.sleep(2000);
		return routesAndPartners.size();
	}
	
	public int popularDestinationsCount() throws InterruptedException {
		Thread.sleep(2000);
		return popularDestinations.size();
	}
	
	public boolean findMontreal() throws InterruptedException {
		Thread.sleep(2000);
		for(WebElement wb: popularDestinations) {
			if(wb.getText().equals("Montreal")) {
				return true;
			}
		}
		return false;
	}
	
	
}
