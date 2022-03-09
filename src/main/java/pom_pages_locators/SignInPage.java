package pom_pages_locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {
	public SignInPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="ap_email")
	public WebElement email;
	
	@FindBy(id="ap_password")
	public WebElement Password;
	
	@FindBy(id="signInSubmit")
	public WebElement signIn;
	
    @FindBy(id="continue")
    public WebElement continueButton;
    
//    @FindBy(xpath="//span[@id='cvf-submit-otp-button']")
//    public WebElement continueButton;
//    
    
}
