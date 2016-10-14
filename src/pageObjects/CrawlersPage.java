package pageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.WaitTool;

public class CrawlersPage {

private static WebElement element = null;
	
	public static WebElement createcrawler(WebDriver driver) throws IOException {
		 
	    element = driver.findElement(By.id("createConnectorButton"));
	    WaitTool.waitForVisibility(element);
	    return element;
	 
}
	public static WebElement DataCenter(WebDriver driver) throws IOException {
		 
	    element = driver.findElement(By.id("datacenterMenuBarItem"));
	    WaitTool.waitForVisibility(element);
	    return element;
	 
}
	
	public static WebElement DataCenter_Crawlers(WebDriver driver) throws IOException {
		 
	    element = driver.findElement(By.id("crawlersMenuItem"));
	    WaitTool.waitForVisibility(element);
	    return element;
	 
}
}
