package kitePomUsingTestNg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KiteHomePage 
{
//data members
	
@FindBy(xpath="//span[@class='user-id']")private WebElement UserName;
@FindBy(xpath="//a[@target='_self']")private WebElement LogoutButton;

//constructor 

   public KiteHomePage (WebDriver driver) 
 {
	   PageFactory.initElements(driver, this);
	}
   
   //members
   
   public void validateUserName(String ExpectedUserId) 
   {
	  String expectedUserName=ExpectedUserId;
	  String actualUserName = UserName.getText();
	  
	  if (expectedUserName.equals(actualUserName)) 
	  {
		  System.out.println("Actual and expected userid is matching Tc is passed");
	  }
	  
	  else 
	  {
		  System.out.println("actual user id is not matching with expected user id tc is failde");
	  }
   }
   
   public String actualUserName()
   {
	   String actualUserName=UserName.getText();
       return actualUserName;
   }
   public void logout() throws InterruptedException
   {
	   UserName.click();
	   Thread.sleep(2000);
	   LogoutButton.click();
   }
   
}
