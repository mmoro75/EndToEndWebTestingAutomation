package Resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Base {
	
	public static WebDriver driver;  // create global WebDriver driver for the entire class 
	public Properties prop;   // create global Properties for  entire class and public across
	// browser invocation definition 
	public FileInputStream fis ;
	
	public WebDriver initilizeDriver () throws IOException
	
	{
		
	  // define properties object
	  prop = new Properties();
	  // create file fis with location
	  fis= new FileInputStream("C:\\Users\\u6017127\\Java_workspace\\AutomationWebTests\\src\\main\\java\\EndToEndWebTesting\\AutomationWebTests\\data.properties"); 
	  prop.load(fis);  // load file
	  
	  String browserName=prop.getProperty("browser");  // get properties from file property browser
	  
	  if (browserName.equals("chrome")){
		  
		//  System.setProperty("webdriver.chrome.driver", "location")
		   driver = new ChromeDriver();
		  
	  }
	  
	  else if (browserName.equals("firefox")) {  // you need to use.eequals and not ==as we are extracting a value from properties not comparing to values
		  
		driver = new FirefoxDriver();
		  
	  }
	  
	  else if (browserName.equals("IE")){
		  
		   driver = new InternetExplorerDriver();
		  
	  }
	  
	  
	  // give implicit wait to give time to load the driver and not fail the script
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  
	  // return the driver to use it in the test cases
	  return driver ;
	  
	}  
	
  
	
   public String UrlNavigation(String addr ) throws IOException {    // obtain url from file
	   
	   fis= new FileInputStream("C:\\Users\\u6017127\\Java_workspace\\AutomationWebTests\\src\\main\\java\\EndToEndWebTesting\\AutomationWebTests\\data.properties"); 
		 prop.load(fis);  // load file
		  
	  String url = prop.getProperty(addr);  
	   
      return url ;
	
   }
   
   
   
   public void getScreenShoot(String result) throws IOException {   // define screen shot method (String result we are expecting test title from Listener
	   
	   // take a screenshot output as File
	   File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);  
	   // copy file generated to local machine
	   FileUtils.copyFile(src, new File("C:\\Users\\u6017127\\Java_workspace\\AutomationWebTests\\ScreenShots\\"+result+"ScreenShot.png")); // filename will be result from listener concatenated
	   
   }
   
	
	
}

	

	