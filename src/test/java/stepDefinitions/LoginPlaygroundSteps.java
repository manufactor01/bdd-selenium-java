package stepDefinitions;

import core.CoreFunctions;
import core.DriverCreator;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.Logger;
import org.junit.Assert;
import pages.PlaygroundHomePage;
import pages.PlaygroundLoginPage;
import java.io.InputStream;
import java.util.Properties;

public class LoginPlaygroundSteps {

    private static Properties prop = new Properties();
    private static InputStream in = DriverCreator.class.getResourceAsStream("../test.properties");

    PlaygroundHomePage playgroundHomePage = new PlaygroundHomePage();
    PlaygroundLoginPage playgroundLoginPage = new PlaygroundLoginPage();

    CoreFunctions functions = new CoreFunctions();

    Logger logger = Logger.getLogger(LoginSteps.class);

    @Given("I am on the login page of Lambdatest Playground")
    public void iAmOnTheLoginPageOfLambdatestPlayground() throws Exception {
        this.playgroundHomePage.openHomePage();
        this.functions.attachScreenshot("Main Page");
        this.playgroundHomePage.clickLoginLink();
        this.functions.attachScreenshot("Login Page");
    }

    @When("I type (.+) as email and (.+) as password")
    public void iTypeEmailAndPassword(String username, String password) {
        this.playgroundLoginPage.loginWithCredentials(username, password);
        this.functions.attachScreenshot("Enter Email and Password");
        this.playgroundLoginPage.clickLoginButton();
    }

    @Then("I should see my account dashboard")
    public void iShouldSeeMyAccountDashboard() {
        if(this.playgroundLoginPage.verifyUserLoginDashboard()){
            this.functions.attachScreenshot("Verify login dashboard");
        }else{
            Assert.fail("Dashboard doesnt show");
        }


    }
}
