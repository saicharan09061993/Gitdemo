package Automation.E2Eproject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageSource.Loginpage;
import resources.Base;
import resources.Commondriver;

public class Homepage2 {

	private Commondriver cmn;
	private WebDriver driver;
	public static Logger log=LogManager.getLogger(Homepage2.class.getName());
	@BeforeMethod
	public void ExecuteFirst() throws Throwable  {
		 cmn =new Commondriver();
		 
		 driver = cmn.getDriver();
		 log.info("driver is intialised");
		cmn.openbrowserandNaviagteToUrl();
		log.info("homepage dipalyed");
		
	}
	

	@Test(dataProvider="getData")
	public void loginp(String user,String pass,String text)
	{
		try {
			
			Loginpage lg=new Loginpage(driver);
			String str=lg.login("user", "pass");
			System.out.println(text);
			System.out.println(str);
			log.info(str);
		
			
		} 
		catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@AfterMethod
	public void close() throws Exception
	{
		cmn.closeAllBrowser();
	}
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data=new Object[2][3];
		data [0][0]= "saicharan";
		data [0][1]= "123456";
		data [0][2]= "santhosh";
		data [1][0]= "4656";
		data [1][1]= "charan";
		data [1][2]= "8778785";
		return data;
	}

}
