package stepDefination;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import com.Driver.*;
import com.Page.*;

public class OrangeHRMSfunction  
{


	private OrangehrmsLoginPage lgorange = new OrangehrmsLoginPage(webdriverInitializer.getDriver());
	
	@Given("open browser with URL")
	public void open_browser_with_url()
	{
	    
	}

	@And("Login page should be Visible")
	public void login_page_should_be_visible() 
	{
	    lgorange.verifyLogin();
	}

	@When("I pass Username as {string} Password as {string} and verify with Error message as {string}")
	public void i_pass_username_as_password_as_and_verify_with_error_message_as(String username, String password, String errormsg) throws InterruptedException 
	{
	    lgorange.passlogincredentials(username, password, errormsg);
	}

	@Then("CLick LOgin button")
	public void c_lick_l_ogin_button() 
	{
	   
	}
		
}

	

	
