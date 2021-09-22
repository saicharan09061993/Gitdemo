package resources;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Base {
	private WebDriver driver;
	public Base(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
   public Alert getAlert() 
	{
	return driver.switchTo().alert();
	}
   public void acceptAlert() throws Exception
   {
	   getAlert().accept();
   }
   public void rejectAlert() throws Exception
   {
	   getAlert().dismiss();
   }
   public String getTextOnAlert() throws Exception
   {
	 return getAlert().getText();  
   }
   public void changetheStatusOfCheckbox(WebElement element,boolean status)throws Exception
   {
	   if((element.isSelected()&&!status)||(element.isSelected()&&status))
	   {
		   element.click();
	   }
   }
   public void cliking(WebElement element)throws Exception
   {
	   element.click();   
   }
   public String getText(WebElement element) throws Exception
   {
	   return element.getText();
   }
   public String getAttribute(WebElement element)throws Exception
   {
	   return element.getAttribute(null);
   }
   public String getCssvalue(WebElement element) throws Exception
   {
	   return element.getCssValue(null);
   }
   public boolean isElementVisible(WebElement element) throws Exception
   {
	   return element.isDisplayed();
   }
   public boolean isElementSelected(WebElement element) throws Exception
   {
	   return element.isSelected();
   }
   public boolean isElementEnabled(WebElement element) throws Exception
   {
	   return element.isEnabled();
   }
   public Select dropDown(WebElement element)throws Exception
   {
	   Select dropdown = new Select(element);
	   return dropdown;
   }
   public void selecteviaVisibleText(WebElement element,String visibleText)throws Exception
   {
	   dropDown(element).selectByVisibleText(visibleText);
   }
   public void selecteviaindex(WebElement element,int index)throws Exception
   {
	   dropDown(element).selectByIndex(index);
   }
   public void selecteviaValue(WebElement element,String value)throws Exception
   {
	   dropDown(element).selectByValue(value);
   }
   public boolean isMultiple(WebElement element)throws Exception
   {
	   return dropDown(element).isMultiple();
   }
   public List<WebElement> getAllOptions(WebElement element)throws Exception
   {
	   return  dropDown(element).getOptions();
   }
   public List<WebElement> getAllSelectedOptions(WebElement element)throws Exception
   {
	   return  dropDown(element).getAllSelectedOptions();
   }
   public WebElement getFirstSelectedOption(WebElement element)throws Exception
   {
	   return dropDown(element).getFirstSelectedOption();
   }
   public void changeToFrame(String frameId)throws Exception
   {
	 driver.switchTo().frame(frameId);
   }
   public void changeToFrame(WebElement element)throws Exception
   {
	 driver.switchTo().frame(element);
   }
   public void changeToFrame(int index)throws Exception
   {
	 driver.switchTo().frame(index);
   }
   public void switchToDefaultContent()throws Exception
   {
	 driver.switchTo().defaultContent();  
   
   }
   public JavascriptExecutor jsEngine()throws Exception
   {
	   JavascriptExecutor js=(JavascriptExecutor)driver;
	   return js;
   }
   public void executeJavascript(String scriptToExecute)throws Exception
   {
	   jsEngine().executeScript(scriptToExecute);
   }
   public void scrollDown(int x,int y)throws Exception
   {
	   String scriptToExecute=String.format("window.scrollBy(%d,%d)",x,y);
	   jsEngine().executeScript(scriptToExecute);
   }
   public String executeJavascriptwithReturnValue(String scriptToExecute)throws Exception
   {
	  return (String) jsEngine().executeScript(scriptToExecute);
   }
   public Actions mouseOperation()throws Exception
   {
	   Actions act=new Actions(driver);
	   return act;
   }
   public void dragAndDrop(WebElement element1,WebElement element2)throws Exception
   {
	   mouseOperation().dragAndDrop(element1, element2).build().perform();
   }
   public void moveToElement(WebElement element)throws Exception
   {
	   mouseOperation().moveToElement(element).build().perform();
   }
   public void rightClick(WebElement element)throws Exception
   {
	   mouseOperation().contextClick(element).build().perform();
   }
   public void doubleClick(WebElement element)throws Exception
   {
	   mouseOperation().doubleClick(element).build().perform();
   }
   public void moveToElementAndClick(WebElement element)throws Exception
   {
	   mouseOperation().moveToElement(element).click().build().perform();
   }
   public void setText(WebElement element,String setText)throws Exception
   {
	   element.sendKeys(setText);
   }
   public void clearText(WebElement element)throws Exception
   {
	   element.clear();
   }
   public void changeToChildWindow()throws Exception
   {
	   String childWindow=driver.getWindowHandles().toArray()[1].toString();
	   driver.switchTo().window(childWindow);
   }
   public void switchToAnyWindow(String windowHandle)throws Exception
   {
	   driver.switchTo().window(windowHandle);
   }
   public Set<String> getAllWindowHandle()throws Exception
   {
	  return  driver.getWindowHandles();
   }
   public String getWindowhandle()throws Exception
   {
	   return driver.getWindowHandle();
   }
   public void changeToChildWindow(int index)throws Exception
   {
	   String childWindow=driver.getWindowHandles().toArray()[index].toString();

	  	   driver.switchTo().window(childWindow);
   }
}
