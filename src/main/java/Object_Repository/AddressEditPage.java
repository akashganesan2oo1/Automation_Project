package Object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddressEditPage {
	
	public AddressEditPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "Address_PhoneNumber")
	private WebElement addressPhoneNumberTF;
	
	@FindBy(xpath = "//input[@value = 'Save']")
	private WebElement saveButton;

	public WebElement getAddressPhoneNumberTF() {
		return addressPhoneNumberTF;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

}
