package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

public class PlaygroundHomePage extends Page{

    private enum Using {

        MY_ACCOUNT_LINK(By.xpath("//a[@role='button'][normalize-space()='My account']")),
        LOGIN_LINK(By.xpath("//span[normalize-space()='Login']")),
        REGISTER_LINK(By.xpath("//span[normalize-space()='Register']"));

        public final By selector;
        Using(By selector) {
            this.selector = selector;
        }
    }

    public PlaygroundHomePage() {
        super();
    }

    public void clickLoginLink() {
        Actions builder = new Actions(driver);
        builder.moveToElement(driver.findElement(Using.MY_ACCOUNT_LINK.selector)).build().perform();
        driver.findElement(Using.LOGIN_LINK.selector).click();

    }

    public void clickRegisterLink() {
        Actions builder = new Actions(driver);
        builder.moveToElement(driver.findElement(Using.MY_ACCOUNT_LINK.selector)).build().perform();
        driver.findElement(Using.REGISTER_LINK.selector).click();
    }

}
