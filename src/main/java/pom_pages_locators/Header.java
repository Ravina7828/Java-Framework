package pom_pages_locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Header {

	public Header(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	@FindBy(name="url")
	public WebElement header_dropdown;
	
	@FindBy(id="twotabsearchtextbox")
	public WebElement search_bar;
   
    
    
    
}
