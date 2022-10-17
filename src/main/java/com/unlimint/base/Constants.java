package com.unlimint.base;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Constants {

    public static final String SEPARATOR = System.getProperty("file.separator");
    public static final String USER_DIR = System.getProperty("user.dir");
    public static final String PROPERTIES_PATH;
    public static final String SCREENSHOT_PATH;
    public static final String TARGET_PATH;
    public static final String RESOURCE_PATH;
    public static final String CHROMEDRIVER_PATH;
    public static final String FIREFOXDRIVER_PATH;
    public static  final String EXTENT_REPORT_NAME;
    public static  final String EXTENT_REPORT_PATH;


    public Constants() {
    }

    static {

        PROPERTIES_PATH = USER_DIR + SEPARATOR ;
        SCREENSHOT_PATH = USER_DIR + SEPARATOR + "test-output" + SEPARATOR ;
        TARGET_PATH = USER_DIR + SEPARATOR + "target" + SEPARATOR;
        RESOURCE_PATH = USER_DIR + SEPARATOR + "src" + SEPARATOR + "main" + SEPARATOR + "resources" + SEPARATOR;
        CHROMEDRIVER_PATH= USER_DIR + SEPARATOR + "drivers" +SEPARATOR +"chromedriver.exe";
        FIREFOXDRIVER_PATH= USER_DIR + SEPARATOR + "drivers" +SEPARATOR;
        EXTENT_REPORT_NAME="extentreport"+(new SimpleDateFormat("_MM-dd-yyyy__hh.mm.ss_zzz").format(new Date()))+".html";
        EXTENT_REPORT_PATH = USER_DIR+SEPARATOR+"test-output"+SEPARATOR+EXTENT_REPORT_NAME;


    }
}

