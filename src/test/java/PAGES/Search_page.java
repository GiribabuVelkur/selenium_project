package PAGES;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Search_page {
    WebDriver driver;
	
	public Search_page(WebDriver driver) {
		
		this.driver=driver;
	}
	public void search() {
		//enterning the search details
		driver.findElement(By.xpath("//input[@name='keywords']")).sendKeys("fish");
		//clicking the search button
		driver.findElement(By.xpath("//input[@id='searchProducts']")).click();
		
	}

}
