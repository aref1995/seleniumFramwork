package pages;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class UserRegisterationPage extends PageBase {

	public UserRegisterationPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "gender-male")
	WebElement genderRdoBtn;
	
	@FindBy(id = "FirstName")
	WebElement fnTxtBox;
	
	@FindBy(id = "LastName")
	WebElement snTxtBox;
	
	@FindBy(id = "Email")
	WebElement emailTxtBox;
	
	@FindBy(id = "Password")
	WebElement PasTxtBox;
	
	@FindBy(id="ConfirmPassword")
	WebElement conpasTxtBox;
	
	@FindBy(id = "register-button")
	WebElement RegsiterBtn;
	
	@FindBy(css = "div.result")
	public WebElement succsmessage ;
	
	@FindBy(xpath = "/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a")
	public WebElement LogoutLink;
	
	@FindBy(linkText = "My account")
	WebElement myaccountlink;
	
	public void userregisteration(String firstname , String lastname , String email , String password) {
		// hena ana gpt el click method ele m3rfha fe pageBase wa 7tet id 3la tool fa hna hy3ml click
		clickbotton(genderRdoBtn);
		settextfiledtext(fnTxtBox, firstname);
		settextfiledtext(snTxtBox, lastname);
		settextfiledtext(emailTxtBox, email);
		settextfiledtext(PasTxtBox, password);
		settextfiledtext(conpasTxtBox, password);
		clickbotton(RegsiterBtn);
	}
	
	public void userlogout() {
		//new
		clickbotton(LogoutLink);
		
	}
	
	public void openmyaccountpage() {
		clickbotton(myaccountlink);
	}
}
