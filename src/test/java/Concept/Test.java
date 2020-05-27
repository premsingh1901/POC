package Concept;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;
import com.paulhammant.ngwebdriver.NgWebDriver;

import poc.com.base.BaseForAngular;


public class Test extends BaseForAngular {
	public static String screenshotPath="C:\\Users\\singhpre\\Desktop\\Unisys\\POC\\POCAngular\\screenshots\\test.png";
	static String currentDirectory = System.getProperty("user.dir");
	public static void main(String[] args) throws IOException {

		System.setProperty("webdriver.chrome.driver",currentDirectory+"\\Drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		javaScriptExecutor=(JavascriptExecutor)driver;
		ngDriver=new NgWebDriver(javaScriptExecutor);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.facebook.com/");
		
		File fileSrc= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//FileUtils.copyFile(fileSrc, new File(screenshotPath));
		 Files.copy(fileSrc, new File(screenshotPath));
			
	}

}
