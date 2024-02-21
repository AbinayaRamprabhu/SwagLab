package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import Library.baseclass;

public class ConfirmOrderWithRandomProducts extends baseclass
{
	private final By subTotal = By.xpath("//div[@class='summary_subtotal_label']");
    private final By tax = By.xpath("//div[@class='summary_tax_label']");
    private final By total = By.xpath("//div[@class='summary_total_label']");
    private final By finishButton = By.xpath("//a[@class='btn_action cart_button']");
    private final By confirmationMessage = By.xpath("//h2[@class='complete-header']");
    WebDriver driver;
    //public ConfirmOrderWithRandomProducts(WebDriver driver) {
      //  this.driver = driver;
    //}
    public ConfirmOrderWithRandomProducts(WebDriver driver)
    {
    	PageFactory.initElements(driver, this);
    	
    }
    public ConfirmOrderWithRandomProducts clickOnFinishButton() {
        driver.findElement(this.finishButton).click();
        return this;
    }

    public double getSubTotal() {
        return Double.parseDouble(driver.findElement(this.subTotal).getText().replace("Item total: $", ""));
    }

    public double getTax() {
        return Double.parseDouble(driver.findElement(this.tax).getText().replace("Tax: $", ""));
    }

    public float total() {
        return Float.parseFloat(driver.findElement(this.total).getText().replace("Total: $", ""));
    }

    public boolean confirmationMessage() {
        return driver.findElement(this.confirmationMessage).getText().equals("THANK YOU FOR YOUR ORDER");
    }

    public float calculateSubTotalPlusTax() {
        double subtotal = getSubTotal();
        System.out.println("subtotal value: " + subtotal);
        double taxValue = getTax();
        System.out.println("Tax value: " + taxValue);
        float totalPrice = (float) (subtotal + taxValue);
        System.out.println("Total value: " + totalPrice);
        return totalPrice;
    }
}
