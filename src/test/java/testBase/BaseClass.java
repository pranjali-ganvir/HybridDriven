package testBase;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

	public class BaseClass {
         //declare static webdriver and setup teardown methods are common for all test cases
		public static WebDriver driver;
		//create varaiable for log4j2
		public Logger logger;
		//Loading config.properties file
        public Properties p;
		
		@BeforeClass(groups= {"Sanity", "Regression", "Master", "Datadriven"})
		@Parameters({"os","browser"})
		public void setup(String os, String br) throws IOException 
		{
			//Loading config.properties file
            FileReader file = new FileReader("./src//test//resources//config.properties");
			//load file now
            p = new Properties();
            p.load(file);
            
			logger = LogManager.getLogger(this.getClass());
			
			
			if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
			{
				DesiredCapabilities capabilities=new DesiredCapabilities();
				
				//os
				if(os.equalsIgnoreCase("windows"))
				{
					capabilities.setPlatform(Platform.WIN11);
				}
				else if(os.equalsIgnoreCase("linux"))
				{
					capabilities.setPlatform(Platform.LINUX);
					
				}
				else if (os.equalsIgnoreCase("mac"))
				{
					capabilities.setPlatform(Platform.MAC);
				}
				else
				{
					System.out.println("No matching os");
					return;
				}	
			//cross browser testing
			switch(br.toLowerCase())
			{
			case "chrome": capabilities.setBrowserName("chrome"); break;
			case "edge": capabilities.setBrowserName("MicrosoftEdge"); break;
			case "firefox": capabilities.setBrowserName("firefox"); break;
			default: System.out.println("No matching browser"); return;
			}
			
			driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
		}
			if(p.getProperty("execution_env").equalsIgnoreCase("local"))
			{

				switch(br.toLowerCase())
				{
				case "chrome" : driver=new ChromeDriver(); break;
				case "edge" : driver=new EdgeDriver(); break;
				case "firefox": driver=new FirefoxDriver(); break;
				default : System.out.println("Invalid browser name.."); return;
				}
			}
			


		    //driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			//driver.get("https://demo.opencart.com/");
			driver.get(p.getProperty("appURL")); //reading URL from config properties file 

			driver.manage().window().maximize();
			
		}
		
		@AfterClass
		public void tearDown() {
			driver.quit();
			
		}
		//declare method java
 		
	 	  public String randomeString()
	 		  { //RandomStringUtils is a class 
	 			  //this method  will generate any string of 5 characters in generated string //same use this
	 		 // method for firstname and lastname 
	 			@SuppressWarnings("deprecation")
				String generatedString =RandomStringUtils.randomAlphabetic(5); 
	 			return generatedString;
	 			}
	 	       
	 			
	 			 public String randomeAlphaNumeric() 
	 			 { //RandomStringUtils is a class //in this method
	 			 //  concatenate two string numeric and password
	 				@SuppressWarnings("deprecation")
					String generatedString = RandomStringUtils.randomAlphabetic(5);
	 				String generatedNumber = RandomStringUtils.randomNumeric(5); 
	 				 return  (generatedString+"@"+generatedNumber); //contatenate with special character
	 				 }
	 			public String captureScreen(String tname) throws IOException {

	 				String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
	 						
	 				TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
	 				File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
	 				
	 				String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
	 				File targetFile=new File(targetFilePath);
	 				
	 				sourceFile.renameTo(targetFile);
	 					
	 				return targetFilePath;

	 			}
	 			
	 			
	 		}
			
	
			
			
		
		
		
		
