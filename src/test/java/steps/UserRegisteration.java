package steps;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.UserRegisterationPage;
import tests.TestBase;


public class UserRegisteration extends TestBase{
	
	HomePage pageobject;
	UserRegisterationPage registerobject;
	@Given("the user in homepage")
	public void the_user_in_homepage() {
	    pageobject = new HomePage(driver);
	    pageobject.openregisterationPage();
	}
	@When("i click on register link")
	public void i_click_on_register_link() {
	    Assert.assertTrue(driver.getCurrentUrl().contains("register"));
	}
	/*
	 * @When("i entered the user data") public void i_entered_the_user_data() {
	 * registerobject = new UserRegisterationPage(driver);
	 * registerobject.userregisteration("Ahmed", "Aref", "Aref@test.com",
	 * "12345678"); }
	 */
	@When("i {string} , {string} , {string} , {string}")
	public void i(String firstname, String lastname, String email, String password) {
		registerobject = new UserRegisterationPage(driver);
		registerobject.userregisteration(firstname,lastname,email,password);
	}
	
	@Then("the registeration page displayed succssfully")
	public void the_registeration_page_displayed_succssfully() {
	  registerobject.userlogout();
	}
}
