package generic_library;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import io.github.bonigarcia.wdm.managers.EdgeDriverManager;
import io.github.bonigarcia.wdm.managers.FirefoxDriverManager;
import io.github.bonigarcia.wdm.managers.InternetExplorerDriverManager;

public class BaseTest implements Constants {
	public static WebDriver driver;
	public static ExtentReports extent;
	public static ExtentTest extentTest;
	public PropertyFile pdata = new PropertyFile();
	
	@BeforeSuite
	public void setExtentReport() {
		extent = new ExtentReports(extent_path);
		extent.addSystemInfo("Project Name", "Amazon");
		
	}
	 @BeforeMethod
	  @Parameters("browsers")
	  public void verifyBrowsers(String browser_name) throws FileNotFoundException, IOException {
		  ChromeOptions options = new ChromeOptions();
		  options.addArguments("start-maximized");
//		  options.addArguments("headless");
		  options.addArguments("disable-extensions");
		  options.addArguments("disable-infobars");
		  if(browser_name.equalsIgnoreCase("chrome")){
			  ChromeDriverManager.chromedriver().setup();
			  driver = new ChromeDriver(options);
		  }
		  else if(browser_name.equalsIgnoreCase("firefox")) {
			  FirefoxDriverManager.firefoxdriver().setup();
			  driver = new FirefoxDriver();
		  }
		  else if(browser_name.equalsIgnoreCase("microsoft_edge")) {
			  EdgeDriverManager.edgedriver().setup();
			  driver = new EdgeDriver();
		  }
		  else if(browser_name.equalsIgnoreCase("explorer")) {
			  InternetExplorerDriverManager.iedriver().setup();
			  driver = new InternetExplorerDriver();
		  }
		  else {
			  System.out.println("No browser found");
		  }

		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		  driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	      driver.get(pdata.getData("URL"));
	  }
	 
	 
	@AfterMethod
	public void teardown(ITestResult result) throws IOException {
		if(result.getStatus()==ITestResult.FAILURE){
			extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS "+result.getName()); //to add name in extent report
			extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS "+result.getThrowable()); //to add error/exception in extent report
			
			String screenshotPath = BaseTest.getScreenshot(driver, result.getName());
			extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath)); //to add screenshot in extent report
			//extentTest.log(LogStatus.FAIL, extentTest.addScreencast(screenshotPath)); //to add screencast/video in extent report
		}
		else if(result.getStatus()==ITestResult.SKIP){
			extentTest.log(LogStatus.SKIP, "Test Case SKIPPED IS " + result.getName());
		}
		else if(result.getStatus()==ITestResult.SUCCESS){
			extentTest.log(LogStatus.PASS, "Test Case PASSED IS " + result.getName());
		}
	    driver.quit();

	}
	
	public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException {
//		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());// to 
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		// after execution, you can see screenshot in a folder "Photo"
		String destination = Screenshot_path + screenshotName + ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
		
	}
	
	@AfterSuite
	public void endExtentReport() {
//		extent.endTest(extentTest); //ending test and ends the current test and prepare to create html report
		extent.flush();
//		extent.close();


		
		
	}
}

	



