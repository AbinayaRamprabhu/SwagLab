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
import pages.AddRandomProductsToCart;
import pages.CheckoutOrder;
import pages.CheckoutYourInformation;
import pages.ConfirmOrderWithRandomProducts;
import pages.Loginpage;

@SuppressWarnings("unused")
public class ConfirmOrderWithRandomProductsTest extends baseclass
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
	 @Test()
	    public void Confirm_Order(String firstname, String lastname, String code, Double totalPrice) 
	 {	 //Verifying confirm order with random products(testcase 22 )  
		 TCID=22;
	        new AddRandomProductsToCart(driver).addRandomProductToCartAndGetPrices();	       
	       
	        new CheckoutOrder(driver).ClickOnCheckOutButton();
	        
	        new CheckoutYourInformation(driver).PageTitle();
	       
	        new CheckoutYourInformation(driver).addFirstName(firstname).addLastName(lastname).addPostalCode(code).ClickOnContinueButton();       

	        new ConfirmOrderWithRandomProducts(driver).getSubTotal();
	        
	        new ConfirmOrderWithRandomProducts(driver).getTax();
	       
	        new ConfirmOrderWithRandomProducts(driver).total();
	       
	        Assert.assertEquals(totalPrice, new ConfirmOrderWithRandomProducts(driver).getSubTotal(), "The total item prices in cart is equal total price");
	       
	        Assert.assertEquals(new ConfirmOrderWithRandomProducts(driver).calculateSubTotalPlusTax(), new ConfirmOrderWithRandomProducts(driver).total(), "Total is = subtotal+tax");
	       
	        new ConfirmOrderWithRandomProducts(driver).clickOnFinishButton();       

	        new ConfirmOrderWithRandomProducts(driver).confirmationMessage();
	    }
	
}
