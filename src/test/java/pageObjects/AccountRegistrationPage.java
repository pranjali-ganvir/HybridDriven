package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage{

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement txtFirstname;          
	
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement  txtLastname;          
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement  txtEmail;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtPassword;             
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement chkPolicy;
	
	@FindBy(xpath="//button[normalize-space()='Continue']")
	WebElement  btnContinue;
	
	@FindBy(xpath="//a[normalize-space()='Your Account Has Been Created!']")
	WebElement comfirmMessage;
	
	public void setFirstname(String fname) {
		txtFirstname.sendKeys(fname);
	}
	
	public void setLastname(String lname) {
		txtLastname.sendKeys(lname);
	}
	public void setEmail(String email) {
		txtEmail.sendKeys(email);
	}
	public void setPassword(String password) {
		txtPassword.sendKeys(password);
	}
	public void setPrivacyPolicy() {
		chkPolicy.click();
	}
	public void clickContinue(){
		//btnContinue.click();
		btnContinue.submit();

	}
	
	//not doing validations here
	public String getConfirmationMsg() {	
		try {
			return (comfirmMessage.getText());
		}
		catch(Exception e) {
			return (e.getMessage());
		}
	}
	
}
