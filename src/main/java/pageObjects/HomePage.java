// package pageObjects;

// import java.util.List;

// import org.openqa.selenium.By;
// import org.openqa.selenium.WebDriver;
// import org.openqa.selenium.WebElement;

// public class HomePage {
// 	public WebDriver driver;
	
	
// 	private By searchBox = By.id("twotabsearchtextbox");
// 	private By clickSearchBox = By.id("nav-search-submit-button");
// 	public By searchResults = By.xpath("(//a[@class='a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal'])");
// 										//span[@class='a-size-medium a-color-base a-text-normal']
// 	public HomePage(WebDriver driver) {
// 		this.driver = driver;
// 	}
	
// 	public List<WebElement> searchResults()
// 	{
// 		return driver.findElements(searchResults);
// 	}

	
// 	public WebElement searchBox()
// 	{
// 		return driver.findElement(searchBox);
// 	}
// 	public WebElement ClicksearchBox()
// 	{
// 		return driver.findElement(clickSearchBox);
		
// 	}

// }
