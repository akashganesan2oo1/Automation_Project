package Object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CompletedPage {

	public CompletedPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className = "title")
	private WebElement title;

	public WebElement getTitle() {
		return title;
	}
}
