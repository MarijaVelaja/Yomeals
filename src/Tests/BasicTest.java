package Tests;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
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
	protected WebDriverWait waiter;
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
		this.waiter = new WebDriverWait(driver, 10);

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

		loginPage = new LoginPage(driver, js, waiter);
		popUpPage = new LocationPopupPage(driver, js, waiter);
		notificationPage = new NotificationSistemPage(driver, js, waiter);
		profilePage = new ProfilePage(driver, js, waiter);
		authPage = new AuthPage(driver, js, waiter);
		mealPage = new MealPage(driver, js, waiter);
		cartPage = new CartSummaryPage(driver, js, waiter);

	}

	public void takeScreenshotWhenFailure(ITestResult result) throws InterruptedException, IOException{
		if(ITestResult.FAILURE==result.getStatus()) {
			TakesScreenshot screenshot = (TakesScreenshot) driver;
			File scr = screenshot.getScreenshotAs(OutputType.FILE);
			
			LocalDateTime ldt = LocalDateTime.now();
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss");
			
			FileUtils.copyFile(scr, new File("./screenshots/"+ldt.format(dtf)+".png"));
		
		Thread.sleep(2000);
		this.driver.quit();
		
		
		}
	
	
	
	
		
	
	}	
	
}

	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	

