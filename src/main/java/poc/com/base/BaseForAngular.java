package poc.com.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.paulhammant.ngwebdriver.NgWebDriver;

/**
 * @author SinghPre
 *
 */
public class BaseForAngular {
	
	public static WebDriver driver;
	public static NgWebDriver ngDriver;
	public static JavascriptExecutor javaScriptExecutor;
	public static Properties prop;
	
	/*
	 * To get the directory of the current user
	 */
	static String currentDirectory = System.getProperty("user.dir");
	String filePath=currentDirectory+"\\src\\main\\java\\poc\\com\\config\\config.Properties";
	
		
	
		
	public BaseForAngular()
	{
		try{
			prop=new Properties();
			FileInputStream fis=new FileInputStream(filePath);
			prop.load(fis);
			
		}catch(FileNotFoundException ex) {
			ex.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
			
		}
		
	}
		public static void intilization()
		{
			String browserName=prop.getProperty("browserType");
			if(browserName.equalsIgnoreCase("Chrome"))
			{
				System.setProperty("webdriver.chrome.driver",currentDirectory+"\\Drivers\\chromedriver.exe");
				//WebDriverManager.chromedriver().version(“2.40”).setup(); 
				
				driver=new ChromeDriver();
				javaScriptExecutor=(JavascriptExecutor)driver;
				ngDriver=new NgWebDriver(javaScriptExecutor);
			}
			if(browserName.equalsIgnoreCase("Firfox"))
			{
				System.setProperty("webdriver.gecko.driver",currentDirectory+"\\Drivers\\geckodriver.exe");
				driver=new FirefoxDriver();
				javaScriptExecutor=(JavascriptExecutor)driver;
				ngDriver=new NgWebDriver(javaScriptExecutor);
			}
			if(browserName.equalsIgnoreCase("IE"))
			{
				System.setProperty("webdriver.ie.driver",currentDirectory+"\\Drivers\\IEDriverServer.exe");
				driver=new InternetExplorerDriver();
				javaScriptExecutor=(JavascriptExecutor)driver;
				ngDriver=new NgWebDriver(javaScriptExecutor);
			}
			
			//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.get(prop.getProperty("url"));
			
		}
		
}



