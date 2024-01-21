package nopCom;

import java.util.concurrent.TimeUnit;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.base.BaseClass;
import com.pageObject.IndexPage;
import com.utility.logs;
@Listeners(com.utility.ListenerClass01.class)
public class IndexPageTest extends BaseClass {
	 IndexPage index;
   @Parameters("url")
	@BeforeClass(groups= { "smoke","sanity","Regression"})//	Compulsory (groups= { "smoke","sanity","Regression"}) should take here if doing grouping testing
	public void OpenWebsit()
	{ 
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		index=new IndexPage(driver);	
	}	 
@Test(priority=1,groups= "smoke")
public void TitleValidate() 
{	
	String expectedTitle=driver.getTitle();
	String actualTitle="nopCommerce demo store";
	Assert.assertEquals(expectedTitle,actualTitle);
    logs.info("get title verification");
}
@Test(groups="smoke")
public void nopCommerceLogoDispValidate() 
{ 
	Boolean logo=index.nopCommerceLogoDisplayed();
	Assert.assertTrue(logo);
}
@Test(groups="smoke")
public void RegBtnDisplayedValidate() 
{       
		Boolean Btn1=index.RegBtnDisplayed();
        Assert.assertTrue(Btn1);
        
}
@Test(groups="smoke")
public void RegBtnClickValidate() throws InterruptedException 
{
	index.RegBtnClick();
	Thread.sleep(3000);
	String expectedUrl=driver.getCurrentUrl();
	System.out.println(expectedUrl);
	Assert.assertNotEquals(expectedUrl, "https://demo.nopcommerce.com/register?returnUrl=%2F"); 
	driver.navigate().back();
}
@Test
public void logInBtn()
{
	index.logInPageBtnClick();
	String url=driver.getCurrentUrl();
	Assert.assertEquals(url, "https://demo.nopcommerce.com/login?returnUrl=%2F");
	driver.navigate().back();
}

@Test
public void ClickOnWishListValidation()
{
	index.ClickOnWishList();
	String expectedUrl=driver.getCurrentUrl();
	System.out.println(expectedUrl);
	Assert.assertEquals(expectedUrl,"https://demo.nopcommerce.com/wishlist");	
	driver.navigate().back();
}
@Test
public void ClickOnShoppingCartValidation()
{
	index.ClickOnShoppingCart();
	String expectedUrl=driver.getCurrentUrl();
	System.out.println(expectedUrl);
	Assert.assertEquals(expectedUrl,"https://demo.nopcommerce.com/cart");	
	driver.navigate().back();
}
@Test
public void Seachproduct() throws InterruptedException
{
    index.searchField("build");
    Thread.sleep(3000);
	index.searchProduct("Build your own computer");
	String url=driver.getCurrentUrl();
	Assert.assertEquals(url,"https://demo.nopcommerce.com/build-your-own-computer");
	driver.navigate().back();

}

}
