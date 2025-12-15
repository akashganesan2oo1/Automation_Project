package Object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WishListPage {
	
	public WishListPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[contains(@name , 'itemquantity')]")
	private WebElement quant;
	
	@FindBy(name = "updatecart")
	private WebElement updateWishListButton;
	
	@FindBy(className = "product-unit-price")
	private WebElement price;
	
	@FindBy(className = "product-subtotal")
	private WebElement subTotal;
	
	@FindBy(xpath = "//a[text() = \"50's Rockabilly Polka Dot Top JR Plus Size\"]/ancestor::tr/descendant::input[@name = \"addtocart\"]")
	private WebElement addToCartCheckBox;
	
	@FindBy(name = "addtocartbutton")
	private WebElement addToCartButton;
	
	@FindBy(xpath = "//a[text() = \"50's Rockabilly Polka Dot Top JR Plus Size\"]/ancestor::tr/descendant::input[@name = \"removefromcart\"]")
	private WebElement removeFromWhishListCheckBox;
	
	@FindBy(xpath = "//div[@class = 'wishlist-content']")
	private WebElement result;

	public WebElement getResult() {
		return result;
	}

	public WebElement getRemoveFromWhishListCheckBox() {
		return removeFromWhishListCheckBox;
	}

	public WebElement getAddToCartButton() {
		return addToCartButton;
	}

	public WebElement getAddToCartCheckBox() {
		return addToCartCheckBox;
	}

	public WebElement getSubTotal() {
		return subTotal;
	}

	public WebElement getPrice() {
		return price;
	}

	public WebElement getUpdateWishListButton() {
		return updateWishListButton;
	}

	public WebElement getQuant() {
		return quant;
	}

}
