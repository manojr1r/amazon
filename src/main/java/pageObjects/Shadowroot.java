package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Shadowroot {

    public static void main(String[] args) {
				
        WebDriverManager.chromedriver().setup();
        ChromeOptions co =new ChromeOptions();        
        co.setExperimentalOption("detach", true);   //This will not close the browser automatically after execution
        co.addArguments("--start-maximized");

        
        WebDriver driver = new ChromeDriver(co);

		driver.get("");


        
    
}

}
