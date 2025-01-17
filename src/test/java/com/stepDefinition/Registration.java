package com.stepDefinition;

import com.basepage.BasePage;
import com.pageobject.RegistrationPage;

import org.junit.Assert;
 import org.openqa.selenium.WebDriver;
  
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Registration extends BasePage{

	WebDriver driver; 
	  RegistrationPage registerpage; 
 
	@Given("User open browser to register page")
	public void user_open_browser_to_register_page() {
		driver = BasePage.setDriver();
		registerpage =new RegistrationPage(driver);
		registerpage.goPageRegiter();

  	}

	@When("User enter valid credential {string} {string} {string} {string} {string} {string}")
	public void user_enter_valid_credential(String fname, String lname, String emailaddresse,String telep, String pwd, String confpass) {
		registerpage.registerUser(fname, lname, emailaddresse, telep, pwd, confpass);
	
	}

	@And("User click button policy")
	public void user_click_button_policy() {
		
		registerpage.clickBtnPolicy();
	}

	@And("User click button register")
	public void user_click_button_register() {
 
		registerpage.clickBtnRegister();
	}

	@Then("User create account")
	public void user_create_account() {
		
 		Assert.assertEquals(registerpage.successRegister(), "Your Account Has Been Created!");
        closeDriver();

	}
	
	@Then("User have msg error displayed {string}")
	public void user_have_msg_error_displayed(String error) {
 
		Assert.assertEquals(registerpage.errorRegister(), error);
		closeDriver();
			
	}

}
