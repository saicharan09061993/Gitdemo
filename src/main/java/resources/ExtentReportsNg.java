package resources;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsNg {
	        public static ExtentReports extent;
			@BeforeTest
			public static ExtentReports config()
			{
				String path = System.getProperty("user.dir")+"\\reports\\index.html";
				ExtentSparkReporter reportes = new ExtentSparkReporter(path);
				reportes.config().setReportName("web automation results");
				reportes.config().setDocumentTitle("test results");
				extent = new ExtentReports();
				extent.attachReporter(reportes);
				extent.setSystemInfo("Tester", "Saicharan");
				return extent;
				
			}
			@Test
			public void initialdemo()
			{
				ExtentTest test= extent.createTest("Initial Demo");
				System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
				WebDriver driver = new ChromeDriver();
				driver.get("https://rahulshettyacademy.com/AutomationPractice/");
				extent.flush();
			}


	}


