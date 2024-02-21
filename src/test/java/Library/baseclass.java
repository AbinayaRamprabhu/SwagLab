package Library;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

//import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class baseclass 
{
	 public static WebDriver driver; 
	@BeforeMethod
	@SuppressWarnings("deprecation")
	public void invokeBrowser() throws IOException //throws InterruptedException
, InterruptedException
	{
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\abina\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		@SuppressWarnings("unused")
		WebDriver driver1 = new ChromeDriver(); 
		Thread.sleep(1000);
	    WebDriverManager.edgedriver().setup();
		@SuppressWarnings("unused")
		WebDriver driver2 = new EdgeDriver();
		WebDriverManager.firefoxdriver().setup();
		Thread.sleep(1000);
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get(utilityclass.readPFData("URL"));
		//Thread.sleep(5000);
	}
	
@AfterMethod
public void tearDown()
{
	driver.quit();
}
}
	


