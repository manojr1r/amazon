package CloudScale;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.base;

public class secoundTest extends base {
	public WebDriver driver;
	@BeforeTest
	public void initialize() throws IOException
	{
		driver= initializeDriver();
		driver.get(prop.getProperty("url"));
	}
	
	@Test(dataProvider="getData")
		public void addToCart(String Searchdata ) throws IOException
		{
		LandingPage l = new LandingPage(driver);
		l.searchBox().sendKeys(Searchdata);
		
		l.ClicksearchBox().click();
		
		List<WebElement> searchResults = driver.findElements(By.className("a-size-medium"));
		
		//div[@id='nav-flyout-searchAjax']
		
		
		
		
		}
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data = new Object[1][1];
		data[0][0] = "mobile";
		
		return data;
	}

}
