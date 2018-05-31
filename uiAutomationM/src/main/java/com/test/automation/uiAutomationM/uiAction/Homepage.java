package com.test.automation.uiAutomationM.uiAction;

import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
	
	public static final Logger log = Logger.getLogger(Homepage.class.getName()); 

	@FindBy(xpath="//a[contains(text(),'Sign in')]")
	WebElement signIn;
	
	@FindBy(name="email")
	WebElement loginEmailAddress;
	
	@FindBy(id="passwd")
	WebElement loginPassword;
	
	@FindBy(id="SubmitLogin")
	WebElement submitButton;
	
	@FindBy(xpath="//div[@id='center_column']/div[1]/ol/li")
	WebElement authenticationFailed;
	
	public Homepage(WebDriver driver) {
		
		PageFactory.initElements(driver,this);
	}
	
	public void loginToApplication(String emailAddress,String password)
	{
		signIn.click();
		log.info("clicked on sign in and object is: "+signIn.toString());
		loginEmailAddress.sendKeys(emailAddress);
		log.info("entered email address:"+emailAddress+" and object is "+loginEmailAddress.toString());
		loginPassword.sendKeys(password);
		log.info("entered password:"+password+" and object is "+loginPassword.toString());
		submitButton.click();
		log.info("clicked on submit button and object is: "+submitButton.toString());
	}
	public String getInvalidLoginText()
	{
		log.info("error message is:"+authenticationFailed.getText());
		return authenticationFailed.getText();
	}
}
