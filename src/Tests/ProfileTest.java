package Tests;

import java.io.File;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfileTest extends BasicTest {

	@Test(priority = 1)

	public void editProfile() throws InterruptedException {

		this.driver.get(baseURL + "guest-user/login-form");
		this.popUpPage.closePopup();
		this.loginPage.loginUser(email, password);
		Assert.assertTrue(this.notificationPage.getTextMessage().contains("Login Successfull"),
				"[ERROR] Unexpected login message");

		this.driver.navigate().to(baseURL + "member/profile");
		this.profilePage.changeInfo("John", "Smith", "5142 Brynhurst Ave, Los Angeles, CA", "445-453-23", "90043",
				"United States", "California", "Los Angeles");
		Assert.assertTrue(this.notificationPage.getTextMessage().contains("Setup Successful"),
				"[ERROR] Unexpected setup message");

		this.authPage.logOut();
		Assert.assertTrue(this.notificationPage.getTextMessage().contains("Logout Successfull"),
				"[ERROR]Unexpected logout message ");

	}

	@Test(priority = 2)

	public void changeImg() throws IOException, InterruptedException {

		this.driver.navigate().to(baseURL + "/guest-user/login-form");
		this.popUpPage.closePopup();
		this.loginPage.loginUser(email, password);
		Assert.assertTrue(this.notificationPage.getTextMessage().contains("Login Successfull"),
				"[ERROR] Unexpected login message");

		this.driver.navigate().to(baseURL + "/member/profile");
		String imgPath = new File("image//test.jpg").getCanonicalPath();
		this.profilePage.uploadImg(imgPath);
		Assert.assertTrue(this.notificationPage.getTextMessage().contains("Profile Image Uploaded"),
				"[ERROR] Image Upload failed");
		this.notificationPage.waitUntilMessageDisappears();

		this.profilePage.removeImg();
		Assert.assertTrue(this.notificationPage.getTextMessage().contains("Profile Image Deleted Successfully"),
				"Profile Image Deleted Failed");
		this.notificationPage.waitUntilMessageDisappears();

		this.authPage.logOut();
		Assert.assertTrue(this.notificationPage.getTextMessage().contains("Logout Successfull"),
				"[ERROR]Unexpected logout message ");
		this.notificationPage.waitUntilMessageDisappears();

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
