package scripts;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import generic_library.BaseTest;
import generic_library.PropertyFile;
import pom_pages.Sign_in;

public class TC_001_Login_Test extends BaseTest{
	public static WebDriver driver;
	String data ;
	public PropertyFile pdata = new PropertyFile();
	
	public TC_001_Login_Test() throws FileNotFoundException, IOException {
//		String data = pdata.getData("text");

	}
	
	@Test(priority=1)
	public void testcase_01() throws FileNotFoundException, IOException, InterruptedException {
		extentTest = extent.startTest("testcase_01");
		Sign_in s1 = new Sign_in(BaseTest.driver);
		
		s1.SignIn(pdata.getData("MOBILE_NUMBER"), pdata.getData("PASSWORD"));
	}
	

}
















