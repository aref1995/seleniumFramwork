package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends PageBase{

	public HomePage(WebDriver driver) {
		super(driver);
		Jse = (JavascriptExecutor) driver;
		action=new Actions(driver);

	}
	@FindBy(linkText ="Register")
	WebElement registerLink;
	
	@FindBy(linkText = "Log in")
	WebElement LoginLink;
	
	@FindBy(linkText = "Contact us")
	WebElement contactusLink;
	
	@FindBy(id = "customerCurrency")
	WebElement currencydrp;
	
	@FindBy(xpath = "/html/body/div[6]/div[2]/ul[1]/li[1]/a")
	WebElement compuotermenue;
	
	@FindBy(xpath = "/html/body/div[6]/div[2]/ul[1]/li[1]/ul/li[2]/a")
	WebElement NoteBookMenue;
	
	public void openregisterationPage() {
	
	clickbotton(registerLink);
	}
	
	public void Openloginpage() {
		
		clickbotton(LoginLink);
	}
	
	public void OpencontactusPage() {
		
		scrollbotton();
		clickbotton(contactusLink);
	}
	
	public void changecurrency() {
		
		select = new Select(currencydrp);
		select.selectByVisibleText("Euro");
	}
	
	public void SelectNoteBookMenue() {
		action.moveToElement(compuotermenue).moveToElement(NoteBookMenue).click().build().perform();
		
	}
}
