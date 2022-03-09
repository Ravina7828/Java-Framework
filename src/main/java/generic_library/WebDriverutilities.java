package generic_library;

import static org.testng.Assert.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class WebDriverutilities {
	public static WebDriver driver;
	public WebDriverutilities() {
		driver = BaseTest.driver;
	}
	
	public static WebElement wait_for_element(WebElement e1) {
		WebDriverWait wait = new WebDriverWait (driver, 20);
		WebElement element = wait.until(ExpectedConditions.visibilityOf(e1));
		assertTrue(element.isDisplayed());
		return element;
	}
	
	public static void verify_title(String el) {
		String title = driver.getTitle();
	    Assert.assertEquals(title, el);
	}
	
	public static void click(WebElement el) {
		wait_for_element(el).click();
	}
	
	public static void type_text(WebElement el, String text) {
		wait_for_element(el).sendKeys(text);
	}


	public static void movetoelemet(WebElement el) {
		Actions ac = new Actions(driver);
		ac.moveToElement(el).perform();
	}
	
	public static void scroll(int x , int y) {
		JavascriptExecutor js =(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy("+x+","+y+")");
	}
	public static void dropDown(WebElement ele,String text) {
		   Select s=new Select(ele);
		   s.selectByVisibleText(text);
	   }
	
	//Actions Class Methods -->>
	   public static void mouseHover(WebElement ele) {
		   Actions a=new Actions(driver);
		   a.moveToElement(ele).perform();
	   }
	   public static void doubleClick(WebElement ele) {
		   Actions a=new Actions(driver);
		   a.doubleClick(ele).perform();
	   }
	   public static void rightClick(WebElement ele) {
		   Actions a=new Actions(driver);
		   a.contextClick(ele).perform();
	   }
	   
	   //Switching one frame to another
	   public static void switchToframe() {
		   driver.switchTo().frame(0);
		   
	   }
	   //to accept alert methods
	   public static void alertPopup() {
		   driver.switchTo().alert().accept();
	   }
	   //Navigate methods
	   public static void navBack() {
		   driver.navigate().back();
	   }
	   public static void navForword() {
		   driver.navigate().forward();
	   }
	   public static void navRefresh() {
		   driver.navigate().refresh();
	   }
	   

}
