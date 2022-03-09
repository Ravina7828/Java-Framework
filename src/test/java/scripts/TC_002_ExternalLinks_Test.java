package scripts;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import generic_library.BaseTest;
import pom_pages.Home;

public class TC_002_ExternalLinks_Test extends BaseTest{
	public static WebDriver driver;

	@Test(priority=0)
	public void testcase_02() throws FileNotFoundException, IOException, InterruptedException {
		extentTest = extent.startTest("testcase_02");
		Home h1 = new Home(BaseTest.driver);
		h1.openAllLinks();
	}
	

}
















