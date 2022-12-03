package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CheckOutProductPage;
import pages.HomePage;
import pages.LoginPage;
import pages.OrderDetailsPage;
import pages.ProductDetailsPage;
import pages.ShoppingCartPage;
import pages.SrearchPage;
import pages.UserRegisterationPage;

public class RegisteredUserCheckOutProductTest extends TestBase{

	HomePage homeobject;
	UserRegisterationPage  registerobject;
	LoginPage LoginObject;
	ProductDetailsPage proudctobject;
	ShoppingCartPage shoppingobject;
	CheckOutProductPage checkobject;
	OrderDetailsPage Orderobject;
	@Test (priority = 0)
	
	public void usercanregistersuccessfully() {
		homeobject = new HomePage(driver);
		homeobject.openregisterationPage();
		registerobject=new UserRegisterationPage(driver);
		registerobject.userregisteration("Ahmed", "Aref", "ahmedaref9@gmail.com", "12345678");
		Assert.assertTrue(registerobject.succsmessage.getText().contains("Your registration completed"));
	}
	
	String proudctName="Apple MacBook Pro 13-inch";
	SrearchPage searchobject;
	ProductDetailsPage detailsobject;
	
	@Test (priority = 1)
	
	public void UserCanSearchWithAutoSuggest()  {
		
		try {
			searchobject = new SrearchPage(driver);
			searchobject.productsearchusingAutoSuggest("MacB");
			detailsobject = new ProductDetailsPage(driver);
			Assert.assertTrue(detailsobject.productnamereadcrumb.getText().equalsIgnoreCase(proudctName));
			
		} catch (Exception e) {
		System.out.println("Error Occurred"+ e.getMessage());
		}
		
	}
	
		@Test(priority = 2)
	
	public void UserCanAddProductToShoppingCart() throws InterruptedException {
		
		proudctobject = new ProductDetailsPage(driver);
		proudctobject.AddProductToCart();
		Thread.sleep(1000);
		driver.navigate().to("https://demo.nopcommerce.com/cart");
		
	}
		
	@Test(priority = 3)
	
	public void ResiteredUserCanCheckOutProduct() throws InterruptedException {
		
		shoppingobject =new ShoppingCartPage(driver);
		shoppingobject.CheckoutProduct();
		checkobject = new CheckOutProductPage(driver);
		checkobject.CheckOutProduct("test", "test", "test", "test");
		Assert.assertTrue(checkobject.ConfirmOrderMessage.isDisplayed());
		checkobject.OrderDetails();
		Orderobject = new OrderDetailsPage(driver);
		Orderobject.printOrderDetails();
		Orderobject.DownloadPDFInvoice();
		
	}
}
