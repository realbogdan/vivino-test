package vivino.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LogInPage extends Screen {
	
	public LogInPage(WebDriver webDriver) {
		super(webDriver);
	}
	
	@FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@text, 'Sign in')]")
	public WebElement signInText;

	@FindBy (how = How.XPATH, using = "//android.widget.EditText[contains(@resource-id, 'edtPassword')]")
	public WebElement passwordField;
	
	@FindBy (how = How.XPATH, using = "//android.widget.EditText[contains(@resource-id, 'edtEmail')]")
	public WebElement emailField;
	
	public String getSignInText() {
		return signInText.getAttribute("text");
	}
}