package Generic_Utilities;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

public class Listeners_Implementation implements ITestListener {
	
	@Override
	public void onTestFailure(ITestResult result) { 
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailure(result);
		TakesScreenshot ts = (TakesScreenshot) BaseClass.sDriver;
		String screenshot = ts.getScreenshotAs(OutputType.BASE64);
		BaseClass.test.addScreenCaptureFromPath(screenshot);
		BaseClass.test.log(Status.FAIL, result.getName()+" is Failed");
		
	}
}
