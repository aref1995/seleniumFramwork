package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends PageBase{

	public ProductDetailsPage(WebDriver driver) {
		super(driver);
		
	
	}
	@FindBy(css = "strong.current-item")
	public WebElement productnamereadcrumb;
	
	@FindBy(xpath = "//*[@id=\"product-details-form\"]/div[2]/div[1]/div[2]/div[10]/div[3]/button")
	WebElement emilfriendBtn;
	
	@FindBy (css = "span.price-value-4")
	public WebElement proudctpricelbl;
	
	@FindBy(xpath = "//*[@id=\"product-details-form\"]/div[2]/div[1]/div[2]/div[3]/div[2]/a[2]")
	WebElement AddReviewLink;
	
	@FindBy(id = "add-to-wishlist-button-4")
	 WebElement wishlistLink;
	
	@FindBy(css = "button.button-2.add-to-compare-list-button")
	WebElement AddToCompareBTN;
	
	@FindBy(id = "add-to-cart-button-4")
	WebElement AddToCartBtn;
	
	public void OpenAddReviewPage() {
		
		clickbotton(AddReviewLink);
	}
	
	public void sendemailBtn() {
		
		clickbotton(emilfriendBtn);
	}
	
	public void AddProudctToWishList() {
		
		clickbotton(wishlistLink);
	}
	
	public void AddProudctToCompare() {
		
		clickbotton(AddToCompareBTN);
	}
	
	public void AddProductToCart() {
		
		clickbotton(AddToCartBtn);
	}
}

	
