package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterationPage;

public class UserRegisterationTestWithJAVAFaker extends TestBase {

	HomePage homeobject;
	UserRegisterationPage  registerobject;
	LoginPage LoginObject;
	Faker fakedate = new Faker();
	String firstname = fakedate.name().firstName();
	String lastname = fakedate.name().lastName();
	String email = fakedate.internet().emailAddress();
	String pass = fakedate.number().digits(8).toString();

	@Test (priority = 0,alwaysRun = true)

	public void usercanregistersuccessfully() {
		homeobject = new HomePage(driver);
		homeobject.openregisterationPage();
		registerobject=new UserRegisterationPage(driver);
		registerobject.userregisteration(firstname,lastname,email,pass);
		Assert.assertTrue(registerobject.succsmessage.getText().contains("Your registration completed"));
		registerobject.userlogout();
		homeobject.Openloginpage();
		LoginObject = new LoginPage(driver);
		LoginObject.userlogin(email,pass);
		Assert.assertTrue(registerobject.LogoutLink.getText().contains("Log out"));
		registerobject.userlogout();

	}
	
}
