

import java.io.IOException;
import java.util.List;

import pageObjects.HomePage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class MyClass {

	public static void main(String args[]) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "/Users/vishalarora/Downloads/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("http://180.151.194.86:8085/eu/Projects.html");
		//driver.get("http://192.169.1.171:8085/eu/Projects.html");
		HomePage.user_Name(driver).sendKeys("ephesoft");
		HomePage.user_Password(driver).sendKeys("ephesoft");
		//driver.findElement(By.name("j_username")).sendKeys("ephesoft");
		//driver.findElement(By.name("j_password")).sendKeys("ephesoft");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@id='button']/button/i")).click();
		//driver.findElement(By.cssSelector("i[class*='submit'][title='Login']")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='createProjectButton']")));
	
		System.out.println(driver.findElement(By.xpath("//*[@id='createProjectButton']")).isEnabled());
		System.out.println(driver.findElement(By.xpath("//*[@id='editProjectButton']")).isEnabled());
		System.out.println(driver.findElement(By.xpath("//*[@id='deleteProjectButton']")).isEnabled());
		System.out.println(driver.findElement(By.xpath("//*[@id='openProjectButton']")).isEnabled());
		System.out.println(driver.findElement(By.xpath("//*[@id='shareProjectButton']")).isEnabled());
		
		
		
		//driver.findElement(By.id("createProjectButton")).click();
		//driver.findElement(By.id("textField-projectName-input")).sendKeys("Test1");
		
		//Select listbox = new Select(driver.findElement(By.xpath("//*[@id='projectCreationViewPanel']/tbody/tr[5]/td/select")));
		//listbox.selectByValue("ENGLISH");
		//driver.findElement(By.id("button-saveProject")).click();
		Thread.sleep(2000);
		//Actions action = new Actions(driver).doubleClick(driver.findElement(By.xpath("//*[@id='projectsGrid']/div[2]/div[2]")));
		Actions action = new Actions(driver).doubleClick(driver.findElement(By.xpath("//*[@id='projectsGrid']/div[2]/div[1]/table/tbody[2]/tr[1]/td/div/table/tbody[1]/tr")));
		action.build().perform();
		WebElement el1=driver.findElement(By.id("datacenterMenuBarItem"));
		wait.until(ExpectedConditions.elementToBeClickable(el1));
		el1.click();
		WebElement el2=driver.findElement(By.xpath("//*[@id='crawlersMenuItem']/span"));
		wait.until(ExpectedConditions.elementToBeClickable(el2));
		System.out.println(el2.getText());
		System.out.println(el2.isEnabled());
		Actions action1 = new Actions(driver);
		action1.moveToElement(el2).doubleClick().build().perform();
		/*
		
		action1.moveToElement(el1).click().moveToElement(el2).doubleClick();
		action1.build().perform();
		*/
		
	}
//	
}
