package pratice;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import pageObjects.LandingPage;
import pageObjects.LoginPage;

@Test
@Listeners(pratice.Listeners.class)
public class ValidateTitle extends base {
	public static Logger log =  LogManager.getLogger(ValidateNavigationBar.class.getName());
	public WebDriver driver;

	
	@BeforeTest
	 public void initialize() throws IOException {
		driver = this.initializeDriver();
		log.info("Driver is initialized");
		
		driver.get(prop.getProperty("url"));
		log.info("Navigate to Home Page");
		
	}
	
	@Test
	public void validateAppTitle() throws IOException {
		LandingPage lp= new LandingPage(driver);
		AssertJUnit.assertEquals(lp.getTitle().getText(), "FEATURED COURSES");	
		log.info("Sucessfully validated text message");

	}
	
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}
	

	

}
