package EndToEndWebTesting.AutomationWebTests;


import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.FindElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.MainPage;
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
	
	@Test
	public void WomenBlouses() throws IOException  
	// the arguments we are passing into the methods have to be equal to the number of row for the object 
	
	{
		driver.get(UrlNavigation("url2"));  // not included in BeforeTest as it needs to execute twice
		
		MainPage pg = new MainPage(driver);
		pg.getWomen().click(); 
	
	
		Assert.assertEquals(driver.findElement(By.xpath("//span[@class='category-name']")).getText(),"Women");
		
		pg.getTops().click();
		pg.getBlouses().click();
		
		Assert.assertEquals(driver.findElement(By.xpath("//span[@class='category-name']")).getText(),"Blouses");
	}
	
	
	@Test
	public void WomenT_Shirts() throws IOException  
	// the arguments we are passing into the methods have to be equal to the number of row for the object 
	
	{
		driver.get(UrlNavigation("url2"));  // not included in BeforeTest as it needs to execute twice
		
		MainPage pg = new MainPage(driver);
		pg.getWomen().click(); 
	
	
		Assert.assertEquals(driver.findElement(By.xpath("//span[@class='category-name']")).getText(),"Women");
		
		pg.getTops().click();
		pg.getT_Shirts().click();
		
		Assert.assertEquals(driver.findElement(By.xpath("//span[@class='category-name']")).getText(),"T-shirts");
	}
	
	
	
	@Test
	public void WomenT_Shirts_AddToCard() throws IOException  
	// the arguments we are passing into the methods have to be equal to the number of row for the object 
	
	{
		driver.get(UrlNavigation("url2"));  // not included in BeforeTest as it needs to execute twice
		
		MainPage pg = new MainPage(driver);
		pg.getWomen().click(); 
	
	
		Assert.assertEquals(driver.findElement(By.xpath("//span[@class='category-name']")).getText(),"Women");
		
		pg.getTops().click();
		pg.getT_Shirts().click();
		
		Assert.assertEquals(driver.findElement(By.xpath("//span[@class='category-name']")).getText(),"T-shirts");
		
		driver.findElement(By.xpath("//img[@title='Faded Short Sleeve T-shirts']")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Add to cart')]")).click();
		
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='layer_cart_product col-xs-12 col-md-6']//h2")));
		
		assertEquals(driver.findElement(By.xpath("//div[@class='layer_cart_product col-xs-12 col-md-6']//h2")).getText(), "Product successfully added to your shopping cart");
		
		driver.findElement(By.xpath("//a[@title='Proceed to checkout']//span")).click();
		
	//	assertEquals(driver.findElement(By.xpath("//h1[@id='cart_title']")).getText(), "SHOPPING-CART SUMMARY");
		assertEquals(driver.findElement(By.xpath("//td[@class='cart_description']//p[1]")).getText(), "Faded Short Sleeve T-shirts");
	}
	

	
	
	@Test
	public void SummerDresses() throws IOException {
		
		driver.get(UrlNavigation("url2")); 
		
		MainPage pg = new MainPage(driver);
		pg.getDresses().click(); 
		
		Assert.assertEquals(driver.findElement(By.xpath("//span[@class='category-name']")).getText(),"Summer Dresses");
		
	}
	
	
	
	
	
/*	@AfterTest 
	public void TearDown() {
		
		driver.quit();
		driver=null;  // set driver to null to free up memory
	}
	
	*/
	
   	
	

}
