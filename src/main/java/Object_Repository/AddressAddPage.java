package Object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddressAddPage {
	
	public AddressAddPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "Address_FirstName")
	private WebElement addressFirstNameTF;
	
	@FindBy(id = "Address_LastName")
	private WebElement addressLastNameTF;
	
	@FindBy(id = "Address_Email")
	private WebElement addressEmailTF;
	
	@FindBy(xpath = "(//select[@data-val = 'true'])[1]")
	private WebElement countryDropDown;
	
	@FindBy(xpath = "(//select[@data-val = 'true'])[2]")
	private WebElement stateDropDown;
	
	@FindBy(id = "Address_City")
	private WebElement addressCityTF;
	
	@FindBy(id = "Address_Address1")
	private WebElement addressAddress1TF;
	
	@FindBy(id = "Address_ZipPostalCode")
	private WebElement addressZipTF;
	
	@FindBy(id = "Address_PhoneNumber")
	private WebElement addressPhoneNumberTF;
	
	@FindBy(xpath = "//input[@value = 'Save']")
	private WebElement saveButton;

	public WebElement getAddressFirstNameTF() {
		return addressFirstNameTF;
	}

	public WebElement getAddressLastNameTF() {
		return addressLastNameTF;
	}

	public WebElement getAddressEmailTF() {
		return addressEmailTF;
	}

	public WebElement getCountryDropDown() {
		return countryDropDown;
	}

	public WebElement getStateDropDown() {
		return stateDropDown;
	}

	public WebElement getAddressCityTF() {
		return addressCityTF;
	}

	public WebElement getAddressAddress1TF() {
		return addressAddress1TF;
	}

	public WebElement getAddressZipTF() {
		return addressZipTF;
	}

	public WebElement getAddressPhoneNumberTF() {
		return addressPhoneNumberTF;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

}
