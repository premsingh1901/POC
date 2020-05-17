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

public class MultipleDataSet extends BaseForAngular{
	
	POCPageForAngular pocPage;
	MultipleDataSet()
	{
		super();
		
	}

	
	@BeforeMethod
	public void setUp()
	{		
		intilization();
		pocPage=new POCPageForAngular();
	}
	
	@DataProvider
	public Object[][] getDataFromExcel() throws InvalidFormatException
	{
		Object data[][] = TestUtils.getTestData("add");
		return data;
	}
	
	@Test(priority = 1, dataProvider ="getDataFromExcel")
	public void calculator(String value1,String value2, String value3, String value4)
		{

		String result=pocPage.calValue(value1, value2, value3);
		Assert.assertEquals(result, "30");
		
	}
	@DataProvider
	public Object[][] getDataFromExcelforMinus() throws InvalidFormatException
	{
		Object data[][] = TestUtils.getTestData("Minus");
		return data;
	}
	
	@Test(priority = 2, dataProvider ="getDataFromExcelforMinus")
	public void calculatorMinus(String valueM1,String valueM2, String valueM3)
		{

		String result=pocPage.calValue(valueM1, valueM2, valueM3);
		Assert.assertEquals(result, "80");
		
	}
	
	
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
	
}
