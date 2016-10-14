package pageObjects;

import java.io.IOException;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

import utilities.WaitTool;

public class LoginPage {

	private static WebElement element = null;
	
	 @FindBy(css = "button[type='submit'][title='Login']")
		WebElement gwtButton;
	
	
	public static WebElement user_Name(WebDriver driver) throws IOException {
	 
	    element = driver.findElement(By.name("j_username"));
	    WaitTool.waitForVisibility(element);
	    return element;
	 
	    }
	 
	 public static WebElement user_Password(WebDriver driver) throws IOException{
	 
	    element = driver.findElement(By.name("j_password"));
	    WaitTool.waitForVisibility(element);
	    return element;
	 
	    }
	 
	 public static WebElement Submit(WebDriver driver) throws IOException{

		element = driver.findElement(By.xpath("//*[@id='button']/button/i"));		    
		   WaitTool.waitForVisibility(element);
		return element;
		 
		    }
	 
	 public static WebElement hiUser(WebDriver driver) throws IOException{
			WaitTool.threadWait(100);
			element = driver.findElement(By.xpath("//*[@id='projectHeaderView']/div[2]/div[1]/div/table/tbody/tr/td/table/tbody/tr/td[3]/div/div"));		    
			   WaitTool.waitForVisibility(element);
			return element;
			 
			    }
	
}
