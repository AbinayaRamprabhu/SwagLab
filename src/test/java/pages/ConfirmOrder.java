package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import Library.baseclass;

public class ConfirmOrder extends baseclass
{
	 private final By subTotal = By.xpath("//div[@class='summary_subtotal_label']");
	    private final By tax = By.xpath("//div[@class='summary_tax_label']");
        private final By total = By.xpath("//div[@class='summary_total_label']");
	    private final By finishButton = By.xpath("//a[@class='btn_action cart_button']");
	    private final By confirmationMessage = By.xpath("//h2[@class='complete-header']");
	    WebDriver driver;
	   	    //public ConfirmOrder(WebDriver driver) {
	        //this.driver = driver;
	    //}  
	    public ConfirmOrder(WebDriver driver)
	    {
	    	PageFactory.initElements(driver, this);
	    	
	    }
	    public ConfirmOrder clickOnFinishButton() {
	        driver.findElement(this.finishButton).click();
	        return this;
	    }
	    public boolean getSubTotal() {
	        float totalprice = 0;
			return driver.findElement(this.subTotal).getText().equals("Item total: $" + totalprice);
	    }
	    public boolean tax() {
	        return driver.findElement(this.tax).getText().equals("Tax: 10.40");
	    }

	    public float taxs() {
	        return Float.parseFloat(driver.findElement(this.tax).getText().replace("Tax: $", ""));
	    }
	    public boolean total() {
	        return driver.findElement(this.total).getText().equals("Total: 140.34");
	    }
	    public boolean confirmationMessage() {
	        return driver.findElement(this.confirmationMessage).getText().equals("THANK YOU FOR YOUR ORDER");
	    }

	    public String getSubTotalPrice() {
	        return driver.findElement(this.subTotal).getText().replace("Item total: $", "");
	    }

	    public String calculateSubTotalPlusTax() {
	       
	    	float totalprice = 0;
			return String.valueOf(totalprice + taxs());
	    }

	    public String getTotalPrice() {
	        return driver.findElement(this.total).getText().replace("Total: $", "");
	    }
	}

