package com.unlimint.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

import static com.unlimint.base.Constants.PROPERTIES_PATH;

public class Config extends TestSuiteBase{


    public static String appUrl = null;
    public static String apiEndpoint = null;
    public static String password = null;
    public static String registerdEmail = null;
    public String propFileName = "app.properties";

    public Config() {
        Properties prop = new Properties();


        try {
            InputStream inputStream = new FileInputStream(PROPERTIES_PATH + propFileName);

            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }


                // get the property value and print it out


                appUrl = prop.getProperty("applicationURL");
                apiEndpoint = prop.getProperty("Api.endpoint");
                password = prop.getProperty("password");
                registerdEmail = prop.getProperty("usedemail");


        } catch (Exception e) {
            System.out.println("Exception stack trace.. " + e);
        }

    }
}
