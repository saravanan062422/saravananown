package orj.testdata;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class POM extends BaseClassOwn{
	
	
	public POM() {
		
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id="email")
	private WebElement username;
	@FindBy(id="pass")
	private WebElement password;
	@FindBy(name="login")
	private WebElement btnclick;
	  
  public WebElement getBtnclick() {
		return btnclick;
	}
public WebElement getUsername() {
		return username;
	}
	public WebElement getPassword() {
		return password;
	}
  
	
	

}
