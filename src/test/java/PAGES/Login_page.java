package PAGES;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import BASE_CLASSES.Utilities;



public class Login_page {
	
	 Utilities wt;
		WebDriver dr;
		public Login_page(WebDriver dr)
		{
			this.dr=dr;
			wt=new Utilities(dr);
		}
		public void sign() {
			//clicking signin button
			dr.findElement(By.xpath("/html/body/div[1]/div[2]/div/a[2]")).click();
			
	}
		public void username(String uid)
		{
			//entering the user name
			By by_uid= By.xpath("//input[@name='username']");
			WebElement we_uid =wt.ElementToBeClickable(by_uid,10);
			we_uid.sendKeys(uid);
		}
		
		public void password(String pwd)
		{
			//Enterning the password
			By by_pwd= By.xpath("//input[@name='password']");
			WebElement we_pwd =wt.ElementToBeClickable(by_pwd,10);
			we_pwd.sendKeys(pwd);
		}
		
		public void clickBTN()
		{
			//clicking the login button
			By byclk= By.xpath("//input[@id='login']");
			WebElement we_clk =wt.ElementToBeClickable(byclk,10);
			we_clk.click();
		}
		public String Login(String uid,String pwd)
		{
			this.sign();
			this.username(uid);
			this.password(pwd);
			this.clickBTN();
		 String s=dr.getTitle();
		 System.out.println(s);
		 return s;
			
		}


}
