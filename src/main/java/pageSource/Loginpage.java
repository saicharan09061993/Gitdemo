package pageSource;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import resources.Base;

public class Loginpage {
private Base b;
@FindBy(id="user_email")
private WebElement email;
@FindBy(id="user_password")
private WebElement Password;
@FindBy(xpath="//input[@value='Log In']")
private WebElement login;
@FindBy(css=".alert.alert-danger.alert-show.mb-5")
private WebElement text;
@FindBy(linkText="Forgot Password?")
private WebElement forgot;
@FindBy(xpath="//section/div/h1")
private WebElement reset;
public Loginpage(WebDriver driver)
{
	PageFactory.initElements(driver,this);
         b=new Base(driver);
         
}
public String login(String username,String password) throws Throwable
{
	b.setText(email,username);
	b.setText(Password, password);
	b.cliking(login);
	return b.getText(text);
}
public String Forgot() throws Exception
{
	b.cliking(forgot);
	 return b.getText(reset);
}
}
