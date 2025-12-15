package Object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	
	public ProductPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@value = 'Add to wishlist']")
	private WebElement addToWishListButton;

	public WebElement getAddToWishListButton() {
		return addToWishListButton;
	}

}
