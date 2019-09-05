package com.pwc.dpe;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class helperFunctions {
	
	static WebDriver driver;
	static long implicitTimeout;
	public static Reader read;
	public static LoginPageObject objects;
	public static WebsitePagesObject wpo;
	static String newAutomationUser = "";
	static String newAutomationAccount;
	static String browserUsed = "";	
	//static String PageTitle= "Automation" + randomNum(0,10000);

	public helperFunctions()
	{
		implicitTimeout = 10;		
		driver = DPETests.driver;
		read = DPETests.read;
		browserUsed = read.getBrowser();
		objects = DPETests.objects;
		wpo = DPETests.wpo;

	}
	
	
	
	
	/**
	 * This method is used for waiting for Login Page to appear.
	 * 
	 */
	
	public static void waitForLoginPage()
	{

		boolean submitBtnExist = waitForElementToExist(	objects.bySignIn_button,
														read.getmediumWaitTime(),
														true);
		if (!submitBtnExist)
		{
			try
			{
				signOut();
			}
			catch (Exception e)
			{
				System.out.println("signOut threw exception..");
			}
			finally
			{
				driver.get(read.getURL());
				waitForElementToExist(	objects.bySignIn_button,
										read.getmediumWaitTime(), true);
			}
		}

	}
	
	/**
	 * This method is used for signing out from application
	 * 
	 */

	public static void signOut()
	{
		driver.findElement(objects.byNameDropDown);
		click(objects.byNameDropDown);
		driver.findElement(objects.bySignout_mousehover).isDisplayed();		
		JSmouseOver(objects.bySignout_mousehover);
		click(objects.bySignout);	
		Reporter.log("Signed Out" + "<br>");
	}
	
	/**
	 * This methods waits for given waitTime to look for web element on web page
	 * 
	 */

	public static boolean waitForElementToExist(final By byElementToFind,
			long waitTime,
			Boolean waitForAjax)
       {

            try
               {
                     Reporter.log("Waiting for element " + byElementToFind.toString()
                         + " to exist" + "<br>");
                if (waitForAjax)
                      {
                         waitForAjaxRefresh();
                      }
                WebDriverWait wait = new WebDriverWait(driver, waitTime);
                driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);

                Boolean foundElement = wait.until(new ExpectedCondition<Boolean>() {
    @Override
        public Boolean apply(WebDriver driver)
    {
             return elementExists(byElementToFind);
    }
   });

        driver.manage().timeouts()
         .implicitlyWait(implicitTimeout, TimeUnit.SECONDS);
        Reporter.log("Found Element: " + byElementToFind + "<br>");
         return foundElement;
               }
         catch (TimeoutException ex)
          {
        Reporter.log("Failed to find element '" + byElementToFind
    + "' after " + waitTime + " seconds." + "<br>");
        return false;
 }
 }
	
	
	/**
	 * Works on the assumption that jQuery Ajax libraries are present on the
	 * page, and if they are, waits for calls to them to complete
	 */
	
	
	
	public static void waitForAjaxRefresh()
	{
		Reporter.log("Waiting for Ajax Refresh" + "<br>");
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 60);
			final JavascriptExecutor javascript = (JavascriptExecutor) (driver instanceof JavascriptExecutor ? driver
					: null);

			wait.until(new ExpectedCondition<Boolean>() {
				@Override
				public Boolean apply(WebDriver d)
				{
					boolean outcome = Boolean.parseBoolean(javascript.executeScript("return jQuery.active == 0")
																		.toString());
					return outcome;
				}
			});
		}
		catch (TimeoutException ex)
		{
			throw new TimeoutException(
										"Timed out after "
												+ "60"
												+ " seconds while waiting for Ajax to complete.");
		}
		catch (WebDriverException e)
		{
			Reporter.log("JQuery libraries are not present on page "
							+ driver.getCurrentUrl() + " - "
							+ driver.getTitle() + "<br>");
		}
	}
	
	
	/**
	 * This method would check for element exists on web page
	 * 
	 */

	private static boolean elementExists(By by)
	{
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		Boolean elementFound = false;

		try
		{
			@SuppressWarnings("unused")
			WebElement toFind = driver.findElement(by);
			elementFound = true;
		}
		catch (NoSuchElementException ex)
		{
			elementFound = false;
		}

		driver.manage().timeouts()
				.implicitlyWait(implicitTimeout, TimeUnit.SECONDS);
		Reporter.log("Found Element " + by.toString() + ": " + elementFound
						+ "<br>");
		return elementFound;
	}
	
	
	
	/**
	 * This method is used when user wants to click any Web Element on page
	 * 
	 */
	public static void click(By elemBy)
	{
		waitForAjaxRefresh();

		try
		{
			// just to check if StaleElementReferenceException is thrown
			boolean checkExist = driver.findElement(elemBy).isDisplayed();
		}
		catch (StaleElementReferenceException e)
		{
			// retry in a moment
			waitForAjaxRefresh();
			Reporter.log("StaleElementReference Exception Caught, Trying Again.."
							+ "<br>");

		}
		catch (NoSuchElementException ne)
		{
			// retry in a moment
			waitForAjaxRefresh();
			Reporter.log("NoSuchElement Exception Caught, Trying Again.."
							+ "<br>");
		}
		finally
		{
			// clicking using JS
			waitForAjaxRefresh();
			//clickUsingJS(elemBy);
		}

		waitForAjaxRefresh();

	}
	
	
	
	/**
	 * This method is used for hovering the mouse on web element
	 * 
	 */

	public static void JSmouseOver(By elemBy)
	{
		Reporter.log("Moving mouse over: " + elemBy.toString() + "<br>");
		System.out.println("Moving mouse over: "  + elemBy.toString() + "<br>");
		final JavascriptExecutor jExecutor = (JavascriptExecutor) (driver instanceof JavascriptExecutor ? driver
				: null);
		String hoverScript = "var evObj = document.createEvent('MouseEvents');"
								+ "evObj.initMouseEvent(\"mouseover\",true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);"
								+ "arguments[0].dispatchEvent(evObj);";
		jExecutor.executeScript(hoverScript, driver.findElement(elemBy));
		System.out.println("End of Mouse hover");
	}
	
	
	
	/**
	 * This method is used for Template selection
	 * 
	 */
	
 /**	
	public static void selectTemplate(String TemplateName){
		if(TemplateName.equalsIgnoreCase("L3LP"))
				{
			driver.findElement(wpo.byLevel3Landing).click();
		}
		else if (TemplateName.equalsIgnoreCase("CL")){
			driver.findElement(wpo.byCampaignLanding).click();
		}
			else if (TemplateName.equalsIgnoreCase("CD")){
				driver.findElement(wpo.byContentDetail).click();
			}
				else if (TemplateName.equalsIgnoreCase("L1LP")){
					driver.findElement(wpo.byLevel1Landing).click();
				}
					else if (TemplateName.equalsIgnoreCase("L2LP")){
						driver.findElement(wpo.byLevel2Landing).click();
					}
					else if (TemplateName.equalsIgnoreCase("COP")){
						driver.findElement(wpo.byGhostTemplate).click();
					}
		} */
	
	
	
	/**
	 * This method generates random number
	 * 
	 */
	
	
	public static String randomNum(int lowerLimit, int upperLimit)
	{
		Random r = new Random();
		return Integer.toString(r.nextInt(upperLimit - lowerLimit) + lowerLimit);
	}
	


}
