package Testcases;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Library.baseclass;
import Library.utilityclass;
import pages.AddRandomProductsToCart;
import pages.Loginpage;

public class AddRandomProductsToCartTest extends baseclass
{
	int TCID;
	Loginpage login;
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
	//Verifying adding random products to cart(testcase 12)
	 @Test(priority = 1, description = "Add Products To Shopping Cart")
	    public void Add_Random_Products_To_Shopping_Cart() 
	 {TCID=12;
	        new AddRandomProductsToCart(driver).addRandomProductToCartAndGetPrices();
	    }
}
