package stepDefinitions;

import core.CoreFunctions;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.NotificationMessagePage;

public class NotificationMessageSteps {
    private NotificationMessagePage notificationMessagePage = new NotificationMessagePage();
    CoreFunctions functions = new CoreFunctions();

    @Given("^i am in notification message page$")
    public void iAmInNotificationMessagePage() throws Throwable {
        notificationMessagePage.open("https://the-internet.herokuapp.com/notification_message_rendered");
        this.functions.attachScreenshot("Notification Message Page");
    }

    @When("^I click on button Click Here for (.+) times$")
    public void iClickOnButtonClickHereForManyTimes(int times) throws Throwable {
        notificationMessagePage.clickOnButtonForTimes(times);
        this.functions.attachScreenshot("Click on Button");
    }

    @Then("^I am alerted with (.+)$")
    public void iAmAlertedWithMessage(String message) throws Throwable {
        notificationMessagePage.containsAlertMessage(message);
        this.functions.attachScreenshot("Alert Message");
    }
}
