package poc.com.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Driver;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Base {
	
	public static WebDriver driver;
	public static Properties prop;
	static String currentDirectory = System.getProperty("user.dir");
	String filePath=currentDirectory+"\\src\\main\\java\\poc\\com\\config\\config.Properties";
		
	public Base()
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
			if(browserName.equals("Chrome"))
			{
				System.setProperty("webdriver.chrome.driver",currentDirectory+"\\Drivers\\chromedriver.exe");
				driver=new ChromeDriver();
			}
			if(browserName.equals("Firfox"))
			{
				System.setProperty("webdriver.gecko.driver",currentDirectory+"\\Drivers\\geckodriver.exe");
				driver=new FirefoxDriver();
			}
			if(browserName.equals("IE"))
			{
				System.setProperty("webdriver.ie.driver",currentDirectory+"\\Drivers\\IEDriverServer.exe");
				driver=new InternetExplorerDriver();
			}
			
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.get(prop.getProperty("url"));
			
		}
		
}



