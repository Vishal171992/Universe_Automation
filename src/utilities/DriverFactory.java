package utilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {
	private static WebDriver driver;

	public static WebDriver getDriver() throws IOException {
		if (driver == null) {
			UniverseProperty.readCorePropertiesFromClassPath();
			String driverpath = UniverseProperty.getPropertyValueByName("DRIVER_PATH");
			String drivername = UniverseProperty.getPropertyValueByName("DRIVER_NAME");
			
			
			System.setProperty(drivername, driverpath);
			driver = new ChromeDriver();
			//driver.get(url);
			
		}
		return driver;

	}
}
