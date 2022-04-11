package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SelectedLinkPage {
	public WebDriver driver;
	
	private By quantity = By.id("quantity");
	public By addToCart = By.cssSelector("#add-to-cart-button");
	private By clickCart = By.id("nav-cart-count");
	
	private By verifyPage =By.id("productTitle");
	
	
	
	private By closePopup = By.id("attach-close_sideSheet-link");
	
	
//	List<WebElement> searchResults = driver.findElements(By.className("a-size-medium"));
	
	public WebElement verifyPage()
	{
		return driver.findElement(verifyPage);
	}
	
	public SelectedLinkPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public List<WebElement> closePopup()
	{
		return  driver.findElements(closePopup);
	}

	public WebElement addToCart()
	{
		return driver.findElement(addToCart);
	}
	public WebElement quantity()
	{
		return driver.findElement(quantity);
		
	}
	public WebElement staticDropdown()
	{
		return driver.findElement(quantity);
		
	}
	public WebElement clickCart()
	{
		return driver.findElement(clickCart);
	}

}
