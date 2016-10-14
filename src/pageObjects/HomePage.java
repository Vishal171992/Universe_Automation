package pageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import utilities.WaitTool;

public class HomePage {
	private static WebElement element = null;
	
	public static WebElement createButton(WebDriver driver) throws IOException {
	 
	    element = driver.findElement(By.id("createProjectButton"));
	    WaitTool.waitForVisibility(element);
	    return element;
	 
	    }
	
	public static WebElement nameField(WebDriver driver) throws IOException {
		 
	    element = driver.findElement(By.id("textField-projectName-input"));
	    WaitTool.waitForVisibility(element);
	    return element;
	 
	    }
	
	public static WebElement addButton(WebDriver driver) throws IOException {
		 
	    element = driver.findElement(By.id("button-addTag"));
	    WaitTool.waitForVisibility(element);
	    return element;
	 
	    }
	public static WebElement key(WebDriver driver) throws IOException {
		WaitTool.threadWait(1000);
		 element = driver.findElement(By.cssSelector("td[cellindex='0']"));
		//element = driver.findElement(By.id("x-auto-109-input"));GKVVQWVDEK
		//element= driver.findElement(By.xpath("//td[contains(@class,'GKVVQWVDNAD GKVVQWVDFKE') and contains(text(),'Key-1')]"));
	    WaitTool.waitForClickability(element);
	    return element;
	 
	    }
	public static WebElement value(WebDriver driver) throws IOException {
		WaitTool.threadWait(100);
		element = driver.findElement(By.cssSelector("td[cellindex='1']"));
		//element = driver.findElement(By.xpath("//*[@id='tagGridPanel']/tbody/tr/td/div/div[2]/div[1]/table/tbody[2]/tr/td[2]/div"));
		//element = driver.findElement(By.className(className));
		WaitTool.waitForVisibility(element);
	    return element;
	 
	    }
	
	public static WebElement save(WebDriver driver) throws IOException {
		WaitTool.threadWait(100);
	    element = driver.findElement(By.id("button-saveProject"));
	    WaitTool.waitForVisibility(element);
	    return element;
	 
	    }
	
	public static WebElement cancel(WebDriver driver) throws IOException {
		 
	    element = driver.findElement(By.id("button-cancelProject"));
	    WaitTool.waitForVisibility(element);
	    return element;
	 
	    }
	
	
	public static WebElement projectlistfirstitem(WebDriver driver) throws IOException {
		 
		WaitTool.threadWait(100);
		element = driver.findElement(By.xpath("//*[@id='projectsGrid']/div[2]/div[1]/table/tbody[2]/tr[1]/td/div/table/tbody[2]/tr[1]/td[2]/div"));
	    WaitTool.waitForVisibility(element);
	    return element;
	 
	    }
	
	
	public static WebElement ReloadButton(WebDriver driver) throws IOException {
		 
	    element = driver.findElement(By.id("gridRefresh"));
	    WaitTool.waitForVisibility(element);
	    return element;
	 
	    }
	
	
	public static WebElement project_duplicate_text(WebDriver driver) throws IOException {
		 
	    element = driver.findElement(By.xpath("//*[@id='label']"));
	    WaitTool.waitForVisibility(element);
	    return element;
	 
	    }
	public static Select selectlanguage(WebDriver driver) throws IOException {
		 WaitTool.threadWait(1000);
		Select element = new Select(driver.findElement(By.id("designation")));
	  //  WaitTool.waitForVisibility(element);
	    return element;
	 
	    }
	public static WebElement openproject(WebDriver driver) throws IOException {
		 
	    element = driver.findElement(By.id("openProjectButton"));
	    WaitTool.waitForVisibility(element);
	    return element;
	 
	    }
	
	public static WebElement Project_Breadcrumb(WebDriver driver) throws IOException {
		 
	    element = driver.findElement(By.xpath("//*[@id='Project']"));
	    WaitTool.waitForVisibility(element);
	    return element;
	 
	    }
	
	

	
	
}
