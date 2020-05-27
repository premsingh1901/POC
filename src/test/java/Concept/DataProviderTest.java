package Concept;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import poc.com.utils.TestUtils;

public class DataProviderTest {
	
	
	@DataProvider(name="uds")
	public Integer[][] getDataFromExcel()
	{
		Integer data[][] = new Integer[2][2];
		data[0][0]=5;
		data[0][1]=10;
	//	data[0][2]=20;
		
		data[1][0]=100;
		data[1][1]=200;
		//data[1][2]=300;
		
		//data[2][0]=1000; data[2][1]=2000; data[2][2]=3000;
		 
		
		return data;
	}
	
	
	@Test(dataProvider ="uds" )
	public void getDataProviderData(int num1, int num2)
	{
		//if(num1==5)
		System.out.println("Num1 "+ num1);
		//else
		System.out.println("Num2 "+ num2);
	}
	

}

