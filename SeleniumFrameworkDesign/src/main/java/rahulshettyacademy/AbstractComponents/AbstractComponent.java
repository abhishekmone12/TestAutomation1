package rahulshettyacademy.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.bytebuddy.asm.MemberSubstitution.FieldValue;
import rahulshettyacademy.PageObjects.CartPage;
import rahulshettyacademy.PageObjects.OrdersPage;

public class AbstractComponent 
{

	WebDriver driver;
	
	public AbstractComponent(WebDriver driver) {
		
		this.driver = driver ;
		PageFactory.initElements(driver, this);
		
	}
	
	
	@FindBy(css = "[routerlink*='cart']")
	WebElement cartHeader;
	
	@FindBy(css = "[routerlink*='myorders']")
	WebElement orderHeader;
	
/*	<button _ngcontent-jaw-c33="" routerlink="/dashboard/myorders" class="btn btn-custom" style="margin-top: -10px;"
			+ "" tabindex="0"><i _ngcontent-jaw-c33="" class="fa fa-handshake-o"></i>&nbsp; ORDERS</button> */

	public void waitForElementToAppear(By findBy)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
		
	}
	
	public void waitForWebElementToAppear(WebElement findBy)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(findBy));
		
	}
	
	
	public void waitForElementToDisappear(WebElement ele) throws InterruptedException
	{
		Thread.sleep(1000);
	//	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	//	wait.until(ExpectedConditions.invisibilityOf(ele));
		
	}
	
	public CartPage goToCartPage() 
	{
		cartHeader.click(); 
         return new CartPage(driver);
        
	}
	
	public OrdersPage goToOrdersPage() 
	{
		orderHeader.click(); 
      return new OrdersPage(driver);
	}
}
