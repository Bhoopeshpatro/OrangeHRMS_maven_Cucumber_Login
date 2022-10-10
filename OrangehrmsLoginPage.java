package com.Page;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class OrangehrmsLoginPage 
{

	public WebDriver driver;
	
	public OrangehrmsLoginPage(WebDriver driver) 
	{
		this.driver=driver;
	}
	
	private By usernametxt = By.xpath("//*[@id='txtUsername']");
	private By passwordtxt = By.xpath("//input[@id='txtPassword']");
	private By loginbtn = By.xpath("//*[text()='LOGIN Panel']//parent::form//div[5]//input");
	private By welcomlink = By.xpath("//*[@id='branding']//a[2]");
	private By error = By.xpath("//*[@id='divLoginButton']//span");
	
	public void verifyLogin() 
	{
		String acturalURL = "http://orangehrm.qedgetech.com/symfony/web/index.php/auth/login";
		String expectedURL = driver.getCurrentUrl();
		Assert.assertEquals(acturalURL, expectedURL);
		
		driver.findElement(usernametxt).isDisplayed();
		driver.findElement(passwordtxt).isDisplayed();
		driver.findElement(loginbtn).isDisplayed();
				
	}
	
	public void passlogincredentials(String username, String password, String errormsg) throws InterruptedException 

	{
		driver.findElement(usernametxt).sendKeys(username);
		driver.findElement(passwordtxt).sendKeys(password);
		driver.findElement(loginbtn).click();
		
		if(errormsg.isEmpty()) 
		{
			WebElement wl = driver.findElement(welcomlink);
			wl.isDisplayed();
			wl.click();
			Thread.sleep(2000);
		}else 
		{
			String rmsg = driver.findElement(error).getText();
			System.out.println("the ERROR MESSAGE "+ rmsg);
			Assert.assertEquals(errormsg, rmsg);
		}
	}
	
	
	
}



