package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ComparePage extends PageBase{

	public ComparePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css = "table.compare-products-table")
	WebElement CompareTable;
	
	@FindBy(css = "div.no-data")
	public WebElement NoDataLbl;
	
	@FindBy(css = "a.clear-list")
	WebElement clearListLink;
	
	@FindBy(tagName = "tr")
	public List<WebElement> allrows;
	
	@FindBy(tagName = "td")
	public List<WebElement> allcl;
	
	@FindBy (linkText = "Asus N551JK-XO076H Laptop")
	public WebElement Firstproducttagname;
	
	@FindBy (linkText = "Apple MacBook Pro 13-inch")
	public WebElement Secondproducttagname;
	
	public void clearCompareList() {
		
		clickbotton(clearListLink);
	}
	
	public void CompareProducts() {
		
		//Get All Rows
		
		System.out.println(allrows.size());
		//Get Date from Each Row
		
		for(WebElement row : allrows) {
			System.out.println(row.getText()+"\t");
			for(WebElement col:allcl) {
				
				System.out.println(col.getText()+"\t");
			}
		}
		
	}

}
