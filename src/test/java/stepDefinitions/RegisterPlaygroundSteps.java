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
import pages.PlaygroundRegisterPage;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class RegisterPlaygroundSteps {

    private static Properties prop = new Properties();
    private static InputStream in = DriverCreator.class.getResourceAsStream("../test.properties");

    PlaygroundHomePage playgroundHomePage = new PlaygroundHomePage();
    PlaygroundRegisterPage playgroundRegisterPage = new PlaygroundRegisterPage();

    CoreFunctions functions = new CoreFunctions();

    Logger logger = Logger.getLogger(LoginSteps.class);

    @Given("I am on the register page of Lambdatest Playground")
    public void iAmOnTheRegisterPageOfLambdatestPlayground() throws IOException {
        this.playgroundHomePage.openHomePage();
        this.functions.attachScreenshot("Main Page");
        this.playgroundHomePage.clickRegisterLink();
        this.functions.attachScreenshot("Register Page");
    }

    @When("I type valid personal details")
    public void iTypeValidPersonalDetails() {
        String firstName = this.functions.generateName();
        String lastName = this.functions.generateName();
        String email = this.functions.generateEmail();
        String telephone = this.functions.generateTelephone();
        String password = this.functions.generatePassword();

        this.playgroundRegisterPage.enterFirstName(firstName);
        this.playgroundRegisterPage.enterLastName(lastName);
        this.playgroundRegisterPage.enterEmail(email);
        this.playgroundRegisterPage.enterTelephone(telephone);
        this.playgroundRegisterPage.enterPassword(password);
        this.playgroundRegisterPage.enterPasswordConfirm(password);
        this.playgroundRegisterPage.clickPrivacyPolicyCheckbox();
        this.functions.attachScreenshot("Enter new account data");
        this.playgroundRegisterPage.clickContinueButton();
    }

    @Then("I should see a register account success message")
    public void iShouldSeeARegisterAccountSuccessMessage() {
        if(this.playgroundRegisterPage.seeRegisterAccountSuccessMessage()){
            this.functions.attachScreenshot("Register account succes pagge");
        }else{
            Assert.fail("No se visualizar el mensaje de registro satifactorio");
        }


    }
}
