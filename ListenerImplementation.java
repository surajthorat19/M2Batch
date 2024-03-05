package CommonUtil;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementation implements ITestListener

{
	ExtentReports report;

	public void onTestStart(ITestResult result)
	{
		String methodName = result.getMethod().getMethodName();
		Reporter.log(methodName+"TestScript execution is started",true);
		
	}

	public void onTestSuccess(ITestResult result) 
	{
		String methodName = result.getMethod().getMethodName();
	//	Reporter.log(methodName+"TestScript execution is passed",true);
		
	}

	public void onTestFailure(ITestResult result) 
	{
		String message = result.getThrowable().toString();        // it will show the error in html report
		String methodName = result.getMethod().getMethodName();   // it will give the method name
		Reporter.log(methodName+"TestScript execution is failed",true);
		
	}

	public void onTestSkipped(ITestResult result) 
	{
		String methodName = result.getMethod().getMethodName();
		Reporter.log(methodName+"TestScript execution is skipped ",true);
	
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
	{
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedWithTimeout(ITestResult result) 
	{
		// TODO Auto-generated method stub
		
	}

	
	public void onStart(ITestContext context) 
	{
	
	//	Reporter.log("TestScript execution is ",true);
	 JavaUtil jUtil=new JavaUtil();
	 
		
	// Use ExtentSparkReporter class just to configure extent report	
		ExtentSparkReporter reporter=new ExtentSparkReporter("./extentreport/report"+jUtil.getRandomNumber()+".html");
		reporter.config().setDocumentTitle("vtigercrm");
		reporter.config().setTheme(Theme.DARK);
		reporter.config().setReportName("Pune");
		
// Use ExtentReports class to generate ExtentReport		
		report= new ExtentReports();               // ExtentReports class we wont write here bcz wa write in class so i create global bcz i have to access onFinish also
		report.attachReporter(reporter);
		report.setSystemInfo("OS", "Window");
		report.setSystemInfo("Browser", "Chrome");
		report.setSystemInfo("chromeversion", "121");
		report.setSystemInfo("Author", "Suraj");
		
		
		
	}

	public void onFinish(ITestContext context)
	{
		
	//	Reporter.log("TestScript execution is finish",true);
		
		report.flush();
		
	}

	

}
