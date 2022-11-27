package tests;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterationPage;

public class UserRegisterationTestWithDDTAndCSV extends TestBase {

	HomePage homeobject;
	UserRegisterationPage  registerobject;
	LoginPage LoginObject;

	CSVReader reader;

	@Test (priority = 0,alwaysRun = true)

	public void usercanregistersuccessfully() throws CsvValidationException, IOException {
		//Get Path Of CSV File
		String CSVFile = System.getProperty("user.dir")+"\\src\\test\\java\\data\\UserData111.csv"; 
		reader = new CSVReader(new FileReader(CSVFile));
		
		String [] csvfile;
		// while loop will be executed till last value in csv file.
		
		while ((csvfile = reader.readNext())!= null) {
			
			String Fname = csvfile[0];
			String Lname = csvfile[1];
			String Email = csvfile[2];
			String Pass = csvfile[3];
			homeobject = new HomePage(driver);
		homeobject.openregisterationPage();
		registerobject=new UserRegisterationPage(driver);
		registerobject.userregisteration(Fname,Lname,Email,Pass);
		Assert.assertTrue(registerobject.succsmessage.getText().contains("Your registration completed"));
		registerobject.userlogout();
		homeobject.Openloginpage();
		LoginObject = new LoginPage(driver);
		LoginObject.userlogin(Email,Pass);
		Assert.assertTrue(registerobject.LogoutLink.getText().contains("Log out"));
		registerobject.userlogout();
		}
		
		
	}


}
