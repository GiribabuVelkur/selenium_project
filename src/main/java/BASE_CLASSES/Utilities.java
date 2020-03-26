package BASE_CLASSES;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utilities {
	WebDriver driver;
	int counter;
	public Utilities(WebDriver driver) 
	{
		this.driver=driver;
	}
	//To Launch the browser
		public WebDriver Launch_browser(String Browser,String url) {
			//To Launch chrome browser
			if(Browser.contains("CHROME"))
			{
		        //setting the chromedriver path
				System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
				driver=new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				driver.get(url);
			}
			//To Launch Firefox browser
			else if(Browser.contains("FIREFOX"))
			{
				//setting the geckodriver path
				System.setProperty("webdriver.gecko.driver", "RESOURCES/DRIVER/geckodriver.exe");
				driver=new FirefoxDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				driver.get(url);
				
			}
			return driver;
			
		}
		
		public WebElement WaitForElement(By locator, int timeout) {
			// TODO Auto-generated constructor stub
		   try {
			WebDriverWait wait=new WebDriverWait(driver,timeout);
			WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			System.out.println("Element Located");
			return element;
		   }
		   catch(Exception e) {
			   System.out.println("Element not located" +e);
		   }
		return null;
		}	
		//To wait up to given element is clickable
		
		public WebElement ElementToBeClickable(By locator,int timeout) {
			try {
			WebDriverWait wait=new WebDriverWait(driver,timeout);
			WebElement element=wait.until(ExpectedConditions.elementToBeClickable(locator));
			return element;
			} catch(Exception e) {
				   System.out.println("Element not located" +e);
			   }
			return null;

	   }
		
//to take screenshot
		
		public void Screenshot()
		{
			String path="C:\\Users\\BLTuser.BLT0207\\Documents\\New folder\\Screenshots\\";
			
			String filename=counter+".png";
			File f1=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			File f2=new File(path+filename);
			try {
				FileUtils.copyFile(f1,f2);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			counter++;
		}

}
