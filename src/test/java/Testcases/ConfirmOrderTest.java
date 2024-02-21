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
import pages.CheckoutYourInformation;
import pages.ConfirmOrder;
import pages.Loginpage;

public class ConfirmOrderTest extends baseclass
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
	 
	    @Test
	    
	 	public void Confirm_Order(String firstname, String lastname, String PostalCode) 
	 {		//Verifying confirm order (testcase 21)   
	    	TCID=21;
	 	    new AddAllProductsToCart(driver).addProductToCart().Navigatetothecart();      
	      
	        new CheckoutOrder(driver).ClickOnCheckOutButton();
	       
	        new CheckoutYourInformation(driver).PageTitle();			
			
	        new CheckoutYourInformation(driver).addFirstName(firstname).addLastName(lastname).addPostalCode(PostalCode);
	       
	        new CheckoutYourInformation(driver).ClickOnContinueButton();
	        
	        new ConfirmOrder(driver).getSubTotalPrice();

	        new ConfirmOrder(driver).getTotalPrice();

	        Assert.assertEquals(new ConfirmOrder(driver).getTotalPrice(), new ConfirmOrder(driver).getSubTotalPrice(), "Total is not Matched");

	        Assert.assertEquals(new ConfirmOrder(driver).calculateSubTotalPlusTax(), new ConfirmOrder(driver).getTotalPrice(), "Total is != subtotal+tax");

	        new ConfirmOrder(driver).clickOnFinishButton();

	        new ConfirmOrder(driver).confirmationMessage();
	    }
	}

