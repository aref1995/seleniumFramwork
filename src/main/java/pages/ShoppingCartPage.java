package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends PageBase{

	public ShoppingCartPage(WebDriver driver) {
		super(driver);
		}
	@FindBy(name = "updatecart")
	WebElement RemoveItemfromcartBTN;
	
	@FindBy(className = "qty-input")
	WebElement Quantity;
	
	@FindBy(css = "td.subtotal")
	public WebElement Price;
	
	@FindBy(css = "a.product-name")
	public WebElement productName;
	
	@FindBy (id = "updatecart")
	WebElement UpdateCart;
	
	@FindBy(css = "div.no-data")
	public WebElement NodataTxt;
	
	@FindBy(id = "checkout")
	WebElement CheckOutBTN;
	
	@FindBy(id = "termsofservice")
	WebElement checkTerms;
	
	public void RemoveProductFromCart() {
		
		clickbotton(RemoveItemfromcartBTN);
	}
	
	public void UpdateProductQuntityincart(String Quntitiy) {
		ClearText(Quantity);
		settextfiledtext(Quantity, Quntitiy);
		clickbotton(UpdateCart);
	}
	
	public void CheckoutProduct() {
		
		clickbotton(checkTerms);
		clickbotton(CheckOutBTN);
	}
}


