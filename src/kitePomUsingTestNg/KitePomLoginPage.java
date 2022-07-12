package kitePomUsingTestNg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KitePomLoginPage 

{
 //1.Data members
@FindBy(id="userid")private WebElement UserName; 
@FindBy(id= "password")private WebElement Password;
@FindBy(xpath="//button[@type='submit']")private WebElement ClickButton;


//2.constructor
 
   public KitePomLoginPage (WebDriver driver)
   
    {
	   PageFactory.initElements(driver,this);
	}
   
   
   //3.methods 
   
  public void SendUserName (String userName) 
  {
	  UserName.sendKeys(userName);
  }
  
  public void Password(String password) 
  {
	  Password.sendKeys(password);
  }

  public void ClickOnLoginButton() 
  {
	  
	  ClickButton.click();
  }
	
	
}
