package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class mailPage {
	
private WebDriver driver; 
	
public mailPage(WebDriver driver) {
	super();
	this.driver = driver;
	PageFactory.initElements(driver, this);
}
	
	@FindBy(linkText="http://elearningm1.upskills.in/main/messages/new_message.php")
	private WebElement Compose; 
	
	@FindBy(className="select2-search__field")
	private WebElement Reciever;
	
	@FindBy(id="compose_message_title")
	private WebElement Subj; 
	
	@FindBy(className="cke_editable cke_editable_themed")
	private WebElement Msg; 
	
	@FindBy(id="compose_message_compose")
	private WebElement Send; 
	
	@FindBy(xpath="//*[@id=\"cm-content\"]/div/div[2]/div/div[1]")
	private WebElement acktext; 

   public void ComposeMessage() {
		this.Compose.click();
		}
	
	public void SendTo(String Recipeint) {
		this.Reciever.clear();
		this.Reciever.sendKeys(Recipeint);
		this.Reciever.sendKeys(Keys.ENTER); 
	}
	
	public void Subjectline(String Subject) {
		this.Subj.clear(); 
		this.Subj.sendKeys(Subject);
}
	public void MesaageBox(String Message) {
		this.Msg.clear(); 
		this.Msg.sendKeys(Message);
}

    public void SendMessage() throws InterruptedException {
    	 JavascriptExecutor js = (JavascriptExecutor) this.driver;
    	 js.executeScript("window.scrollBy(0,1000)");
    	 		this.Send.click(); 
    	 		Thread.sleep(1000);
    }
    	 		
    	 		public String getAckText() {
    	 			String a = this.acktext.getText();
    	 			return a;
    	 	}	 		
}
    

