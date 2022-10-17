package com.unlimint.workflow;


import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.unlimint.base.CommonMethods;
import com.unlimint.pages.PlaceOrderPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.HashMap;

public class PlaceOrder extends PlaceOrderPage {

    public WebDriver driver;
    public CommonMethods commonMethods;
    public Actions action;
    public WebDriverWait wait;
    public ExtentTest extentTest;
    public static Logger log = LogManager.getLogger(PlaceOrder.class);

    public PlaceOrder(WebDriver driver, ExtentTest extentTest, CommonMethods commonMethods){
        super(driver);
        this.driver = driver;
        this.commonMethods = commonMethods;
        this.extentTest = extentTest;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        action = new Actions(driver);

    }

    /**
     * This will Place the random order after adding address of the user.
     */

    public void placeOrder(){


        commonMethods.fnclickableElementClick(whatsNewMenu);

        log.info("What's new menu is opened and random order will be placed.");
        extentTest.log(Status.INFO, "What's new menu is opened and random order will be placed.");

        commonMethods.fnclickableElementClick(jackets);
        commonMethods.fnclickableElementClick(product);
        commonMethods.fnclickableElementClick(sizeOfProduct);
        commonMethods.fnclickableElementClick(colorOfProduct);
        commonMethods.fnclickableElementClick(addToCart);

        log.info("Order has been added to cart .");
        extentTest.log(Status.INFO, "Order has been added to cart .");

        commonMethods.validateIfPageReloadedSuccessfully(loadingImg);
        commonMethods.fnclickableElementClick(myCart);
        commonMethods.fnWait("1000");
        commonMethods.fnclickableElementClick(proceedToCheckout);

        log.info("Proceeding to checkout .");
        extentTest.log(Status.INFO, "Proceeding to checkout .");

        commonMethods.validateIfPageReloadedSuccessfully(loadingImg);
        commonMethods.fnclickableElementClick(selectShippingCharges);
        commonMethods.fnclickableElementClick(next);
        commonMethods.validateIfPageReloadedSuccessfully(loadingImg);
        commonMethods.fnclickableElementClick(placeOrder);

        log.info("Order has been placed successfully .");
        extentTest.log(Status.INFO, "Order has been placed successfully .");

    }

    /**
     * This will fetch the order Id displayed on the site and validate the order details on MyOrders Page..
     */

    public void getOrderIdAndValidateOrderDetailsOnMyOrdersPage(){


        String orderId = commonMethods.fnvisibledElementGetText(orderNumber);
        log.info("order Id " +orderId+ " generated successfully after placing order .");
        extentTest.log(Status.INFO, "order Id " +orderId+ " generated successfully after placing order .");

        commonMethods.fnclickableElementClick(customerAction);
        commonMethods.fnclickableElementClick(myAccount);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@class='col id'][text()='"+orderId+"']/following-sibling::td[@class='col status'][text()='Pending']"))).click();

        log.info("order details are validated successfully for "+orderId+ " on My Orders Page.");
        extentTest.log(Status.INFO, "order details are validated successfully for "+orderId+ " on My Orders Page.");
        commonMethods.fnWait("1000");
    }

}
