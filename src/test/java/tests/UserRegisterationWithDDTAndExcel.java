package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import data.ExcelReader;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterationPage;

public class UserRegisterationWithDDTAndExcel extends TestBase {

	HomePage homeobject;
	UserRegisterationPage  registerobject;
	LoginPage LoginObject;
	
	@DataProvider(name = "ExcelData")
	
	public Object [][] userregister() throws IOException{
		//get data from Excel reader Class
		
		ExcelReader ER = new ExcelReader();
			return ER.getexceldata();	
	}
	
	
	@Test (priority = 0,alwaysRun = true , dataProvider = "ExcelData")
	
	public void usercanregistersuccessfully(String Fname , String Lname , String Email , String Paas) {
		homeobject = new HomePage(driver);
		homeobject.openregisterationPage();
		registerobject=new UserRegisterationPage(driver);
		registerobject.userregisteration(Fname,Lname,Email,Paas);
		Assert.assertTrue(registerobject.succsmessage.getText().contains("Your registration completed"));
		registerobject.userlogout();
		homeobject.Openloginpage();
		LoginObject = new LoginPage(driver);
		LoginObject.userlogin(Email,Paas);
		Assert.assertTrue(registerobject.LogoutLink.getText().contains("Log out"));
		registerobject.userlogout();
	}
	
	
}
