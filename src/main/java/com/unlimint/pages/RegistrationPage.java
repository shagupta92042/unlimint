package com.unlimint.pages;

import com.unlimint.base.TestSuiteBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class RegistrationPage extends TestSuiteBase {

    WebDriver driver;
    public RegistrationPage(WebDriver driver){

    this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[text()='Create an Account']")
    public WebElement createAccountLink;

    @FindBy(xpath = "//input[@id='firstname']")
    public WebElement firstNameTextBox;

    @FindBy(xpath = "//input[@id='lastname']")
    public WebElement lastNameTextBox;

    @FindBy(xpath = "//input[@id='email_address']")
    public WebElement emailTextBox;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement passwordTextBox;

    @FindBy(xpath = "//input[@id='password-confirmation']")
    public WebElement passwordConfirmationTextBox;

    @FindBy(xpath = "//button/span[text()='Create an Account']")
    public WebElement submitButtonforCreateAcc;

    @FindBy(xpath = "//span[contains(text(),'Welcome')]")
    public WebElement welcomeText;

    @FindBy(xpath = "//div[contains(@data-bind,'prepareMessage')]")
    public WebElement messageText;

    @FindBy(xpath = "//li/a[text()='Address Book']")
    public WebElement addressBook;

    @FindBy(xpath = "//input[contains(@name,'street')]")
    public WebElement streetTextBox;

    @FindBy(xpath = "//select[contains(@id,'country')]")
    public WebElement countryTextBox;

    @FindBy(xpath = "//input[contains(@id,'city')]")
    public WebElement cityTextBox;

    @FindBy(xpath = "//select[contains(@id,'region_id')]")
    public WebElement stateTextBox;

    @FindBy(xpath = "//span[text()='State/Province']")
    public WebElement stateLabel;

    @FindBy(xpath = "//input[contains(@id,'region')]")
    public WebElement stateSimpleTextBox;

    @FindBy(xpath = "//input[contains(@id,'telephone')]")
    public WebElement phoneTextBox;

    @FindBy(xpath = "//input[contains(@id,'zip')]")
    public WebElement postCodeTextBox;

    @FindBy(xpath = "//span[text()='Save Address']")
    public WebElement saveAddress;

}
