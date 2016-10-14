package pageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import utilities.WaitTool;

public class AddconnectorPage {

private static WebElement element = null;
private static Select se = null ;
	
	public static WebElement crawlername(WebDriver driver) throws IOException {
		 
	    element = driver.findElement(By.id("connectorNameTextField-input"));
	    WaitTool.waitForVisibility(element);
	    return element;
}
	public static WebElement connectortytpelist(WebDriver driver) throws IOException {
		 
	  //  element = driver.findElement(By.id("connectorsTypeListBox-input"));
		element = driver.findElement(By.id("connectorsTypeListBox"));
		WaitTool.waitForVisibility(element);
		/* se = new Select(element);
		se.selectByValue("CMIS");*/
		  return element;
		  
	}
		  public static WebElement folderimport(WebDriver driver) throws IOException {
			  
			    element = driver.findElement(By.className("GKVVQWVDHDD x-view-highlightrow GKVVQWVDJDD"));
			    WaitTool.waitForVisibility(element);
			    return element;
		}
		  
		 
	    

	public static WebElement crawlerusername(WebDriver driver) throws IOException {
		 
	    //element = driver.findElement(By.id("x-auto-113-input"));
	    element = driver.findElement(By.xpath("//div[contains(@class,'connectorTextBoxStyle') and contains(@id,'connectorUserNameTextField')]"));
		//element = driver.findElement(By.xpath("//div[contains(@class,'connectorTextBoxStyle GKVVQWVDH2C') and contains(@id,'x-auto-')]"));
	    WaitTool.waitForVisibility(element);
	    return element;
	
}
	public static WebElement crawlerpass(WebDriver driver) throws IOException {
		 
	   // element = driver.findElement(By.id("x-auto-114-input"));
	    element = driver.findElement(By.xpath("//div[contains(@class,'connectorTextBoxStyle') and contains(@id,'connectorPasswordTextField')]"));
	    WaitTool.waitForVisibility(element);
	    return element;
	
}
	public static WebElement cmisurl(WebDriver driver) throws IOException {
		 
	 //   element = driver.findElement(By.id("x-auto-115-input"));
	    element = driver.findElement(By.xpath("//div[contains(@class,'connectorTextBoxStyle') and contains(@id,'connectorServerURLTextField')]"));
	    WaitTool.waitForVisibility(element);
	    return element;
	
}
	public static WebElement cmisfoldername(WebDriver driver) throws IOException {
		 
	   // element = driver.findElement(By.id("x-auto-117-input"));
	    element = driver.findElement(By.xpath("//div[contains(@class,'connectorTextBoxStyle') and contains(@id,'connectorFolderNameTextField')]"));
	    WaitTool.waitForVisibility(element);
	    return element;
	
}
	

	public static WebElement crawlertestconnection(WebDriver driver) throws IOException {
		 
	    element = driver.findElement(By.id("testConnectionButton"));
	    WaitTool.waitForVisibility(element);
	    return element;
	
}
	public static WebElement crawlercancel(WebDriver driver) throws IOException {
		 
	    element = driver.findElement(By.id("cancelButton"));
	    WaitTool.waitForVisibility(element);
	    return element;
	
}
	public static WebElement crawlersave(WebDriver driver) throws IOException {
		 
	    element = driver.findElement(By.id("saveButton"));
	    WaitTool.waitForVisibility(element);
	    return element;
	
}
	
	public static WebElement crawlerconnpopup(WebDriver driver) throws IOException {
		
		element = driver.findElement(By.xpath("//div[contains(@class,'windowBorderStyle') and contains(@id,'x-auto-')]"));
	    //element = driver.findElement(By.xpath("//div[contains(text(),'OK')]"));
	    WaitTool.waitForVisibility(element);
	    return element;
	
	   // GKVVQWVDJTD dialog windowBorderStyle
	    //id="x-auto
	    
}
	public static WebElement crawlerokpopup(WebDriver driver) throws IOException {
		
		
	    element = driver.findElement(By.xpath("//div[contains(text(),'OK')]"));
	    WaitTool.waitForVisibility(element);
	    return element;
	
	   // GKVVQWVDJTD dialog windowBorderStyle
	    //id="x-auto
	    
}
	
	public static WebElement fibasefoldername(WebDriver driver) throws IOException {
		
		element = driver.findElement(By.xpath("//div[contains(@class,'connectorTextBoxStyle') and contains(@id,'connectorBaseFolderNameTextField')]"));
	    //element = driver.findElement(By.id("x-auto-122-input"));
	    WaitTool.waitForVisibility(element);
	    return element;
	
}
}


