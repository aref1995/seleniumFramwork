package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.EmailFriendPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductDetailsPage;
import pages.SrearchPage;
import pages.UserRegisterationPage;

public class EmailFriendTest extends TestBase {

	HomePage homeobject;
	UserRegisterationPage  registerobject;
	LoginPage LoginObject;
	String proudctName="Apple MacBook Pro 13-inch";
	SrearchPage searchobject;
	ProductDetailsPage detailsobject;
	EmailFriendPage Emailobject;
	String friendmail = "aref@test.com";
	String personalmessage = "Hi this good for you";
	//1- user registeration
	@Test (priority = 0,alwaysRun = true)
	
	public void usercanregistersuccessfully() {
		homeobject = new HomePage(driver);
		homeobject.openregisterationPage();
		registerobject=new UserRegisterationPage(driver);
		registerobject.userregisteration("Ahmed", "Aref", "ahmedaref2@gmail.com", "12345678");
		Assert.assertTrue(registerobject.succsmessage.getText().contains("Your registration completed"));
	}
	
	// user search for proudct
	@Test(priority = 1)
	
	public void usercansearchforaproduct() {
		
		searchobject = new SrearchPage(driver);
		detailsobject = new ProductDetailsPage(driver);
		searchobject.productsearch(proudctName);
		searchobject.openprodcuttitle();
		Assert.assertTrue(detailsobject.productnamereadcrumb.getText().equalsIgnoreCase(proudctName));
		
	}
	
	// user Email his friend
	@Test(priority = 2)
	
	public void RegisteredUserCanSendproudcetToFriend() {
		detailsobject.sendemailBtn();
		Emailobject =new EmailFriendPage(driver);
		Emailobject.Emailfriends(friendmail, personalmessage);
		Assert.assertTrue(Emailobject.sucessmailmessage.getText().contains("Your message has been sent."));
		 
		
		
	}
	
	
	// user logout
	@Test (priority = 3)
	public void registeredUserCanLogout() {
		
		registerobject.userlogout();
	}
	
	
}
