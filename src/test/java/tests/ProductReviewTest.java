package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.ProductDetailsPage;
import pages.ProductReviewPage;
import pages.SrearchPage;
import pages.UserRegisterationPage;

public class ProductReviewTest extends TestBase{
	HomePage homeobject;
	UserRegisterationPage  registerobject;
	LoginPage LoginObject;
	String proudctName="Apple MacBook Pro 13-inch";
	SrearchPage searchobject;
	ProductDetailsPage detailsobject;
	ProductReviewPage reviewobject;
	String ReviewtitleTXT = "good proudct";
	String reviewmessage = "vrey good MacLabTop";
@Test (priority = 0,alwaysRun = true)
	
	public void usercanregistersuccessfully() {
		homeobject = new HomePage(driver);
		homeobject.openregisterationPage();
		registerobject=new UserRegisterationPage(driver);
		registerobject.userregisteration("Ahmed", "Aref", "ahmedaref5@gmail.com", "12345678");
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
		LoginObject.userlogin("ahmedaref5@gmail.com", "12345678");
		Assert.assertTrue(registerobject.LogoutLink.getText().contains("Log out"));
	}
	
	@Test(priority = 3)
	
	public void usercansearchforaproduct() {
		
		searchobject = new SrearchPage(driver);
		detailsobject = new ProductDetailsPage(driver);
		searchobject.productsearch(proudctName);
		searchobject.openprodcuttitle();
		Assert.assertTrue(detailsobject.productnamereadcrumb.getText().equalsIgnoreCase(proudctName));
		detailsobject.OpenAddReviewPage();
		
	}
	
	@Test(priority = 4)
	
	public void RegisteredUserCanAddReviewForProudct() {
		
		reviewobject = new ProductReviewPage(driver);
		reviewobject.AddProudctReview(ReviewtitleTXT, reviewmessage);
		Assert.assertTrue(reviewobject.sucessreviewmes.getText().contains("Product review is"));
	}
	
}
