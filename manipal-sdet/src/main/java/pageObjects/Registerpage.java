package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Registerpage {
	

			private WebDriver driver; 
			
			public Registerpage(WebDriver driver) {
				super();
				this.driver = driver;
				PageFactory.initElements(driver, this);
			}
		 	
			 String F1;
			 String L1;
			 
			 @FindBy(id="registration_firstname")
			private WebElement Fname;
			
			 @FindBy(id="registration_lastname")
			private WebElement Lname; 
			
			 @FindBy(id="registration_email")
			private WebElement email; 
			
			 @FindBy(id="username")
			private WebElement UID; 
			
			 @FindBy(id="pass1")
			private WebElement PWD; 
			
			 @FindBy(id="pass2")
			private WebElement cPWD; 
			
			 @FindBy(id="registration_submit")
			private WebElement Registration;
			
						
			public void sendFirstname(String firstname) {
				this.Fname.clear();
				this.Fname.sendKeys(firstname);
				F1=firstname;
			}
			
			public void sendLastname(String lastname) {
				this.Lname.clear(); 
				this.Lname.sendKeys(lastname);
				L1=lastname;
		}
			public void mailRegPage(String email) {
				this.email.clear(); 
				this.email.sendKeys(email);
			}
			
			public void Username(String uname) {
				this.UID.clear(); 
				this.UID.sendKeys(uname);
			}
			
			public void Password(String pass) {
				this.PWD.clear(); 
				this.PWD.sendKeys(pass);
			}
			public void ConfirmPWD(String conf_pass) {
				this.cPWD.clear(); 
				this.cPWD.sendKeys(conf_pass);
				
			}
			public void RegistrationButton() {
				this.Registration.click();
			}					
			public String GetFnameLname() {
				String s = F1.concat(" ").concat(L1);
				System.out.println(s);
				return s;
			}
			
}
