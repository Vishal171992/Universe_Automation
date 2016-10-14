package AutomationTests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.DriverFactory;
import utilities.functionLibrary;
import utilities.utilLibrary;

public class CreateProject_negative {

	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;
	
@Test
public void testMethod() throws IOException
	{	
		report= utilLibrary.getReportInstance();
		logger=report.startTest("Create_Project_duplicate");
		logger.log(LogStatus.INFO, "Project creation_duplicate scenario");
		driver = DriverFactory.getDriver();
		functionLibrary.createProject(driver, report, logger);
//		String projectname = report.getProjectName();
//		System.out.println(projectname);
	}
	

@AfterMethod
public void tearDown(ITestResult result)
{
	if(result.getStatus()==ITestResult.FAILURE)
	{
		//System.out.println("inside teardown");
		String screenshot_path=utilLibrary.captureScreenshot(driver, result.getName());
		System.out.println(screenshot_path);
		String image= logger.addScreenCapture(screenshot_path);
		logger.log(LogStatus.FAIL, "Project creation_duplicate", image);
		
	
	}
	report.endTest(logger);
	report.flush();	
}
	
	
}
