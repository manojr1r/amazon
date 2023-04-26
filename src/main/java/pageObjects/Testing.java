package pageObjects;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Testing {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = WebDriverManager.chromedriver().create();
		driver.get("https://www.amazon.in");
		driver.manage().window().maximize();		
		HomePage l = new HomePage(driver);
				l.searchBox().sendKeys("mobile"); 
				
				l.ClicksearchBox().click();
				
				List<WebElement> searchResults = driver.findElements(By.className("a-size-medium"));
				
				assertTrue(searchResults.size()>0);
				
				
				for(int j=0; j<searchResults.size();j++)
				{  String pulledName = null; 
//					String name = searchResults.get(i).getText();
//					System.out.println(name);
					if (j==3)
					{
						pulledName = searchResults.get(j).getText();
						searchResults.get(j).click();
						Set<String> windows = driver.getWindowHandles();
						Iterator<String> it = windows.iterator();
							
						String parentId = it.next();
						driver.switchTo().window(parentId);
						String childId = it.next();
						driver.switchTo().window(childId);
						assertEquals(pulledName, driver.findElement(By.id("productTitle")).getText());
						break;
					}
				}
				
				SelectedLinkPage sP = new SelectedLinkPage(driver);
				
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
				wait.until(ExpectedConditions.visibilityOfElementLocated(sP.addToCart));
						
				sP.addToCart().click();
				Thread.sleep(2000);
				if (sP.closePopup().size()>0)
				{
					sP.closePopup().get(0).click();
				}
				Thread.sleep(2000);
				wait.until(ExpectedConditions.elementToBeClickable(sP.clickCart()));

				sP.clickCart().click();
				
				addToCartPage addtocart = new addToCartPage(driver);
				
//				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("\"sc-subtotal-amount-buybox\"")));
				
				String priceForOneinText = addtocart.priceForOne().getText().substring(1);
				priceForOneinText = priceForOneinText.replaceAll(",", ""); 
				double priceForOne = Double.parseDouble(priceForOneinText);
				priceForOne = (priceForOne)*10;
//				addtocart.quantity().click();
				
				addtocart.StaticdropDown().selectByIndex(10);
				addtocart.selectQuantity().sendKeys("10");
				
				addtocart.updateQuantitybutton().click();
				
//				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("\"sc-subtotal-amount-buybox\"")));
				Thread.sleep(1000);
				String priceForTeninText = addtocart.priceForTen().getText().substring(1);
				priceForTeninText = priceForTeninText.replaceAll(",", "");
				double priceForTen = Double.parseDouble(priceForTeninText);
				if (ExpectedConditions.elementToBeClickable(By.linkText("product detail page")) != null)
				{
				assertEquals(priceForOne, priceForTen);
				System.out.println("Quantity changed to 10 priced tallies");
				}
				else
				{
					System.out.println("This seller has a limit per customer. To see if more are available from another seller");
				}
				
				
						
		}
	
	
}
