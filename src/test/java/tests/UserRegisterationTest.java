package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterationPage;

public class UserRegisterationTest extends TestBase {

	HomePage homeobject;
	UserRegisterationPage  registerobject;
	LoginPage LoginObject;
	@Test (priority = 0,alwaysRun = true)
	
	public void usercanregistersuccessfully() {
		homeobject = new HomePage(driver);
		homeobject.openregisterationPage();
		registerobject=new UserRegisterationPage(driver);
		registerobject.userregisteration("Ahmed", "Aref", "ahmedaref1@gmail.com", "12345678");
		Assert.assertTrue(registerobject.succsmessage.getText().contains("Your registration completed"));
	}
	@Test (priority = 1)
	public void registeredUserCanLogout() {
		
		registerobject.userlogout();
	}
	
	@Test (priority = 2)
	
	public void RegisteredUserCanLogin() {	
		homeobject.Openloginpage();
		LoginObject = new LoginPage(driver);
		LoginObject.userlogin("ahmedaref1@gmail.com", "12345678");
		Assert.assertTrue(registerobject.LogoutLink.getText().contains("Log out"));
	}
}
