package vivino.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SignUpWithEmailPage extends Screen {

	public SignUpWithEmailPage(WebDriver webDriver) {
		super(webDriver);
	}
	
	@FindBy (how = How.XPATH, using = "//android.widget.EditText[contains(@resource-id, 'edtPassword')]")
	public WebElement passwordField;
	
	@FindBy (how = How.XPATH, using = "//android.widget.EditText[contains(@resource-id, 'edtEmail')]")
	public WebElement emailField;
	
	@FindBy (how = How.XPATH, using = "//android.widget.Button[contains(@resource-id, 'button')]")
	public WebElement doneButton;

	
	public NewProfilePage clickDoneAndProceed() {
		doneButton.click();
		return PageFactory.initElements(appiumDriver, NewProfilePage.class);
	}
	
	public void fillEmail() {
//		emailField.sendKeys("generalitet@gmail.com");
		enterText("generalitet@gmail.com");
	}
	
	public void fillPassword() {
//		passwordField.sendKeys("baraban");
		passwordField.click();
		enterText("baraban");
	}

}
