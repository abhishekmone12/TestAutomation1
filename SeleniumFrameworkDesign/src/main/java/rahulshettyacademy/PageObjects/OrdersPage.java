package rahulshettyacademy.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.AbstractComponent;

public class OrdersPage extends AbstractComponent{

	WebDriver driver;

	public OrdersPage(WebDriver driver)
	{
		super(driver);
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(css= "tr td:nth-child(3)")
	private List<WebElement> productNames;
	
	
	   public Boolean VerifyOrdersDisplay(String productName)
	   {	   
		   
	    Boolean match = productNames.stream().anyMatch(Product-> Product.getText().equalsIgnoreCase(productName));
	    return match;
       }
	
	
	
}
