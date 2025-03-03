package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyAccountPage extends BasePage {

	// only one element added
	public MyAccountPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//h2[text()='My Account']") // MyAccount Page heading
	WebElement msgHeading;

	
	  @FindBy(xpath="//span[normalize-space()='My Account']") 
	  WebElement lnkMyAccount;
	  
	  
	  @FindBy(xpath ="//div[@class='list-group']//a[text()='Logout']") // Locate
	   WebElement lnkLogout;
	  
	 

	public boolean isMyAccountPageExists() {
		try {
			return (msgHeading.isDisplayed());
		} catch (Exception e) {
			return false;
		}
	}

	public void clickLogout()  {
		/*
		 * WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		 * wait.until(ExpectedConditions.elementToBeClickable(By.
		 * xpath("//span[normalize-space()='My Account']"))); // click on the compose
		 * button as soon as the "compose" button is visible
		 * driver.findElement(By.xpath(
		 * "/html[1]/body[1]/nav[1]/div[1]/div[2]/ul[1]/li[2]/div[1]/ul[1]/li[5]/a[1]"))
		 * .click(); Thread.sleep(2000);
		 */
		lnkLogout.click();
	}
}
