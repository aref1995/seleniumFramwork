package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductDetailsPage;
import pages.ShoppingCartPage;
import pages.SrearchPage;

public class AddProudctToShoppingCartTest extends TestBase{

	String proudctName="Apple MacBook Pro 13-inch";
	ProductDetailsPage proudctobject;
	HomePage HomeObject;
	ShoppingCartPage shoopingobject;
	ProductDetailsPage detailsobject;
	SrearchPage searchobject;
	
	@Test (priority = 0)
	
	public void UserCanSearchForProduct() throws InterruptedException {
		
		searchobject = new SrearchPage(driver);
		searchobject.productsearchusingAutoSuggest("MacB");
		detailsobject = new ProductDetailsPage(driver);
		Assert.assertTrue(detailsobject.productnamereadcrumb.getText().contains(proudctName));
	}
	
	@Test(priority = 1)
	
	public void UserCanAddProductToShoppingCart() throws InterruptedException {
		
		proudctobject = new ProductDetailsPage(driver);
		proudctobject.AddProductToCart();
		Thread.sleep(1000);
		driver.navigate().to("https://demo.nopcommerce.com/cart");
	}
	
	@Test (priority = 2)
	
	public void UserCanUpdateQuntityinCart() {
		
		shoopingobject = new ShoppingCartPage(driver);
		shoopingobject.UpdateProductQuntityincart("3");
		Assert.assertTrue(shoopingobject.Price.getText().contains("5,400.00"));
	}
	@Test (priority = 3)
	public void UserCanRemoveProductFromCart() {
		shoopingobject = new ShoppingCartPage(driver);
		shoopingobject.RemoveProductFromCart();
		Assert.assertTrue(shoopingobject.NodataTxt.getText().contains("Your Shopping Cart is empty"));
	}
}
