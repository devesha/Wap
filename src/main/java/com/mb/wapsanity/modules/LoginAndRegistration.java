package com.mb.wapsanity.modules;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class LoginAndRegistration {
	//==========================
   private static String intertialScreenXPATH	= "//*[@id='infoContainer']/div[3]/div[2]/a";
   private static String sideMenuXPATH = "//div[@class='navigation']";
   private static String myMagicBoxXPATH = "//a[text()='My MagicBox']";
   
   //login page
   private static String userNameXpath="//*[@id='username']";
   private static String passwordXpath="//*[@id='password']";
   private static String loginButtonXPATH= ".//*[@id='loginForm']/div/div[2]/a";
   private static String logoutXpath="//*[text()='Logout']";
   private static String postProperty="//*[text()='Post Property']";
   private static String registrationBtn="//div[@class='registerLink']/a";
   
   //registration page
   private static String userTypeId="iamIndividual";
   private static String nameId="name";
   private static String emailId="email";
   private static String passwordId="password";
   private static String confirmPasswordId="password2";
   private static String isdCodeId="isdCode";
   private static String mobileNumId="mobile";
   private static String cityId="ct";
   private static String regSubmit="//div[@class='formBtnRow xtraPadding']/a";
   private static String globalError="//*[@id='globalError']";
 //  private static String freePost="//div[@class='freePackagesBox']/h2";
   
   
      RemoteWebDriver driver;
      WebDriverWait wait;
      public static String errorText;
      WebElement element;
      public static boolean isElementPresent;
	//==========================		
			public LoginAndRegistration(RemoteWebDriver driver) {
				super();
				this.driver = driver;
			}
			
		public boolean intertialScreenClick()
		{
		boolean status = false;
		try{
		
		wait = new WebDriverWait(driver, 30);
	    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(intertialScreenXPATH)));
	    driver.findElement(By.xpath(intertialScreenXPATH)).click();
	    Reporter.log("Interstitial Pass /n");
	    status=true;
	    
		}catch(Exception e){
			Reporter.log("Some problem came in selecting Interstitial /n");
			e.printStackTrace();
		}
		return status;
		}
		
		public boolean loginTest()
		{
			boolean status = false;
			try{
		//	 wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(sideMenuXPATH)));
			 driver.findElement(By.xpath(sideMenuXPATH)).click();
			 Reporter.log(">> Side menu /n");
			 driver.findElement(By.xpath(myMagicBoxXPATH)).click();
			 Reporter.log(">> my magic box /n");
			 driver.findElement(By.xpath(userNameXpath)).sendKeys("mobile1@kumar.com");
			 Reporter.log(">> user name /n");
			 driver.findElement(By.xpath(passwordXpath)).sendKeys("password");
			 Reporter.log(">> password /n");
		     driver.findElement(By.xpath(loginButtonXPATH)).click();
		     Reporter.log(">> Login button /n");
		     status = true;
			}catch(Exception e)
			{
				Reporter.log("Some problem came in Login");
				e.printStackTrace();
			}
			return status;
		}
		
		
		public boolean logoutTest()
		{
			boolean status = false;
			try{
				
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(sideMenuXPATH)));
				driver.findElement(By.xpath(sideMenuXPATH)).click();
				//isElementPresent = driver.findElementByXPath(logoutXpath).isDisplayed();
				if(driver.findElementByXPath(logoutXpath).isDisplayed())
				{
					driver.findElement(By.xpath(logoutXpath)).click();
					status = true;
				}
				else
				{
					status = false;
					errorText="User not loggedin / Logout button not visible";
					driver.navigate().refresh();
				}
				
				
			}catch(Exception e)
			{
				e.printStackTrace();
				driver.navigate().refresh();
			}
			return status;
		}
		
		public boolean openRegistrationPage()
		{
			boolean status = false;
			
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(sideMenuXPATH)));
			driver.findElement(By.xpath(sideMenuXPATH)).click();
			driver.findElement(By.xpath(postProperty)).click();
			driver.findElement(By.xpath(registrationBtn)).click();
			
			status=true;
			
			return status;
			
		}
		
		public boolean insertRegistrationData()
		{
			boolean status = false;
			try{	
			driver.findElement(By.id(userTypeId)).click();
			driver.findElementById(nameId).sendKeys("Mobile Kumar");
			driver.findElementById(emailId).sendKeys("mobiles@kumar.com");
			driver.findElementById(passwordId).sendKeys("password");
		//	driver.findElementById(confirmPasswordId).sendKeys("password");
			
			Select dropdownIsd = new Select(driver.findElementById(isdCodeId));
			dropdownIsd.selectByValue("51");
			driver.findElementById(mobileNumId).sendKeys("5655545322");
			
			Select dropdownCity = new Select(driver.findElementById(cityId));
			dropdownCity.selectByValue("6403");
			status=true;	
		}
			catch(Exception e)
			{
				e.printStackTrace();
				return status;
			}
			return status;			
		}
		
		public boolean registrationClick()
		{
			boolean status = false;
			try
			{
			driver.findElement(By.xpath(regSubmit)).click();
		
		
		    isElementPresent = driver.findElementByXPath(globalError).isDisplayed();
			if(isElementPresent == true)
			{
		    	errorText=driver.findElement(By.xpath(globalError)).getText();
				status=false;
			}
		    else
			    {
		    	status = true;
		    	}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return status;
		}

}
