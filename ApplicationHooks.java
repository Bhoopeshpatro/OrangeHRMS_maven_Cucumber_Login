package AppHooks;


import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.Driver.*;
import com.utils.*;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHooks 
{
	//variable of webdriverinirializer class
	private webdriverInitializer driverFactory;
	public WebDriver driver;
	private configreader configReader;
	Properties prop;

	@Before(order = 0)
	public void getProperty() 
	{
		configReader = new configreader();
		prop = configReader.init_prop();
	}

	@Before(order = 1)
	public void launchBrowser()
	{
		String browserName = prop.getProperty("browser");
		driverFactory = new webdriverInitializer();
		driver = driverFactory.init_driver(browserName);
		driver.get("http://orangehrm.qedgetech.com/symfony/web/index.php/auth/login");
		System.out.println("Browser Opened");


	}

	@After(order = 0)
	public void quitBrowser() 
	{

		driver.quit();
	}

	@After(order = 1)
	public void tearDown(Scenario scenario) 
	{
		if (scenario.isFailed())
		{
			// take screenshot:
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcePath, "image/png", screenshotName);

		}
	}

}
