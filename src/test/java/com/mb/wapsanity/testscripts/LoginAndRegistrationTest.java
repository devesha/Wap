package com.mb.wapsanity.testscripts;


//import org.openqa.selenium.By;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.mb.wapsanity.modules.LoginAndRegistration;

public class LoginAndRegistrationTest extends LaunchWap 
{

	//    ====================
	//variable declare
	
	boolean intertial;
    boolean login;
	public LoginAndRegistration loginObj;
	boolean logout;
	boolean registration;
	public static String isFunction;

	
	
	
	
	//	====================
	
    @BeforeTest     //Launch browser
    public void before() throws InterruptedException
    {
    	driver.get("http://m.magicbricks.com");
    	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		loginObj  =  new LoginAndRegistration(driver);
    }
    
    
	@Test(priority=1) //Intertial screen testcase
    public void intertialScreen()
	{
	try
	  { 
		isFunction="Interstitial";
        intertial = loginObj.intertialScreenClick();
        
       }catch(Exception e){
		  e.printStackTrace(); 
		  Assert.assertTrue(intertial, isFunction);
	     }
	Assert.assertTrue(intertial, isFunction);
     }
	
	@Test(priority=2)
	public void registration()
	{
		try{
			
		isFunction="openRegistrationpage";
		registration=loginObj.openRegistrationPage();
		
		isFunction="insertRegistrationData";
		registration=loginObj.insertRegistrationData();
		
		
		isFunction= "registrationCLick";	
		registration = loginObj.registrationClick();
		
		
		}catch(Exception e)
		{
			e.printStackTrace();
			Assert.assertTrue(registration,isFunction + "  \n Error :  "+ LoginAndRegistration.errorText);
		}
		Assert.assertTrue(registration,isFunction + "  \n Error :  "+ LoginAndRegistration.errorText);
	}
	
	@Test(priority=3) //Logout
	public void logout()
	{
		try
		{
			isFunction= "Logout";	
			logout = loginObj.logoutTest();
			
		}catch(Exception e)
		{
			e.printStackTrace();
			Assert.assertTrue(logout,isFunction);
		}
		Assert.assertTrue(logout,isFunction + " \n Error : " + LoginAndRegistration.errorText);
	}
	
	@Test(priority=4)  //login testcase
	public void loginCase()
	{
		 try
		  { 
			 
			isFunction="Login";
	        login = loginObj.loginTest();
	       }catch(Exception e){
			  e.printStackTrace();
			  Assert.assertTrue(login, isFunction);
		     }
		 Assert.assertTrue(login, isFunction);
	}
	
    @AfterTest
    public void tearDown() throws Exception {
      //  driver.quit();
    }
}
