package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	
    //reusing baseclass constructor below reusing pagefactory init elements
	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="//span[normalize-space()='My Account']")
	WebElement lnkMyAccount;
	
	@FindBy(xpath ="//a[@class='dropdown-item'][normalize-space()='Register']")
	WebElement lnkRegister;
	

@FindBy(linkText = "Login")   // Login link added in step5
WebElement linkLogin;


public void clickMyAccount()
{
	lnkMyAccount.click();
}

public void clickRegister()
{
	lnkRegister.click();
}

public void clickLogin()
{
	linkLogin.click();
}

}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

