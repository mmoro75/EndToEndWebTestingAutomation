package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {


	public WebDriver driver;


	public MainPage (WebDriver driver) {

		this.driver =  driver ;
		PageFactory.initElements( driver , this );



	}


	@FindBy(xpath="//a[@title='T-shirts']") WebElement Tshirts;
	@FindBy(xpath="//a[@title='Dresses']") WebElement Dresses;
	@FindBy(xpath="//a[@title='Women']") WebElement Women;
	@FindBy(xpath="//a[@title='Casual Dresses']//img[@class='replace-2x']") WebElement CasualDresses;
	@FindBy(xpath="//a[@title='Evening Dresses']//img[@class='replace-2x']") WebElement EveningDresses;
	@FindBy(xpath="//a[@title='Summer Dresses']//img[@class='replace-2x']") WebElement SummerDresses;
	@FindBy(xpath="//input[@id='search_query_top']") WebElement Search;
	@FindBy(xpath="//b[contains(text(),'Cart')]") WebElement Cart;
//	@FindBy(xpath="//div[@class='columns-container']//ul[@class='tree dynamized']//li[1]//span[1]") WebElement Tops ; // this is to open top menu
	@FindBy(xpath="//a[@title='Tops']//img[@class='replace-2x']") WebElement Tops ;
	@FindBy(xpath="//a[@title='T-shirts']//img[@class='replace-2x']") WebElement T_Shirts ;
	@FindBy(xpath="//a[@title='Blouses']//img[@class='replace-2x']") WebElement Blouses ;
	
	public WebDriver getDriver() {
		return driver;
	}
	public WebElement getTshirts() {
		return Tshirts;
	}
	public WebElement getDresses() {
		return Dresses;
	}
	public WebElement getWomen() {
		return Women;
	}
	public WebElement getCasualDresses() {
		return CasualDresses;
	}
	public WebElement getEveningDresses() {
		return EveningDresses;
	}
	public WebElement getSummerDresses() {
		return SummerDresses;
	}
	public WebElement getSearch() {
		return Search;
	}
	public WebElement getCart() {
		return Cart;
	}
	
	public WebElement getTops() {
		return Tops;
	}
	
	public WebElement getBlouses() {
		return Blouses;
	}
	
	public WebElement getT_Shirts() {
		return T_Shirts;
	}


}
