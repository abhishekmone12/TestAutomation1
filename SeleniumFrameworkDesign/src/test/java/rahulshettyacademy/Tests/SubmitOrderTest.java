package rahulshettyacademy.Tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import rahulshettyacademy.PageObjects.CartPage;
import rahulshettyacademy.PageObjects.CheckOutPage;
import rahulshettyacademy.PageObjects.ConfirmationPage;
import rahulshettyacademy.PageObjects.OrdersPage;
import rahulshettyacademy.PageObjects.ProductCatalogue;
import rahulshettyacademy.TestComponents.BaseTest;
public class SubmitOrderTest extends BaseTest
{
	
	String productName = "IPHONE 13 PRO";


	@Test(dataProvider = "getData", groups = {"Purchase"})
	public void SubmitOrder(HashMap <String, String> input) throws InterruptedException, IOException
	{
	    
		ProductCatalogue productCatalogue =	landingPage.loginApplication(input.get("email"), input.get("password"));
		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(input.get("product"));
        CartPage cartPage = productCatalogue.goToCartPage();
        Boolean match = cartPage.VerifyProductDisplay(input.get("product"));
        Assert.assertTrue(match);
        CheckOutPage checkoutPage = cartPage.goToCheckOutPage();
        checkoutPage.selectCountry("india");
        ConfirmationPage confirmationPage =  checkoutPage.submitOrder();
        String confirmMessage = confirmationPage.verifyConfirmationMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	
	}
	
	 @Test(dependsOnMethods = {"SubmitOrder"})
	public void VerifyOrderDisplay() {
		
		ProductCatalogue productCatalogue =	landingPage.loginApplication("abhishekmone.12@gmail.com" , "Auto@123!");
		OrdersPage ordersPage = productCatalogue.goToOrdersPage();
		Assert.assertTrue(ordersPage.VerifyOrdersDisplay(productName));
		
	} 
	 
	 
	 @DataProvider()
	 public Object [][] getData() throws IOException
	 {
		  List<HashMap<String, String>> data = getJsonDataToMap(System.getProperty("user.dir") 
					+ "\\src\\test\\java\\rahulshettyacademy\\data\\PurchaseOrder.json");

		return new Object [][] {{data.get(0)}, {data.get(1)}};
		 
	 }
	 
	 /* HashMap<String,String> map = new HashMap <String,String>();
	 
		map.put("email", "xxxxx@gmail.com");
		 map.put("password", "xxxxx");
		 map.put("product", "IPHONE 13 PRO");

		 HashMap<String,String> map1 = new HashMap <String,String>();

		 map1.put("email", "xxxxx@gmail.com");
		 map1.put("password", "IamKing@000");
		 map.put("product", "qwerty"); */
		 		
	 
}
 

