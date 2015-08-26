package vivino.pages;

import io.appium.java_client.AppiumDriver;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends Screen {

	@FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id, 'action_bar_title')]")
	public WebElement titleText;

	@FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id, 'action_profile')]")
	public WebElement actionProfileButton;

	@FindBy(how = How.XPATH, using = "//android.widget.ImageView[contains(@resource-id, 'fab')]")
	public WebElement cameraButton;

	@FindBy(how = How.XPATH, using = "//android.widget.ImageView[contains(@resource-id, 'cameraGalleryButton')]")
	public WebElement cameraGalleryButton;

	@FindBy(how = How.XPATH, using = "//android.widget.ImageView[contains(@resource-id, 'cameraUseButton')]")
	public WebElement cameraUseButton;

	@FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id, 'friends_txt')]")
	public WebElement friendsButton;

	@FindBy(how = How.XPATH, using = "//android.widget.ImageView[contains(@resource-id, 'tab1')]")
	public WebElement homeTab1Vivino;

	@FindBy(how = How.XPATH, using = "//android.widget.ImageView[contains(@resource-id, 'tab4')]")
	public WebElement homeTab4NearbyPlaces;

	@FindBy(how = How.XPATH, using = "//android.widget.RelativeLayout[contains(@resource-id, 'parentLayout')]")
	public WebElement nearbyPlacesList;

	@FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id, 'txtNoWine')]")
	public WebElement poweredByFoursquareText;
	
	@FindBy(how = How.XPATH, using = "//android.view.View[contains(@resource-id, 'grid')]")
	public WebElement gallery;
	
	@FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id, 'txtLocationName')]")
	public WebElement nearbyPlaceName;

	public HomePage(WebDriver webDriver) {
		super(webDriver);
	}
	
	// my method to harvest unique nearby places' names
	public boolean checkNearbyPlacesPresence() {
		Set<String> placesNamesSet = new HashSet<String>();
		List<WebElement> list = new ArrayList<WebElement>();

		list.addAll(appiumDriver.findElements(By
				.xpath("//android.widget.TextView[contains(@resource-id, 'txtLocationName')]")));
		for (WebElement item : list) {
			placesNamesSet.add(item.getAttribute("text"));
		}

		int oldSetSize = placesNamesSet.size();
		boolean continueScroll = oldSetSize < 1 ? false : true;

		while (continueScroll) {
			((AppiumDriver) appiumDriver).swipe(545, 1630, 545, 330, 2000);
			
			nearbyPlaceName.isDisplayed();
			list.clear();
			list.addAll(appiumDriver.findElements(By
					.xpath("//android.widget.TextView[contains(@resource-id, 'txtLocationName')]")));
			for (WebElement item : list) {
				placesNamesSet.add(item.getAttribute("text"));
			}
			continueScroll = placesNamesSet.size() > oldSetSize ? true : false;
			oldSetSize = placesNamesSet.size();
		}
		System.out.println("Set of nearby places:");
		for (String item : placesNamesSet) {
			System.out.println(item);
		}
		System.out.println("Total nearby places: " + placesNamesSet.size());
		return placesNamesSet.size() > 0;
	}

	public void goToTab1Vivino() {
		homeTab1Vivino.click();
	}

	public void goToTab4NearbyPlaces() {
		homeTab4NearbyPlaces.click();
	}

	public String getTitleText() {
		return titleText.getAttribute("text");
	}

	public boolean getActionProfileButton() {
		return actionProfileButton.isDisplayed();
	}

	// select first photo in opened gallery
	public RecognizedWinePage pickWinePhoto() {
		gallery.isDisplayed();
		((AppiumDriver) appiumDriver).tap(1, 170, 400, 100);
		cameraUseButton.click();
		return PageFactory.initElements(appiumDriver, RecognizedWinePage.class);
	}

	public void goToCamera() {
		cameraButton.isDisplayed();
		cameraButton.click();
	}

	public void goToGallery() {
		cameraGalleryButton.click();
	}

	public FriendsPage goToFriendsPage() {
		friendsButton.click();
		return PageFactory.initElements(appiumDriver, FriendsPage.class);
	}

	public UserProfilePage goToProfile() {
		actionProfileButton.click();
		return PageFactory.initElements(appiumDriver, UserProfilePage.class);
	}

}