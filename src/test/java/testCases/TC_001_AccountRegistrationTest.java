package testCases;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest  extends BaseClass{
	
	// we can refer multiple page object class  in same test
	@Test(groups={"Regression","Master"})
	public void verify_account_registration() {
		
		logger.info("****Starting TC001_AccountRegistrationTest ****");
		//call page objects methods
		//put in try catch block
		try 
		{
		HomePage n = new HomePage(driver);
		n.clickMyAccount();
		logger.info("****Click on Account link****");

		n.clickRegister();
		logger.info("**** Click on Register link*****");

		AccountRegistrationPage n2 = new AccountRegistrationPage(driver);

		n2.setFirstname(randomeString());
		n2.setLastname(randomeString());
		n2.setEmail(randomeString()+"@gmail.com");
	    n2.setPassword(randomeAlphaNumeric());
	    n2.setPrivacyPolicy();
		n2.clickContinue();
		 
		logger.info("***Validating expected message ****");
		String confmsg= n2.getConfirmationMsg();
		
		  if(confmsg.equals("Your Account Has Been Created!")) 
		  {
		  Assert.assertTrue(true); 
		  }
		  else 
		  { logger.error("Test Failed");
		  logger.debug("Debug logs"); 
		  Assert.assertTrue(false);
		  }
		 
       // Assert.assertEquals(confmsg, "Your Account Has Been Created!");	
		}
		catch(Exception e) {
			//Assert.fail();
		}
		
		logger.info("***Finished  TC001_AccountRegistrationTest****");

	}
}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
