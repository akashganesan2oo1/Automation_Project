package Demo_Web_Shop_Project;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Generic_Utilities.BaseClass;
import Generic_Utilities.WebdriverUtility;
import Object_Repository.ApparelAndShoesPage;
import Object_Repository.HomePage;
import Object_Repository.ProductPage;
import Object_Repository.WishListPage;
@Listeners(Generic_Utilities.Listeners_Implementation.class)
public class WishListTest extends BaseClass {
	
	@Test(priority = 1, groups = {"smoke", "functional"})
	public void addToWishListTest() {
		
		ProductPage pp = new ProductPage(driver);
		ApparelAndShoesPage asp = new ApparelAndShoesPage(driver);
		HomePage hp = new HomePage(driver);
		hp.getApparelandSShoes().click();
		asp.getFrok().click();
		pp.getAddToWishListButton().click();
		hp.getWhishListLink().click();
		WebdriverUtility.takeScreenshotWebPage(driver, "addToWishListTest");
		test.log(Status.PASS, "Product Added to WishList");
	}
	
	@Test(priority = 2, groups = {"functional", "regression"})
	public void UpdateToWishListTest() {
		
		WishListPage wp = new WishListPage(driver);
		HomePage hp = new HomePage(driver);
		hp.getWhishListLink().click();
		WebElement quant = wp.getQuant();
		quant.clear();
		quant.sendKeys("10");
		wp.getUpdateWishListButton().click();
		String price = wp.getPrice().getText();
		int cost = (int) Double.parseDouble(price);
		cost = cost *10;
		String subTotal = wp.getSubTotal().getText();
		int cost2 = (int) Double.parseDouble(subTotal);
		Assert.assertEquals(cost, cost2);
		WebdriverUtility.takeScreenshotWebPage(driver, "UpdateToWishListTest");
		test.log(Status.PASS, "Quantity Updated Successfully");
	}
	
	@Test(priority = 3, groups = {"functional"})
	public void moveToCartTest() {
		
		WishListPage wp = new WishListPage(driver);
		HomePage hp = new HomePage(driver);
		hp.getWhishListLink().click();
		wp.getAddToCartCheckBox().click();
		wp.getAddToCartButton().click();
		Assert.assertEquals(driver.getTitle().contains("Cart"), true);
		WebdriverUtility.takeScreenshotWebPage(driver, "moveToCartTest");
		test.log(Status.PASS, "Product Added to Cart");
	}
	
	@Test(enabled = false, groups = "regression")
	public void removeFromWishList() {
		
		WishListPage wp = new WishListPage(driver);
		HomePage hp = new HomePage(driver);
		hp.getWhishListLink().click();
		wp.getRemoveFromWhishListCheckBox().click();
		wp.getUpdateWishListButton().click();
		WebElement result = wp.getResult();
		Assert.assertEquals(result.getText().contains("empty"), true);
		WebdriverUtility.takeScreenshotWebPage(driver, "moveToCartTest");
		test.log(Status.PASS, "Product Removed From WishList");
	}

}
