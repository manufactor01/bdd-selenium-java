package core;

import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

public class DriverCreator {
    private static Properties prop = new Properties();
    private static InputStream in = DriverCreator.class.getResourceAsStream("../test.properties");

    private static String properties = "test.properties";
    private static String browser;
    private static String logLevel;

    private static final Logger logger = Logger.getLogger(String.valueOf(DriverCreator.class));

    private DriverCreator() {
        DriverCreator.initConfig();
    }

    public static WebDriver initConfig() {
        try {
            logger.info("*******************************************************************************************************");
            logger.info("[ POM Configuration ] - Read the basic properties configuration from: " + properties);
            prop.load(in);
            browser = prop.getProperty("browser");
            logLevel = prop.getProperty("logLevel");
        } catch (IOException e) {
            logger.error("initConfig Error", e);
        }
        logger.info("[ POM Configuration ] - " + "Browser: " + browser);
        logger.info("[ POM Configuration ] - Logger Level: " + logLevel);
        logger.info("*******************************************************************************************************");
        return WebDriverFactory.createNewWebDriver(browser);
    }
}
