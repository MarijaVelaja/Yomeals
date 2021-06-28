package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LocationPopupPage extends BasicPage {

	public LocationPopupPage(WebDriver driver, JavascriptExecutor js,WebDriverWait waiter) {
		super(driver, js, waiter);
		// TODO Auto-generated constructor stub
	}

	public WebElement getSelectLocation() {
		return driver.findElement(By.xpath("//div[@class='location-selector']/a"));

	}

	public void clickSelectLocation() {
		this.getSelectLocation().click();
	}
	
	
	
	public WebElement getCloseButton() {
		return driver.findElement(By.className("close-btn-white"));

	}

	public WebElement getKeyword() {
		return driver.findElement(By.id("locality_keyword"));
	}

	public WebElement getLocationItem(String locationName) {
		return driver.findElement(By.xpath("//li/a[contains(text(),'" + locationName + "')]/.."));
	}

	public WebElement getLocationInput() {
		return driver.findElement(By.id("location_id"));

	}

	public WebElement getSubmit() {
		return driver.findElement(By.xpath("//*[@name='btn_submit']"));
	}


	public void selectLocation(String locationName) throws InterruptedException {
		getKeyword().click();
		Thread.sleep(2000);
		String location = getLocationItem(locationName).getAttribute("data-value");
		js.executeScript("arguments[0].value=arguments[1];", this.getLocationInput(), location);
		js.executeScript("arguments[0].click()", getSubmit());

	}

	public void closePopup() {
		this.getCloseButton().click();

	}

}
