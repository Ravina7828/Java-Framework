package pom_pages;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;

import generic_library.WebDriverutilities;
import pom_pages_locators.HomePage;
import pom_pages_locators.SignInPage;

public class Sign_in extends HomePage{
	public WebDriverutilities utils;
	public SignInPage sign ;
	public Sign_in(WebDriver driver) {
		super(driver);
		utils =  new WebDriverutilities();
		sign = new SignInPage(driver);
		
	}
	
	public void SignIn(String email,String password ) throws InterruptedException, FileNotFoundException, IOException {
		WebDriverutilities.verify_title("Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
		WebDriverutilities.click(account_list);
		WebDriverutilities.verify_title("Amazon Sign In");
		WebDriverutilities.type_text(sign.email, email);
		WebDriverutilities.click(sign.continueButton);
		WebDriverutilities.type_text(sign.Password, password);
		WebDriverutilities.click(sign.signIn);
	}
}
