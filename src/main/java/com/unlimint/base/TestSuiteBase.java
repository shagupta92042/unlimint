package com.unlimint.base;

import com.unlimint.util.ExtentTestNGITestListener;
import com.unlimint.util.WebDriverProvider;
import com.unlimint.workflow.GetRandomUserDataApi;
import com.unlimint.workflow.PlaceOrder;
import com.unlimint.workflow.Registration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import static com.unlimint.util.WebDriverProvider.getDriverInstance;

@Listeners(ExtentTestNGITestListener.class)
public class TestSuiteBase extends WebDriverProvider {

    public Registration regsiterUser;
    public PlaceOrder placeOrder;
    public CommonMethods commonMethods;
    public Config config;
    public String date;
    protected WebDriver driver;
    public GetRandomUserDataApi getRandomUserDataApi;
    public static Logger log = LogManager.getLogger(TestSuiteBase.class);


    public TestSuiteBase() {
        super();


    }

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {

        log.info(" : TestSuiteBase - beforeSuite called");
    }

    @Parameters({"platform"})
    @BeforeMethod(alwaysRun = true)
    public void beforeTest() throws Exception {

        config = new Config();
        driver = getDriverInstance();

        log.info(" : TestSuiteBase - beforeTest called");
    }

    @AfterMethod(alwaysRun = true)
    public void afterTest() {
        log.info(" : TestSuiteBase - afterTest called");
        driver.close();
        driver.quit();
        log.info(" : TestSuiteBase - Browser Closed");
    }

    public enum UserDataValues {
        FIRST_NAME("first"),
        LAST_NAME("last"),
        COUNTRY("country"),
        STATE("state"),
        CITY("city"),
        STREET_NAME("streetName"),
        PHONE("phone"),
        POST_CODE("postcode"),
        EMAIL("email"),
        PASSWORD("password");

        public String value;

        UserDataValues(String value) {
            this.value = value;

        }

        public String getValue() {
            return value;
        }


    }

    public void initTest() throws Exception {


        getRandomUserDataApi = new GetRandomUserDataApi();
        commonMethods = new CommonMethods(driver);
        regsiterUser = new Registration(driver, ExtentTestNGITestListener.getTestExtent(), commonMethods);
        placeOrder = new PlaceOrder(driver, ExtentTestNGITestListener.getTestExtent(), commonMethods);
        driver.manage().window().maximize();

    }




}

