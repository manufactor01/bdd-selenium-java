package stepDefinitions;

import core.DriverCreator;
import core.CoreFunctions;
import pages.LoginPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

import static org.junit.Assert.assertTrue;

public class LoginSteps {
    private static Properties prop = new Properties();
    private static InputStream in = DriverCreator.class.getResourceAsStream("../test.properties");

    LoginPage loginPage = new LoginPage();

    CoreFunctions functions = new CoreFunctions();

    Logger logger = Logger.getLogger(LoginSteps.class);

    @Given("I am on the login page")
    public void iAmOnTheLoginPage() throws Exception {
        //String url = functions.readProperties("MainAppUrlBase");
        this.loginPage.open("https://the-internet.herokuapp.com/login");
        this.functions.attachScreenshot("Login Page");
    }

    @When("I login with (.+) and (.+)")
    public void iLoginWithUsernameAndPassword(String username, String password) throws Exception {
        this.loginPage.completeLoginForm(username, password);
        this.functions.attachScreenshot("Login");
        this.loginPage.submit();
    }

    @Then("I should see a flash message saying (.+)")
    public void iShouldSeeAFlashMessage(String message) throws Exception {
        this.functions.attachScreenshot("Flash Message");
        assertTrue(this.loginPage.containsFlashMessage(message));
    }
}