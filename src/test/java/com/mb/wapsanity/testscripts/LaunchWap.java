package com.mb.wapsanity.testscripts;

import java.net.URL;

//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeSuite;

public class LaunchWap {

	public static RemoteWebDriver driver;
	
	   @BeforeSuite
	   public void setUp() throws Exception {
	        DesiredCapabilities  capabilities = new DesiredCapabilities();
		    capabilities.setCapability("platformName", "Android");
		    capabilities.setCapability("deviceName","Nexus 4");
		    capabilities.setCapability("platformVersion", "4.4");
		    capabilities.setCapability("app", "chrome");
		    driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
		}  
	
	
}
