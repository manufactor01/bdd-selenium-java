package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class NotificationMessagePage extends Page {

    private final By btnClickHere = By.xpath("//*[@id=\"content\"]/div/p/a");
    private final By flashAlert = By.id("flash");

    private WebElement getBtnClickHere() {
        return this.driver.findElement(btnClickHere);
    }

    private WebElement getFlashAlert() {
        return this.driver.findElement(flashAlert);
    }

    public void clickOnButtonForTimes(int times) {
        for (int i = 0; i < times; i++) {
            this.getBtnClickHere().click();
        }
    }

    public boolean containsAlertMessage(String message) {
        return this.getFlashAlert().getText().contains(message);
    }
}
