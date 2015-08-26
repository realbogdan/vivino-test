package vivino.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class UserProfilePage extends Screen {

	public UserProfilePage(WebDriver webDriver) {
		super(webDriver);
	}
	
	@FindBy (how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id, 'txtUserName')]")
	public WebElement profileName;
	
	@FindBy (how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id, 'txtFollow')]")
	public WebElement followUnfollowButton;
	
	public String getProfileName() {
		return profileName.getAttribute("text");
	}
	
	public boolean unfollowUser() {
		followUnfollowButton.click();
		return followUnfollowButton.getAttribute("text").equals("Follow");
	}

}
