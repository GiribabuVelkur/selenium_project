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

public class Test_Jpet  {
	WebDriver driver;
	Utilities ult;
	Read_excel read;

	
	Register_page Register;           
	Login_page Login;
	Search_page search;
	Add_to_cart addcart;
	Products_incart productincart;       
	Screen_shot screenshot;
	
	
	
	@BeforeClass
	public void beforeclass() 
	{
		ult=new Utilities(driver);
		read=new Read_excel();
		read.get_data();
		
		
	}
	@BeforeMethod
	public void beforemethod() 
	{
		//passing url and browser to base class function
		driver=ult.Launch_browser("CHROME", "https://jpetstore.cfapps.io/catalog");
		//creating a object to the register function
		Register=new Register_page(driver);
		
		
		//creating a object to the login function
			Login=new Login_page(driver);
			//creating a object to the search function
		search=new Search_page(driver);
		//ceating a object to the addcart function
		addcart=new Add_to_cart(driver);
		//creating a  object to products in cart function
		productincart=new Products_incart(driver);
		//creating a object to the screenshot function
		screenshot=new Screen_shot(driver);
	}
  
@Test(dataProvider="loginpage")
  public void Register_login(String un,String pd,String cpd,String nm,String ln,String eml,String ph,String a1,String a2,String ct,String st,String zp,String ctr,String uid,String pwd) throws IOException 
  {
	  
	  String phn=ph.substring(1, 10);
	  String zpc=zp.substring(1, 6);
	  //calling register function
	  Register.do_reg(un,pd,cpd,nm,ln,eml,phn,a1,a2,ct,st,zpc,ctr);
  
	 
	  
	  
	 //calling login function 
	 String s= Login.Login(uid,pwd);
	 Assert.assertTrue(s.contains("Demo"));
	 driver.quit();
	 
	  
  }
	  @Test(priority=2)
	  public void search_secenario() throws IOException {
	  //calling searching function
		  Login.Login("giri","babuyadav");
		  //calling searching function
		  search.search();
		  //calling adda_product function
		  addcart.add_product(); 
		  //calling screenshot function
		  screenshot.Take_screenshot();
		  driver.close();
		  
	  }
		  //calling add cart function
	
	  @Test(priority=3) public void adding_product() throws IOException { 
		  String expected="Thank you, your order has been submitted.";
	  Login.Login("giri","babuyadav"); 
	  search.search(); 
	  //calling add_product function
	  addcart.add_product(); 
	  //calling placing_order class
	   String Actuals= productincart.placing_order();
	  Assert.assertEquals(Actuals, expected);
	  
	 
	  
  }
  @DataProvider(name="loginpage")
  public String[][] Provide_data()
  {
	  //reading a data from excel
	  read=new Read_excel();
		return read.get_data();
	 
  }
  
}
