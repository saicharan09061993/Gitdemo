package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;



public class Commondriver {
	private WebDriver driver;
	private long pageLoadTimeOut;
	private long elementDetectionTimeOut;
	public Properties prop;
	
	public WebDriver getDriver()
	{
		return driver;
	}
	public void setPageLoadTimeOut(long pageLoadTimeOut)
	{
		this.pageLoadTimeOut = pageLoadTimeOut;
	}

	public void setElementDetectionTimeOut(long elementDetectionTimeOut)
	{
		this.elementDetectionTimeOut = elementDetectionTimeOut;
	}
    public Commondriver() throws Throwable
    {
    	prop =new Properties();
    	FileInputStream fis= new FileInputStream("C:\\Users\\91995\\Desktop\\New folder\\E2Eproject\\src\\main\\java\\resources\\data.properties");
    	prop.load(fis);
  //  String browserType=prop.getProperty("browser");
    	String browserType=System.getProperty("browser");
    	//browserType =browserType.trim();
    	if(browserType.contains("firefox"))
    	{
    
    		System.setProperty("driver.gecko.drive","C:\\Users\\91995\\Downloads\\geckodriver-v0.29.1-win32.exe");
    		driver = new FirefoxDriver();
    	}
    		
    	else if(browserType.contains("chrome"))
    	{
    		ChromeOptions options=new ChromeOptions();
    		options.addArguments("headless");
    		System.setProperty("webdriver.chrome.driver","C:\\Users\\chromedriver.exe");
    		driver = new ChromeDriver(options);
    	}
    	/*case "ie":
    		System.setProperty("driver.ie.drive","C:\\Users\\91995\\Downloads\\geckodriver-v0.29.1-win32.exe");
    		//driver = new ();
    		break;
         default:
    			throw new Exception("invalid browsertype:"+browserType);*/
    			

    		
    	driver.manage().deleteAllCookies();
    	driver.manage().window().maximize();
    	elementDetectionTimeOut =20l;
    	pageLoadTimeOut=60l;
    	
    }
	
	public void openbrowserandNaviagteToUrl() throws Exception {
		// TODO Auto-generated method stub
		driver.manage().timeouts().pageLoadTimeout(pageLoadTimeOut, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(elementDetectionTimeOut,TimeUnit.SECONDS);
		prop =new Properties();
    	FileInputStream fis= new FileInputStream("C:\\Users\\91995\\Desktop\\New folder\\E2Eproject\\src\\main\\java\\resources\\data.properties");
    	prop.load(fis);
		driver.get(prop.getProperty("Url"));
	}
	
	public String getTitle() throws Exception {
		// TODO Auto-generated method stub
		return driver.getTitle();
	}
	
	
	public String getPageSource() throws Exception {
		// TODO Auto-generated method stub
		return driver.getPageSource();
	}
	
	public String getCurrentUrl() throws Exception {
		// TODO Auto-generated method stub
		return driver.getCurrentUrl();
	}
	
	public void navigateToUrl(String Url) throws Exception {
		// TODO Auto-generated method stub
		driver.navigate().to(Url);
	}
	
	public void navigateForward() throws Exception {
		// TODO Auto-generated method stub
		driver.navigate().forward();
	}
	
	public void navigatebackward() throws Exception {
		// TODO Auto-generated method stub
		driver.navigate().back();
	}
	
	public void refresh() throws Exception {
		// TODO Auto-generated method stub
		driver.navigate().refresh();
	}
	
	public void closeBrowser() throws Exception {
		// TODO Auto-generated method stub
		driver.close();
	}
	
	public void closeAllBrowser() throws Exception {
		// TODO Auto-generated method stub
		driver.quit();
	}
    

 
	public String getScreenShot(String testcaseName,WebDriver driver) throws IOException
	{
		TakesScreenshot ts= (TakesScreenshot) driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		String destinationFile=System.getProperty("user.dir")+"\\reports\\"+testcaseName+".png";
		FileUtils.copyFile(src, new File(destinationFile));
		return destinationFile;
	}






}


	



	


	
	
	



