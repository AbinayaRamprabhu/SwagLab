package Testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Library.baseclass;
import Library.utilityclass;
import pages.CheckoutOrder;
import pages.CheckoutYourInformation;
import pages.Loginpage;

public class CheckoutTheInformationTest extends baseclass
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
	//Verifying adding information information page(testcase 14)
	    @SuppressWarnings("null")
		@Test(dataProvider="info",dataProviderClass=utilityclass.class)
	    public void CheckoutTheInformation(String scenario,String firstname,String lastname,String PostalCode) 
	    { TCID=14;
	        Assert.assertTrue(new CheckoutOrder(driver).checkCheckOutButtonAppear());      
	        new CheckoutOrder(driver).ClickOnCheckOutButton();
	        new CheckoutYourInformation(driver).PageTitle();      
	        new CheckoutYourInformation(driver).addFirstName(firstname).addLastName(lastname).addPostalCode(PostalCode);
	        new CheckoutYourInformation(driver).ClickOnContinueButton();
	        new CheckoutYourInformation(driver).ClickOnCanButton();
	        CheckoutYourInformation continueButton = null;
	    //Verifying with valid information(testcase 15)
		if(scenario=="valid)")
		{TCID=15;
			 new CheckoutYourInformation(driver).ClickOnContinueButton();
		}
		//Verifying with blank firstname(testcase 16)
		else if(scenario.equals("blank firstname"))
		{TCID=16;
			String actualresult=continueButton.getErrorMessage();
			String expectedresult="result";
			Assert.assertEquals(actualresult, expectedresult);
		
		}
		//Verifying with blank values(testcase 17)
		else if(scenario.equals("blank lastname"))
		{TCID=17;
			String actualresult=continueButton.getErrorMessage();
			String expectedresult="result";
			Assert.assertEquals(actualresult, expectedresult);
				}
		//Verifying with blank lastname(testcase 18)
				else if(scenario.equals("blank PostalCode"))
				{TCID=18;
					String actualresult=continueButton.getErrorMessage();
					String expectedresult="result";
					Assert.assertEquals(actualresult, expectedresult);
						}
		//Verifying with blank lastname(testcase 19)
				else if(scenario.equals("blank"))
				{TCID=19;
					String actualresult=continueButton.getErrorMessage();
					String expectedresult="result";
					Assert.assertEquals(actualresult, expectedresult);
						}
	    }
	    //Verifying cancel button(testcase 20)
		@Test
		public void ClickOnCanButton()
		{TCID=20;
			driver.navigate().to("https://www.saucedemo.com/cart.html");   
	  
	        
	    }
		
}
