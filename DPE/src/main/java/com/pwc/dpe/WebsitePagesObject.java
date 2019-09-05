package com.pwc.dpe;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

public class WebsitePagesObject {
	public static Reader read;
	public WebDriver driver;
	static long implicitTimeout;
	public static LoginPageObject objects;
	public static WebsitePagesObject wpo;
	static String newAutomationUser = "";
	static String newAutomationAccount;
	static String browserUsed = "";		
	
	public By byCreatePage;
	public By byCreatePage1;
	public By byCreatePage2;
	public By byNewPage;
	public By byPageTitle_textbox;
	public By byPageCreate_button;
	public By byPageCancel_button;
	public By byPageCrossIcon;
	public By byCampaignLanding;
	public By byLevel1Landing;
	public By byLevel3Landing;
	public By byLevel2Landing;
	public By byCampaignOnePager;
	public By byContentDetail;
	public By byGhostTemplate;
	public By byWholePagesList;
	public By byDeletePage_button;
	public By byYes_button;
	public By byMouseHoverDeleteButton;
	public By byTextAutomation;
	
	
	public WebsitePagesObject(){
		    read = DPETests.read;		   
		    implicitTimeout = 10;		
			driver = DPETests.driver;
			read = DPETests.read;
			browserUsed = read.getBrowser();
			objects = DPETests.objects;
			wpo = DPETests.wpo;
		    read = DPETests.read;
		   
		   byCreatePage =  By.xpath("//button[contains(.,'New')]");
		   byCreatePage1 = By.xpath("//td/table[@class='x-btn cq-siteadmin-create x-btn-text-icon']");
		   byCreatePage2 = By.xpath("//td/table[@class='x-btn cq-siteadmin-create x-btn-text-icon x-btn-over']");
		   byNewPage =     By.xpath("(//ul/li/a)[5]");
		   byPageTitle_textbox = By.xpath("//input[@name='title' and @type='text']");
		   byPageCreate_button= By.xpath("//div[@class='x-window-bl']//td[@class='x-btn-tc']");
		   byPageCancel_button = By.xpath("//div[@class='x-window-bl']//button[contains(text(),'Cancel')]");
		   byCampaignLanding = By.xpath("//div/div/img");
		   byLevel1Landing = By.xpath("//div[2]/img");
		   byLevel3Landing = By.xpath("//div[3]/img");
		   byLevel2Landing = By.xpath("//div[4]/img");
		   byCampaignOnePager = By.xpath("//div[5]/img");
		   byContentDetail = By.xpath("//div[6]/img");
		   byGhostTemplate = By.xpath("(//div[@class='x-panel-body x-panel-body-noheader'])[3]//div[7]");
		   byWholePagesList = By.xpath("//div[contains(text(),'Automation')]");
		   byDeletePage_button = By.xpath("//button[contains(.,'Delete')]");
		   byYes_button = By.xpath("//button[contains(.,'Yes')]");
		   byMouseHoverDeleteButton = By.xpath("//table[@class='x-btn cq-siteadmin-delete x-btn-noicon']");
		   byTextAutomation = By.xpath("//div[contains(text(),'Automation')]");
		   	   
	}
	
	/**
	 * This method is used to delete created page
	 * 
	 */
	
	 public void deleteThePage() throws Exception{
		   System.out.println("Deletion of previous created pages starts");  
		   List<WebElement> allLists = driver.findElements(byWholePagesList);
		   System.out.println("Size of List:" + allLists.size());		  
		   for ( int i=0; i < allLists.size(); i++ ){	   
		   driver.findElement(byTextAutomation).click();
		   read.getlongWaitTime();
		   driver.findElement(byDeletePage_button).click();
		   read.getlongWaitTime();
		   driver.findElement(byYes_button).click();	
		   read.getlongWaitTime();
		   driver.navigate().refresh();
		   Thread.sleep(10000);
		   }
	   }
	 

		/**
		 * This method is used to create new page
		 * @throws InterruptedException 
		 * 
		 */
	 
	 public void createPage() throws InterruptedException{
			String PageTitle= "Automation" + helperFunctions.randomNum(0,10000);
			//Thread.sleep(8000);
			driver.navigate().refresh();
			Thread.sleep(8000);
			driver.findElement(byCreatePage).click();	
			Reporter.log("Clicked on a new page button");
			Thread.sleep(10000);
			//driver.findElement(wpo.byNewPage).click();
			driver.findElement(By.xpath("//ul/li[@class='x-menu-list-item']")).click();
			Thread.sleep(5000);
			driver.findElement(byPageTitle_textbox).sendKeys(PageTitle);	
			selectTemplate(read.getTemplate());
			System.out.println("Template has been selected");
			driver.findElement(byPageCreate_button).click();
			Thread.sleep(5000);
		}
	 
		
		/**
		 * This method is used for Template selection
		 * 
		 */
		
		
		public void selectTemplate(String TemplateName){
			if(TemplateName.equalsIgnoreCase("L3LP"))
					{
				driver.findElement(byLevel3Landing).click();
			}
			else if (TemplateName.equalsIgnoreCase("CL")){
				driver.findElement(byCampaignLanding).click();
			}
				else if (TemplateName.equalsIgnoreCase("CD")){
					driver.findElement(byContentDetail).click();
				}
					else if (TemplateName.equalsIgnoreCase("L1LP")){
						driver.findElement(byLevel1Landing).click();
					}
						else if (TemplateName.equalsIgnoreCase("L2LP")){
							driver.findElement(byLevel2Landing).click();
						}
						else if (TemplateName.equalsIgnoreCase("COP")){
							driver.findElement(byGhostTemplate).click();
						}
			}
		
}
