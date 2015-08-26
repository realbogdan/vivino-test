package vivino.tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import vivino.pages.AddFriendsPage;
import vivino.pages.CreateAnAccountPage;
import vivino.pages.FriendsPage;
import vivino.pages.HomePage;
import vivino.pages.NewProfilePage;
import vivino.pages.RecognizedWinePage;
import vivino.pages.SignUpWithEmailPage;
import vivino.pages.StartPage;
import vivino.pages.UserProfilePage;
import vivino.pages.WelcomeBackPage;

public class MobileDemoTest extends TestBase {
	
	@Test
	public void accountRegistration() {
	StartPage startPage = PageFactory.initElements(appiumDriver, StartPage.class);
	CreateAnAccountPage createAnAccountPage = startPage.goToCreateAnAccountPage();
	createAnAccountPage.swipeToLastScreen();
	SignUpWithEmailPage signUpWithEmail = createAnAccountPage.goToSignUpWithEmailPage();
	signUpWithEmail.fillEmail();
	signUpWithEmail.fillPassword();
	NewProfilePage newProfilePage = signUpWithEmail.clickDoneAndProceed();
	newProfilePage.fillName();
	newProfilePage.fillSurname();
	HomePage homePage = newProfilePage.clickDoneAndProceed();
	Assert.assertEquals(homePage.getTitleText(), "My Wines");
	homePage.goToTab1Vivino();
	UserProfilePage userProfile = homePage.goToProfile();
	Assert.assertEquals(userProfile.getProfileName(), "Bogdan Baraban");
	}
	
	@Test
	public void logIn() {
	StartPage startPage = PageFactory.initElements(appiumDriver, StartPage.class);
	WelcomeBackPage welcomeBackPage = startPage.goToWelcomePage();
	welcomeBackPage.fillEmail();
	welcomeBackPage.fillPassword();
	HomePage homePage = welcomeBackPage.clickLogInButtonAndProceed();
	Assert.assertEquals(homePage.getActionProfileButton(), true);
	}
	
	@Test
	public void recognizeVine() {
		StartPage startPage = PageFactory.initElements(appiumDriver, StartPage.class);
		WelcomeBackPage welcomeBackpage = startPage.goToWelcomePage();
		welcomeBackpage.fillEmail();
		welcomeBackpage.fillPassword();
		HomePage homePage = welcomeBackpage.clickLogInButtonAndProceed();
		homePage.goToCamera();
		homePage.goToGallery();
		RecognizedWinePage recognizedWinePage = homePage.pickWinePhoto();
		Assert.assertEquals(recognizedWinePage.getWineTitle(), "Baron de Lirondeau Rouge 2008");
	}
	
	@Test
	public void followUser() {
		StartPage startPage = PageFactory.initElements(appiumDriver, StartPage.class);
		WelcomeBackPage welcomeBackpage = startPage.goToWelcomePage();
		welcomeBackpage.fillEmail();
		welcomeBackpage.fillPassword();
		HomePage homePage = welcomeBackpage.clickLogInButtonAndProceed();
		FriendsPage friendsPage = homePage.goToFriendsPage();
		AddFriendsPage addFriendsPage = friendsPage.goToFindSomeFriends();
		addFriendsPage.goToSearch();
		addFriendsPage.fillUserNameToSearch();
		addFriendsPage.clickSearchIconButton();
		addFriendsPage.clickFollowFriend();
		Assert.assertEquals(addFriendsPage.getFollowButtonText(), "Following");
		Assert.assertEquals(addFriendsPage.goUpToFriendsPage().getFriendsUsername(), "Name D");
		Assert.assertEquals(friendsPage.goToFriendsProfile().unfollowUser(), true);
	}
	
	@Test
	public void checkNearbyPlaces() {
		StartPage startPage = PageFactory.initElements(appiumDriver, StartPage.class);
		WelcomeBackPage welcomeBackpage = startPage.goToWelcomePage();
		welcomeBackpage.fillEmail();
		welcomeBackpage.fillPassword();
		HomePage homePage = welcomeBackpage.clickLogInButtonAndProceed();
		homePage.goToTab4NearbyPlaces();
		Assert.assertEquals(homePage.checkNearbyPlacesPresence(), true);
	}
	
}