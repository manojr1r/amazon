package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class addToCartPage {
	public WebDriver driver;
	
	private By quantity = By.xpath("//select[@name='quantity']");
	private By selectQuantity = By.name("quantityBox");
	private By updateQuantitybutton = By.linkText("Update");
	public By priceForOne = By.xpath("//p/span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap sc-product-price a-text-bold']");
	private By VerifyCorrectItemAdded =By.xpath("//span[@class='a-truncate-cut']");                                 
	private By priceForTen = By.xpath("//span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap']");
	private By alert = By.linkText("product detail page");
	private By delete = By.xpath("//input[@value='Delete']");
	
	public By verify = By.xpath("//div[@class='a-row sc-cart-header']/div/h1[@class='a-spacing-mini a-spacing-top-base']");
	
	
	public WebElement VerifyCorrectItemAdded()
	{
		return driver.findElement(VerifyCorrectItemAdded);
		
	}
	public WebElement verify()
	{
		return driver.findElement(verify);
	}
	public WebElement delete()
	{
		return driver.findElement(delete);
	}
	
	public Select StaticdropDown ()
	{
		WebElement staticDropdown = driver.findElement(quantity);
		Select dropdown = new Select(staticDropdown);
		return dropdown;
	}
	public WebElement priceForTen()
	{
		return driver.findElement(priceForTen);
	}
	public List<WebElement> alert()
	{
		return driver.findElements(alert);
	}
	public WebElement priceForOne()
	{
		return driver.findElement(priceForOne);
	}
	public WebElement selectQuantity()
	{
		return driver.findElement(selectQuantity);
	}
	public WebElement updateQuantitybutton()
	{
		return driver.findElement(updateQuantitybutton);
	}
	
	public WebElement quantity()
	{
		return driver.findElement(quantity);
	}
	
	public addToCartPage(WebDriver driver) {
		this.driver = driver;
	}

	
		
}
