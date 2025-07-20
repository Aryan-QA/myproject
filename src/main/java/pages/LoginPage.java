package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
       WebDriver driver;
	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	// Locators (based on Facebook login page)
    @FindBy(id = "email")
    WebElement usernameField;

    @FindBy(id = "pass")
    WebElement passwordField;

    @FindBy(name = "login")
    WebElement loginButton;
    @FindBy(css = "div._9ay7") // Example error selector (change if needed)
    WebElement errorMessage;
    
    public String getErrorMessage() {
        return errorMessage.getText();
    }

	public void enterUsername(String username) {
		usernameField.sendKeys(username);
		
	}

	public void enterPassword(String password) {
		  passwordField.sendKeys(password);
		
	}

	public void clickLogin() {
		 loginButton.click();
	}

//	public String getTitle() {
//		// TODO Auto-generated method stub
//		return driver.getTitle();
//	}
	
	  public void loginToApp(String username, String password) {
	        enterUsername(username);
	        enterPassword(password);
	        clickLogin();
	    }

	public String getTitle() {
		// TODO Auto-generated method stub
		return driver.getTitle();
	}

}
