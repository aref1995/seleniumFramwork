package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;

public class ProudctHoverMenueTest extends TestBase{

	HomePage pageobject;
	@Test
	public void UserCanSelectSubcategoryFromMenue() {
		
		pageobject = new HomePage(driver);
		pageobject.SelectNoteBookMenue();
		Assert.assertTrue(driver.getCurrentUrl().contains("notebooks"));
	}
	
}
