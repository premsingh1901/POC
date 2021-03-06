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
		
	}
	
	@BeforeMethod
	public void setUp()
	{
		intilization();
		pocPage=new POCPage();
	}
	
	@Test(priority = 1, enabled = false)
	public void validateTitle()
	{
		
		Assert.assertEquals(pocPage.getTitle(), "Super Calculator");
		
		
	}
	
	@Test(priority = 2)
	public void sumTest()
	{
		String result=pocPage.sumNum("10", "20");
		Assert.assertEquals(result, "30");
				
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}

}
