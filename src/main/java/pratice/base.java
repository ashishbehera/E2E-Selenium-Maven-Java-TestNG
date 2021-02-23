package pratice;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public class base {
	
	public WebDriver driver ;
	public Properties prop;
	
	public WebDriver initializeDriver() throws IOException {
		String path = System.getProperty("user.dir") + "//src//main//java//resources//data.properties";
		 prop = new Properties();
		FileInputStream fis = new FileInputStream(path);
		prop.load(fis);
		//String browserName = prop.getProperty("browser");
		String browserName = System.getProperty("browser");
		System.out.println("browserName"+browserName);
		
		if(browserName.contains("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") +"//driver//chromedriver");
			ChromeOptions options = new ChromeOptions();
			if(browserName.contains("headless"))
			options.addArguments("headless");
			 driver = new ChromeDriver(options);
		} 
		else if(browserName.equalsIgnoreCase("firefox")) {		
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") +"//driver//geckodriver");
			 driver = new FirefoxDriver();
		}else if(browserName.equalsIgnoreCase("safari")) {			
			 driver = new SafariDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
		
		
		
	}
	
	public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String time = timestamp.toString();
		String destFile = System.getProperty("user.dir") + "//Screenshots//"+ testCaseName+"_"+time+ ".png";
		FileUtils.copyFile(source,new File(destFile));
		
		return destFile;
		
	}

}
