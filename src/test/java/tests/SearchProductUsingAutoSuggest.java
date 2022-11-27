package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SrearchPage;

public class SearchProductUsingAutoSuggest extends TestBase{
	String proudctName="Apple MacBook Pro 13-inch";
	SrearchPage searchobject;
	ProductDetailsPage detailsobject;
	
	@Test
	
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
	}
