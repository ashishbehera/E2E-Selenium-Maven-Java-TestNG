package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	public WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By email = By.id("user_email");
	By password = By.id("user_password");
	By login = By.name("commit");
	By forgetPassword = By.cssSelector("[href*='password']");

	
	
	public WebElement getEmail() {
		return driver.findElement(email);
	}
	
	public WebElement getPassword() {
		return driver.findElement(password);
	}
	
	public WebElement getLogin() {
		return driver.findElement(login);
		
	}
	
	public ForgotPassword forgetPassword() {
		driver.findElement(forgetPassword).click();
		 ForgotPassword fp = new ForgotPassword(driver);
		return fp;

	}

}
