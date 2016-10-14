package utilities;

import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import pageObjects.AddconnectorPage;
import pageObjects.CrawlersPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class functionLibrary {

	static int projectcreation_counter;
	
	public static void login(WebDriver driver, ExtentReports report, ExtentTest logger){
		try{
				
		String username=UniverseProperty.getPropertyValueByName("UNIVERSE_USERNAME");

		String password= UniverseProperty.getPropertyValueByName("UNIVERSE_PASSWORD");
		LoginPage.user_Name(driver).sendKeys(username);
		LoginPage.user_Password(driver).sendKeys(password);
		LoginPage.Submit(driver).click();
		String title=driver.getTitle();
		
		Assert.assertTrue(title.contentEquals("Projects")); 
		 
		logger.log(LogStatus.PASS, "Title verified");
		
		String uname= LoginPage.hiUser(driver).getText();
		System.out.println(uname);
		Assert.assertTrue(uname.contains(username));
		
		logger.log(LogStatus.PASS, "User "+username+" is successfully logged in");
		}
		catch(Exception e){}
	}
		
	
	
	public static void createProject(WebDriver driver, ExtentReports report, ExtentTest logger){
	projectcreation_counter++;
	
		int flag =1;
	try{
		if (projectcreation_counter==2)				
		{	//createproject popup will still be open after createproject testcase
			//close the testcase
			HomePage.cancel(driver).click();
		}
		String project_name=UniverseProperty.getPropertyValueByName("PROJECT_NAME");
		
		HomePage.createButton(driver).click();
		System.out.println("1");
			
		if (HomePage.nameField(driver).getText().isEmpty())
			{
				HomePage.nameField(driver).sendKeys(project_name);
				logger.log(LogStatus.PASS, "Project name entered successfully");
			}
		else 
			{	
				logger.log(LogStatus.FAIL, "Field: Name is not empty");
				Assert.assertTrue(false);
			}

		
		addTags(driver, report, logger);	//add key value tags to the project
		utilLibrary.selectlanguage(driver);
		
			
		if (HomePage.save(driver).isDisplayed())
			{
				HomePage.save(driver).click();
				
				if (projectcreation_counter==2){		//for duplicate project creation scenario
					
					String duplicate_text= HomePage.project_duplicate_text(driver).getText();
					
					if (duplicate_text.contains("already exists")){
						logger.log(LogStatus.PASS, "Project name already exist error message is shown");
						HomePage.cancel(driver).click();
						return;
					}
					else{
						logger.log(LogStatus.FAIL, "Project name already exist error message is not shown");
						Assert.assertTrue(false);
					}
				}
				WaitTool.threadWait(1000);
				
				try{if (HomePage.save(driver).isDisplayed()){
					//logger.log(LogStatus.PASS, "Project creation popup is closed");
					logger.log(LogStatus.FAIL, "Project creation popup is still visible");
					Assert.assertTrue(false);
					HomePage.cancel(driver).click();
					
				}
				else {
					logger.log(LogStatus.PASS, "Project creation popup is closed");
				}
				}catch(NoSuchElementException e){System.out.println(e);}
				
				String project_name_retrieved= HomePage.projectlistfirstitem(driver).getText();
				System.out.println(project_name);
				if (project_name.contentEquals(project_name_retrieved))
				{
					logger.log(LogStatus.PASS, "Project "+project_name+ " saved successfully");
				}
				else
				{
					logger.log(LogStatus.FAIL, "Project "+project_name+ " did not save successfully");
					Assert.assertTrue(false);
				}
			}
		
		else 
			{
			logger.log(LogStatus.ERROR, "Save button is not visible");
			Assert.assertTrue(false);
			}
			
	
		
		
	}
		
		
	catch(Exception e){
			System.out.println(e);
			logger.log(LogStatus.ERROR, "Exception: "+e);
		}
			
	}
	
	
	
	public static void addTags(WebDriver driver, ExtentReports report, ExtentTest logger) 
	{
	try{
		HomePage.addButton(driver).click();
	
		
		if (HomePage.key(driver).isEnabled())
			{
				//System.out.println("2");
	
				WebElement active = driver.switchTo().activeElement(); 
				active.sendKeys("ProjectKey"); 
				active.sendKeys(Keys.TAB);
				logger.log(LogStatus.INFO, "Key entered successfully");
				
				System.out.println("3");
			}
		else
			{
			logger.log(LogStatus.ERROR, "Key field is not enabled");
			Assert.assertTrue(false);
			}
			
		if (HomePage.value(driver).isEnabled())
			{
			WebElement active = driver.switchTo().activeElement(); 
			active.sendKeys("1"); 	
			logger.log(LogStatus.INFO, "Value entered successfully");
			}
		else
			{
			logger.log(LogStatus.ERROR, "Value field is disabled");
			Assert.assertTrue(false);
			}
		
		}
	catch(Exception e){
		System.out.println(e);
		logger.log(LogStatus.ERROR, "Exception: "+e);
	}
		
		
	}
	
	
	public static void createFolderconnector (WebDriver driver) {
		
		try {
			
			System.out.println("Click on data center ");
		    CrawlersPage.DataCenter(driver).click();
		    System.out.println("Click on Crawlers ");
		    CrawlersPage.DataCenter_Crawlers(driver).click();
		    System.out.println("click on create crawler");
		    CrawlersPage.createcrawler(driver).click();
		    System.out.println("Crawler pop up open");
		    System.out.println("Enter crawler name ");
		    AddconnectorPage.crawlername(driver).sendKeys("TestCrawler");
		    Actions action= new Actions(driver);
		    WebElement coninput= driver.findElement(By.cssSelector("div.GKVVQWVDH3C input#connectorsTypeListBox-input"));
		    coninput.click();
		    
		    //0AddconnectorPage.connectortytpelist(driver).click();
		    action.moveToElement(coninput).moveToElement(driver.findElement(By.xpath("//div[contains(@class,'GKVVQWVDHDD') and contains(text(),'Folder Import')]"))).click().build().perform();
		    
		   
		    /*String ConnType = UniverseProperty.getPropertyValueByName("CONNECTOR_TYPE");
		    if (ConnType.contentEquals("CMIS")){
		     AddconnectorPage.connectortytpelist(driver).click();
		     //AddconnectorPage.connectortytpelist(driver).sendKeys(Keys.ENTER);
		    
		    
		    }
		    else {
		     System.out.println("Click on Arrowdown ");
		     Thread.sleep(2000);
		     AddconnectorPage.connectortytpelist(driver).click();
		     AddconnectorPage.connectortytpelist(driver).sendKeys(Keys.ARROW_DOWN);
		     Thread.sleep(2000);
		     AddconnectorPage.connectortytpelist(driver).sendKeys(Keys.ENTER);
		    }*/
		    
		    String basefolder = UniverseProperty.getPropertyValueByName("FOLDER_IMPORT_BASEFOLDER");
		    
		    AddconnectorPage.fibasefoldername(driver).click();
		    WebElement active4 = driver.switchTo().activeElement();
		    active4.sendKeys(basefolder);
		    
		    
		  
		    System.out.println("Test connection");
		    AddconnectorPage.crawlertestconnection(driver).click();
		    WaitTool.threadWait(2000);


		    String text= AddconnectorPage.crawlerconnpopup(driver).getText();
		    System.out.println(text);
		    Thread.sleep(1000);
		    AddconnectorPage.crawlerokpopup(driver).click();
		    
		    

		    System.out.println("save connection");
		    //AddconnectorPage.crawlersave(driver).click();	
		    Thread.sleep(2000);
		    AddconnectorPage.crawlercancel(driver).click();
		}
		catch(Exception e){
			System.out.println(e);
			
	}
	
}



public static void createcmisconnector (WebDriver driver){

try {
		System.out.println("Click on data center ");
	  CrawlersPage.DataCenter(driver).click();
	  System.out.println("Click on Crawlers ");
	  CrawlersPage.DataCenter_Crawlers(driver).click();
	  System.out.println("click on create crawler");
	  CrawlersPage.createcrawler(driver).click();
	  System.out.println("Crawler pop up open");
	  System.out.println("Enter crawler name ");
	  AddconnectorPage.crawlername(driver).sendKeys("TestCrawler");
	  
	  String cmisuser = UniverseProperty.getPropertyValueByName("CMIS_USERNAME");
	  
	  Thread.sleep(1000);
	  Actions action= new Actions(driver);
	  WebElement coninput= driver.findElement(By.cssSelector("div.GKVVQWVDH3C input#connectorsTypeListBox-input"));
	  coninput.click();
	  action.moveToElement(coninput).moveToElement(driver.findElement(By.xpath("//div[contains(@class,'GKVVQWVDHDD') and contains(text(),'CMIS')]"))).click().build().perform();
	  AddconnectorPage.crawlerusername(driver).click();
	  WebElement active = driver.switchTo().activeElement();
	  active.sendKeys(cmisuser);
	  
	  String cmispassword = UniverseProperty.getPropertyValueByName("CMIS_PASSWORD");
	  AddconnectorPage.crawlerpass(driver).click();
	  WebElement active1 = driver.switchTo().activeElement();
	  active1.sendKeys(cmispassword);
	  //AddconnectorPage.crawlerpass(driver).sendKeys(cmispassword);
	  
	  String cmisurl = UniverseProperty.getPropertyValueByName("CMIS_URL");
	  AddconnectorPage.cmisurl(driver).click();
	  WebElement active2 = driver.switchTo().activeElement();
	  active2.sendKeys(cmisurl);
	  //AddconnectorPage.cmisurl(driver).sendKeys(cmisurl);
	  
	  String cmisfoldername = UniverseProperty.getPropertyValueByName("CMIS_FOLDERNAME");
	  AddconnectorPage.cmisfoldername(driver).click();
	  WebElement active3 = driver.switchTo().activeElement();
	  active3.sendKeys(cmisfoldername);
	  //AddconnectorPage.cmisfoldername(driver).sendKeys(cmisfoldername);
	  
	  System.out.println("Test connection");
	  AddconnectorPage.crawlertestconnection(driver).click();
	  
	  
	  WaitTool.threadWait(2000);


	  String text= AddconnectorPage.crawlerconnpopup(driver).getText();
	  System.out.println(text);
	  AddconnectorPage.crawlerokpopup(driver).click();
	  
	  System.out.println("save connection");
	  AddconnectorPage.crawlercancel(driver).click();
	 // AddconnectorPage.crawlersave(driver).click();
	}


	 catch(Exception e){
	  System.out.println(e);
}
}




}

	

