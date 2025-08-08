package org.stepdefinitions;


import org.applicationhooks.AppHooks;
import org.factory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.pages.ArbitratorLogin;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ArbitratorLoginStepDef {
	private WebDriver driver;
	ArbitratorLogin Arb_obj= new ArbitratorLogin(DriverFactory.getDriver());
	// LoginPage lp_obj= new LoginPage(DriverFactory.getDriver());
	/****************
	 * @ArbLogin
	 */

	@Given("Arb user is on login page")
	public void arbuser_is_on_login_page() {
		DriverFactory.getDriver().get(AppHooks.prop.getProperty("UrlArb"));  
	}
	@Then("ArbUser name and ArbPassword field is displayed")
	public void arb_user_name_and_arb_password_field_is_displayed() throws InterruptedException {
		Arb_obj.userPassDisplay();
	}
	@When("user see the user name field then enter ArbUser name")
	public void user_see_the_user_name_field_then_enter_arbu_user_name() {
		Arb_obj.enterUName(AppHooks.prop.getProperty("UserArbN"));
	}
	@Then("user see the user password field then enter Arb password")
	public void user_see_the_user_password_field_then_enter_arb_password() throws InterruptedException {
		Arb_obj.enterPass(AppHooks.prop.getProperty("PassArb"));

	}


	@When("user see the pop up then he click on ok button")
	public void user_see_the_pop_up_then_he_click_on_ok_button() {
       Arb_obj.finalSubmitButton();
	}

	@Then("user verify the table title on the page as {string}")
	public void user_verify_the_table_title_on_the_page_as(String string) {
		Arb_obj.verifyTitle(string);
	}
	@Then("user click on Arb logout")
	public void user_click_on_arb_logout() {
		Arb_obj.arbLogout();
	}


	/****************
	 * @throws InterruptedException 
	 * @ArbLogin2
	 */
	@When("the user enters {string} and {string}")
	public void the_user_enters_and(String string, String string2) throws InterruptedException {
		Arb_obj.enterUName(string);
		Arb_obj.enterPass(string2);
	}
	@When("clicks the login button")
	public void clicks_the_login_button() throws InterruptedException {
		Arb_obj.login();
	}
	@Then("the user should be {string}")
	public void the_user_should_be(String string) throws InterruptedException {
		Arb_obj.verifyTitle(string);
		driver.close();
		//Thread.sleep(2000);
		//Arb_obj.arbLogout();
	}






}
