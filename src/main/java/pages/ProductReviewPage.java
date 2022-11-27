package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductReviewPage extends PageBase{

	public ProductReviewPage(WebDriver driver) {
		super(driver);		
	}

	@FindBy (id = "AddProductReview_Title")
	WebElement ReviewtitleTXT;
	
	@FindBy (id = "AddProductReview_ReviewText")
	WebElement ReviewtextTXT;
	
	@FindBy(id = "addproductrating_4")
	WebElement Rating4RdaBtn;
	
	@FindBy(name = "add-review")
	WebElement submitBtn;
	
	@FindBy(css = "div.result")
	public WebElement sucessreviewmes;
	
	public void AddProudctReview(String reviewtitle , String reviewmessage) {
		
		settextfiledtext(ReviewtitleTXT, reviewtitle);
		settextfiledtext(ReviewtextTXT, reviewmessage);
		clickbotton(Rating4RdaBtn);
		clickbotton(submitBtn);
	}
	
	
	
}
