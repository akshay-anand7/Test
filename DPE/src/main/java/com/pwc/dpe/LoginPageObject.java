package com.pwc.dpe;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

public class LoginPageObject {
	public static Reader read;
	public WebDriver driver;
	static long implicitTimeout;
	public static LoginPageObject objects;
	public static WebsitePagesObject wpo;
	static String newAutomationUser = "";
	static String newAutomationAccount;
	static String browserUsed = "";	
		
	public By byUsername_textbox;
	public By byPassword_textbox;
	public By bySignIn_button;
	public By byLoginPageTitle;
	public By byNameDropDown;
	public By byLogoutMenuWindow;
	public By bySignout_mousehover;
	public By bySignout;
	
	
	
	 //Constructor
	   public LoginPageObject(){
		   
		    implicitTimeout = 10;		
			driver = DPETests.driver;
			read = DPETests.read;
			browserUsed = read.getBrowser();
			objects = DPETests.objects;
			wpo = DPETests.wpo;
		    read = DPETests.read;
		   
		   byUsername_textbox = By.id("username");
		   byPassword_textbox = By.id("password");
		   bySignIn_button = By.id("submit-button");
		   byLoginPageTitle = By.xpath("//h1[contains(text(),'Welcome to Adobe Experience Manager')]");
		   byNameDropDown = By.xpath("//table[@class='x-btn x-btn-text-icon']");
		   byLogoutMenuWindow = By.xpath("//div[@class='x-menu x-menu-floating x-layer']");
		   bySignout_mousehover = By.xpath("//li[@class='x-menu-list-item']");
		   bySignout = By.xpath("//li[@class='x-menu-list-item x-menu-item-active']");
		        
	       
	   }
	   

	   public void authorLogin() throws InterruptedException
		{
			Reporter.log("Logging in as Admin User: " + read.getAuthorUsername()
							+ " on " + read.getBrowser() + " on "
							+ read.getPlatform() + "<br>");

			driver.get(read.getURL());
			helperFunctions.waitForLoginPage();  
			driver.findElement(byUsername_textbox).sendKeys(read.getAuthorUsername());
			//driver.findElement(byUsername_textbox).sendKeys("kumaravel.gangadaran@net-effect.com");
			driver.findElement(byPassword_textbox).sendKeys(read.getAuthorPass());
			driver.findElement(bySignIn_button).click();		
            Thread.sleep(10000);
		}
}
  