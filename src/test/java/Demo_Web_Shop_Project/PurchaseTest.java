package Demo_Web_Shop_Project;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Generic_Utilities.BaseClass;
import Object_Repository.CompletedPage;
import Object_Repository.HomePage;
import Object_Repository.OnePageCheckoutPage;
import Object_Repository.ShoppingCartPage;
@Listeners(Generic_Utilities.Listeners_Implementation.class)
public class PurchaseTest extends BaseClass {
	
	@Test(groups = "smoke")
	public void codTest() {
		
		HomePage hp = new HomePage(driver);
		ShoppingCartPage scp = new ShoppingCartPage(driver);
		OnePageCheckoutPage opcp = new OnePageCheckoutPage(driver);
		CompletedPage cp = new CompletedPage(driver);
		hp.getShoppingCartLink().click();
		WebElement cart = scp.getProductLink();
		Assert.assertEquals(cart.getText().contains("Laptop"), true);
		scp.getCheckBox().click();
		scp.getCheckoutButton().click();
		opcp.getBillingAddressContinueButton().click();
		opcp.getInstorepickupCheckbox().click();
		opcp.getShippingAddressContinueButton().click();
		opcp.getCodRadioButton().click();
		opcp.getPaymentMethodContinueButton().click();
		opcp.getPaymentInfoContinueButton().click();
		String prod = opcp.getProductComparition().getText();
		Assert.assertEquals(prod.contains("Laptop"), true);
		opcp.getConfirmButton().click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String placed =cp.getTitle().getText();
		Assert.assertEquals(placed, "Your order has been successfully processed!");
		test.log(Status.PASS, placed);
	}
	
	@Test(groups = "smoke")
	public void checkTest() {
		
		HomePage hp = new HomePage(driver);
		ShoppingCartPage scp = new ShoppingCartPage(driver);
		OnePageCheckoutPage opcp = new OnePageCheckoutPage(driver);
		CompletedPage cp = new CompletedPage(driver);
		hp.getShoppingCartLink().click();
		WebElement cart = scp.getProductLink();
		Assert.assertEquals(cart.getText().contains("Laptop"), true);
		scp.getCheckBox().click();
		scp.getCheckoutButton().click();
		opcp.getBillingAddressContinueButton().click();
		opcp.getInstorepickupCheckbox().click();
		opcp.getShippingAddressContinueButton().click();
		opcp.getCheckRadioButton().click();
		opcp.getPaymentMethodContinueButton().click();
		opcp.getPaymentInfoContinueButton().click();
		String prod = opcp.getProductComparition().getText();
		Assert.assertEquals(prod.contains("Laptop"), true);
		opcp.getConfirmButton().click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String placed =cp.getTitle().getText();
		Assert.assertEquals(placed, "Your order has been successfully processed!");
		test.log(Status.PASS, placed);
	}

}
