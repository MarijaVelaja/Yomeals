package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MealPage extends BasicPage {

	public MealPage(WebDriver driver, JavascriptExecutor js, WebDriverWait waiter) {
		super(driver, js, waiter);

	}

	public WebElement getAddTocart() {
		return this.driver.findElement(
				By.xpath("//div[@class='d-flex align-items-center justify-content-between flex-lg--col']/a"));
	}

	public WebElement getQuantity() {
		return this.driver.findElement(By.name("product-qty"));
	}

	public WebElement getFav() {
		return this.driver.findElement(By.id("item_119"));
	}

	public void addToFavourite() {
		this.getFav().click();
	}
	
	
	
}
