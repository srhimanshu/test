package maven;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Testa
{
	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;
	public static String distribution_type_class_level;

	@BeforeClass(alwaysRun = true)
	@Parameters(value={"browser","distribution_type"})
	public void setup(String browser,String distribution_type) throws InterruptedException
	{
		distribution_type_class_level = distribution_type;
		if(browser.equals("chrome"))
		{
			String chromeDriverPath = System.getProperty("user.dir") + "/chromedriver101";
			System.setProperty("webdriver.chrome.driver", chromeDriverPath);
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless");
			options.addArguments("--window-size=1920,1080");
			driver = new ChromeDriver(options);
			driver.manage().window().maximize();
			wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			js = (JavascriptExecutor) driver;
			
			if(distribution_type.equals("video"))
			{
				driver.get("https://experience-stg.sourcesync.io/213");
				System.out.println("url launched");
				// Play Video
				click("//div[@class='plyr__controls']/button[1]");
				System.out.println("main video played");
			}
			
			else
			{
				driver.get("https://experience-stg.sourcesync.io/214");
				System.out.println("url launched");
			}
		}
		
		else if(browser.equals("firefox"))
		{
			String firefoxDriverPath = System.getProperty("user_dir")+"/geckodriver";
			System.setProperty("webdriver.firefox.driver", firefoxDriverPath);
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--headless");
			options.addArguments("--window-size=1920,1080");
// 			options.addArguments("media.eme.enabled", true);
			driver = new FirefoxDriver(options);
			System.out.println("firefox browser launched");
			driver.manage().window().maximize();
			System.out.println("firefox browser maximized");
			wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			js = (JavascriptExecutor) driver;
			
			if(distribution_type.equals("video"))
			{
				driver.get("https://experience-stg.sourcesync.io/213");
				System.out.println("url launched");

				// Play Video
				click("//div[@class='plyr__controls']/button[1]");
				System.out.println("main video played");
			}
			
			else
			{
				driver.get("https://experience-stg.sourcesync.io/214");
				System.out.println("url launched");
			}
		}
	}

	@Test 
	public void Image() throws InterruptedException 
	{
		// 1. Image Smart Block
		click("//div[contains(text(),'Image')]");
		System.out.println("image smartblock opened");

		// Get Height and Width of Image
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='q-img__image absolute-full']")));
		System.out.println(driver.findElement(By.xpath("//div[@class='q-img__image absolute-full']")).getCssValue("height"));
		System.out.println(driver.findElement(By.xpath("//div[@class='q-img__image absolute-full']")).getCssValue("width"));
		
		click("//div[@class='row']/button");
		System.out.println("image smartblock closed");
	}
	
	@Test
	public void Markdown() throws InterruptedException
	{
		// 2. Markdown Smart Block
		click("//div[contains(text(),'Markdown')]");
		System.out.println("markdown smartblock opened");
		click("//div[@class='row']/button");
		System.out.println("markdown smartblcok closed");
	}
	
	@Test
	public void Social() throws InterruptedException
	{
		// 3. Social Smart Block
		click("//div[contains(text(),'Social')]");
		System.out.println("social smartblock opened");

		// Click Social Media Icons
		SocialIcons();
		click("//div[@class='row']/button");
		System.out.println("social smartblock closed");
	}
	
	@Test
	public void Location() throws InterruptedException
	{
		// 4. Location Smart Block
		click("//div[contains(text(),'Location')]");
		System.out.println("location smartblock opened");
		click("//div[@class='row']/button");
		System.out.println("location smartblock closed");
	}
	
	@Test
	public void VideoYoutube() throws InterruptedException
	{
		// 5. Video Youtube With AutoPlay Functionality
		click("//div[contains(text(),'VideoYoutube')]");
		System.out.println("video smartblock opened");

		// To verify Autoplay functionality
		verifyAutoplayVideoSmartBlock("//div[@class='vjs-control-bar']/button");

		// To click on Skip and Verify main video autoplay
		clickSkipVerifyMainVideoAutoplay("//span[contains(text(),'Skip')]",distribution_type_class_level);

		click("//div[@class='row']/button");
		System.out.println("video smartblock closed");
	}
	
	@Test
	public void Carousel() throws InterruptedException
	{
		// 6. Carousel Smart Block
		click("//div[contains(text(),'Carousel')]");
		System.out.println("carousel smartblock opened");
		click("//div[@class='row']/button");
		System.out.println("carousel smartblock closed");
	}
	
	@Test
	public void Action() throws InterruptedException
	{
		// 9. Action Smart Block
		click("//div[contains(text(),'Action')]");
		System.out.println("action smartblock opened");
		clickSocialIcons("//div[contains(text(),'Source-Digital')]");
		click("//div[@class='row']/button");
		System.out.println("action smartblock closed");
	}
	
	@Test
	public void VideoMp4() throws InterruptedException
	{
		// 10. Video mp4 Smart Block with Autoplay Functionality
		click("//div[contains(text(),'Video Mp4')]");
		System.out.println("mp4 smartblock opened");
	
		// To verify Autoplay functionality
		verifyAutoplayVideoSmartBlock("//div[@class='vjs-control-bar']/button");

		// To click on Skip and Verify main video autoplay
		clickSkipVerifyMainVideoAutoplay("//span[contains(text(),'Skip')]",distribution_type_class_level);

		click("//div[@class='row']/button");
		System.out.println("mp4 smartblock closed");
	}
	
	@Test
	public void VideoVimeo() throws InterruptedException
	{
		// 11. Video Vimeo Smart Block with Autoplay Functionlaity
		click("//div[contains(text(),'VideoVimeo')]");
		System.out.println("vimeo smartblock opened");

		// To verify Autoplay functionality
		verifyAutoplayVideoSmartBlock("//div[@class='vjs-control-bar']/button");

		// To click on Skip and Verify main video autoplay
		clickSkipVerifyMainVideoAutoplay("//span[contains(text(),'Skip')]",distribution_type_class_level);

		click("//div[@class='row']/button");
		System.out.println("vimeo smartblock closed");
	}
	
	@Test
	public void Richtext() throws InterruptedException
	{
		// 8. Rich Text Smart Block
		click("//div[contains(text(),'Richtext')]");
		System.out.println("richtext smartblock opened");
		openLinkNextTab("//a[contains(text(),'https://sourcedigital.net/#/')]");
		click("//div[@class='row']/button");
		System.out.println("richtext smartblock closed");
	}
	
	@Test
	public void Iframe() throws InterruptedException
	{
		// 7. Iframe Smart Block
		click("//div[contains(text(),'Iframe')]");
		System.out.println("iframe smartblock opened");
		System.out.println(driver.findElement(By.xpath("//div[@class='smart-block-list']/iframe")).getCssValue("min-height"));
		System.out.println(driver.findElement(By.xpath("//div[@class='smart-block-list']/iframe")).getCssValue("height"));
		click("//div[@class='row']/button");
		System.out.println("iframe smartblock closed");
	}
	
	@Test(priority=1)
	public void ClickToDial() throws InterruptedException
	{
		// 12.Click To Dial Smart Block
		try {
			click("//div[contains(text(),'Click To Dial')]");
			System.out.println("clicktodial smartblock opened");
		} catch(Exception e)
		{
			driver.quit();
		}
	}
	
	@AfterClass
	public void end() 
	{
		driver.quit();
	}

	public void click(String xpath) throws InterruptedException 
	{
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
		driver.findElement(By.xpath(xpath)).click();
		Thread.sleep(1000);
	}

	public void clickSocialIcons(String xpath) throws InterruptedException 
	{
		String currentWindow = driver.getWindowHandle();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
		driver.findElement(By.xpath(xpath)).click();
		System.out.println("social icon clicked");
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		Thread.sleep(3000);
		driver.close();
		System.out.println("new tab closed");
		driver.switchTo().window(currentWindow);
	}

	public void SocialIcons() throws InterruptedException 
	{
		List<WebElement> socialIcons = driver.findElements(By.xpath("//div[@class='smart-block-list']/div/div"));
		int countSocialIcons = socialIcons.size();
		for (int i = 1; i <= countSocialIcons; i++) 
		{
			String xpath = "//div[@class='smart-block-list']/div/div[" + i + "]/button";
			clickSocialIcons(xpath);
		}
	}

	public void verifyAutoplayVideoSmartBlock(String xpath) throws InterruptedException 
	{
		Thread.sleep(3000);
		System.out.println("Is Video Autoplay working : "+ driver.findElement(By.xpath(xpath)).getAttribute("title").equals("Pause"));
	}

	public void clickSkipVerifyMainVideoAutoplay(String xpath,String distribution_type) throws InterruptedException 
	{
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
		driver.findElement(By.xpath(xpath)).click();
		Thread.sleep(3000);
		if(distribution_type.equals("video"))
		{
			System.out.println("Is Main Video Autoplay working after click skip : "+ driver.findElement(By.xpath("//div[@class='plyr__controls']/button[1]")).getAttribute("aria-label").equals("Pause"));
		}
	}

	public void openLinkNextTab(String xpath) throws InterruptedException 
	{
		String currentWindow = driver.getWindowHandle();
		String url = driver.findElement(By.xpath(xpath)).getAttribute("href");
		js.executeScript("window.open()");
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		driver.get(url);
		System.out.println("link opened in next tab");
		Thread.sleep(3000);
		driver.close();
		System.out.println("new tab closed");
		driver.switchTo().window(currentWindow);
	}
}
