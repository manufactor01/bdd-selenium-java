package pages;

import core.CoreFunctions;
import stepDefinitions.Hooks;
import org.openqa.selenium.WebDriver;

import org.apache.log4j.Logger;

import java.io.IOException;

public class Page {
    protected WebDriver driver;
    protected Logger logger = Logger.getLogger(Page.class);
    CoreFunctions functions = new CoreFunctions();

    // TODO: Crear exception cuando el driver devuelva null
    public Page() {
        try {
            this.driver = Hooks.driver;
            this.driver.manage().window().maximize();
        } catch (Exception e){
            System.out.println("Ha ocurrido un error: "+e);
        }

    }

    public void open(String url) {
        this.driver.get(url);
        this.logger.info("Enter page: " + url);
    }

    public void openHomePage() throws IOException {
        String url = functions.readProperties("MainAppUrlBase");
        driver.get(url);
    }
}
