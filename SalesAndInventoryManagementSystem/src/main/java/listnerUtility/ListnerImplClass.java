package listnerUtility;

import java.util.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import baseClassUtility.BaseClass;
import webDriverUtility.UtilityClassObject;


public class ListnerImplClass implements ITestListener, ISuiteListener {
	public static ExtentReports report;
	public ExtentSparkReporter spark;
	ExtentTest test;
	public void onStart(ISuite suite) {
		//Step-1: ExtentSparkReporter object creation and configure the report
		String time = new Date().toString().replace(" ", "-").replace(":", "_");
		spark = new ExtentSparkReporter("./AdvanceReport/report_"+time+".html");
		spark.config().setDocumentTitle("SIMS Test suite Results");
		spark.config().setReportName("SIMS Report");
		spark.config().setTheme(Theme.DARK);
		
		//Step-2: Add environment information and create test
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "windows-10");
		report.setSystemInfo("Browser", "Chrome");
		
	}
	public void onFinish(ISuite suite) {
		System.out.println(suite.getName().getClass()+" End..");
		report.flush();
	}
	public void onTestStart(ITestResult result) {
		System.out.println(result.getMethod().getMethodName()+" start");
		test = report.createTest(result.getMethod().getMethodName());
		UtilityClassObject.setTest(test);
		test.log(Status.INFO,result.getMethod().getMethodName()+" started");
	}
	public void onTestSucess(ITestResult result) {
		System.out.println(result.getMethod().getMethodName()+" End");
		test.log(Status.PASS, result.getMethod().getMethodName()+" completed");
		
	}
	public void onTestFailure(ITestResult result) {
		String testName = result.getMethod().getMethodName();
		TakesScreenshot ts =  (TakesScreenshot)BaseClass.sdriver;
		String src = ts.getScreenshotAs(OutputType.BASE64);
		String	time=new Date().toString().replace(" ", "_").replace(":", "_");
		test.addScreenCaptureFromBase64String(src, testName+"_"+time);
		test.log(Status.FAIL,result.getMethod().getMethodName()+" failed");
	}
	public void onTestSkipped(ITestResult result) {
		System.out.println(result.getMethod().getMethodName());
		
	}
	public void onTestFailedButWithinSucessPercentage(ITestResult result) {

	}
	public void onStart(ITestContext context) {
		
	}
	public void onFinish(ITestContext context) {
	}
	

}
