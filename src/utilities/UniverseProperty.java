package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

//import org.openqa.selenium.server.ClassPathResource;

public class UniverseProperty {

	private static Properties properties;

	public static Properties readCorePropertiesFromClassPath() throws IOException {
		String filePath = "/Users/vishalarora/Documents/workspace/Universe automation/universe.properties";
		InputStream inputStream = new FileInputStream(filePath);
		 properties = new Properties();
		properties.load(inputStream);
		return properties;
	}

	public static String getPropertyValueByName(String key) {
		return properties.getProperty(key);
	}
}
