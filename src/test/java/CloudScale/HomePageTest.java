package CloudScale;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.base;
public class HomePageTest extends base {
	public WebDriver driver;
@BeforeTest
public void initialize() throws IOException
{
	driver= initializeDriver();
	driver.get(prop.getProperty("url"));
}
	@Test (dataProvider="getData")
	public void basePageNavigation(String Searchdata ) throws IOException
	{
		
		LandingPage l = new LandingPage(driver);
		l.searchBox().sendKeys(Searchdata);
		
		l.ClicksearchBox().click();
		
//		List<WebElement> searchResults = driver.findElements(By.className("a-size-medium"));
		//div[@id='nav-flyout-searchAjax']
		
		/*for( WebElement searchResult: searchResults)
		{
			System.out.println(searchResult);
		}*/
		
        }

	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data = new Object[1][1];
		data[0][0] = "mobile";
		
		
//		data[1][0] ="phone";
		
		
		return data;
	}
	
}






//public static void main(String[] args)
//{
//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\chromedriver.exe");
//WebDriver driver = new ChromeDriver();
//driver.get("https://www.amazon.in/");
//
//driver.findElement(By.id("twotabsearchtextbox")).sendKeys("mobiles");
//driver.findElement(By.id("nav-search-submit-button")).click();
//
//String bodyText = driver.findElement(By.xpath("//body/div[@id='a-page']/div[@id='search']/div[1]/div[2]/div[1]/div[3]/span[1]/div[1]/div[1]/div[1]")).getText();
//Assert.assertTrue(bodyText.contains("Mobile Phone"));
//
//}