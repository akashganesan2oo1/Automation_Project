package Demo_Web_Shop_Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;

import Generic_Utilities.BaseClass;
import Object_Repository.HomePage;
import Object_Repository.SearchPage;
import Object_Repository.ShoppingCartPage;
@Listeners(Generic_Utilities.Listeners_Implementation.class)
public class CartTest extends BaseClass { 
	
	@Test(priority = 1, groups ="smoke")
	public void addToCart() {
		
		ShoppingCartPage scp = new ShoppingCartPage(driver);
		SearchPage sp = new SearchPage(driver);
		HomePage hp = new HomePage(driver);
		Assert.assertEquals(driver.getTitle(), "Demo Web Shop");
		hp.getSearchTF().sendKeys("Laptop");
		hp.getSearchButton().click();
		wait.until(ExpectedConditions.titleContains("Search"));
		Assert.assertEquals(driver.getTitle().contains("Search"), true);
		sp.getAddToCartButton().click();
		Actions action = new Actions(driver);
		WebElement link = hp.getShoppingCartLink();
		action.moveToElement(link).perform();
		link.click();
		WebElement cart = scp.getProductLink();
		Assert.assertEquals(cart.getText().contains("Laptop"), true);
		test.log(Status.PASS, "Product Added Successfully");
	}
	
	@Test(priority = 2)
	public void updateProductToCart() {
		
		ShoppingCartPage scp = new ShoppingCartPage(driver);
		HomePage hp = new HomePage(driver);
		hp.getShoppingCartLink().click();
		WebElement subTotal1 = scp.getSubTotal1();
		String text = subTotal1.getText();
		WebElement quant = scp.getQuant();
		quant.clear();
		quant.sendKeys("10");
		scp.getUpdateCartButton().click();
		WebElement subTotal2 = scp.getSubTotal2();
		String text2 = subTotal2.getText();
		int cost = (int) Double.parseDouble(text);
		cost = cost*10;
		int cost2 = (int) Double.parseDouble(text2);
		Assert.assertEquals(cost, cost2);
		test.log(Status.PASS, "Quantity Updated Successfully");
		
	}
	
	@Test(priority = 3, groups = "regression")
	public void removeFromCart() {
		
		ShoppingCartPage scp = new ShoppingCartPage(driver);
		HomePage hp = new HomePage(driver);
		hp.getShoppingCartLink().click();
		scp.getRemoveFromCartCheckBox().click();
		scp.getUpdateCartButton().click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("order-summary-content")));
		test.log(Status.PASS, "Product Removed Successfully");
	}

}
