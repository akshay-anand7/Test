package com.pwc.dpe;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

//import LRS2_0.helperFunctions;

public class DPETests {
	
	protected ThreadLocal<RemoteWebDriver> threadDriver = null;

	public static WebDriver driver = null;
	public static Reader read;
	helperFunctions helpers = null;
	public static LoginPageObject objects = null;
	public static WebsitePagesObject wpo = null;
	String platform = null;
	String browserName = null;
	
	@BeforeSuite
	public void initSuite()
	{

		read = new Reader();
		read.logincredentials();
		read.timeouts();
		platform = read.getPlatform();
		browserName = read.getBrowser();
		System.out.println("Platform Used: " + platform);
		System.out.println("Browser Used: " + browserName + "\n");

		if (platform.equals("Windows"))
		{
			if (browserName.equals("Firefox"))
			{
				// driver = new FirefoxDriver();
				FirefoxProfile profile = new FirefoxProfile();
				profile.setPreference(	"intl.accept_languages",
										read.getLanguage());
				driver = new FirefoxDriver(profile);

				
			}
			else if (browserName.equals("Chrome"))
			{
				File file = new File("driversWindows/chromedriver.exe");
				System.setProperty(	"webdriver.chrome.driver",
									file.getAbsolutePath());

				DesiredCapabilities capabilities = DesiredCapabilities.chrome();
				DesiredCapabilities.chrome();
				ChromeOptions options = new ChromeOptions();
				options.addArguments("test-type");
				options.addArguments("start-maximized");
				options.addArguments("--js-flags=--expose-gc");
				options.addArguments("--enable-precise-memory-info");
				options.addArguments("--disable-popup-blocking");
				options.addArguments("--disable-default-apps");
				options.addArguments("--enable-automation");
		     	options.addArguments("test-type=browser");
				options.addArguments("disable-extensions");
				options.setExperimentalOption("useAutomationExtension", false);
				options.addArguments("--disable-notifications");
				options.addArguments("chrome.switches", "--disable-extensions");
				options.addArguments("--disable-save-password");
			 	options.addArguments("disable-infobars");
				capabilities.setCapability(ChromeOptions.CAPABILITY, options);
				driver = new ChromeDriver(capabilities);
			}
			else
			// IE
			{
				File file = new File("driversWindows/IEDriverServer_32.exe");
				System.setProperty(	"webdriver.ie.driver",
									file.getAbsolutePath());

				DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
				caps.setCapability(	InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
									true);
				driver = new InternetExplorerDriver(caps);

			}
		}
		else
		// Mac
		{
			final JavascriptExecutor javascriptMax = (JavascriptExecutor) (driver instanceof JavascriptExecutor ? driver
					: null);

			if (browserName.equals("Chrome"))
			{
				File file = new File("driversMac/chromedriver");
				System.setProperty(	"webdriver.chrome.driver",
									file.getAbsolutePath());

				DesiredCapabilities capabilities = DesiredCapabilities.chrome();
				capabilities.setCapability(	"chrome.switches",
											Arrays.asList("--start-maximized"));
				ChromeOptions options = new ChromeOptions();
				options.addArguments("test-type");
				capabilities.setCapability(ChromeOptions.CAPABILITY, options);
				driver = new ChromeDriver(capabilities);

				

			}
			else
			{
				
				driver = new SafariDriver();

				
			}

		}
		System.out.println("..1");
		driver.manage().window().maximize();
		System.out.println("..2");
		driver.manage().timeouts().implicitlyWait(14, TimeUnit.SECONDS);
		System.out.println("..3");

		objects = new LoginPageObject();
		helpers = new helperFunctions();
		wpo = new WebsitePagesObject();
	}

	@BeforeMethod
	public void initTest()
	    {
		
	}
	
	
	@Test
	public void WEB_1() throws Exception
	{
		System.out.print("WEB-1" + "\n");
		objects.authorLogin();
		wpo.deleteThePage();
		wpo.createPage();
		
	}
	
	@AfterMethod
	public void cleanupTest(ITestResult result)
	{
		// not printed in report
		// Reporter.log("<br><br>-----<br>inside @AfterMethod" + "<br>");

		System.out.println("inside @AfterMethod");

		try
		{
			helperFunctions.signOut();
			
		}
		catch (Exception e)
		{
			Reporter.log("Exception caught while signing out at testCleanUp, "
							+ "closing Browser now." + "<br>");

			System.out.println("Exception caught while signing out at testCleanUp "
								+ "\n");
		}
		// driver.close();
		// driver.get(read.getURL());

		if (result.getStatus() == ITestResult.FAILURE)
			System.out.println("Status: FAILED");
		else if (result.getStatus() == ITestResult.SKIP)
			System.out.println("Status: SKIPPED");
		else
			System.out.println("Status: PASSED");

		System.out.println("---------------------------------------------------------------------------------\n");

		Reporter.log("---------------------------------------------------------------------------------"
						+ "<br>");
	}

	@AfterSuite
	public void cleanSuite()
	{
		Reporter.log("inside @AfterSuite" + "<br>");
		driver.close();
		driver.quit();
		driver = null;
		Reporter.log("---------------------------------------------------------------------------------"
						+ "<br>");
	}
	
	
	}


