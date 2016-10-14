package utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.ExtentReports;

import pageObjects.HomePage;

import org.openqa.selenium.TakesScreenshot;

public class utilLibrary {

	
	 public static String captureScreenshot(WebDriver driver, String screenshotname)
	  { 
		 String dest = null;
		 try {
	  

			 File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			 String scrnshpath=UniverseProperty.getPropertyValueByName("SCREENSHOT_PATH");
			  
			 dest = scrnshpath+screenshotname+".png";
			  File destination= new File(dest);
			 FileUtils.copyFile(src, destination);
		
		 }
		 
		 catch (Exception e)
		  {
		   System.out.println(e.getMessage());
		  }
		return dest;
		 
		
	  }
	
	 
	 public static ExtentReports getReportInstance()
	    {
			ExtentReports extent;
			String Path=UniverseProperty.getPropertyValueByName("REPORT_PATH");
			System.out.println(Path);
			extent = new ExtentReports(Path, false);
			extent.config().documentTitle("Automation Report").reportName("Regression");
			
			return extent;
	    }
				
	 
	 public static void selectlanguage(WebDriver driver) throws IOException{
			Select dropdown = new Select(driver.findElement(By.xpath("//*[@id='projectCreationViewPanel']/tbody/tr[5]/td/select"))); 
			dropdown.selectByValue("Russian");
			
		}
	 
}
