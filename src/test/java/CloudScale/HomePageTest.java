package CloudScale;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SelectedLinkPage;
import pageObjects.addToCartPage;
import resources.base;

public class HomePageTest extends base {
	public WebDriver driver;

	@AfterSuite
	public void close() {
//	driver.quit();
	}
	

	@DataProvider(name = "sendData")

	public Object[][] rdata() {
		return new Object[][] { { "mobile" } /*,{"phone"},{"smart phone"}*/
		};
	}

	@BeforeSuite
	public void initialize() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
	}

	@Test(priority = 1, dataProvider = "sendData")
	
	public void searchItem(String Searchdata) throws IOException, InterruptedException {
		HomePage l = new HomePage(driver);
		l.searchBox().sendKeys(Searchdata);
		l.ClicksearchBox().click();

		assertTrue(l.searchResults().size() > 0);
	}

	@Test(dependsOnMethods = "searchItem")
	public void addToCart() throws InterruptedException {
		HomePage l = new HomePage(driver);
		for (int i = 0; i < l.searchResults().size(); i++) {
			if (i == Math.floor((l.searchResults().size() + i) / 2)) {
				String pulledName = l.searchResults().get(i).getText();
//				System.out.println(pulledName);
				l.searchResults().get(i).click();

//				WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
//				wait.until(ExpectedConditions.numberOfWindowsToBe(2));
				Set<String> windows = driver.getWindowHandles();
				Iterator<String> it = windows.iterator();
				it.next();

				String childId = it.next();
				driver.switchTo().window(childId);
				SelectedLinkPage sP = new SelectedLinkPage(driver);
				assertEquals(pulledName, sP.verifyPage().getText());
//				System.out.println("same Item Selected");
				break;
			}
		}

		SelectedLinkPage sP = new SelectedLinkPage(driver);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(sP.addToCart));

		sP.addToCart().click();
//		Thread.sleep(2000);
		if (sP.closePopup().size() > 0) {
			sP.closePopup().get(0).click();
		}
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(sP.clickCart()));

		sP.clickCart().click();

	}

	@Test(dependsOnMethods = "addToCart")
	public void quantityTo10() throws InterruptedException {
		addToCartPage addtocart = new addToCartPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(addtocart.priceForOne));

		String priceForOneinTextsymbol = addtocart.priceForOne().getText().substring(1);
		String priceForOneinText = priceForOneinTextsymbol.replaceAll(",", "");
		double price = Double.parseDouble(priceForOneinText);
		double priceMultipliedOnebyTen = price * 10;

		addtocart.StaticdropDown().selectByIndex(10);
		addtocart.selectQuantity().sendKeys("10");
		addtocart.updateQuantitybutton().click();

		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(addtocart.priceForOne));
		String priceForTeninText = addtocart.priceForTen().getText().substring(1);
		priceForTeninText = priceForTeninText.replaceAll(",", "");
		double priceForTen = Double.parseDouble(priceForTeninText);
//		System.out.println(priceForTen);

		if (((List<WebElement>) addtocart.alert()).size() == 0) {
			
			 assertEquals(priceMultipliedOnebyTen, priceForTen);
		} else {
			System.out.println("This seller has a limit per customer. check availablity from another seller");
		}
		
		if (priceForTen == priceMultipliedOnebyTen) {
			System.out.println("Quantity changed to 10 ");
		} else
			System.out.println("Price Mismatch");
	}

	@Test(dependsOnMethods = "quantityTo10")
	public void deleteCart() {
		addToCartPage addtocart = new addToCartPage(driver);
		addtocart.delete().click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(addtocart.verify));

		assertEquals(addtocart.verify().getText(), "Your Amazon Cart is empty.");
	}

}
