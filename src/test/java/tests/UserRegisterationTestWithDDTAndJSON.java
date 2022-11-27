package tests;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import data.JsonDataReader;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterationPage;

public class UserRegisterationTestWithDDTAndJSON extends TestBase {

	HomePage homeobject;
	UserRegisterationPage  registerobject;
	LoginPage LoginObject;
	@Test (priority = 0,alwaysRun = true)
	
	public void usercanregistersuccessfully() throws FileNotFoundException, IOException, ParseException  {
		//Take Object form JsonClass to read date.
		JsonDataReader jsonobject = new JsonDataReader();
		jsonobject.Jsonreader();
		
		homeobject = new HomePage(driver);
		homeobject.openregisterationPage();
		registerobject=new UserRegisterationPage(driver);
		registerobject.userregisteration(jsonobject.Fname,jsonobject.Lname,jsonobject.email,jsonobject.pass);
		Assert.assertTrue(registerobject.succsmessage.getText().contains("Your registration completed"));
		registerobject.userlogout();
		homeobject.Openloginpage();
		LoginObject = new LoginPage(driver);
		LoginObject.userlogin(jsonobject.email,jsonobject.pass);
		Assert.assertTrue(registerobject.LogoutLink.getText().contains("Log out"));
		registerobject.userlogout();

	}

}
