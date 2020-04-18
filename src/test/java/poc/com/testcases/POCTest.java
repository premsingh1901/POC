package poc.com.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import poc.com.base.Base;
import poc.com.pages.POCPage;

public class POCTest extends Base{
	POCPage pocPage;
	
	public POCTest() {
		super();	
		pocPage=new POCPage();
	}
	
	@BeforeMethod
	public void setUp()
	{
		intilization();
	}
	
	@Test
	public void validateTitle()
	{
		
		Assert.assertEquals(pocPage.getTitle(), "Google");
		
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}

}
