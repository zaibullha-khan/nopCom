package nopCom;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pageObject.IndexPage;
import com.pageObject.LoginPage;
import com.pageObject.RegPage;

@Listeners(com.utility.ListenerClass01.class)
public class RegPageTest extends BaseClass {
	      RegPage reg;
		  IndexPage index;
		@Parameters("url")
		@BeforeClass(groups= { "smoke","sanity","Regression"})//	Compulsory (groups= { "smoke","sanity","Regression"}) should take here if doing grouping testing
		public void Lounch(String url)
		{      
		      driver.get(url);
		      driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			  driver.manage().window().maximize();
		      driver.manage().deleteAllCookies();
		      reg=new RegPage(driver);
		      index=new IndexPage(driver);
		      index.RegBtnClick();
		    
	    }
		@Test(dataProvider="Registration", groups= {"Regression"})
		public void RegTest(String fname,String lname,String Email,String Cname,String pwd,String Cpwd,String DOD,String DOM,String DOY,String res) throws InterruptedException
		{  
//		System.out.println(fname);
//		System.out.println(lname);
//		System.out.println(Email);
//		System.out.println(Cname);
//		System.out.println(pwd);
//		System.out.println(Cpwd);
//		System.out.println(DOD);
//		System.out.println(DOM);
//		System.out.println(DOY);
//		System.out.println(exp);

		reg.FirstNameField(fname);
		reg.LastnameField(lname);
		reg.EmailIdField(Email);
		reg.CompanyNameFieled(Cname);
		reg.PasswordField(pwd);
		reg.ConPassFields(Cpwd);
		reg.DOBDayDropDown(DOD);
		reg.DOBMonthDropDown(DOM);
		reg.DOBYearDropDown(DOY);
	    reg.clickRegBtn();   
	    Thread.sleep(3000);
	    String exp_url="https://demo.nopcommerce.com/registerresult/1?returnUrl=/";
	    String act_url=driver.getCurrentUrl();
	    System.out.println(act_url);
	    //For valid test
	    if (res.equals("Valid"))
		 {
	    	//For valid test new account have not exist not exist 
		    if(act_url.equals(exp_url))
		    {
			        driver.findElement(By.xpath("//a[@class='ico-register']")).click();
			        Assert.assertTrue(true);
			        System.out.println("Successfully registratared");
		    }
		    //For valid test new account already exist
		    else if(!act_url.equals(exp_url))
		    {
		 	        String ex="The specified email already exists";
		 	    	String ac=driver.findElement(By.xpath("//div[@class='message-error validation-summary-errors']//ul")).getText();
		 	        Assert.assertEquals(ex,ac);
		 	        driver.findElement(By.xpath("//a[@class='ico-register']")).click();
		 	        System.out.println("The specified email already exists");
		 	}
		    else 
		    {
		        Assert.assertTrue(false);
		    } 
       }
	    //For Invalid test
	    else if(res.equals("Invalid"))
		{   
			if(act_url.equals(exp_url))
			{
				
				driver.findElement(By.xpath("//a[@class='ico-register']")).click();
				Assert.assertTrue(false);
			}
			else
			{
				Assert.assertTrue(true);
				
			}
		}
						
		}
		
}