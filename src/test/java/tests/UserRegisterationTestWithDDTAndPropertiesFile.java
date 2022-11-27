package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import data.LoadProperties;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterationPage;

public class UserRegisterationTestWithDDTAndPropertiesFile extends TestBase {

	HomePage homeobject;
	UserRegisterationPage  registerobject;
	LoginPage LoginObject;
	String finame=LoadProperties.userdata.getProperty("firstname");
	String Laname = LoadProperties.userdata.getProperty("lastname");
	String Email = LoadProperties.userdata.getProperty("email");
	String Pass = LoadProperties.userdata.getProperty("password");
		
	
	@Test (priority = 0,alwaysRun = true)
	
	public void usercanregistersuccessfully() {
		homeobject = new HomePage(driver);
		homeobject.openregisterationPage();
		registerobject=new UserRegisterationPage(driver);
		registerobject.userregisteration(finame, Laname , Email , Pass);
		Assert.assertTrue(registerobject.succsmessage.getText().contains("Your registration completed"));
		registerobject.userlogout();
		homeobject.Openloginpage();
		LoginObject = new LoginPage(driver);
		LoginObject.userlogin(Email , Pass);
		Assert.assertTrue(registerobject.LogoutLink.getText().contains("Log out"));
		registerobject.userlogout();
	}
	
	
	
}
