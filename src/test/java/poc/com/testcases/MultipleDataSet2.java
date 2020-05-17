package poc.com.testcases;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import poc.com.base.Base;
import poc.com.base.BaseForAngular;
import poc.com.pages.POCPageForAngular;
import poc.com.utils.TestUtils;

public class MultipleDataSet2 extends BaseForAngular{
	POCPageForAngular pocPage;
	
	public MultipleDataSet2() {
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
	@DataProvider
	public Object[][] getDataFromExcel() throws InvalidFormatException
	{
		Object data[][] = TestUtils.getTestData("add");
		return data;
	}
	
	@Test(priority = 2,dataProvider = "getDataFromExcel")
	public void sumTest(String value1,String value2, String value3)
	{
		
		//String result=pocPage.calValue("10", "20", "-");
		String result=pocPage.calValue(value1, value2, value3);
		Assert.assertEquals(result, "30");
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		//driver.close();
	}

}
