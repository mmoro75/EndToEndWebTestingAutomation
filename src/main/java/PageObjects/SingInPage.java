package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SingInPage {
	
	public WebDriver driver;
	
	
	public SingInPage(WebDriver driver) {
		
		this.driver = driver; 
		PageFactory.initElements( driver , this );
	}
	
	@FindBy(id="email") WebElement username ;
	@FindBy(id="passwd") WebElement password;
	@FindBy(id="SubmitLogin") WebElement submit;
	@FindBy(id="email_create") WebElement create;
	@FindBy(id="Submit_create") WebElement submit_create;
	
	public WebElement getUsername() {
		
		return username ;
		
	}
	
	
    public WebElement getPassword() {

		
		return password ;
		
	}
    
    
    public WebElement getSubmit() {
    	
    	return submit ; 
    	
    	
    }
	
 public WebElement getCreate() {
    	
    	return create ; 
    	
    	
    }
 
 public WebElement getSubmit_create() {
 	
 	return submit_create ; 
 	
 	
 }
	

}
