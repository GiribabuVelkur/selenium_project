package PAGES;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Products_incart {
WebDriver dr;
	
	public Products_incart (WebDriver dr) {
		
		this.dr=dr;
	}
	public void adding() {
		//clicking add to cart button
		dr.findElement(By.xpath("//a[@href=\"/cart?add&itemId=EST-2\"]")).click();
		//displaying product information in cart
		String s=dr.findElement(By.xpath("//*[@id=\"Cart\"]/form")).getText();
		System.out.println(s);
	}

}
