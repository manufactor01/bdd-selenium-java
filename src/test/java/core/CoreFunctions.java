package core;

import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import stepDefinitions.Hooks;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class CoreFunctions {

    private final WebDriver driver;
    private final Properties prop;
    private final InputStream in;
    private final Logger logger;

    private static String name;
    private static String email;
    private static String telephone;
    private static String password;

    public CoreFunctions() {
        this.driver = Hooks.driver;
        this.prop = new Properties();
        this.in = DriverCreator.class.getResourceAsStream("../test.properties");
        this.logger = Logger.getLogger(DriverCreator.class);
    }

    public String readProperties(String property) throws IOException {
        this.prop.load(this.in);
        return this.prop.getProperty(property);
    }

    public void takeScreenshot(String captureTest) throws IOException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd-HHmm");
        String screenshotName = java.text.MessageFormat.format(
                "{0}\\{1}\\{2}_({3})", this.readProperties("ScreenShotPath"),
                this.readProperties("browser"), captureTest,
                dateFormat.format(GregorianCalendar.getInstance().getTime()));
        File scrFile = ((TakesScreenshot) this.driver).getScreenshotAs(OutputType.FILE);
        this.logger.info("Screenshot saved as: " + screenshotName);
        FileUtils.copyFile(scrFile, new File(String.format("%s.png", screenshotName)));
    }

    public byte[] attachScreenshot(String description) {
        this.logger.info(java.text.MessageFormat.format("Attaching Screenshot for {0}...", description));
        byte[] screenshot = ((TakesScreenshot) this.driver).getScreenshotAs(OutputType.BYTES);
        Allure.addAttachment(description, new ByteArrayInputStream(((TakesScreenshot) this.driver).getScreenshotAs(OutputType.BYTES)));
        return screenshot;
    }

    public String generateName() {
        return RandomStringUtils.randomAlphabetic(5);
    }

    public String generateEmail() {
        return RandomStringUtils.randomAlphabetic(8) + "@tesdata.com";
    }

    public String generateTelephone() {
        return RandomStringUtils.randomNumeric(10);
    }

    public String generatePassword() {
        return RandomStringUtils.randomAlphabetic(12);
    }


}