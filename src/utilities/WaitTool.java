package utilities;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitTool {

	public static void waitForVisibility(WebElement element) throws IOException {
		WebDriver driver = DriverFactory.getDriver();
		new WebDriverWait(driver, 50).pollingEvery(1, TimeUnit.SECONDS).until(ExpectedConditions.visibilityOf(element));
	}

	public static boolean waitForClickability(WebElement element) throws IOException {
		WebDriver driver = DriverFactory.getDriver();
		new WebDriverWait(driver, 50).pollingEvery(1, TimeUnit.SECONDS)
				.until(ExpectedConditions.elementToBeClickable(element));
		return true;
	}

	// public static void waitForOverlay()
	// {
	// WebDriver driver=DriverFactory.getDriver();
	// WebElement overlay=
	// driver.findElement(By.cssSelector("div.gwt-PopupPanelGlass"));
	// new WebDriverWait(driver, 100).pollingEvery(2, TimeUnit.SECONDS).
	// until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.gwt-PopupPanelGlass")));
	// }
	// public static void waitForOverlay()
	// {
	// WebDriver driver=DriverFactory.getDriver();
	// WebElement
	// overlay=driver.findElement(By.cssSelector("div.gwt-PopupPanelGlass"));
	// new FluentWait<WebElement>(overlay).
	// withTimeout(3, TimeUnit.SECONDS).
	// pollingEvery(50, TimeUnit.MILLISECONDS).
	// ignoring(NoSuchElementException.class).
	// until(new Function<Boolean>() {
	// @Override
	// public boolean apply(WebElement element) {
	// return element.isDisplayed();

	// }
	//
	// public boolean test(WebElement t) {
	// // TODO Auto-generated method stub
	// return false;
	// }
	// }
	public static void waitForOverlayNew() throws IOException {
		WebDriver driver = DriverFactory.getDriver();
		try {
			driver.findElement(By.cssSelector("div.gwt-PopupPanelGlass"));
			WaitTool.threadWait(200);
			System.out.println("waiting for overlay");
			waitForOverlayNew();
		} catch (NoSuchElementException e) {
			return;
		}
	}

	public static void threadWait(int milis) {
		try {
			Thread.sleep(milis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}