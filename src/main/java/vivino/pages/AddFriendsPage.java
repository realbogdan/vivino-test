package vivino.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddFriendsPage extends Screen {

	public AddFriendsPage(WebDriver webDriver) {
		super(webDriver);
	}
	
	@FindBy (how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id, 'action_search_user')]")
	public WebElement searchUserButton;
	
	@FindBy (how = How.XPATH, using = "//android.widget.EditText[contains(@resource-id, 'search_edittext')]")
	public WebElement searchUserField;
	
	@FindBy (how = How.XPATH, using = "//android.widget.ImageView[contains(@resource-id, 'search_icon_imageview')]")
	public WebElement searchIconButton;
	
	@FindBy (how = How.XPATH, using = "//android.widget.Button[contains(@resource-id, 'btnFollow')]")
	public WebElement followButton;
	
	@FindBy (how = How.XPATH, using = "//android.widget.ImageView[contains(@resource-id, 'up')]")
	public WebElement upButton;
	
	
	public void goToSearch() {
		searchUserButton.click();
	}
	
	public void fillUserNameToSearch() {
//		searchUserField.sendKeys("Name di Surname");
		enterText("Name di Surname");
	}
	
	public void clickSearchIconButton() {
		searchIconButton.click();
	}
	
	public void clickFollowFriend() {
		followButton.click();
	}
	
	public String getFollowButtonText() {
		return followButton.getAttribute("text");
	}
	
	public FriendsPage goUpToFriendsPage() {
		upButton.click();
		upButton.click();
		return PageFactory.initElements(appiumDriver, FriendsPage.class);
	}

}
