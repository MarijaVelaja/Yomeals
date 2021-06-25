package Tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import Pages.AuthPage;
import Pages.CartSummaryPage;
import Pages.LocationPopupPage;
import Pages.LoginPage;
import Pages.MealPage;
import Pages.NotificationSistemPage;
import Pages.ProfilePage;

public abstract class BasicTest {

	protected WebDriver driver;
	protected JavascriptExecutor js;
	protected WebDriverWait wait;
	protected LoginPage loginPage;
	protected LocationPopupPage popUpPage;
	protected NotificationSistemPage notificationPage;
	protected ProfilePage profilePage;
	protected AuthPage authPage;
	protected MealPage mealPage;
	protected CartSummaryPage cartPage;
	protected String baseURL = "http://demo.yo-meals.com/";
	protected String email = "customer@dummyid.com";
	protected String password = "12345678a";

	@BeforeMethod

	public void setup() {

		System.setProperty("webdriver.chrome.driver", "driver-lib\\chromedriver.exe");
		this.driver = new ChromeDriver();
		this.js = (JavascriptExecutor) driver;
		this.wait = new WebDriverWait(driver, 10);

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

		loginPage = new LoginPage(driver, js, wait);
		popUpPage = new LocationPopupPage(driver, js, wait);
		notificationPage = new NotificationSistemPage(driver, js, wait);
		profilePage = new ProfilePage(driver, js, wait);
		authPage = new AuthPage(driver, js, wait);
		mealPage = new MealPage(driver, js, wait);
		cartPage = new CartSummaryPage(driver, js, wait);

	}

	@AfterMethod

	public void cleanup() {
		this.driver.quit();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	

