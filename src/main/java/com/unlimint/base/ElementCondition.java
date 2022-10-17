package com.unlimint.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ElementCondition {

    WebDriver driver;
    WebDriverWait wait;
    WebDriverWait wait7s;

    public ElementCondition(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait7s = new WebDriverWait(driver, Duration.ofSeconds(7));
    }

    public void elementToBeClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void visibilityOfElement(WebElement element) {

        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void visibilityOfElementWithIn7s(WebElement element) {

        wait7s.until(ExpectedConditions.visibilityOf(element));
    }


    public void elementClickable(WebElement element) {

        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForElement() {
        try {
            Thread.currentThread().sleep(3000);

            System.out.println("thread: \n" + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
