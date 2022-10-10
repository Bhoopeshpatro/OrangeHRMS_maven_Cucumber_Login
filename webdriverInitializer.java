package com.Driver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class webdriverInitializer 
{
	public WebDriver driver= null;
	public static ThreadLocal<WebDriver> tldriver = new ThreadLocal<WebDriver>();
	/* This method is used to initialize the threadLocal driver on the basis of browser given*/
	
	@SuppressWarnings({ "deprecation" })
	public WebDriver init_driver(String browser)
	{
		System.out.println("Browser value is : "+browser);
		
		if(browser.equals("chrome")) 
		{
			//ChromeOptions option = new ChromeOptions();
			//option.addArguments("windows-size=1400,800");
			//option.addArguments("headless");
			//WebDriver driver = new ChromeDriver(option);
			
			WebDriverManager.chromedriver().setup();
			tldriver.set(new ChromeDriver());
			
		}
		
		else if(browser.equals("Firefox")) 
		{
			WebDriverManager.firefoxdriver().setup();
			tldriver.set(new FirefoxDriver());
			
		}
		
		else if(browser.equals("safari")) 
		{
			tldriver.set(new SafariDriver());
			
			
		}
		
		else
		{
			System.out.println("Error! Please enter valid Browser value");
		}
		
	getDriver().manage().deleteAllCookies();
	getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	getDriver().manage().window().maximize();
			
		return getDriver();
		
	}
	
	/*this method is used to get the driver with ThreadLocal */
	
	public static synchronized WebDriver getDriver()
	{
		return tldriver.get();
	}
	
}
