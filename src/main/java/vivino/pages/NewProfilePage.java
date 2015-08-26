package vivino.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class NewProfilePage extends Screen {

	public NewProfilePage(WebDriver webDriver) {
		super(webDriver);
	}

	@FindBy(how = How.XPATH, using = "//android.widget.EditText[contains(@resource-id, 'edtUserName')]")
	public WebElement userNameField;

	@FindBy(how = How.XPATH, using = "//android.widget.EditText[contains(@resource-id, 'edtUserSurname')]")
	public WebElement userSurnameField;

	@FindBy(how = How.XPATH, using = "//android.widget.Button[contains(@resource-id, 'button')]")
	public WebElement doneButton;

	public void fillName() {
//		userNameField.sendKeys("Bogdan");
		enterText("Bogdan");
	}

	public void fillSurname() {
//		userSurnameField.sendKeys("Baraban");
		userSurnameField.click();
		enterText("Baraban");
	}

	public HomePage clickDoneAndProceed() {
		doneButton.click();
		return PageFactory.initElements(appiumDriver, HomePage.class);
	}
}
