package com.unlimint.util;



import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;


import com.unlimint.base.Constants;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import static com.unlimint.base.Constants.EXTENT_REPORT_NAME;
import static com.unlimint.base.Constants.SCREENSHOT_PATH;


public class Screenshots {

    public static Logger log = LogManager.getLogger(Screenshots.class);


    private Screenshots() {
        super();

    }

    /**
     * Takes the screenshot of the current driver window and save to the
     * Configs.ScreenShotsPath path
     *
     * @param driver
     *            webdriver object
     * @param fileName
     *            takes filename to be given to the captured screenshot
     * @return path of the file saved
     * @throws IOException
     *             throws IOException if encounter any problem
     */
    public static String takeScreenshot(WebDriver driver, String fileName) throws IOException {
        log.info(" : takeScreenshot(" + fileName + " Called");
        fileName = fileName + ".png";
        String directory = SCREENSHOT_PATH;

        System.out.println("before screenshot ..");
        File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        System.out.println("after screenshot ..");
        FileUtils.copyFile(sourceFile, new File(directory + fileName));
        System.out.println("screenshot captured 2");
        return directory + fileName;

    }

    /**
     * set the relative path of the images in html report to ./ usually helpful
     * when screenshots and report are saved to same directory. so that the
     * report doesnt break the image link upon moving to some other location.
     *
     *
     */
    public static void sshotSetRelativePath() {
        FileReader fr = null;
        FileWriter fw = null;
        log.info(" : sshotSetRelativePath Called");
        try {

            File f = new File(SCREENSHOT_PATH +EXTENT_REPORT_NAME);
            ArrayList<String> lines = new ArrayList<String>();
            String line ;
            fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            while ((line = br.readLine()) != null) {
                if (line.contains("<img")) {
                    line = line.replace(SCREENSHOT_PATH, "./");
                }
                lines.add(line + "\n");
            }
            fr.close();
            br.close();

            fw = new FileWriter(f);
            BufferedWriter out = new BufferedWriter(fw);
            for (String s : lines)
                out.write(s);
            out.flush();
            fw.close();
            out.close();
        } catch (FileNotFoundException e) {
            log.error(e.getMessage());
            System.err.println("INFO : extentreport.html doesnt exist at the moment.");
        } catch (Exception ex) {
            log.error(ex.getMessage());
            ex.printStackTrace();
        }

    }
}

