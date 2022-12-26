package stepDefinitions;

import core.DriverCreator;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriverException;

public class Hooks {
    public static WebDriver driver;
    private static final Logger logger = Logger.getLogger(Hooks.class);
    Scenario scenario = null;

    @Before
    public void initDriver(Scenario scenario) throws MalformedURLException {
        logger.info("*******************************************************************************************************");
        logger.info("[ Configuration ] - Initializing driver configuration");
        logger.info("*******************************************************************************************************");
        this.scenario = scenario;
        driver = DriverCreator.initConfig();
        logger.info("*******************************************************************************************************");
        logger.info("[ Scenario ] - " + scenario.getName());
        logger.info("*******************************************************************************************************");
    }

    @After
    public void tearDown() {
        if (scenario.isFailed()) {
            try {
                scenario.write("The scenario failed.");
                scenario.write("Current Page URL is " + driver.getCurrentUrl());
                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "src/test/resources/Data/Screenshots/Failed");
            } catch (WebDriverException somePlatformsDontSupportScreenshots) {
                System.err.println(somePlatformsDontSupportScreenshots.getMessage());
            }
        }
        logger.info("*******************************************************************************************************");
        logger.info("[ Driver Status ] - Clean and close the instance of the driver");
        logger.info("*******************************************************************************************************");
        driver.quit();
    }
}