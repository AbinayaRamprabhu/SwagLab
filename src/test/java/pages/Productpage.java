package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Productpage 
{
	//logos
@FindBy(xpath="//div[@class='app_logo']")private WebElement appLogo;
@FindBy(xpath="//div[@class='bm-burger-button']")private WebElement menuButton;
@FindBy(id="shopping_cart_container")private WebElement ShoppingCart;
@FindBy(xpath="//li[@class='social_twitter']")private WebElement twitter;
@FindBy(xpath="//li[@class='social_facebook']")private WebElement facebook;
@FindBy(xpath="//li[@class='social_linkedin']")private WebElement linkedin;
//Product images
@FindBy(xpath="//img[@alt='Sauce Labs Backpack']")private WebElement backpack;
@FindBy(xpath="//img[@alt='Sauce Labs Bike Light']")private WebElement bikelight;
@FindBy(xpath="//img[@alt='Sauce Labs Bolt T-Shirt']")private WebElement boltTshirt  ;
@FindBy(xpath="//img[@alt='Sauce Labs Fleece Jacket']")private WebElement fleeceJacket;
@FindBy(xpath="//img[@alt='Sauce Labs Onesie']")private WebElement onesie ;
@FindBy(xpath="//img[@alt='Test.allTheThings() T-Shirt (Red) ']")private WebElement redTshirt;
//Product add to cart button
@FindBy(id="add-to-cart-sauce-labs-backpack")private WebElement backpackaddtocart;
@FindBy(id="add-to-cart-sauce-labs-bike-light")private WebElement bikelightaddtocart;
@FindBy(id="add-to-cart-sauce-labs-bolt-t-shirt")private WebElement bolttshirtaddtocart;
@FindBy(id="remove-sauce-labs-fleece-jacket")private WebElement fleecejacketaddtocart;
@FindBy(id="add-to-cart-sauce-labs-onesie")private WebElement onesieaddtocart;
@FindBy(id="add-to-cart-test.allthethings()-t-shirt-(red)")private WebElement redtshirtaddtocart;
//sorting
@FindBy(xpath="//select[@class='product_sort_container']")private WebElement sorting;
public Productpage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}
public boolean appLogovisible()
{
	return appLogo.isDisplayed();
}
public boolean menuButtonvisible()
{
	return menuButton.isDisplayed();
}
public boolean ShoppingCartvisible()
{
	return ShoppingCart.isDisplayed();
}
public boolean twittervisible()
{
	return twitter.isDisplayed();
}
public boolean facebookvisible()
{
	return facebook.isDisplayed();
}
public boolean linkedinvisible()
{
	return linkedin.isDisplayed();
}



}
