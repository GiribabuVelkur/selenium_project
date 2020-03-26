package PAGES;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import BASE_CLASSES.Utilities;




public class Register_page {
	Utilities wt;
	WebDriver dr;
	Register_page obj;
	
	
	
	public Register_page(WebDriver dr)
	{
		this.dr=dr;
		wt=new Utilities(dr);
	}
	
	public void  clk_signup() {
		//click on the signup button
		dr.findElement(By.xpath("//*[@id=\"MenuContent\"]/a[2]")).click();
		
	}
	public void clk_on_register() 
	{
		// click the register button
		By cr=By.xpath("//div[@id='Catalog']//a");
		WebElement we_cr=wt.ElementToBeClickable(cr, 20);
		we_cr.click();
		
	}


	public void unm(String mun) {
		//entering username
		
		By un=By.xpath("//input[@id='username']");
		WebElement w_un=wt.WaitForElement(un, 20);
		w_un.sendKeys(mun);
		
		
	}
	public void pdm(String pwd) {
		//enterning password
		 
		By pd=By.xpath("//input[@id='password']");
		WebElement w_pd=wt.WaitForElement(pd, 10);
		w_pd.sendKeys(pwd);
		
		
	}
	public void cpdm(String cpwd) {
		//enterning the re password
		By cpd=By.xpath("//input[@id='repeatedPassword']");
		WebElement w_cpd=wt.WaitForElement(cpd, 10);
		w_cpd.sendKeys(cpwd);
		
		
	}
	public void fnm(String nm) {
		//entering the name
		By fn=By.xpath("//input[@id='firstName']");
		WebElement w_fn=wt.WaitForElement(fn, 10);
		w_fn.sendKeys(nm);
		
		
	}
	public void lnm(String lsn) {
		//enterning the lastname
		By ln=By.xpath("//input[@id='lastName']");
		WebElement w_ln=wt.WaitForElement(ln, 10);
		w_ln.sendKeys(lsn);
		
		
	}

	public void eidm(String em) {
		//enterning the emailid
		By eid=By.xpath("//input[@id='email']");
		WebElement w_eid=wt.WaitForElement(eid, 10);
		w_eid.sendKeys(em);
		
		
	}

	public void pnm(String ph) {
		//entering the phone number
		By pn=By.xpath("//input[@id='phone']");
		
		WebElement w_pn=wt.WaitForElement(pn, 10);
		w_pn.sendKeys(ph);
		
		
	}

	public void ad1m(String a1) {
		//enterning the address
		By ad1=By.xpath("//input[@id='address1']");
		
		WebElement w_ad1=wt.WaitForElement(ad1, 10);
		w_ad1.sendKeys(a1);
		
		
	}

	public void ad2m(String a2) {
		//enterning the address 2
		By ad2=By.xpath("//input[@id='address2']");
		
		WebElement w_ad2=wt.WaitForElement(ad2, 10);
		w_ad2.sendKeys(a2);
		
		
	}

	public void ctnm(String c) {
		//enterning the city
		By ctn=By.xpath("//input[@id='city']");
		WebElement w_ctn=wt.WaitForElement(ctn, 10);
		w_ctn.sendKeys(c);
		
		
	}

	public void snm(String s) {
		//enterning the state
		By sn=By.xpath("//input[@id='state']");
		WebElement w_sn=wt.WaitForElement(sn, 10);
		w_sn.sendKeys(s);
		
		
	}
	

	public void zipm(String z) {
		//enterning the zipcod
		By zip=By.xpath("//input[@id='zip']");
		WebElement w_zip=wt.WaitForElement(zip, 10);
		w_zip.sendKeys(z);
		
		
	}
	public void cnm(String ct) {
		//enterning the country
		By cn=By.xpath("//input[@id='country']");
		WebElement w_cn=wt.WaitForElement(cn, 10);
		w_cn.sendKeys(ct);
		
		
	}
	public void lpm() {
		//enterning the language oreference
		By lp=By.xpath("//select[@id='languagePreference']//child::option[1]");
		WebElement w_lp=wt.ElementToBeClickable(lp, 10);
		w_lp.click();
		
		
	}
	public void cat() {
		//click the bird
	By by_category= By.xpath("//option[@value='BIRDS']");
	WebElement we_category =wt.ElementToBeClickable(by_category,10);
	we_category.click();
	}
	public void ltm()
	{
		// enter the listoptions
	By by_list= By.xpath("//input[@id='listOption1']");
	WebElement we_list =wt.ElementToBeClickable(by_list,10);
	we_list.click();
	}
	public void bnm() {
		//click the banner options
	By by_banner= By.xpath("//input[@id='bannerOption1']");
	WebElement we_banner =wt.ElementToBeClickable(by_banner,10);
	we_banner.click();
	}
	public void sm() {
		//click the save information button
	By by_save= By.xpath("//input[@value='Save Account Information']");
	WebElement we_save =wt.ElementToBeClickable(by_save,10);
	we_save.click();
	}
	
	public  void do_reg(String un,String pd,String cpd,String nm,String ln,String eml,String ph,String a1,String a2,String ct,String st,String zp,String ctr) {
		
		obj=new Register_page(dr);
		obj.clk_signup();
		obj.clk_on_register();
		obj.unm(un);
		obj.pdm(pd);
		obj.cpdm(cpd);
		obj.fnm(nm);
		obj.lnm(ln);
		obj.eidm(eml);
		obj.pnm(ph);
		obj.ad1m(a1);
		obj.ad2m(a2);
		obj.ctnm(ct);
		obj.snm(st);
		obj.zipm(zp);
		obj.cnm(ctr);
		obj.lpm();
		obj.cat();
		obj.ltm();
		obj.bnm();
		obj.sm();
		
	}
	

}
