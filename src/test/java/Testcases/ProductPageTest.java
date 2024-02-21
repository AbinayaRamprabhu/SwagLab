package Testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Library.baseclass;
import Library.utilityclass;
import pages.Loginpage;
import pages.Productpage;

@SuppressWarnings("unused")
public class ProductPageTest extends baseclass
{
	int TCID;
	Loginpage login;
	protected Object appLogo;
	@BeforeMethod
	public void setup() 
	{
		login=new Loginpage(driver);
	}
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			utilityclass.captureSS(TCID);
		}
		driver.quit();
	}
	
	@Test
	public void Product_page()
	//Verifying the logos and buttons in product page(testcase 9)
	{TCID=9;
		 Assert.assertEquals(new Productpage(driver).appLogovisible(),"Logo is visible");
		 Assert.assertEquals(new Productpage(driver).menuButtonvisible(),"MenuButton is visible");
		 Assert.assertEquals(new Productpage(driver).ShoppingCartvisible(),"ShoppinCart is visible");
		 Assert.assertEquals(new Productpage(driver).twittervisible(),"twitter is visible");
		 Assert.assertEquals(new Productpage(driver).facebookvisible(),"facebook is visible");
		 Assert.assertEquals(new Productpage(driver).linkedinvisible(),"linkedin is visible");
		 
	}
	
}
