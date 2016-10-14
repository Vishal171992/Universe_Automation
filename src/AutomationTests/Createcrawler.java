package AutomationTests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pageObjects.HomePage;
import utilities.DriverFactory;
import utilities.UniverseProperty;
import utilities.functionLibrary;

public class Createcrawler {

	WebDriver driver;
	static int flag=0;
	
	public Createcrawler()
	{
		
	}
	
	@Test
	public void testmethod()throws IOException{
		
		driver = DriverFactory.getDriver();
		String project_name=UniverseProperty.getPropertyValueByName("PROJECT_NAME");
		String project_name_retrieved= HomePage.projectlistfirstitem(driver).getText();
	
		
		String RUN_CRAWLER_FOLDER_IMPORT=UniverseProperty.getPropertyValueByName("RUN_CRAWLER_FOLDER_IMPORT");
		String RUN_CRAWLER_CMIS=UniverseProperty.getPropertyValueByName("RUN_CRAWLER_CMIS");
		
		if (RUN_CRAWLER_FOLDER_IMPORT.equals("TRUE")){
			HomePage.Project_Breadcrumb(driver).click();
			if (project_name.contentEquals(project_name_retrieved))
			{
				
				HomePage.projectlistfirstitem(driver).click();
				HomePage.openproject(driver).click();
			}
		functionLibrary.createFolderconnector(driver);
		
		}
		
		if (RUN_CRAWLER_CMIS.equals("TRUE")){
			HomePage.Project_Breadcrumb(driver).click();
			if (project_name.contentEquals(project_name_retrieved))
			{
				
				HomePage.projectlistfirstitem(driver).click();
				HomePage.openproject(driver).click();
			}
			functionLibrary.createcmisconnector(driver);
		}
	}
}
