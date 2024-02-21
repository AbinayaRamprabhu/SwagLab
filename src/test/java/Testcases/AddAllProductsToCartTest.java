package Testcases;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Library.baseclass;
import Library.utilityclass;
import pages.AddAllProductsToCart;
import pages.Loginpage;

public class AddAllProductsToCartTest extends baseclass{
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
//Verifying add all products to cart sequentially(testcase 10)

	 @Test(priority = 1, description = "Add Products To Shopping Cart")
	    public void Add_Products_To_Shopping_Cart() 
	 {TCID=10;
	
		 new AddAllProductsToCart(driver).addProductToCart().Navigatetothecart();
	    }
//Verifying add all products to cart randomly(testcase 11)
	    @Test(priority = 2, description = "Add Random Products To Shopping Cart")
	    public void Add_Random_Products_To_Shopping_Cart() throws InterruptedException 
	    {TCID=11;

	     	         new AddAllProductsToCart(driver).addrandomproductstoshoppingcart(5).Navigatetothecart();
	    }
	    }

