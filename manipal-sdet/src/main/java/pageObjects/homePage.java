package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class homePage {
	private WebDriver driver; 
	
	

	public homePage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	
	@FindBy(xpath="//*[@id=\"login-block\"]/div/ul/li[1]/a")
	private WebElement Signupbutton; 
	
	public void NewUser() {
		this.Signupbutton.click();
		}
	
	public String getHomeURL() {
		return this.driver.getCurrentUrl();
		}
}
