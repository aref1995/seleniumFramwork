package tests;

  

import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;


import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.UserRegisterationPage;

public class MyAccountTest extends TestBase {
	HomePage homeobject;
	UserRegisterationPage  registerobject;
	MyAccountPage myaccountobject;
	LoginPage LoginObject;
	String oldpassword="12345678";
	String newpassword="123456";
	 String firstname="Ahmed";
	 String lastname="Aref";
	 String email="ahmedaref3@gmail.com";
	
	@Test (priority = 0)

	public void usercanregistersuccessfully() {
		homeobject = new HomePage(driver);
		homeobject.openregisterationPage();
		registerobject=new UserRegisterationPage(driver);
		registerobject.userregisteration(firstname, lastname, email, oldpassword);
		Assert.assertTrue(registerobject.succsmessage.getText().contains("Your registration completed"));
	}
	@Test(priority = 1 )
	public void registeredusercanchangepassword() {
		
		myaccountobject = new MyAccountPage(driver);
		registerobject.openmyaccountpage();
		myaccountobject.openchangepasswordpage();
		myaccountobject.changepassword(oldpassword, newpassword);
		Assert.assertTrue(myaccountobject.resultLBL.getText().contains("Password was changed"));
		myaccountobject.closemessage();
	}
	@Test (priority = 2 )
	public void registeredUserCanLogout() throws InterruptedException {
		Thread.sleep(1000);
	
		
		registerobject.userlogout();
	}
	
	@Test (priority = 3)
	
	public void RegisteredUserCanLogin() {	
		homeobject.Openloginpage();
		LoginObject = new LoginPage(driver);
		LoginObject.userlogin(email, newpassword);
		Assert.assertTrue(registerobject.LogoutLink.getText().contains("Log out"));
	}


	
	
}
