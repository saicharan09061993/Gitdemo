package Automation.E2Eproject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageSource.Loginpage;
import resources.Commondriver;

public class Homepage {
	
	private Commondriver cmn;
	public WebDriver driver;
	public static Logger log=LogManager.getLogger(Homepage2.class.getName());
	@BeforeMethod
	public void ExecuteF() throws Throwable  {
		 cmn =new Commondriver();
		 
		 driver = cmn.getDriver();
		 log.info("driver is intialised");
		cmn.openbrowserandNaviagteToUrl();
		log.info("homepage dipalyed");
		
	}
	@Test()
	public void Loginpage() {
		Loginpage lg=new Loginpage(driver);
		try {
			String str=lg.Forgot();
			System.out.println(str);
			Assert.assertEquals(str,"Reset");
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@AfterMethod
	public void close() throws Exception
	{
		cmn.closeAllBrowser();
	}

}
