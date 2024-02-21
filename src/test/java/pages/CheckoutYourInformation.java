package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Library.baseclass;

public class CheckoutYourInformation extends baseclass
{
	 private final By firstName = By.id("first-name");
	    private final By lastName = By.id("last-name");
	    private final By postalCode = By.id("postal-code");
	    private final By continueButton = By.xpath("//input[@class='btn_primary cart_button']");
	    private final By pageTitle = By.xpath("//div[@class='subheader']");
	    private final By canbutton = By.xpath("//button[@id='cancel']");
	    private final By Errormessage = By.xpath("//body/div[@id='error']");
	    WebDriver driver;
	    	// public CheckoutYourInformation(WebDriver driver) {
	        //this.driver = driver;
	   // }
	    public CheckoutYourInformation(WebDriver driver)
	    {
	    	PageFactory.initElements(driver, this);
	    	
	    }

	 	    public CheckoutYourInformation addFirstName(String firstName) {
	        driver.findElement(this.firstName).sendKeys(firstName);
	        return this;
	    }

	    public CheckoutYourInformation addLastName(String lastName) {
	        driver.findElement(this.lastName).sendKeys(lastName);
	        return this;
	    }

	    public CheckoutYourInformation addPostalCode(String code) {
	        driver.findElement(this.postalCode).sendKeys(code);
	        return this;
	    }

	    public CheckoutYourInformation ClickOnContinueButton() {
	        driver.findElement(this.continueButton).click();
	        return this;
	    }
	    public CheckoutYourInformation ClickOnCanButton() {
	        driver.findElement(this.canbutton).click();
	        return this;
	    }

	    public boolean PageTitle() {
	        return driver.findElement(this.pageTitle).getText().equals("Checkout: Your Information");
	    }
	    public String getErrorMessage()
	    {
	    	return  ((WebElement) Errormessage).getText();
	    }
	}


