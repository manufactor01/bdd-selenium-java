package pages;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PlaygroundRegisterPage extends Page{



    private static final int EXPECTED_ERRORS_TOTAL = 5;
    private static final String REGISTER_ACCOUNT_TITLE = "Register Account";
    private static final String FIRST_NAME_ERROR_MESSAGE = "First Name must be between 1 and 32 characters!";
    private static final String LAST_NAME_ERROR_MESSAGE = "Last Name must be between 1 and 32 characters!";
    private static final String EMAIL_ERROR_MESSAGE = "E-Mail Address does not appear to be valid!";
    private static final String TELEPHONE_ERROR_MESSAGE = "Telephone must be between 3 and 32 characters!";
    private static final String PASSWORD_ERROR_MESSAGE = "Password must be between 4 and 20 characters!";
    private static final String REGISTER_ACCOUNT_SUCCESS_MESSAGE = "Your Account Has Been Created!";

    private enum Using {
        MY_ACCOUNT_LINK(By.xpath("//a[@role='button'][normalize-space()='My account']")),
        REGISTER_LINK(By.xpath("//span[normalize-space()='Register']")),
        REGISTER_ACCOUNT_TITLE(By.xpath("//h1")),
        LOGIN_PAGE_LINK(By.xpath("//h1/following-sibling::p/a")),
        INPUT_FIRST_NAME(By.id("input-firstname")),
        INPUT_LAST_NAME(By.id("input-lastname")),
        INPUT_EMAIL(By.id("input-email")),
        INPUT_TELEPHONE(By.id("input-telephone")),
        INPUT_PASSWORD(By.id("input-password")),
        INPUT_PASSWORD_CONFIRM(By.id("input-confirm")),
        RADIO_NEWSLETTER(By.xpath("//label[normalize-space()='No']")),
        PRIVACY_POLICY_CHECKBOX(By.xpath("//label[@for='input-agree']")),
        PRIVACY_POLICY_LINK(By.xpath("//a[@class='agree']")),
        CONTINUE_BUTTON(By.xpath("//input[@value='Continue']"));

        public final By selector;

        Using(By selector) {
            this.selector = selector;
        }
    }




    public PlaygroundRegisterPage() {
        super();
    }


    public String getRegisterAccountTitle() {
        return driver.findElement(Using.REGISTER_ACCOUNT_TITLE.selector).getText();
    }

    public void enterFirstName(String firstName) {
        WebElement firstNameInput = driver.findElement(Using.INPUT_FIRST_NAME.selector);
        firstNameInput.clear();
        firstNameInput.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        WebElement lastNameInput = driver.findElement(Using.INPUT_LAST_NAME.selector);
        lastNameInput.clear();
        lastNameInput.sendKeys(lastName);
    }

    public void enterEmail(String email) {
        WebElement emailInput = driver.findElement(Using.INPUT_EMAIL.selector);
        emailInput.clear();
        emailInput.sendKeys(email);
    }

    public void enterTelephone(String telephone) {
        WebElement telephoneInput = driver.findElement(Using.INPUT_TELEPHONE.selector);
        telephoneInput.clear();
        telephoneInput.sendKeys(telephone);
    }

    public void enterPassword(String password) {
        WebElement passwordInput = driver.findElement(Using.INPUT_PASSWORD.selector);
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public void enterPasswordConfirm(String passwordConfirm) {
        WebElement passwordConfirmInput = driver.findElement(Using.INPUT_PASSWORD_CONFIRM.selector);
        passwordConfirmInput.clear();
        passwordConfirmInput.sendKeys(passwordConfirm);
    }

    public void clickNewsletterRadioButton() {
        driver.findElement(Using.RADIO_NEWSLETTER.selector).click();
    }

    public void clickPrivacyPolicyCheckbox() {
        driver.findElement(Using.PRIVACY_POLICY_CHECKBOX.selector).click();
    }

    public void clickContinueButton() {
        driver.findElement(Using.CONTINUE_BUTTON.selector).click();
    }

    public boolean seeRegisterAccountSuccessMessage() {
        if(driver.findElement(Using.REGISTER_ACCOUNT_TITLE.selector).getText().equals(REGISTER_ACCOUNT_SUCCESS_MESSAGE)) {
            return true;
        }else{
            return false;
        }
    }


}
