package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SrearchPage;

public class SearchProudctTest extends TestBase{

	
	String proudctName="Apple MacBook Pro 13-inch";
	SrearchPage searchobject;
	ProductDetailsPage detailsobject;
	
	@Test
	
	public void usercansearchforaproduct() {
		
		searchobject = new SrearchPage(driver);
		detailsobject = new ProductDetailsPage(driver);
		searchobject.productsearch(proudctName);
		searchobject.openprodcuttitle();
		Assert.assertTrue(detailsobject.productnamereadcrumb.getText().equalsIgnoreCase(proudctName));
		
	}
}
