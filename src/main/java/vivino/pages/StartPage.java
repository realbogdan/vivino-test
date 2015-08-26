package vivino.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class StartPage extends Screen {
	
	@FindBy (how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id, 'txtgetstartedl')]")
	public WebElement getStartedButton;
	
	@FindBy (how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id, 'txthaveaccount')]")
	public WebElement haveAnAccountLogInButton;
	
	@FindBy (how = How.XPATH, using = "//android.widget.Button[contains(@resource-id, 'button')]")
	public WebElement logInButton;

	
	public StartPage(WebDriver webDriver) {
		super(webDriver);
	}
	
	public CreateAnAccountPage goToCreateAnAccountPage() {
		getStartedButton.click();
		return PageFactory.initElements(appiumDriver, CreateAnAccountPage.class);
	}
	
	public WelcomeBackPage goToWelcomePage() {
		haveAnAccountLogInButton.click();
		return PageFactory.initElements(appiumDriver, WelcomeBackPage.class);
	}

}