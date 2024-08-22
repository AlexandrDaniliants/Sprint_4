package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class WhoIsTheScooterForPage {
    WebDriver driver;
    private final By whoIsTheScooterFor = By.className("App_App__15LM-"); // Локатор страницы Для кого самокат
    private final By firstNameFieldLocator = By.xpath("//input[@placeholder = '* Имя']"); // Поле имя
    private final By secondNameFieldLocator = By.xpath(".//input[@placeholder= '* Фамилия']"); //Поле фамилия
    private final By addressFieldLocator = By.xpath(".//input[@placeholder= '* Адрес: куда привезти заказ']"); //Поле адрес
    private final By metroInputFieldLocator =  By.xpath("//input[@placeholder = '* Станция метро']"); //Поле станция метро
    private final By metroStationListLocator = By.className("select-search__value");// Список станций
    private final By lineOfSelectedMetroStation = By.className("select-search__row");
    private final By telephoneFieldLocator = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']"); // Поле номер телефона
    private final By nextButtonLocator = By.xpath(".//div[@class='Order_NextButton__1_rCA']/button"); // Кнопка далее



    public WhoIsTheScooterForPage(WebDriver driver) {

        this.driver = driver;
    }
    public void waitForLoadWhoIsTheScooterForPage() {  //Ожидаем загрузки страницы Для кого самокат
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.presenceOfElementLocated(whoIsTheScooterFor));
    }
    public WhoIsTheScooterForPage customerFirstNameInput(String inputCustomerName) { //Ввод имени заказчика
        driver.findElement(firstNameFieldLocator).clear();
        driver.findElement(firstNameFieldLocator).sendKeys(inputCustomerName);
        return this;
    }
    public WhoIsTheScooterForPage customerSecondNameInput(String inputCustomerSecondName) { //Ввод фамилии заказчика
        driver.findElement(secondNameFieldLocator).clear();
        driver.findElement(secondNameFieldLocator).sendKeys(inputCustomerSecondName);
        return this;
    }
    public WhoIsTheScooterForPage customerAddressInput(String inputCustomerAddress) { //Ввод адреса заказчика
        driver.findElement(addressFieldLocator).clear();
        driver.findElement(addressFieldLocator).sendKeys(inputCustomerAddress);
        return this;
    }
    public WhoIsTheScooterForPage inputAndSelectNameOfMetroStation(String NameOfMetroStation) { //Ввод названия станции метро и ее выбор
        driver.findElement(metroInputFieldLocator).clear();
        driver.findElement(metroInputFieldLocator).sendKeys(NameOfMetroStation);
        new WebDriverWait( driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(metroStationListLocator));
        driver.findElement(lineOfSelectedMetroStation).click();
        return this;
    }
    public WhoIsTheScooterForPage customerPhoneNumberInput(String inputCustomerPhoneNumber) { // Вводим номер телефона
        driver.findElement(telephoneFieldLocator).clear();
        driver.findElement(telephoneFieldLocator).sendKeys(inputCustomerPhoneNumber);
        return this;
    }
    public void clickOnNextButton() { // Нажимаем на кнопку далее
        driver.findElement(nextButtonLocator).click();

    }

}
