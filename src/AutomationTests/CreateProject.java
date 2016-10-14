package AutomationTests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.DriverFactory;
import utilities.functionLibrary;
import utilities.utilLibrary;

public class CreateProject {

	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;

	public CreateProject() throws IOException {
		// TODO Auto-generated constructor stub
	}

	@Test
	public void testmethod() throws IOException {

		// report=new
		// ExtentReports("/Users/vishalarora/Documents/Universe_automation/Reports/Report.html");
		report = utilLibrary.getReportInstance();
		logger = report.startTest("Create_Project");
		logger.log(LogStatus.INFO, "Project creation");
		driver = DriverFactory.getDriver();
		functionLibrary.createProject(driver, report, logger);

	}

	@AfterMethod
	public void tearDown(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			// System.out.println("inside teardown");
			String screenshot_path = utilLibrary.captureScreenshot(driver, result.getName());
			System.out.println(screenshot_path);
			String image = logger.addScreenCapture(screenshot_path);
			logger.log(LogStatus.FAIL, "Project creation", image);

		}
		report.endTest(logger);
		report.flush();
	}

}
