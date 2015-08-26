package vivino.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class FriendsPage extends Screen {

	public FriendsPage(WebDriver webDriver) {
		super(webDriver);
	}
	
	@FindBy (how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id, 'sendinvite')]")
	public WebElement findSomeFriendsButton;
	
	@FindBy (how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id, 'username')]")
	public WebElement friendsUsername;
	
	public AddFriendsPage goToFindSomeFriends() {
		findSomeFriendsButton.click();
		return PageFactory.initElements(appiumDriver, AddFriendsPage.class);
	}
	
	public String getFriendsUsername() {
		return friendsUsername.getAttribute("text");
	}
	
	public UserProfilePage goToFriendsProfile() {
		friendsUsername.click();
		return PageFactory.initElements(appiumDriver, UserProfilePage.class);
	}
}
