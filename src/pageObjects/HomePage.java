package pageObjects;

import org.openqa.selenium.*;

public class HomePage {

	private static WebElement element = null;
	
	 public static WebElement user_Name(WebDriver driver){
	 
	    element = driver.findElement(By.name("j_username"));
	 
	    return element;
	 
	    }
	 
	 public static WebElement user_Password(WebDriver driver){
	 
	    element = driver.findElement(By.name("j_password"));
	 
	 return element;
	 
	    }
	 
	
}
