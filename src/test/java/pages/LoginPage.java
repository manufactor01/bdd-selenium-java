package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends Page {
    private final By inputUsername = By.id("username");
    private final By inputPassword = By.id("password");
    private final By btnSubmit = By.xpath("//*[@id='login']/button");
    private final By flashMessage = By.id("flash");

    public LoginPage() {
        super();
    }

    private WebElement getInputUsername() {
        return this.driver.findElement(inputUsername);
    }

    private WebElement getInputPassword() {
        return this.driver.findElement(inputPassword);
    }

    private WebElement getBtnSubmit() {
        return this.driver.findElement(btnSubmit);
    }

    private WebElement getFlashMessage() {
        return this.driver.findElement(flashMessage);
    }

    public void login(String username, String password) {
        this.getInputUsername().sendKeys(username);
        this.logger.info(java.text.MessageFormat.format("Username: {0} entered...", username));
        this.getInputPassword().sendKeys(password);
        this.logger.info(java.text.MessageFormat.format("Password: {0} entered...", password));
        this.getBtnSubmit().click();
        this.logger.info("Submit Button was clicked...");
    }

    public void completeLoginForm(String username, String password) {
        this.getInputUsername().sendKeys(username);
        this.logger.info(java.text.MessageFormat.format("Username: {0} entered...", username));
        this.getInputPassword().sendKeys(password);
        this.logger.info(java.text.MessageFormat.format("Password: {0} entered...", password));
    }

    public void submit() {
        this.getBtnSubmit().click();
        this.logger.info("Submit Button was clicked...");
    }

    public boolean containsFlashMessage(String message) {
        this.logger.info(java.text.MessageFormat.format("message: {0} is asserted", message));
        return this.getFlashMessage().getText().contains(message);
    }
}