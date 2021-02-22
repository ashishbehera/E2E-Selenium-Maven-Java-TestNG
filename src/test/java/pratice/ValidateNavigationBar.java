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
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import pageObjects.LandingPage;
import pageObjects.LoginPage;

@Test
public class ValidateNavigationBar extends base {
	public static Logger log =  LogManager.getLogger(ValidateNavigationBar.class.getName());
	public WebDriver driver;

	
	@BeforeTest
	 public void initialize() throws IOException {
		driver = this.initializeDriver();
		driver.get(prop.getProperty("url"));
		
	}
	
	@Test
	public void validateTitle() throws IOException {

		LandingPage lp= new LandingPage(driver);
		AssertJUnit.assertTrue(lp.getNavigationBar().isDisplayed());
		log.info("Navigation Bar is displayed");
		
	}
	

	@AfterTest
	public void tearDown() {
		driver.close();
	}

}
