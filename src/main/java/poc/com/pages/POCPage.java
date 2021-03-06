package poc.com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.paulhammant.ngwebdriver.*;

import poc.com.base.Base;

public class POCPage extends Base {
	
		
	
	@FindBy(xpath = "//input[@name='q']")
	WebElement searchBox;
	
	public String getTitle()
	{
		return driver.getTitle();
	}
	
	@ByAngularModel.FindBy(model = "first")
	WebElement firstTextField;
	
	@ByAngularModel.FindBy(model = "second")
	WebElement secondTextField;
	
	@ByAngularModel.FindBy(model = "operator")
	WebElement operator;
	
	@ByAngularButtonText.FindBy(buttonText = "Go!")
	WebElement buttonGo;

	
	@FindBy(tagName="h2")
	WebElement result;
	
	public String sumNum(String v1, String v2) 
	{
		firstTextField.clear();
		firstTextField.sendKeys(v1);
		
		operator.sendKeys("+");
		
		secondTextField.clear();
		secondTextField.sendKeys(v2);
		buttonGo.click();
		try {
		Thread.sleep(2000);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		System.out.println(result.getText());
		return result.getText();
		
		
	}

	
	

	public POCPage(){
		PageFactory.initElements(driver, this);
	}
}
