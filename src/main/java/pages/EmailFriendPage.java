package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailFriendPage extends PageBase{

	public EmailFriendPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "FriendEmail")
	WebElement friedmailTXT;
	
	@FindBy (id = "YourEmailAddress")
	WebElement youremailTXT;
	
	@FindBy (id = "PersonalMessage")
	WebElement personalmessageTXT;
	
	@FindBy(name = "send-email")
	WebElement sendmailBtn;
	
	@FindBy (css = "div.result")
	public WebElement sucessmailmessage ;
	
	public void Emailfriends(String friendmail , String personalmessage  ) {
		
		settextfiledtext(friedmailTXT, friendmail);
		settextfiledtext(personalmessageTXT, personalmessage);
		clickbotton(sendmailBtn);
	}
}
