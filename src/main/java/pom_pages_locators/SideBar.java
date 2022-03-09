package pom_pages_locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SideBar {
	private WebDriver driver;

	public SideBar(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	@FindBy(id="nav-hamburger-menu")
	public WebElement sidebar;
	
   
    
    
    
}
