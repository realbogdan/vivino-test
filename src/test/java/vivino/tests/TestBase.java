package vivino.tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import vivino.utility.XmlPropertyLoader;

// Base class for all the test classes

public class TestBase {

	protected static AppiumDriver appiumDriver;
	protected String timeout;

	@BeforeMethod
	public void setup()
			throws Exception {
		timeout = XmlPropertyLoader.loadProperty("implicit-timeout");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "02c5603308eb1b68");
		capabilities.setCapability(MobileCapabilityType.APP,
				XmlPropertyLoader.loadProperty("application.path"));
		appiumDriver = new AndroidDriver(new URL(
				XmlPropertyLoader.loadProperty("appium.server.url")),
				capabilities);
		appiumDriver.manage().timeouts()
				.implicitlyWait(Integer.valueOf(timeout), TimeUnit.SECONDS);
	}

	@AfterMethod
	public void tearDown() throws Exception {
		if (appiumDriver != null) {
			appiumDriver.quit();
			appiumDriver = null;
		}
	}

}