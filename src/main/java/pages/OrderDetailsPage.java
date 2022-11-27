package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderDetailsPage extends PageBase{

	public OrderDetailsPage(WebDriver driver) {
		super(driver);
	}

	@FindBy (css = "a.button-2.print-order-button")
	WebElement PrintinvoiceLink;
	
	@FindBy(css = "a.button-2.pdf-invoice-button")
	WebElement PrintPDFInvoiceLink;
	
	public void printOrderDetails() {
		
		clickbotton(PrintinvoiceLink);
	}
	
	public void DownloadPDFInvoice() throws InterruptedException {
		
		clickbotton(PrintPDFInvoiceLink);
		Thread.sleep(1000);
	}
	
	
}
