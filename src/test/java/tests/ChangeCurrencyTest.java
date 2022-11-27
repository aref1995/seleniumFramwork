package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SrearchPage;

public class ChangeCurrencyTest extends TestBase{

	
	HomePage pageobject;
	ProductDetailsPage productobject;
	String proudctName="Apple MacBook Pro 13-inch";
	SrearchPage searchobject;
	ProductDetailsPage detailsobject;
	
	@Test(priority = 0)
	
	public void usercansearchforaproduct() {
		
		searchobject = new SrearchPage(driver);
		detailsobject = new ProductDetailsPage(driver);
		searchobject.productsearch(proudctName);
		searchobject.openprodcuttitle();
		Assert.assertTrue(detailsobject.productnamereadcrumb.getText().equalsIgnoreCase(proudctName));
		
	}
	
	@Test (priority = 1)
	
	public void usercanchangecurrency() {
		
		pageobject = new HomePage(driver);
		productobject = new ProductDetailsPage(driver);
		pageobject.changecurrency();
		Assert.assertTrue(productobject.proudctpricelbl.getText().contains("€"));
		System.out.println(productobject.proudctpricelbl.getText());
	}

	
}
