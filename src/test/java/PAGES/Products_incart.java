package PAGES;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import BASE_CLASSES.Utilities;

public class Products_incart {
WebDriver dr;
Utilities wt;
	
	public Products_incart (WebDriver dr) {
		
		this.dr=dr;
		wt=new Utilities(dr);
	}
	public void adding() {
		//clicking add to cart button
		 By cr=By.xpath("//a[@href=\"/cart?add&itemId=EST-2\"]");  
		WebElement we_cr=wt.ElementToBeClickable(cr, 20);
		we_cr.click();
	}
		public void cart() {
		//displaying product information in cart
		String s=dr.findElement(By.xpath("//*[@id=\"Cart\"]/form")).getText();
		System.out.println(s);
	}
		public void  myorders() {
			//clicking placing order button
			
			
		By my=By.xpath("//a[@href='/my/orders/create?form']");
		WebElement We_my=wt.ElementToBeClickable(my, 20);
		We_my.click();
		}
		
		public void creditcard() {
		
			//Enterning the credit card number
		By cd=By.xpath("//input[@name='creditCard']");
		WebElement W_cd=wt.WaitForElement(cd, 10);
		W_cd.sendKeys("5462897859858");
		
		}
		public void expiredate() {
			//Enterning the credit card expire date
		dr.findElement(By.xpath("//input[@id='expiryDate']")).sendKeys("05/2028");
		
		
		}
		public void continueorder() {
			//clicking continue button
		dr.findElement(By.xpath("//input[@name='continue']")).click();
		}
		public void clickorders() {
			
			//clicking order button
		dr.findElement(By.xpath("//input[@id='order']")).click(); 
		}
		public String orderstatus() {
			//checking order status
		String Actual=dr.findElement(By.xpath("//li[@class='success']")).getText();
		System.out.println(Actual);
		return Actual;
	}
		public String placing_order() {
			this.adding();
			this.cart();
			this.myorders();
			this.creditcard();
			this.expiredate();
			this.continueorder();
			this.clickorders();
			return this.orderstatus();
		}

}
