package Object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {
	
	public ShoppingCartPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "14.1-inch Laptop")
	private WebElement productLink;
	
	@FindBy(xpath = "//a[text() = '14.1-inch Laptop']/ancestor::tr[@class = 'cart-item-row']/descendant::span[@class = 'product-subtotal']")
	private WebElement subTotal1;
	
	@FindBy(xpath = "//a[text() = '14.1-inch Laptop']/ancestor::tr[@class = 'cart-item-row']/descendant::input[contains(@name , 'itemquantity')]")
	private WebElement quant;
	
	@FindBy(name = "updatecart")
	private WebElement updateCartButton;
	
	@FindBy(xpath = "//a[text() = '14.1-inch Laptop']/ancestor::tr[@class = 'cart-item-row']/descendant::span[@class = 'product-subtotal']")
	private WebElement subTotal2;
	
	@FindBy(xpath = "//tr[@class = 'cart-item-row']/descendant::a[text() = '14.1-inch Laptop']/ancestor::td/..//input[@name = 'removefromcart']")
	private WebElement removeFromCartCheckBox;
	
	@FindBy(id = "termsofservice")
	private WebElement checkBox;
	
	@FindBy(id = "checkout")
	private WebElement checkoutButton;

	public WebElement getRemoveFromCartCheckBox() {
		return removeFromCartCheckBox;
	}

	public WebElement getCheckBox() {
		return checkBox;
	}

	public WebElement getCheckoutButton() {
		return checkoutButton;
	}

	public WebElement getSubTotal2() {
		return subTotal2;
	}

	public WebElement getUpdateCartButton() {
		return updateCartButton;
	}

	public WebElement getQuant() {
		return quant;
	}

	public WebElement getSubTotal1() {
		return subTotal1;
	}

	public WebElement getProductLink() {
		return productLink;
	}

}
