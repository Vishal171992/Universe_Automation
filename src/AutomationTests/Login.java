package AutomationTests;

import java.io.IOException;

import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.DriverFactory;

import utilities.UniverseProperty;
import utilities.functionLibrary;
import utilities.utilLibrary;

public class Login {

WebDriver driver;
ExtentReports report;
ExtentTest logger;

	public Login() throws IOException {
		driver = DriverFactory.getDriver();
		String url = UniverseProperty.getPropertyValueByName("UNIVERSE_URL"); 
		driver.get(url);
	
	}
	
@Test
	public void callLogin() throws InterruptedException {
	
		report= utilLibrary.getReportInstance();
		//report=new ExtentReports("/Users/vishalarora/Documents/Universe_automation/Reports/Report.html");
		logger=report.startTest("Login");
		logger.log(LogStatus.INFO, "Logging in");
	
		functionLibrary.login(driver, report, logger);
		
	}

@AfterMethod

	public void tearDown(ITestResult result)
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			System.out.println("inside teardown");
			String screenshot_path=utilLibrary.captureScreenshot(driver, result.getName());
			System.out.println(screenshot_path);
			String image= logger.addScreenCapture(screenshot_path);
			logger.log(LogStatus.FAIL, "Title verification", image);
			
		
		}
		report.endTest(logger);
		report.flush();

	}


}


