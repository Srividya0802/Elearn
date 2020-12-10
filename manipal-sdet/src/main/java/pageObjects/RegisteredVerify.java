package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.*;

import pageObjects.Registerpage;

public class RegisteredVerify {

	private WebDriver driver; 
	
	
	public RegisteredVerify(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
		
		
	}
	
	//Registerpage R1 = new Registerpage(driver);
 	
    @FindBy(xpath = "//div[@class='col-xs-12 col-md-12']/p")
	private WebElement text;
    
   
   @FindBy(xpath = "//*[@id='navbar']/ul[1]/li[1]/a")
	private WebElement home ;
    
    public boolean VerifyText(String S) {
        boolean Flag;
        String T = text.getText();
    	if(T.contains(S)) {
   	 Flag = true;
   	 return Flag;}
    	else 
    	
    		Flag = false;
    		return Flag;
    	}


public void clickHome()  {
			this.home.click();
	
}	
}
