package com.trackx.truelocate.flow;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.trackx.truelocate.common.utils.GeneralActions;
import com.trackx.truelocate.common.utils.ReusableActions;
import com.trackx.truelocate.pagecomponents.Truelocatelogin;


public class LoginFLow extends GeneralActions {
	static WebDriver driver;
	Truelocatelogin truelocatelogin;
	
	//Logger log4jlogger =Logger.getLogger("devpinoyLogger");
	

	
	 @BeforeClass
	  public void setUp() throws IOException  {
		
		  driver = launchBrowser(driver,"firefox");
		  truelocatelogin = PageFactory.initElements(driver, Truelocatelogin.class);
		 
		  ReusableActions.loadPropFileValues(); 
		  ReusableActions.openUrl(driver,ReusableActions.getPropFileValues("Url"));
	      }
	 
	/**
	 * Login Checkout Flow Test Script
     */

	
	@Test(priority=1,dataProviderClass=Truelocatelogin.class, dataProvider="getData")
	public void LoginFlow(String sUsername,String sPassword) throws Exception {
		
		
		
		try{
			
			 truelocatelogin.enterUsernamepassword(sUsername, sPassword);
		     Thread.sleep(1000);
		      Reporter.log("##########-------Login application-------##########");
		      Reporter.log("##########-------Login Successfully,----------############");
		      TestNGResults.put("2", new Object[] {  "Login screen", "Login successful", "Pass" });
		      Assert.assertTrue(true);
			 }
	
			 catch(Exception e){
				 
			TestNGResults.put("2", new Object[] { "Login screen screen", "Login not successful", "Fail" });
			Assert.assertTrue(false);
			 }
			//e.printStackTrace();
			
	
	}
	
	
	@AfterClass
			public void quitDriver(){
	 try{
		
		 Thread.sleep(5000);
		 driver.quit();
		 }
		  catch (Exception e) {
		 e.printStackTrace();
		 }
	

	
}

	
}
