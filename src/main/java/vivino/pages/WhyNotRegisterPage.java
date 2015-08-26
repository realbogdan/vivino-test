package vivino.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class WhyNotRegisterPage extends Screen {

	public WhyNotRegisterPage(WebDriver webDriver) {
		super(webDriver);
	}
	
	@FindBy (how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id, 'registerEmail_TextView')]")
	public WebElement registerWithEmailButton;
	
	public SignUpWithEmailPage goToSignUpWithEmail() {
		registerWithEmailButton.click();
		return PageFactory.initElements(appiumDriver, SignUpWithEmailPage.class);
	}
	
}
