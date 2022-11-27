package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PageBase {
	
	protected WebDriver driver;
	public JavascriptExecutor Jse;
	public Select select;
	public Actions action;

	//Create constructor 
	
	public PageBase (WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	// here define clicl methode 3shan a3mlo recall fe ay botton field
	protected static void clickbotton(WebElement click) {
		
		click.click();
	}
	protected static void settextfiledtext(WebElement textelement , String value) {
		
		textelement.sendKeys(value);
	}
	
	public void scrollbotton() {
		
		Jse.executeScript("scrollBy(0,2500)");
	}
	
	public void ClearText(WebElement element) {
		
		element.clear();
	}
}
