package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfileTest extends BasicTest {
	
	@Test(priority = 1) 
	
	public void editProfile() throws InterruptedException {
		
		this.driver.get(baseURL + "guest-user/login-form");
		this.popUpPage.closePopup();
		this.loginPage.loginUser(email, password);
		Assert.assertTrue(this.notificationPage.getTextMessage().contains("Login Successfull"),"[ERROR] Unexpected login message");
		
		
		this.driver.navigate().to(baseURL+ "member/profile");
		this.profilePage.changeInfo("John", "Smith","5142 Brynhurst Ave, Los Angeles, CA", "445-453-23", "90043", "United States", "California", "Los Angeles");
		Assert.assertTrue(this.notificationPage.getTextMessage().contains("Setup Successful"),"[ERROR] Unexpected setup message");
		
		
		
		this.authPage.logOut();
		Assert.assertTrue(this.notificationPage.getTextMessage().contains("Logout Successfull"),"[ERROR]Unexpected logout message ");
		
		
	}
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
