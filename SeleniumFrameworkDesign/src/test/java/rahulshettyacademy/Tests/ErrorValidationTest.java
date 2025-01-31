package rahulshettyacademy.Tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import rahulshettyacademy.PageObjects.CartPage;
import rahulshettyacademy.PageObjects.ProductCatalogue;
import rahulshettyacademy.TestComponents.BaseTest;
public class ErrorValidationTest extends BaseTest
{

	@Test(groups = {"ErrorHandling"})
	public void loginErrorValdation() throws InterruptedException, IOException
	{
		
	    
		landingPage.loginApplication("abhishekmone.12@gmail.com", "3573kfk");
		Assert.assertEquals("Incorrect email or password.",landingPage.getErrorMessage() );
		;
		
	}
	
	
	@Test
	public void productErrorValdation() throws InterruptedException, IOException
	{
		String productName = "IPHONE 13 PRO";
	    
		ProductCatalogue productCatalogue =	landingPage.loginApplication("abhishekmone.12@gmail.com", "Auto@123!");
		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);
        CartPage cartPage = productCatalogue.goToCartPage();
        Boolean match = cartPage.VerifyProductDisplay("IPHONE 14");
        Assert.assertFalse(match);
       
	
	}
}
 

