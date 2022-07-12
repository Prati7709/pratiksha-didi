package kitePomUsingTestNg;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ValidateKiteAppUsername {
	
	WebDriver driver;
	org.apache.poi.ss.usermodel.Sheet mySheet ;
    KitePomLoginPage login;
    KitePomPinPage pin;
    KiteHomePage home;
    
	
	@BeforeClass
	public void LaunchBrowser() throws EncryptedDocumentException, IOException 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hp\\Downloads\\selenium-java-4.1.4\\chromedriver.exe");
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("incognito");
		driver = new ChromeDriver (opt);
		driver.manage().window().maximize();
		driver.get("https://kite.zerodha.com/");
		Reporter.log("Launching Browser",true);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
		
		File myfile=new File("C:\\Users\\Hp\\OneDrive\\Documents\\my excel sheet\\kitelogin.xlsx");
		mySheet = WorkbookFactory.create(myfile).getSheet("Sheet1");
		
		login=new KitePomLoginPage(driver);
		pin  =new KitePomPinPage(driver);
		home =new KiteHomePage(driver);
		
	}
	
	@BeforeMethod
	 public void LoginToKiteApp() 
	{
		String UN = mySheet.getRow(0).getCell(0).getStringCellValue();
		String PWD = mySheet.getRow(0).getCell(1).getStringCellValue();
		String PIN = mySheet.getRow(1).getCell(0).getStringCellValue();
		
		login.SendUserName(UN);
		Reporter.log("sending username",true);
		login.Password(PWD);
		Reporter.log("sending password",true);
		login.ClickOnLoginButton();
		
		pin.sendPin(PIN);
		Reporter.log("Sending pin",true);
		pin.continuebutton();
		Reporter.log("click on continuebutton",true);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
	}
  @Test
  public void ValidateUserName() 
  {
	  String expectedUN =mySheet.getRow(1).getCell(1).getStringCellValue();
	  String actualUn = home.actualUserName();
	  
	  Assert.assertEquals(actualUn,expectedUN ,"actual and Expected UN are not matching TC Failed");
	  
	  Reporter.log("Actual and Expected UN TC PASSED ",true);
  }


    @AfterMethod
     public void logoutfromKiteApp() throws InterruptedException
    {
	home.logout();
	Reporter.log("logging out",true);
     }
  @AfterClass
	public void closeBrowser() throws InterruptedException 
	{
		Thread.sleep(1000);
		Reporter.log("closing browser",true);
		driver.close();
  
 }
}
