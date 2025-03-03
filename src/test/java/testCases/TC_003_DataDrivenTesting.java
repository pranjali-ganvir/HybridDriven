package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

//DATA VALID LOGIN SUCESSFUL //LOGOUT// TEST PASS
//DATA VALID LOGIN UNSUCESSFUL // TEST FAIL
//DATA INVALID  LOGIN SUCESSFUL //LOGOUT// TEST FAIL
//DATA INVALID  LOGIN UNSUCESSFUL // TEST PASS

/*Data is valid  - login success - test pass  - logout
 					login failed - test fail

Data is invalid - login success - test fail  - logout
 					login failed - test pass
*/


public class TC_003_DataDrivenTesting extends BaseClass {

	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class, groups="Datadriven")// getting data provider from different class
	public void verify_loginDDT(String email, String pwd, String exp) throws InterruptedException
	{
		logger.info("***** stating TC_003_DDT ******");
		
		try
		{
		//HomePage
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		//Login
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(email);
		lp.setPassword(pwd);
		lp.clickLogin();
			
		//MyAccount
		MyAccountPage macc=new MyAccountPage(driver);
		boolean targetPage=macc.isMyAccountPageExists();
		
		
		if(exp.equalsIgnoreCase("Valid"))
		{
			if(targetPage==true)
			{		
				macc.clickLogout();

				// Create WebDriverWait instance (Explicit Wait)
				Assert.assertTrue(true);	

			}
			else
			{
				Assert.assertTrue(false);
			}
		}
		
		if(exp.equalsIgnoreCase("Invalid"))
		{
			if(targetPage==true)
			{
				Assert.assertTrue(false);
				macc.clickLogout();

				
			}
			else
			{
				Assert.assertTrue(true);
			}
		}
		}
		catch(Exception e)
		{
			Assert.fail();
		}
	//	Thread.sleep(3000);
		logger.info("***** Finished TC_003_DDT ******");
		
	}
}










