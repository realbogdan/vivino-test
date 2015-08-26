package vivino.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RecognizedWinePage extends Screen {

	public RecognizedWinePage(WebDriver webDriver) {
		super(webDriver);
	}
	
	@FindBy (how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id, 'winemiddel_textView')]")
	public WebElement wineNameTitle;
	
	public String getWineTitle() {
		return wineNameTitle.getAttribute("text");
	}
	
}