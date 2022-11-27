package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterationPage;

public class UserRegisterationTestWithDDTAndDataProvider extends TestBase {

	HomePage homeobject;
	UserRegisterationPage  registerobject;
	LoginPage LoginObject;
	
	@DataProvider(name = "TestData")
	public static Object [][]userdata(){
		return new Object [][]{
			{"Ahmed","Aref","aref3@test.com","123456"},
			{"Hana","Ahmed","hana3@test.com","123456"}
		};
		}
		
	
	
	@Test (priority = 0,alwaysRun = true,dataProvider = "TestData")
	
	public void usercanregistersuccessfully(String Fname , String Lname , String Email , String Password) {
		homeobject = new HomePage(driver);
		homeobject.openregisterationPage();
		registerobject=new UserRegisterationPage(driver);
		registerobject.userregisteration(Fname , Lname , Email,Password);
		Assert.assertTrue(registerobject.succsmessage.getText().contains("Your registration completed"));
		registerobject.userlogout();
		homeobject.Openloginpage();
		LoginObject = new LoginPage(driver);
		LoginObject.userlogin(Email,Password);
		Assert.assertTrue(registerobject.LogoutLink.getText().contains("Log out"));
		registerobject.userlogout();
		
	}
	
	
	
}
