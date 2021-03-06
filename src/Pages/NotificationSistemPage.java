package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NotificationSistemPage extends BasicPage {

	public NotificationSistemPage(WebDriver driver, JavascriptExecutor js, WebDriverWait waiter) {
		super(driver, js, waiter);

	}

	public WebElement getMessage() {
		return driver.findElement(By.xpath("//*[contains(@class, 'alert--success') or contains(@class, 'alert--danger')]"
				+ "[contains(@style,'display: block')]"));
	}

	public String getTextMessage() {
		return driver.findElement(By.xpath("//*[contains(@class, 'alert--success') or contains(@class, 'alert--danger')]"
				+ "[contains(@style,'display: block')]")).getText();
	}

	public void waitUntilMessageDisappears() {
		this.waiter.until(ExpectedConditions.attributeContains(getMessage(),"style", "display: none;"));

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
