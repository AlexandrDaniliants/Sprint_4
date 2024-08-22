package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static pageObject.Constants.ColourOfScooters.BLACK;
import static pageObject.Constants.ColourOfScooters.GREY;


public class AboutRentPage {
    WebDriver driver;

    private final By aboutRentPageLocator = By.className("App_App__15LM-"); //Заголовок страницы
    private final By dateOfDeliveryFieldLocator = By.xpath(".//input[@placeholder='* Когда привезти самокат']"); // Поле когда привезти самокат
    private final By durationOfRentalFieldLocator = By.xpath(".//span[@class='Dropdown-arrow']");// Поле срок аренды
    private final By durationOfRentalDropDownList = By.className("Dropdown-menu");//Выпадающий список поля срок аренды
    private final By colorOfScooterIsBlackCheckboxLocator = By.id("black"); // Чекбокс черный цвет скутера
    private final By colorOfScooterIsGreyCheckboxLocator = By.id("grey"); // Чекбокс серый цвет скутера
    private final By customerCommentFieldLocator = By.xpath(".//input[@placeholder='Комментарий для курьера']"); //комментарий для курьера
    private final By nextButtonLocator = By.xpath("//div[@class = 'Order_Buttons__1xGrp']/button[text()='Заказать']"); // Кнопка заказать

    public AboutRentPage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitAboutRentPageLoad() {  //Ожидание загрузки страницы
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.presenceOfElementLocated(aboutRentPageLocator));
    }
    public AboutRentPage inputDateOfDelivery(String dateOfDelivery) {   // Ввод даты доставки
        driver.findElement(dateOfDeliveryFieldLocator).clear();
        driver.findElement(dateOfDeliveryFieldLocator).sendKeys(dateOfDelivery);
        return this;
    }
    public AboutRentPage inputDurationOfRental(By DurationOfRental) { //Выбор количество суток
        driver.findElement(durationOfRentalFieldLocator).click();
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable((DurationOfRental))).click();
        return this;
    }
    public AboutRentPage colourOfScooterSelect(Enum colourOfScooter) {
        if ( colourOfScooter.equals(BLACK) ) {
            driver.findElement(colorOfScooterIsBlackCheckboxLocator).click();
        } else if ( colourOfScooter.equals(GREY) ) {
            driver.findElement(colorOfScooterIsGreyCheckboxLocator).click();
        }
        return this;
    }

    public AboutRentPage inputCustomerComment(String customerComment) {
        driver.findElement(customerCommentFieldLocator).sendKeys(customerComment);
        return this;
    }
    public void clickOnNextButton(){
        driver.findElement(nextButtonLocator).click();
    }

}
