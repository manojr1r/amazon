package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	public WebDriver driver;
	
	
	By searchBox = By.id("twotabsearchtextbox");
	By clickSearchBox = By.id("nav-search-submit-button");
	
	
	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement searchBox()
	{
		return driver.findElement(searchBox);
	}
	public WebElement ClicksearchBox()
	{
		return driver.findElement(clickSearchBox);
		
	}

}
