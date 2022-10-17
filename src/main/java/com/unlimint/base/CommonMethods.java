package com.unlimint.base;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CommonMethods {

    WebDriver driver;
    WebElement element;
    ElementCondition elementCondition;


    public CommonMethods(WebDriver driver) {
        this.driver = driver;

        elementCondition = new ElementCondition(driver);

    }

    public boolean fnWait(String strTime) {
        try {
            int iSleepWait = Integer.parseInt(strTime);
            Thread.currentThread().sleep(iSleepWait);

            return true;
        } catch (Exception e) {

            return false;
        }
    }

    public String fnvisibledElementGetText(WebElement element) {
        String getText = null;

        if (element != null) {
           // System.out.println("Verifying if " + element + " is visible");
            elementCondition.elementToBeClickable(element);

            getText = element.getText();
        }

        return getText;

    }

    public void validateIfPageReloadedSuccessfully(WebElement element) {
        String pageLoadStatus = null;
        boolean flag = true;
        JavascriptExecutor js;

        do {

            js = (JavascriptExecutor) driver;

            pageLoadStatus = (String) js.executeScript("return document.readyState");

        } while (!pageLoadStatus.equals("complete"));

        System.out.println("Page Loaded.");

        while (flag == true) {

            if (element != null) {
               // System.out.println("Verifying if " + element + " is visible");
                try {
                    elementCondition.visibilityOfElementWithIn7s(element);
                } catch (Exception e) {
                flag = false;
                }
            }

        }
    }

    public boolean fnclickableElementClick(WebElement element ) {
        boolean bReturn = false;


        if (element != null) {
           // System.out.println("Verifying if " + element + " is clickable");
            elementCondition.elementToBeClickable(element);
            element.click();
            bReturn = true;
        }


        return bReturn;

    }

    public boolean fnvisibledElementSendKeys(WebElement element, String textValue) {
        boolean bReturn = false;

        if (element != null) {

            elementCondition.elementToBeClickable(element);
          //  System.out.println("Verifying if " + element + " is clickable");

            element.clear();
            try {
                Thread.sleep(1500);
            } catch (Exception e) {

            }
            element.sendKeys(textValue);
         //   System.out.println("send keys contract");

            bReturn = true;

        }


        return bReturn;
    }

}
