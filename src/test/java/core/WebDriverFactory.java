package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import org.apache.log4j.Logger;

public class WebDriverFactory {
    private final static Logger logger = Logger.getLogger(String.valueOf(WebDriverFactory.class));
    private static WebDriverFactory instance = null;

    private WebDriverFactory() {
    }

    public static WebDriverFactory getInstance() {
        if (instance == null) {
            instance = new WebDriverFactory();
        }
        return instance;
    }

    public static WebDriver createNewWebDriver(String browser) {
        WebDriver driver;

        switch(browser.toUpperCase()){
            case "FIREFOX":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "CHROME":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "INTERNET EXPLORER":
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
                break;
            case "MICROSOFT EDGE":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            default:
                logger.error("The Driver is not selected properly, invalid name: " + browser);
                return null;
        }


        return driver;
    }
}