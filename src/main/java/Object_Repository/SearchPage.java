package Object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
	
	public SearchPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "(//h2[@class = 'product-title'])[1]/ancestor::div[@class = 'item-box']//input[@value = 'Add to cart']")
	private WebElement addToCartButton;

	public WebElement getAddToCartButton() {
		return addToCartButton;
	}
	
	

}

