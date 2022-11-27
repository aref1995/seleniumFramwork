package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SrearchPage;
import pages.WishListPage;

public class AddProuductToWishListTest extends TestBase{

	String proudctName="Apple MacBook Pro 13-inch";
	SrearchPage searchobject;
	ProductDetailsPage detailsobject;
	WishListPage wishobject;
	
	@Test(priority = 0)
	
	public void usercansearchforaproduct() {
		
		searchobject = new SrearchPage(driver);
		detailsobject = new ProductDetailsPage(driver);
		searchobject.productsearch(proudctName);
		searchobject.openprodcuttitle();
		Assert.assertTrue(detailsobject.productnamereadcrumb.getText().equalsIgnoreCase(proudctName));
		
	}
	
	@Test(priority = 1)
	
	public void usercanAddproudctToWishList() {
		detailsobject = new ProductDetailsPage(driver);
		detailsobject.AddProudctToWishList();
		driver.navigate().to("https://demo.nopcommerce.com/wishlist");
		wishobject = new WishListPage(driver);
		Assert.assertTrue(wishobject.WishListheder.isDisplayed());
		Assert.assertTrue(wishobject.productCell.getText().contains(proudctName));
	}
	
	@Test (priority = 2)
	
	public void UserCanRemoveProudctFromWishList() {
		
		wishobject = new WishListPage(driver);
		wishobject.removeproudctfrowishlist();
		Assert.assertTrue(wishobject.emptycartLBL.getText().contains("The wishlist is empty"));
	}
	
}
