package Demo_Web_Shop_Project;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;
import Generic_Utilities.File_Utility;
import Object_Repository.AddressAddPage;
import Object_Repository.AddressEditPage;
import Object_Repository.AddressPage;
import Object_Repository.HomePage;
@Listeners(Generic_Utilities.Listeners_Implementation.class)
public class AddressTest extends BaseClass{
	
	@Test(priority = 1)
	public void addAddressTest() {
		
		AddressAddPage aap = new AddressAddPage(driver);
		AddressPage ap = new AddressPage(driver);
		HomePage hp = new HomePage(driver);
		hp.getAddressLink().click();
		ap.getAddNewButton().click();
		
		aap.getAddressFirstNameTF().sendKeys(File_Utility.getPropertyData("FirstName"));
		aap.getAddressLastNameTF().sendKeys(File_Utility.getPropertyData("LastName"));
		aap.getAddressEmailTF().sendKeys(File_Utility.getPropertyData("email"));
		WebElement country = aap.getCountryDropDown();
		Select select = new Select(country);
		select.selectByValue("1");
		WebElement state = aap.getStateDropDown();
		Select select2 = new Select(state);
		select2.selectByVisibleText("California");
		aap.getAddressCityTF().sendKeys(File_Utility.getPropertyData("City"));
		aap.getAddressAddress1TF().sendKeys(File_Utility.getPropertyData("Add1"));
		aap.getAddressZipTF().sendKeys(File_Utility.getPropertyData("Zip"));
		aap.getAddressPhoneNumberTF().sendKeys(File_Utility.getPropertyData("PhNo"));
		aap.getSaveButton().click();
		Assert.assertEquals(driver.getCurrentUrl().contains("addresses"), true);
		
	}
	
	@Test(priority = 2)
	public void editAddressTest() {
		
		AddressEditPage aep = new AddressEditPage(driver);
		AddressPage ap = new AddressPage(driver);
		HomePage hp = new HomePage(driver);
		hp.getAddressLink().click();
		ap.getEditButton().click();
		wait.until(ExpectedConditions.urlContains("https://demowebshop.tricentis.com/customer/addressedit"));
		WebElement number = aep.getAddressPhoneNumberTF();
		number.clear();
		number.sendKeys("1234567890");
		aep.getSaveButton().click();
				
	}
	
	@Test(priority = 3)
	public void deleteAddressTest() {
		
		AddressPage ap = new AddressPage(driver);
		HomePage hp = new HomePage(driver);
		hp.getAddressLink().click();
		ap.getDeleteButton().click();
		
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

}
