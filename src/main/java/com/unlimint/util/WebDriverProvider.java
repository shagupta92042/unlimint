package com.unlimint.util;

import com.unlimint.base.Config;
import com.unlimint.workflow.GetRandomUserDataApi;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;

import static com.unlimint.base.Config.appUrl;
import static com.unlimint.base.Constants.CHROMEDRIVER_PATH;

public class WebDriverProvider {

    protected static WebDriver driver;
    public static Logger log = LogManager.getLogger(GetRandomUserDataApi.class);

public static WebDriver getDriverInstance() {

    log.info("webdriver instance called");

    System.setProperty("webdriver.chrome.driver", CHROMEDRIVER_PATH);
    ChromeOptions options = new ChromeOptions();
    driver = new ChromeDriver(options);
    driver.get(appUrl);
    return driver;
}


}
