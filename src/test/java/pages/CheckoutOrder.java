package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import Library.baseclass;

public class CheckoutOrder extends baseclass {
	private final By CheckOutButton = By.xpath("//a[contains(text(),'CHECKOUT')]");

 
    WebDriver driver;

    //public CheckoutOrder(WebDriver driver) {
        //this.driver = driver;
    //}
    public CheckoutOrder(WebDriver driver)
    {
    	PageFactory.initElements(driver, this);
    	
    }

    public CheckoutOrder ClickOnCheckOutButton() {
        driver.findElement(this.CheckOutButton).click();
        return this;
    }

    public boolean checkCheckOutButtonAppear() {
        return driver.findElement(this.CheckOutButton).isDisplayed();
    }
}

