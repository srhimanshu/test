package maven;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Testb 
{
	public WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;
	public static String distribution_type_class_level;

	@Test
	@Parameters(value={"browser","distribution_type"})
	public void setup(String browser,String distribution_type) throws InterruptedException
	{
		distribution_type_class_level = distribution_type;
		if(browser.equals("chrome"))
		{
			String chromeDriverPath = System.getProperty("user.dir") + "/chromedriver";
			System.setProperty("webdriver.chrome.driver", chromeDriverPath);
			ChromeOptions options = new ChromeOptions();
//			options.addArguments("--headless");
			driver = new ChromeDriver(options);
			driver.manage().window().maximize();
			wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			js = (JavascriptExecutor) driver;
			
			if(distribution_type.equals("video"))
			{
				driver.get("https://www.google.com");
			}
			
			else
			{
				driver.get("https://www.google.com");
			}
		}
		
		else if(browser.equals("firefox"))
		{
			String firefoxDriverPath = System.getProperty("user_dir")+"/geckodriver";
			System.setProperty("webdriver.firefox.driver", firefoxDriverPath);
			FirefoxOptions options = new FirefoxOptions();
//			options.addArguments("--headless");
			driver = new FirefoxDriver(options);
			driver.manage().window().maximize();
			wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			js = (JavascriptExecutor) driver;
			
			if(distribution_type.equals("video"))
			{
				driver.get("https://www.google.com");
			}
			
			else
			{
				driver.get("https://www.google.com");
			}
		}
	}

}
