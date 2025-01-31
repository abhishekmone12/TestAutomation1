package rahulshettyacademy.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG 
{

	
	public void getReportObject() {
		
		//getReportObject method creates test entry and gives object 
		
		String path = System.getProperty("user.dir") + "//reports/index.html";
	 	ExtentSparkReporter reporter = new ExtentSparkReporter(path);
	 	reporter.config().setReportName("Automation Test Results");
	 	reporter.config().setDocumentTitle("Test Results");
	 	
	 	
	 	
	 	ExtentReports extent = new ExtentReports();
	 	extent.attachReporter(reporter);
	 	extent.setSystemInfo("Tester", "Ravi");
	 	
	}
}
