package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CheckOutProductPage extends PageBase{

	public CheckOutProductPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "BillingNewAddress_CountryId")
	WebElement countrylist ;
	
	@FindBy (id = "BillingNewAddress_StateProvinceId")
	WebElement StateList ;
	
	@FindBy(id = "BillingNewAddress_City")
	WebElement CityTxt;
	
	@FindBy(id = "BillingNewAddress_Address1")
	WebElement AddressTxt;
	
	@FindBy(id = "BillingNewAddress_ZipPostalCode")
	WebElement ZipCodeTxt;
	
	@FindBy(id = "BillingNewAddress_PhoneNumber")
	WebElement PhoneTxt;
	
	@FindBy(css = "button.button-1.new-address-next-step-button" )
	WebElement ContinueBtn;
	
	@FindBy (css = "button.button-1.shipping-method-next-step-button")
	WebElement cont2Btn;
	
	@FindBy (css = "button.button-1.payment-method-next-step-button")
	WebElement cont3Btn;
	
	@FindBy(css = "button.button-1.payment-info-next-step-button")
	WebElement con4Btn;
	
	@FindBy(id = "shippingoption_0")
	WebElement ShippingRdBtn;
	
	@FindBy(id = "paymentmethod_0")
	WebElement PaymethodRDBtn;
	
	@FindBy (className = "product-name")
	public WebElement ProductNameConfirm;
	
	@FindBy(css = "div.title")
	public WebElement ConfirmOrderMessage;
	
	@FindBy (css = "button.button-1.confirm-order-next-step-button")
	WebElement ConfirmBtn;
	
	@FindBy (css = "div.details-link")
	WebElement DetailsOrderLink;
	
	public void CheckOutProduct(String City , String Zip , String phone , String Address)  {
		select = new Select(countrylist);
		select.selectByVisibleText("Albania");
		select = new Select(StateList);
		select.selectByVisibleText("Other");
		settextfiledtext(CityTxt, City);
		settextfiledtext(AddressTxt, Address);
		settextfiledtext(ZipCodeTxt, Zip);
	settextfiledtext(PhoneTxt, phone);
		clickbotton(ContinueBtn);
		clickbotton(cont2Btn);
		clickbotton(cont3Btn);
		clickbotton(con4Btn);
		clickbotton(ConfirmBtn);
		
		//clickbotton(ContinueBtn);
		//clickbotton(ShippingRdBtn);
		//clickbotton(PaymethodRDBtn);
	//	clickbotton(ContinueBtn);
		//clickbotton(ConfirmBtn);
		
	}
		
	public void OrderDetails() {
		
		clickbotton(DetailsOrderLink);
	}



}
