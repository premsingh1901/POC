package poc.com.dataproviders;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;

import poc.com.utils.TestUtils;

public class DataProviders {
	
	
	@DataProvider(name="getExcelData")
	public Object[][] getDataFromExcel() throws InvalidFormatException
	{
		Object data[][] = TestUtils.getTestData("add");
		return data;
	}

}
