package Generic_Utilities;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;

public class WebdriverUtility {
	
	public static void takeScreenshotWebPage(WebDriver driver, String name) {
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./src/test/resources/ScreenShots/"+name+".png");
		try {
			FileHandler.copy(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void takeScreenshotWebElement(WebElement element, String name) {
		
		File src = element.getScreenshotAs(OutputType.FILE);
		File dest = new File("./src/test/resources/ScreenShots/"+name+".png");
		try {
			FileHandler.copy(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
