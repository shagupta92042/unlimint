package com.unlimint.pages;

import com.unlimint.base.TestSuiteBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PlaceOrderPage extends TestSuiteBase {

    WebDriver driver;
    public PlaceOrderPage(WebDriver driver){

    this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a/span[contains(text(),'New')]")
    public WebElement whatsNewMenu;

    @FindBy(xpath = "//a[text()='Jackets']")
    public WebElement jackets;

    @FindBy(xpath = "//a[@class='product-item-link']")
    public WebElement product;

    @FindBy(xpath = "//div[@class='swatch-attribute size']/div/div[@class='swatch-option text']")
    public WebElement sizeOfProduct;

    @FindBy(xpath = "//div[@class='swatch-attribute color']/div/div[@class='swatch-option color']")
    public WebElement colorOfProduct;

    @FindBy(xpath = "//span[text()='Add to Cart']")
    public WebElement addToCart;

    @FindBy(xpath = "//a[@class='action showcart']//span[@class='counter qty']")
    public WebElement myCart;

    @FindBy(xpath = "//button[text()='Proceed to Checkout']")
    public WebElement proceedToCheckout;

    @FindBy(xpath = "//img[@alt='Loading...']")
    public WebElement loadingImg;

    @FindBy(xpath = "//input[@class='radio']")
    public WebElement selectShippingCharges;


    @FindBy(xpath = "//span[text()='Next']")
    public WebElement next;

    @FindBy(xpath = "//span[text()='Place Order']")
    public WebElement placeOrder;

    @FindBy(xpath = "//a[@class='order-number']/strong")
    public WebElement orderNumber;


    @FindBy(xpath = "//button[@class='action switch']")
    public WebElement customerAction;

    @FindBy(xpath = "//li/a[text()='My Account']")
    public WebElement myAccount;

    @FindBy(xpath = "//li/a[text()='My Orders']")
    public WebElement myOrders;


}
