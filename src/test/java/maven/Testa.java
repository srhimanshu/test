package maven;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Testa 
{
	@Test
	public void runChrome()
	{
		String chromeDriverPath = System.getProperty("user.dir")+"/chromedriver";
//		System.out.println(chromeDriverPath);
//		WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		WebDriver driver = new ChromeDriver(options);
		driver.get("http://www.google.com");
		driver.quit();
	}
}
