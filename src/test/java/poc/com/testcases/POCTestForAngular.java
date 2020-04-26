package poc.com.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import poc.com.base.BaseForAngular;

import poc.com.pages.POCPageForAngular;

public class POCTestForAngular extends BaseForAngular{
	POCPageForAngular pocPage;
	
	public POCTestForAngular() {
		super();	
		
	}
	
	@BeforeMethod
	public void setUp()
	{
		intilization();
		pocPage=new POCPageForAngular();
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
