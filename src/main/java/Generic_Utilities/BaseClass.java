package Generic_Utilities;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Object_Repository.HomePage;
import Object_Repository.LoginPage;
import Object_Repository.WelcomePage;
@Listeners(Generic_Utilities.Listeners_Implementation.class)
public class BaseClass {
	
	public WebDriver driver;
	public static WebDriver sDriver;
	public WebDriverWait wait;
	public ExtentReports reports;
	public static ExtentTest test;
	@BeforeSuite
	public void configureReport() {
		
		ExtentSparkReporter spark = new ExtentSparkReporter("./src/test/resources/reports/Report_"+java_Utility.getName()+".html");
		reports = new ExtentReports();
		reports.attachReporter(spark);
	}
	
	@Parameters("browser")
	@BeforeClass(alwaysRun = true)
	public void launchBrowser(@Optional("chrome") String browser) {
		
		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} 
		
		sDriver = driver;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(File_Utility.getPropertyData("url"));
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		Reporter.log("Browser launched successfully", true);
	}
	
	@BeforeMethod(alwaysRun = true)
	public void login(Method method) {
		
		test = reports.createTest(method.getName());
		test.log(Status.INFO, "Welcome Page Displayed Successfully");
		WelcomePage wp = new WelcomePage(driver);
		wp.getLoginLink().click();
		LoginPage lp = new LoginPage(driver);
		lp.getEmailTF().sendKeys(File_Utility.getPropertyData("email"));
		lp.getPasswordTF().sendKeys(File_Utility.getPropertyData("password"));
		test.log(Status.INFO, "User Logged In Successfully");
		lp.getLoginButton().click();
		Reporter.log("logged in successfully",true);
	}
	
	@AfterMethod(alwaysRun = true)
	public void logout() {
		HomePage hp = new HomePage(driver);
		hp.getLogoutLink().click();
		Reporter.log("logged out successfully",true);
	}
	
	@AfterClass(alwaysRun = true)
	public void quitBrowser() {
		
		driver.quit();
		Reporter.log("Browser closed successfully",true );
	}
	
	@AfterSuite(alwaysRun = true)
	public void saveReport() {
		
		reports.flush();
	}

}
