package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasicPage {

	public LoginPage(WebDriver driver, JavascriptExecutor js) {
		super(driver, js);
	
	}
	
	public WebElement getLoginButton() {
		return this.driver.findElement(By.xpath("//*[@class='filled']/a"));
	}
	
	public WebElement getEmailUsername() {
		return this.driver.findElement(By.name("username"));
	}

	public WebElement getPassword() {
		return this.driver.findElement(By.name("password"));
	}
	
	public WebElement getSecondLoginButton() {
		return this.driver.findElement(By.name("btn_submit"));
	}
	
	
	public void loginUser (String username, String password) {
		this.getLoginButton().click();
		this.getEmailUsername().clear();
		this.getEmailUsername().sendKeys(username);
		this.getPassword().clear();
		this.getPassword().sendKeys(password);
		this.getSecondLoginButton().click();
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
}
