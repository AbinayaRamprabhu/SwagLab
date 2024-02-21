package Testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Library.baseclass;
import Library.utilityclass;
import pages.AddAllProductsToCart;
import pages.CheckoutOrder;
import pages.Loginpage;

public class CheckoutOrderTest extends baseclass
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
	//Verifying checkout order(testcase 13)
	  @Test(enabled = true)
	    public void CheckOutOrder() 
	  {TCID=13;

	        new AddAllProductsToCart(driver).addProductToCart();
	        new CheckoutOrder(driver).ClickOnCheckOutButton();
	        Assert.assertTrue(new CheckoutOrder(driver).checkCheckOutButtonAppear());
	    }
}
