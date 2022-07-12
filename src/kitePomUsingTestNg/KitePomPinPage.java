package kitePomUsingTestNg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KitePomPinPage 

{
// 1. Data members
	
	@FindBy(id="pin") private WebElement PIN;
	@FindBy(xpath="//button[@type='submit']")private WebElement clickoncontinuebutton;
	
	
	
	//2.constructor 
	
	public KitePomPinPage (WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	//3.members 
	
	public void sendPin(String pin ) 
	
	{
		PIN.sendKeys(pin);
	}
	
	public void continuebutton() 
	{
		clickoncontinuebutton.click();
	}
}
