package com.test.automation.uiAutomationM.homepage;

import java.util.logging.Logger;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.test.automation.uiAutomationM.testBase.Testbase;
import com.test.automation.uiAutomationM.uiAction.Homepage;

public class TC001_VerifyLoginWithInvalidCredentials extends Testbase{

	public static final Logger log = Logger.getLogger(TC001_VerifyLoginWithInvalidCredentials.class.getName());
	Homepage homepage;
	
	@BeforeTest
	public void setUp()
	{
		init();
	}
	@Test
	public void verifyLoginWithInvalidCredentials()
	{
		log.info("===========Starting VerifyLoginWithInvalidCredentials Test=============");
		homepage = new Homepage(driver);
		homepage.loginToApplication("test@gmail.com", "password");
		Assert.assertEquals(homepage.getInvalidLoginText(),"Authentication failed.");
		log.info("===========Finished VerifyLoginWithInvalidCredentials Test=============");
		
	}
	@AfterClass
	public void endTest()
	{
		driver.close();
	}
}

