package pages;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Library.baseclass;

public class AddRandomProductsToCart extends baseclass{
	    private final By shoppingCartIcon = By.id("shopping_cart_container");
    public double TotalPrice;
    WebDriver driver;
    //public AddRandomProductsToCart(WebDriver driver) {
        //this.driver = driver;
   // }
    public AddRandomProductsToCart(WebDriver driver)
    {
    	PageFactory.initElements(driver, this);
    	
    }
    @SuppressWarnings("deprecation")
	public AddRandomProductsToCart addRandomProductToCartAndGetPrices() {
                List<WebElement> products = driver.findElements(By.className("inventory_list"));
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            int randomProductIndex = random.nextInt(products.size());
            WebElement product = products.get(randomProductIndex);
            product.findElement(By.xpath("//button[@class=\"btn_primary btn_inventory\"]")).click();
        }

              driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(this.shoppingCartIcon).click();

        List<WebElement> prices = driver.findElements(By.className("inventory_item_price"));
        List<Double> productPrices = new ArrayList<>();
        for (WebElement priceElement : prices) {
            productPrices.add(Double.parseDouble(priceElement.getText()));
        }
        this.TotalPrice = 0;
        for (double productPrice : productPrices) {
            this.TotalPrice += productPrice;
        }

        System.out.println("Product prices:");
        for (double productPrice : productPrices) {
            System.out.println(productPrice);
        }
        System.out.println("Total price: " + TotalPrice);
        return this;
    }

    public double getTotalPrice() {
        return this.TotalPrice;
    }

}
