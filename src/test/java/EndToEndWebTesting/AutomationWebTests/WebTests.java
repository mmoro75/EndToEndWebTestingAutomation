package EndToEndWebTesting.AutomationWebTests;


import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.SingInPage;
import Resources.Base;


public class WebTests extends Base {     // extend base class to access the driver methods
 
	private static Logger log = LogManager.getLogger(Base.class.getName()); // implementing logging mechanism to each test 
	
	@BeforeTest
	
	public void SetUp() throws IOException {
		
		driver=initilizeDriver();   // use method in Base class to initialise driver 
		 log.info("driver is initialized"); 
		
			
	}
	
	
	@Test(dataProvider="getData")   // testNG to use data provider
	
	public void Login(String username, String password) throws IOException  
	// the arguments we are passing into the methods have to be equal to the number of row for the object 
	
	{
		driver.get(UrlNavigation("url"));  // not included in BeforeTest as it needs to execute twice
		
		//Validations with Asserts
		
		Assert.assertEquals(driver.findElement(By.xpath("//h3[contains(text(),'Already registered?')]")).getText(), "ALREADY REGISTERED?");
		log.info("sgn in form");
	    Assert.assertTrue(driver.findElement(By.xpath("//img[@class='logo img-responsive']")).isDisplayed());
		
	    log.info("the logo is displayed");
		
		SingInPage lg = new SingInPage(driver);
		lg.getUsername().sendKeys(username);
		lg.getPassword().sendKeys(password);
		
		
	}
    
	@DataProvider     // we are using external data in order to not hard coding data in scripts
	public Object[][] getData() {
		
		// row stands for how many different data types test should run 
		// columns stands for how many values you want to enter for each test 
		Object[][] data= new Object[2][2];  //Array size is 2 
		//0 row
		data[0][0]= "mmoro@yahoo" ;
		data[0][1]= "passwABC";
		// 1 row 
		data[1][0]="gino@yahoo";
		data[1][1]="passDEF";
		
		return data;
		
	}
	
	@AfterTest 
	public void TearDown() {
		
		driver.quit();
		driver=null;  // set driver to null to free up memory
	}
	

}
