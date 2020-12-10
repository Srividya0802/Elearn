package stepDef;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.RegisteredVerify;
import pageObjects.Registerpage;
import pageObjects.homePage;
import pageObjects.mailPage;

public class elearnStep {
	
	   //System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\drivers\\chromedriver.exe");
		 WebDriver driver = new ChromeDriver();
	 	 homePage h = new homePage(driver);
	 	 Registerpage R = new Registerpage(driver);
	 	 RegisteredVerify RV = new RegisteredVerify(driver);
	 	 mailPage M = new mailPage(driver);
	 	 

	@Given("^I launch elearn application url$")
	public void i_launch_elearn_application() throws Throwable {
		driver.get("http://elearningm1.upskills.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  	}

	@When("^In Home page$")
	public void in_Home_page() throws Throwable {
		//String s = driver.getCurrentUrl();
		System.out.println("Navigated to Home Page");
	 
	}

	@Then("^Sign in to Register$")
	public void sign_in_to_Register() throws Throwable {
		  h.NewUser();
	}

	@Then("^Enter registration details using \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void enter_registration_details_using(String firstname, String lastname, String email, String uname, String pass, String conf_pass) throws Throwable {
	   R.sendFirstname(firstname);
	   R.sendLastname(lastname);
	   R.mailRegPage(email);
	   R.Username(uname);
	   R.Password(pass);
	   R.ConfirmPWD(conf_pass);
	}

	@Then("^click register$")
	public void click_register() throws Throwable {
	   R.RegistrationButton();
	   Thread.sleep(1000);
	}

	@Then("^verify the user is registered$")
	public void verify_the_user_is_registered() throws Throwable {
		String Name = R.GetFnameLname();
		boolean b=RV.VerifyText(Name);
		Assert.assertTrue(b);
		System.out.println("Scenario1 pass");
		
		
	}

	@Given("^Click on homePage$")
	public void click_on_homePage() throws Throwable {
		Thread.sleep(6000);
	 RV.clickHome();
	}

	@When("^In homepage$")
	public void in_homepage() throws Throwable {
		String hP=h.getHomeURL();
	    System.out.println(hP);
	}

	@Then("^Click on Compose$")
	public void click_on_Compose() throws Throwable {
	M.ComposeMessage();
	}

	@Then("^enter \"([^\"]*)\" mail id , \"([^\"]*)\" and \"([^\"]*)\"$")
	public void enter_mail_id_and(String mailid, String subject, String m) throws Throwable {
	  	   M.Subjectline(subject);
	   M.MesaageBox(m);
	   M.SendTo(mailid);
	}

	@Then("^click send button$")
	public void click_send_button() throws Throwable {
	  M.SendMessage();
	}

	@Then("^Verify acknowledgement shown$")
	public void verify_acknowledgement_shown() throws Throwable {
	  String Actstring = M.getAckText();
	  String Expected = "The message has been sent to naveen naveen (naveen)";
	  Assert.assertEquals(Actstring, Expected);
	  
	}


}
