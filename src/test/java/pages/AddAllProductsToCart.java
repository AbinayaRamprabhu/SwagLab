package pages;
import java.util.ArrayList;
//import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import Library.NumberGenerator;
import Library.baseclass;
import Library.utilityclass;

public class AddAllProductsToCart extends baseclass{
	 static float totalprice = 0;
	    	    private final By shoppingCartIcon = By.id("shopping_cart_container");
	    WebDriver driver;
	    NumberGenerator generator;
	    public AddAllProductsToCart(WebDriver driver)
	    {
	    	PageFactory.initElements(driver, this);
	    	
	    }
	    //ToDo: define driver
	   // public AddAllProductsToCart(WebDriver driver) {
	     //   this.driver = driver;
	    //}

	   	    public AddAllProductsToCart Navigatetothecart() {
	        driver.findElement(this.shoppingCartIcon).click();
	        return this;
	    }

	    public AddAllProductsToCart addProductToCart() {
	        for (int i = 3; i <= 8; i++) {
	            driver.findElement(By.xpath("(//button)[" + i + "]")).click();
	            totalprice += utilityclass.removeFirstLetterAndReturnFloat(driver.findElement(By.xpath("(//div[@class=\"inventory_item_price\"])[" + (i - 2) + "]")).getText());
	        }
	        System.out.println(totalprice);
	        return this;
	    }

		public AddAllProductsToCart addrandomproductstoshoppingcart(int i) {
			ArrayList<String> products = new ArrayList<>();
	        products.add("Product 1");
	        products.add("Product 2");
	        products.add("Product 3");
	        products.add("Product 4");
	        products.add("Product 5");
	        products.add("Product 6");	       
	        Random random = new Random();
            int productIndex = random.nextInt(products.size());
	        String product = products.get(productIndex);
	        System.out.println("Adding product " + product + " to the cart.");
	        driver.findElement(this.shoppingCartIcon).click();
	        return this;
			
		}
		
		}

