package TESTS;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import BASE_CLASSES.Utilities;
import EXCEL.Read_excel;
import PAGES.Add_to_cart;
import PAGES.Products_incart;

import PAGES.Login_page;
import PAGES.Register_page;
import PAGES.Screen_shot;
import PAGES.Search_page;

public class Test_Jpet extends Read_excel {
	WebDriver driver;
	Utilities ult;

	
	Register_page Rp;
	Login_page Lp;
	Search_page sp;
	Add_to_cart ac;
	Products_incart ap;
	Screen_shot sc;
	
	
	
	@BeforeClass
	public void bfc() 
	{
		ult=new Utilities(driver);
		get_data();
		
		
	}
	@BeforeMethod
	public void bfm() 
	{
		//passing url and browser to base class function
		driver=ult.Launch_browser("CHROME", "https://jpetstore.cfapps.io/catalog");
		//creating a object to the register function
		Rp=new Register_page(driver);
		
		
		//creating a object to the login function
			Lp=new Login_page(driver);
			//creating a object to the search function
		sp=new Search_page(driver);
		//ceating a object to the addcart function
		ac=new Add_to_cart(driver);
		//creating a  object to products in cart function
		ap=new Products_incart(driver);
		//creating a object to the screenshot function
		sc=new Screen_shot(driver);
	}
  
@Test(dataProvider="loginpage")
  public void Register_login(String un,String pd,String cpd,String nm,String ln,String eml,String ph,String a1,String a2,String ct,String st,String zp,String ctr,String uid,String pwd) throws IOException 
  {
	  
	  String phn=ph.substring(1, 10);
	  String zpc=zp.substring(1, 6);
	  //calling register function
	  Rp.do_reg(un,pd,cpd,nm,ln,eml,phn,a1,a2,ct,st,zpc,ctr);
  
	 
	  
	  
	 //calling login function 
	 String s= Lp.Login(uid,pwd);
	 Assert.assertTrue(s.contains("Demo"));
	 
	  
  }
	  @Test(priority=4)
	  public void search_secenario() throws IOException {
	  //calling searching function
		  sp.search();
		  //calling add cart function
	  ac.add_product();
	  //calling screen shot function
	  sc.Take_screenshot();
	  ap.adding();
	  
  }
  @DataProvider(name="loginpage")
  public String[][] Provide_data()
  {
	  //reading a data from excel
	  return testdata;
  }
  
}
