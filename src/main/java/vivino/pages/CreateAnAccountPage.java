package vivino.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CreateAnAccountPage extends Screen {
	
	@FindBy (how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id, 'txtIHaveAnAccount')]")
	public WebElement loginWithVivinoAccountButton;
	
	@FindBy (how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id, 'txtTryUsOut')]")
	public WebElement tryUsOutButton;
	
	@FindBy (how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id, 'txtSignUpWithEmail')]")
	public WebElement signUpWithEmailButton;
	
	@FindBy (how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id, 'moreoptions')]")
	public WebElement moreOptionsButton;
	
	public CreateAnAccountPage(WebDriver webDriver) {
		super(webDriver);
	}
	
	public WhyNotRegisterPage goToRegister() {
		tryUsOutButton.click();
		return PageFactory.initElements(appiumDriver, WhyNotRegisterPage.class);
	}
	
	public SignUpWithEmailPage goToSignUpWithEmailPage() {
		moreOptionsButton.click();
		signUpWithEmailButton.click();
		return PageFactory.initElements(appiumDriver, SignUpWithEmailPage.class);
	}
	
	public void swipeToLastScreen() {
		swipeLeft();
		swipeLeft();
		swipeLeft();
		swipeLeft();
	}

}
