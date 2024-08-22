package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderHasBeenPlacedWindow {
    WebDriver driver;
    private final By HeaderOfOrderHasBeenPlacedWindow = By.xpath(".//div[text()='Заказ оформлен']");
    private final By buttonYes = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Да']");

    public OrderHasBeenPlacedWindow(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnButtonYes() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(buttonYes)).click();
    }

    public String HeaderOfOrderHasBeenPlacedWindowText() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(driver -> (driver.findElement(HeaderOfOrderHasBeenPlacedWindow).getText() != null
                && !driver.findElement(HeaderOfOrderHasBeenPlacedWindow).getText().isEmpty()));
        return driver.findElement(HeaderOfOrderHasBeenPlacedWindow).getText();
    }

}


