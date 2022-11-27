package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SrearchPage extends PageBase{

	public SrearchPage(WebDriver driver) {
		super(driver);
	
	}
	
	@FindBy(id = "small-searchterms")
	WebElement searchtxtBox;
	
	@FindBy(xpath = "//*[@id=\"small-search-box-form\"]/button")
	WebElement searchBtn;
	
	@FindBy(id = "ui-id-1")
	List<WebElement> productlist;
	
	@FindBy(linkText = "Apple MacBook Pro 13-inch")
	WebElement proudcttitle;
	
	public void productsearch(String prodctName) {
		
		settextfiledtext(searchtxtBox, prodctName);
		clickbotton(searchBtn);
	}
	
	public void openprodcuttitle() {
		
		clickbotton(proudcttitle);
	}
	
	public void productsearchusingAutoSuggest(String Searchtxt) throws InterruptedException  {
		
		settextfiledtext(searchtxtBox, Searchtxt);
		Thread.sleep(1000);
		productlist.get(0).click();
	}

}
