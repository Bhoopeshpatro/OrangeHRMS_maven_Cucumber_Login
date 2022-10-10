package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/features/"}, 
glue = {"stepDefination", "AppHooks"}, 
plugin = {"pretty", 
		"html:target/cucumber", 
		 "json:target/cucumber.json",
		 "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		
		monochrome = true, publish = true, dryRun = true)
public class TestRunner 
{

	
	/* plugin = {"pretty", "html:target/cucumber", 
			 "json:target/cucumber.json", 
			 "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}*/
}

