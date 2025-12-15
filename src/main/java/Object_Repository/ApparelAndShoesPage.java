package Object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ApparelAndShoesPage {
	
	public ApparelAndShoesPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "50's Rockabilly Polka Dot Top JR Plus Size")
	private WebElement frok;

	public WebElement getFrok() {
		return frok;
	}

}
