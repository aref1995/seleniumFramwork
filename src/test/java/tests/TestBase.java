package tests;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import utilities.Helper;

public class TestBase extends AbstractTestNGCucumberTests{
	public static String downloadpath = System.getProperty("user.dir")+"\\Downloads";
	public static WebDriver driver;
	
	@SuppressWarnings("deprecation")
	public static ChromeOptions chromeoptions() {
		ChromeOptions options = new ChromeOptions();
		HashMap<String, Object> chromeprs=new HashMap<String, Object>();
		chromeprs.put("profile.default.content_setting.popups", 0);
		chromeprs.put("download.default_diractory", downloadpath);
		options.setExperimentalOption("prefs", chromeprs);
		options.setCapability(CapabilityType.ACCEPT_SSL_CERTS,true);
		return options;
		
		
	}
		
	
	@BeforeSuite
	
	// this defined in Testng file 
	
	
	public void startDriver() {
		
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
			driver=new ChromeDriver(chromeoptions());
		
	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(120,TimeUnit.SECONDS);
		driver.navigate().to("https://demo.nopcommerce.com/");
	}

	//take screenshot when test case fail and add it in the screenshot folder 
	@AfterMethod
	 public void screenshotOnFailuer(ITestResult result) {
		if (result.getStatus()==ITestResult.FAILURE) {
			System.out.println("Failed!");
			System.out.println("Taking screenshot......");
			Helper.capturescreenshot(driver, result.getName());
		}
		
	}	
	
}
