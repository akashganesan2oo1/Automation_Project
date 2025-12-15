package Object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	public HomePage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Log out")
	private WebElement logoutLink;
	
	@FindBy(name = "q")
	private WebElement searchTF;
	
	@FindBy(xpath = "//input[@value = 'Search']")
	private WebElement searchButton;
	
	@FindBy(linkText = "Shopping cart")
	private WebElement shoppingCartLink;
	
	@FindBy(linkText = "Apparel & Shoes")
	private WebElement apparelandSShoes;
	
	@FindBy(xpath = "//span[text() = 'Wishlist']")
	private WebElement whishListLink;
	
	@FindBy(linkText = "Addresses")
	private WebElement addressLink;
	

	public WebElement getAddressLink() {
		return addressLink;
	}

	public WebElement getWhishListLink() {
		return whishListLink;
	}

	public WebElement getApparelandSShoes() {
		return apparelandSShoes;
	}

	public WebElement getShoppingCartLink() {
		return shoppingCartLink;
	}

	public WebElement getSearchTF() {
		return searchTF;
	}

	public WebElement getSearchButton() {
		return searchButton;
	}

	public WebElement getLogoutLink() {
		return logoutLink;
	}
	
	

}
