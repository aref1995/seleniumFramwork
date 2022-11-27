package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends PageBase{

	public ContactUsPage(WebDriver driver) {
		super(driver);
	
	}
	@FindBy(id = "FullName")
	WebElement FullNameTXT;
	
	@FindBy(id = "Email")
	WebElement EmailTXT;
	
	@FindBy(id = "Enquiry")
	WebElement Enquirytxt;
	
	@FindBy(name = "send-email")
	WebElement submitBtn;
	
	@FindBy(css = "div.result")
	public WebElement successMessage;
	
	public void ContactUs(String FullName , String Email , String Enquiry) {
		
		settextfiledtext(FullNameTXT, FullName);
		settextfiledtext(EmailTXT, Email);
		settextfiledtext(Enquirytxt, Enquiry);
		clickbotton(submitBtn);
	}

}
