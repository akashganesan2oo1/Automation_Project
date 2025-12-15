package Object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddressPage {
	
	public AddressPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@value = 'Add new']")
	private WebElement addNewButton;
	
	@FindBy(xpath = "//input[@value = 'Edit']")
	private WebElement editButton;
	
	@FindBy(xpath = "//strong[text() = 'Eren Yegar']/ancestor::div[@class = 'center-2']/descendant::input[@value = 'Delete']")
	private WebElement deleteButton;

	public WebElement getDeleteButton() {
		return deleteButton;
	}

	public WebElement getEditButton() {
		return editButton;
	}

	public WebElement getAddNewButton() {
		return addNewButton;
	}
	
}
