package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends PageBase{

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(linkText = "Change password")
	WebElement changepasswordlink;
	
	public void openchangepasswordpage() {
		
		clickbotton(changepasswordlink);
	}
	
	@FindBy(id = "OldPassword")
	 WebElement oldpasswordtxt;
	

	@FindBy(id = "NewPassword")
	 WebElement newpasswordtxt;
	

	@FindBy(id = "ConfirmNewPassword")
	 WebElement confirmpasswordtxt;
	
	@FindBy(xpath = "/html/body/div[6]/div[3]/div/div[2]/div/div[2]/form/div[2]/button")
	 WebElement changepasswordbtn;
	
	@FindBy(xpath = "//*[@id=\"bar-notification\"]/div/p")
	public WebElement resultLBL;
	//new
	@FindBy(xpath = "//*[@id=\"bar-notification\"]/div/span")
	public WebElement closeconfirmmessage;
	//new
	public void closemessage() {
		
		clickbotton(closeconfirmmessage);
	}
	
	public void changepassword(String oldpassword , String newpassword) {
		
		settextfiledtext(oldpasswordtxt, oldpassword);
		settextfiledtext(newpasswordtxt, newpassword);
		settextfiledtext(confirmpasswordtxt, newpassword);
		clickbotton(changepasswordbtn);
	}
	
}
