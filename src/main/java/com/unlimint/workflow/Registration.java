package com.unlimint.workflow;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.unlimint.base.CommonMethods;
import com.unlimint.pages.RegistrationPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.HashMap;

import static com.unlimint.base.Config.*;

public class Registration extends RegistrationPage {

    public WebDriver driver;
    public CommonMethods commonMethods;
    public ExtentTest extentTest;
    public static Logger log = LogManager.getLogger(Registration.class);


    public Registration(WebDriver driver, ExtentTest extentTest, CommonMethods commonMethods) {
        super(driver);
        this.driver = driver;
        this.extentTest = extentTest;
        this.commonMethods = commonMethods;

    }

    /**
     * This will register user details on the website and will be reused everytime in the test cases.
     *
     * @param userData - User details of the random data fetched
     */

    public void registerUser(HashMap<String, String> userData) {

        log.info("Fake site loaded successfully");
        extentTest.log(Status.INFO, "Fake site loaded successfully ");

        commonMethods.fnclickableElementClick(createAccountLink);
        commonMethods.fnvisibledElementSendKeys(firstNameTextBox, userData.get(UserDataValues.FIRST_NAME.getValue()));
        commonMethods.fnvisibledElementSendKeys(lastNameTextBox, userData.get(UserDataValues.LAST_NAME.getValue()));
        commonMethods.fnvisibledElementSendKeys(emailTextBox, userData.get(UserDataValues.EMAIL.getValue()));
        commonMethods.fnvisibledElementSendKeys(passwordTextBox, password);
        commonMethods.fnvisibledElementSendKeys(passwordConfirmationTextBox, password);
        commonMethods.fnclickableElementClick(submitButtonforCreateAcc);

        String message = commonMethods.fnvisibledElementGetText(messageText);

        log.info(message);
        extentTest.log(Status.INFO, message);

        Assert.assertTrue(message.contains("Thank you for registering"));

        log.info("User has been registered successfully and welcome message has been validated");
        extentTest.log(Status.INFO, "User has been registered successfully and welcome message has been validated");

        commonMethods.fnWait("1000");

    }

    /**
     * This will add and fill the address details of the user given in the userData after successful registration .
     *
     * @param userData - User details (Address details ) of the random data fetched
     */

    public void fillAddressAfterRegistration(HashMap<String, String> userData) {

        commonMethods.fnclickableElementClick(addressBook);

        log.info("Going to add/fill the address for user");

        Select select = new Select(countryTextBox);
        select.selectByVisibleText(userData.get(UserDataValues.COUNTRY.getValue()));

        try {
            commonMethods.fnclickableElementClick(stateLabel);
            select = new Select(stateTextBox);
            select.selectByVisibleText(userData.get(UserDataValues.STATE.getValue()));

        } catch (Exception e) {
            try {
                commonMethods.fnclickableElementClick(stateLabel);
                select = new Select(stateTextBox);
                select.selectByIndex(1);
            } catch (Exception e1) {
                commonMethods.fnvisibledElementSendKeys(stateSimpleTextBox, userData.get(UserDataValues.STATE.getValue()));
            }
        }

        commonMethods.fnvisibledElementSendKeys(cityTextBox, userData.get(UserDataValues.CITY.getValue()));
        commonMethods.fnvisibledElementSendKeys(streetTextBox, userData.get(UserDataValues.STREET_NAME.getValue()));
        commonMethods.fnvisibledElementSendKeys(phoneTextBox, userData.get(UserDataValues.PHONE.getValue()));
        commonMethods.fnvisibledElementSendKeys(postCodeTextBox, userData.get(UserDataValues.POST_CODE.getValue()));

        commonMethods.fnclickableElementClick(saveAddress);

        log.info("Address has been added successfully for the user");

    }


    /**
     * This will register user details on the website and will be reused everytime in the test cases.
     *
     * @param userData - User details of the random data fetched
     */

    public void registerUserWithRegisteredEmailId(HashMap<String, String> userData) {

        log.info("Fake site loaded successfully");
        extentTest.log(Status.INFO, "Fake site loaded successfully ");

        commonMethods.fnclickableElementClick(createAccountLink);
        commonMethods.fnvisibledElementSendKeys(firstNameTextBox, userData.get(UserDataValues.FIRST_NAME.getValue()));
        commonMethods.fnvisibledElementSendKeys(lastNameTextBox, userData.get(UserDataValues.LAST_NAME.getValue()));
        commonMethods.fnvisibledElementSendKeys(emailTextBox, registerdEmail);
        commonMethods.fnvisibledElementSendKeys(passwordTextBox, password);
        commonMethods.fnvisibledElementSendKeys(passwordConfirmationTextBox, password);
        commonMethods.fnclickableElementClick(submitButtonforCreateAcc);

        String message = commonMethods.fnvisibledElementGetText(messageText);

        log.warn(message);
        extentTest.log(Status.WARNING, message);

        Assert.assertFalse(message.contains("Thank you for registering"));



    }


}
