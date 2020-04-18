package Test;

import org.openqa.selenium.chrome.ChromeDriver;

public class Test {

	public static void main(String[] args) {
		
		String currentDirectory = System.getProperty("user.dir");
		System.out.println(currentDirectory+"\\Drivers\\chromedriver.exe");
		
		
		String filePath=currentDirectory+"\\src\\main\\java\\poc\\com\\config\\config.Properties";
			
		System.out.println(filePath);
		

	}

}
