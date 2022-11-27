package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ComparePage;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SrearchPage;

public class AddProudctToCompareTest extends TestBase{

	String firstproudctName="Apple MacBook Pro 13-inch";
	String SecondproudctName="Asus N551JK-XO076H Laptop";
	
	ProductDetailsPage proudctobject;
	HomePage HomeObject;
	ComparePage comparepbject;
	SrearchPage searchobject;
	@Test(priority = 0)
	public void UserCanComparePrducts() throws InterruptedException {
		proudctobject = new ProductDetailsPage(driver);
		HomeObject = new HomePage(driver);
		comparepbject = new ComparePage(driver);
		searchobject = new SrearchPage(driver);
		
		searchobject.productsearchusingAutoSuggest(firstproudctName);
		proudctobject.AddProudctToCompare();
		
		searchobject.productsearchusingAutoSuggest(SecondproudctName);
		proudctobject.AddProudctToCompare();
		Thread.sleep(1000);
		
		driver.navigate().to("https://demo.nopcommerce.com/compareproducts");
		Assert.assertTrue(comparepbject.Firstproducttagname.getText().equals(SecondproudctName));
		Assert.assertTrue(comparepbject.Secondproducttagname.getText().equals(firstproudctName));
		comparepbject.CompareProducts();
		
	}
	
	@Test(priority = 1)
	public void UserCanClearCompareList() {
		
		comparepbject = new ComparePage(driver);
		comparepbject.clearCompareList();
		Assert.assertTrue(comparepbject.NoDataLbl.getText().contains("You have no items to"));
	}

}
