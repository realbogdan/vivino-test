package vivino.pages;

import io.appium.java_client.AppiumDriver;

import java.io.IOException;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//Base class for all the pages

public abstract class Screen {

	protected WebDriver appiumDriver;

	public Screen(WebDriver webDriver) {
		this.appiumDriver = webDriver;
	}

	public WebDriver getWebDriver() {
		return appiumDriver;
	}

	@FindBy(how = How.XPATH, using = "//android.widget.EditText[contains(@resource-id, 'edtPassword')]")
	public WebElement passwordField;

	@FindBy(how = How.XPATH, using = "//android.widget.EditText[contains(@resource-id, 'edtEmail')]")
	public WebElement emailField;

	@FindBy(how = How.XPATH, using = "//android.widget.Button[contains(@resource-id, 'button')]")
	public WebElement logInButton;

	// my custom alternative method to sendKeys(), 5 times faster
	public void enterText(String textToEnter) {
		textToEnter = textToEnter.replaceAll(" ", "%s");
		try {
			Runtime.getRuntime().exec(
					System.getenv("ANDROID_HOME")
							+ "//platform-tools//adb shell input text "
							+ textToEnter);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void fillEmail() {
		// emailField.sendKeys("dirtyp970@gmail.com");
		enterText("dirtyp970@gmail.com");
	}

	public void fillPassword() {
		// passwordField.sendKeys("testpassword");
		passwordField.click();
		enterText("testpassword");
	}

	public HomePage clickLogInButtonAndProceed() {
		logInButton.click();
		return PageFactory.initElements(appiumDriver, HomePage.class);
	}

	public void swipeLeft() {
		@SuppressWarnings("rawtypes")
		AppiumDriver appium = (AppiumDriver) appiumDriver;
		Dimension size = appiumDriver.manage().window().getSize();
		int startx = (int) (size.width * 0.8);
		int endx = (int) (size.width * 0.20);
		int starty = size.height / 2;
		appium.swipe(startx, starty, endx, starty, 1000);
	}

	public void waitForScreenToLoad(WebDriver driver, WebElement element,
			int seconds) {
		WebDriverWait wait = new WebDriverWait(driver, seconds);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

}
