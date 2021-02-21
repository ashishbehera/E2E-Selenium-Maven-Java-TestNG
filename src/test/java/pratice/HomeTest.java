package pratice;

import org.testng.annotations.Test;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.ForgotPassword;
import pageObjects.LandingPage;
import pageObjects.LoginPage;

@Test
public class HomeTest extends base {
	public static Logger log =  LogManager.getLogger(ValidateNavigationBar.class.getName());
	public WebDriver driver;

	
	@BeforeTest
	 public void initialize() throws IOException {
		driver = this.initializeDriver();
		
	}

	@Test(dataProvider = "getData")
	public void basePageNavigation(String userName,String password,String userInfo) throws IOException {
		driver.get(prop.getProperty("url"));
		LandingPage landPageObjects = new LandingPage(driver);
		LoginPage lp =landPageObjects.getLogin();
		lp.getEmail().sendKeys(userName);
		lp.getPassword().sendKeys(password);
		log.info(userInfo);
		lp.getLogin().click();
		ForgotPassword fp = lp.forgetPassword();
		fp.getEmail().sendKeys("xxxxxx");
		fp.sendMeInstructions();
	}
	
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}
	
	
	
	@DataProvider
	public Object[][] getData() {
		
		Object[][] data = new Object[2][3];
		data[0][0] = "non.restricted@gmail.com";
		data[0][1] = "12345";
		data[0][2] = "Non Restricted User";
		
		data[1][0] = "restricted.com";
		data[1][1] = "67854";
		data[1][2] = "Restricted User";
		
		return data;
	}
	
	

}
