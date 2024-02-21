package pages;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Library.baseclass;

public class Loginpage extends baseclass
{
@FindBy(xpath="//div[@class='login_logo']")private WebElement logo;
	//WebElement logo1=driver.findElement(By.xpath("//div[contains(text(),'Swag Labs')]"));private WebElement logo;
@FindBy(xpath="//input[@id='user-name']")private WebElement Username;
@FindBy(xpath="//input[@id='password']")private WebElement pwd;
@FindBy(xpath="//input[@id='login-button']")private WebElement loginbutton;
@FindBy(xpath="//div[@class='error-message-container error']")private WebElement Errormessage;

public Loginpage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
	
}
public String verifyURL()
{
	String url=driver.getCurrentUrl();
	return url;
}
public boolean verifyLogo()
{
	boolean lg=logo.isDisplayed();
	return lg;
	}
public String verifyPageTitle()
{
	return driver.getTitle();
}
//Username and password
public void enterCredentials(String username,String password)
{
	Username.sendKeys(username);
	pwd.sendKeys(password);
	loginbutton.click();
}
//Invalid password
public String getErrorMessage()
{
	return Errormessage.getText();
}
}
