package rahulshettyacademy.TestComponents;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.IRetryAnalyzer;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import rahulshettyacademy.resources.ExtentReporterNG;

public class Retry extends BaseTest implements IRetryAnalyzer
{

	int count =0;
	int maxTry = 1;
@Override
public boolean retry(ITestResult result) 
{
	if(count < maxTry)
	{
		count++;
	    return true ;
	}
	return false;
}


}