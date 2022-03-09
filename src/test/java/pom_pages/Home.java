package pom_pages;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;

import generic_library.BaseTest;
import generic_library.PropertyFile;
import generic_library.WebDriverutilities;
import pom_pages_locators.HomePage;

public class Home extends HomePage{
//	public WebDriver driver;
	public WebDriverutilities utils;
	public PropertyFile pdata = new PropertyFile();
	public Home(WebDriver driver) {
		super(driver);
		utils =  new WebDriverutilities();
	}
	
	public void openAllLinks() throws FileNotFoundException, InterruptedException, IOException {
		Sign_in s1 = new Sign_in(BaseTest.driver);
		s1.SignIn(pdata.getData("MOBILE_NUMBER"), pdata.getData("PASSWORD"));
		WebDriverutilities.wait_for_element(account_list);
	}

}


