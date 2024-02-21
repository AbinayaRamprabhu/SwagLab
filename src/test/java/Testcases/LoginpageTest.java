package Testcases;

import java.io.IOException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
//import org.testng.ITestResult;
//import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Library.baseclass;
import Library.utilityclass;
import pages.Loginpage;

public class LoginpageTest extends baseclass
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
	

	//Verifying the Url(testcase 1)
	@Test
public void verifyURL() throws IOException
{TCID=1;
	String actualURL=login.verifyURL();
	String expectedURL=utilityclass.readPFData("URL");
	Assert.assertEquals(actualURL, expectedURL);
}
	//Verifying Logo(testcase 2)
	@Test
	public void verifyLogo()
	{TCID=2;
		boolean actuallogo=login.verifyLogo();
		boolean expectedlogo=true;
		Assert.assertEquals(actuallogo, expectedlogo);
		}
	//Verifying page title(testcase 3)
	@Test
	public void verifyPageTitle()
	{TCID=3;
	login.verifyPageTitle();	
	}
		 //@Test

		// @DataProvider(name="Credential")
		   // public  String Object[][] Credential()
		//@DataProvider
	   //Object[]Credential()
		//{
			//return new Object[][]
					//{{"valid","standard_user","secret_sauce"},
				    // {"valid","problem_user","secret_sauce"},
				    // {"valid","performance_glitch_user","secret_sauce"},
				     //{"valid","error_user","secret_sauce"},
				    // {"valid","visual_user","secret_sauce"},
				    // {"invalid","gdygf","secret_sauce"},
				     //{"invalid","standard_user","765"},
				    // {"invalid","ahhgf","fbshgf"},
				     //{"blank","",""}};		     					
		//}
	 @Test(dataProvider="Credentials",dataProviderClass=utilityclass.class)
	 public void verifyLoginFunctionality(String scenario,String Username,String Pwd,String result) throws IOException
	 {TCID=4;
	login.enterCredentials(Username, Pwd);
	//Verifying with valid credentials(testcase 4)
	if(scenario=="valid)")
	{
		String actualresult=login.verifyURL();
		String expectedresult=result;
		Assert.assertEquals(actualresult, expectedresult);
	}
	//Verifying with invalid username and valid password(testcase 5)
	else if(scenario.equals("invalidUsername"))
	{TCID=5;
		String actualresult=login.getErrorMessage();
		String expectedresult=result;
		Assert.assertEquals(actualresult, expectedresult);
		
	}
	//Verifying with valid username and invalid password(testcase 6)
		else if(scenario.equals("invalidPwd"))
		{TCID=6;
			String actualresult=login.getErrorMessage();
			String expectedresult="result";
			Assert.assertEquals(actualresult, expectedresult);
			
		}
	//Verifying with invalid username and invalid password(testcase 7)
		else if(scenario.equals("invalidUsername,invalidPWD"))
		{TCID=7;
			String actualresult=login.getErrorMessage();
			String expectedresult="result";
			Assert.assertEquals(actualresult, expectedresult);
			
		}
	//Verifying with blank input(testcase 8)
		else if(scenario.equals("blank"))
		{TCID=8;
			String actualresult=login.getErrorMessage();
			String expectedresult="result";
			Assert.assertEquals(actualresult, expectedresult);
			
		}
		 
}
}
