package Tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MealItemTest extends BasicTest {
	


	@Test (priority = 1)
	
	public void addMealToCart() throws InterruptedException {
		
		this.driver.navigate().to(baseURL + "meal/lobster-shrimp-chicken-quesadilla-combo");
		this.popUpPage.closePopup();
		this.mealPage.getAddTocart(4);
		Thread.sleep(2000);
		Assert.assertTrue(this.notificationPage.getTextMessage().contains("The Following Errors Occurred: "),"[ERROR] No message shown");
		Assert.assertTrue(this.notificationPage.getTextMessage().contains("Please Select Location"),"[ERROR] No message shown");
		this.notificationPage.waitUntilMessageDisappears();
		
		Thread.sleep(2000);
		
		this.popUpPage.clickSelectLocation();
		this.popUpPage.selectLocation("City Center - Albany");
         
		this.mealPage.getAddTocart(4);	
		Thread.sleep(2000);
		Assert.assertTrue(this.notificationPage.getTextMessage().contains("Meal Added to Cart")," [ERROR] Adding to cart was unsuccessful");
		this.notificationPage.waitUntilMessageDisappears();
		
	}
	
	 @Test (priority = 3)

	public void addToFavorite() throws InterruptedException {

		this.driver.navigate().to(baseURL + "meal/lobster-shrimp-chicken-quesadilla-combo");
		this.popUpPage.closePopup();
		this.mealPage.addToFavourite();
		Thread.sleep(2000);
		
		Assert.assertTrue(this.notificationPage.getTextMessage().contains("Please login first!")," [ERROR] Unexpected login message");
		this.notificationPage.waitUntilMessageDisappears();

		this.driver.navigate().to(baseURL + "guest-user/login-form");
		Thread.sleep(2000);
		this.loginPage.loginUser(email, password);
		Thread.sleep(2000);
		this.driver.navigate().to(baseURL + "meal/lobster-shrimp-chicken-quesadilla-combo");
		this.mealPage.addToFavourite();
		
		Thread.sleep(2000);
		Assert.assertTrue(this.notificationPage.getTextMessage().contains("Product has been added to your favorites")," [ERROR] Product has not been added to your favorites");
		this.notificationPage.waitUntilMessageDisappears();
		
	}

  @Test (priority = 2)
	 
	  public void clearCart() throws InterruptedException, IOException {
	  this.driver.navigate().to(baseURL + "meals");
	  Thread.sleep(2000);
	  
	  
	  this.popUpPage.selectLocation("City Center - Albany");
	  Thread.sleep(2000);
	  File file = new File("data/Data.xlsx");
	  FileInputStream fis = new FileInputStream(file);
	  XSSFWorkbook wb = new XSSFWorkbook(fis);
	  XSSFSheet sheet = wb.getSheet("Meals");
	
	  for (int i = 1; i < 6; i++) {
			String meal = sheet.getRow(i).getCell(0).getStringCellValue();
			double quantity = sheet.getRow(i).getCell(1).getNumericCellValue();
	

			this.driver.navigate().to(meal);
			this.mealPage.getAddTocart(quantity);
			Assert.assertTrue(this.notificationPage.getTextMessage().contains ("Meal Added To Cart"),"[ERROR] Cart is empty");
	
	  }
	  
	   this.cartPage.cartClearAll();
	   Assert.assertTrue(this.notificationPage.getTextMessage().contains ("All meals removed from Cart successfully"),"[ERROR] Items have not been removed");
	   this.notificationPage.waitUntilMessageDisappears();	
	
	

	} 
}
