package testCases;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass{
        
	@Test(groups={"Sanity"})
	public void verify_login() {
	
		logger.info(" **Staring of TC_002_LoginTest**");
		try 
		{		
			//HomePage
			HomePage hp=new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogin();
		
			//Login
			LoginPage lp=new LoginPage(driver);
			lp.setEmail(p.getProperty("email"));
			lp.setPassword(p.getProperty("password"));
			lp.clickLogin();
			
			//MyAccount
			MyAccountPage macc=new MyAccountPage(driver);
			boolean targetPage=macc.isMyAccountPageExists();
			
			Assert.assertTrue(targetPage);//Assert.assertEquals(targetPage, true,"Login failed");
			}
			catch(Exception e)
			{
				Assert.fail();
			}
			logger.info("****** Finished TC_002_LoginTest *****");
		}
		
}
