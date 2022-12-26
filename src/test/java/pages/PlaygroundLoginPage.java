package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PlaygroundLoginPage extends Page{

    private enum Using {

        LOGIN_EMAIL_INPUT(By.xpath("//input[@id='input-email']")),
        LOGIN_PASSWORD_INPUT(By.xpath("//input[@id='input-password']")),
        LOGIN_BUTTON(By.xpath("//input[@value='Login']")),
        RETURNING_CUSTOMER_TITLE(By.xpath("//h2[normalize-space()='Returning Customer']")),
        LOGIN_ERROR_MESSAGE(By.xpath("//div[@class='alert alert-danger alert-dismissible']")),
        USER_LOGIN_DASHBOARD(By.xpath("//h2[normalize-space()='My Account']")),
        USER_DASHBOARD_TABLE(By.xpath("//div[@id='content']"));

        public final By selector;
        Using(By selector) {
            this.selector = selector;
        }
    }

    public PlaygroundLoginPage() {
        super();
    }

    public boolean getLoginTitle() {
        return driver.findElement(Using.RETURNING_CUSTOMER_TITLE.selector).isDisplayed();
    }

    public void loginEmailAddress(String username) {
        WebElement emailInput = driver.findElement((Using.LOGIN_EMAIL_INPUT.selector));
        emailInput.clear();
        emailInput.sendKeys(username);
    }

    public void loginPassword(String password) {
        WebElement passwordInput = driver.findElement((Using.LOGIN_PASSWORD_INPUT.selector));
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(Using.LOGIN_BUTTON.selector).click();
    }

    public boolean verifyUserLoginDashboard() {
        return driver.findElement(Using.USER_LOGIN_DASHBOARD.selector).isDisplayed();
    }

    public void loginWithCredentials(String username, String password){
        //Si se encuentra en la página del login, realiza el login, sino regresa un error
        if(getLoginTitle()) {
            loginEmailAddress(username);
            loginPassword(password);
        }else {
            Assert.fail("No se encuentra en la pantalla del login");
        }

    }
}
