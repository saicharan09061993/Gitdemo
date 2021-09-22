package pageSource;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import resources.Base;



public class Landingpage {

	
	private Base b;
	@FindBy(id="twotabsearchtextbox")
	private WebElement SearchBox;
	@FindBy(id="searchDropdownBox")
	private WebElement Searchcat;
	@FindBy(id="nav-search-submit-button")
	private WebElement SearchButton;
	@FindBy(xpath="//h1/div/div/div[1]")
	private WebElement resultcount;
	public Landingpage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		b=new Base(driver);
	}
	 public String  searchProduct(String product,String category) throws Exception
	   {
		   b.setText(SearchBox,product);
			b.selecteviaVisibleText(Searchcat,category);
			b.cliking(SearchButton);
			return b.getText(resultcount);
			
	   }

}

