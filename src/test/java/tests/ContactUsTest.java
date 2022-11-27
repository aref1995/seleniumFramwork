package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ContactUsPage;
import pages.HomePage;

public class ContactUsTest extends TestBase{

	HomePage pageobject;
	ContactUsPage contactobject;
	
	String Fullname="Ahmed Aref";
	String Email = "ahmed@test.com";
	String enquiry="Hi Admin";
	
	@Test
	
	public void UserCanContactUs() {
		
		pageobject = new HomePage(driver);
		pageobject.OpencontactusPage();
		contactobject = new ContactUsPage(driver);
		contactobject.ContactUs(Fullname, Email, enquiry);
		Assert.assertTrue(contactobject.successMessage.getText().contains("Your enquiry has been successfully sent to the store owner."));
		
	}
}
