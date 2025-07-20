package tests;
import utilities.ExcelUtil;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import listeners.TestListener;
import pages.LoginPage;
import io.qameta.allure.*;

@Listeners(listeners.TestListener.class)
public class LoginTest extends BaseTest {
	

//	  @Test(priority=1)
//	    public void loginWithValidCredentials() {
//	        LoginPage loginPage = new LoginPage(driver);
//	        loginPage.enterUsername("admin");
//	        loginPage.enterPassword("admin123");
//	        loginPage.clickLogin();
//	    }
//	  @Test(priority=2)
//	  public void loginWithInvalid() {
//		  LoginPage loginPage = new LoginPage(driver);
//	        loginPage.enterUsername("22");
//	        loginPage.enterPassword("n123");
//	        loginPage.clickLogin();
//	       
//		  
//	  }
//	  
//
//	  @Test(priority = 3)
//	  public void loginTitleTest() {
//	      LoginPage loginPage = new LoginPage(driver);
//	      String actual = loginPage.getTitle();
//	      String expected = "Facebook – log in or sign up";  // Or the actual title you expect
//	      Assert.assertEquals(actual, expected, "Page title does not match!");
//	  }
	
	@DataProvider(name = "loginData") // login data file name
    public Object[][] getData() {
		String path = "C:\\Users\\Cloud Laptop\\OneDrive\\Desktop\\testdata\\LoginData.xlsx";

        return ExcelUtil.getExcelData(path, "logindata");
    }


    @Test(dataProvider = "loginData") // excel ke liye
    
    // for allure reports
    @Epic("Login Module")
    @Feature("Login with Excel Data")
    @Story("Data-Driven Testing")
    @Severity(SeverityLevel.NORMAL)
    @Description("Logins using data from Excel file")
    
    
    public void loginWithExcelData(String username, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginToApp(username, password);
        //Assert.assertEquals("Expected", "Actual", "Forcing failure to check allure result");

        // You can assert here (e.g. title or URL check)
         System.out.println("Logged in with: " + username + " | " + password);
//     String expectedTitle = "Facebook"; // Update based on actual expected page
//    Assert.assertEquals(loginPage.getTitle(), expectedTitle, "Login failed for: " + username);

}
    
 
 
}
