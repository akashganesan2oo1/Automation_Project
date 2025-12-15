package Object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OnePageCheckoutPage {

	public OnePageCheckoutPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "(//input[@class = 'button-1 new-address-next-step-button'])[1]")
	private WebElement billingAddressContinueButton;
	
	@FindBy(id = "PickUpInStore")
	private WebElement instorepickupCheckbox;
	
	@FindBy(xpath = "(//input[@class = 'button-1 new-address-next-step-button'])[2]")
	private WebElement shippingAddressContinueButton;
	
	@FindBy(xpath = "//input[@value = 'Payments.CashOnDelivery']")
	private WebElement codRadioButton;
	
	@FindBy(xpath = "//input[@value = 'Payments.CheckMoneyOrder']")
	private WebElement checkRadioButton;
	
	@FindBy(xpath = "//input[@value = 'Payments.Manual']")
	private WebElement creditCardRadioButton;

	@FindBy(xpath = "//input[@value = 'Payments.PurchaseOrder']")
	private WebElement purvhaseOrderRadioButton;
	
	@FindBy(xpath = "//input[@class = 'button-1 payment-method-next-step-button']")
	private WebElement paymentMethodContinueButton;
	
	@FindBy(xpath = "//input[@class='button-1 payment-info-next-step-button']")
	private WebElement paymentInfoContinueButton;
	
	@FindBy(xpath = "(//a[text() = '14.1-inch Laptop'])[2]")
	private WebElement productComparition;
	
	@FindBy(xpath = "//input[@value= 'Confirm']")
	private WebElement confirmButton;

	public WebElement getBillingAddressContinueButton() {
		return billingAddressContinueButton;
	}

	public WebElement getInstorepickupCheckbox() {
		return instorepickupCheckbox;
	}

	public WebElement getShippingAddressContinueButton() {
		return shippingAddressContinueButton;
	}

	public WebElement getCodRadioButton() {
		return codRadioButton;
	}

	public WebElement getCheckRadioButton() {
		return checkRadioButton;
	}

	public WebElement getCreditCardRadioButton() {
		return creditCardRadioButton;
	}

	public WebElement getPurvhaseOrderRadioButton() {
		return purvhaseOrderRadioButton;
	}

	public WebElement getPaymentMethodContinueButton() {
		return paymentMethodContinueButton;
	}

	public WebElement getPaymentInfoContinueButton() {
		return paymentInfoContinueButton;
	}

	public WebElement getProductComparition() {
		return productComparition;
	}

	public WebElement getConfirmButton() {
		return confirmButton;
	}
	
}
