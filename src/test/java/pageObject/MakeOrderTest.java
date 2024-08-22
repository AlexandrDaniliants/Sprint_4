package pageObject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.assertTrue;
import static pageObject.Constants.ColourOfScooters.BLACK;
import static pageObject.Constants.ColourOfScooters.GREY;
import static pageObject.Constants.MakeOrderButtons.BOTTOM_ORDER_BUTTON;
import static pageObject.Constants.MakeOrderButtons.TOP_ORDER_BUTTON;
import static pageObject.Constants.RentalDuration.ONE_DAYS;
import static pageObject.Constants.RentalDuration.THREE_DAYS;


@RunWith(Parameterized.class)

public class MakeOrderTest {

    private WebDriver driver;

    private final String siteAddress = "https://qa-scooter.praktikum-services.ru/";
    private final Enum orderButton;
    private final String customerFirstName;
    private final String customerSecondName;
    private final String customerAddress;
    private final String metroStation;
    private final String customerTelephoneNumber;
    private final String rentalDate;
    private final By rentalPeriod;
    private final Enum scooterColor;
    private final String customerComment;
    private final String ExpectedWindowHeaderWhenOrderIsMakes = "Заказ оформлен";


    public MakeOrderTest(Enum orderButton, String customerFirstName, String customerSecondName, String customerAddress, String metroStation, String customerTelephoneNumber, String rentalDate, By rentalPeriod, Enum scooterColor, String customerComment) {

        this.orderButton = orderButton;
        this.customerFirstName = customerFirstName;
        this.customerSecondName = customerSecondName;
        this.customerAddress = customerAddress;
        this.metroStation = metroStation;
        this.customerTelephoneNumber = customerTelephoneNumber;
        this.rentalDate = rentalDate;
        this.rentalPeriod = rentalPeriod;
        this.scooterColor = scooterColor;
        this.customerComment = customerComment;
    }
    @Parameterized.Parameters
    public static Object[][] getParameters() {
        return new Object[][] {
                {TOP_ORDER_BUTTON, "Василий","Теркин","Адрес Василия Теркина","Черкизовская","79252545623","20.08.2024",ONE_DAYS,GREY,"Комментарий Василия Теркина"},
                {BOTTOM_ORDER_BUTTON, "Глеб","Жеглов","Адрес Глеба Жеглова","Сокольники","79154564654","21.08.2024",THREE_DAYS,BLACK,"Комментарий Глеба Жеглова"}
        };

    }
    @Before

    public void startUp() {
        //Запуск Хрома
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
        //Запуск Мозиллы
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get(siteAddress);
    }

    @Test
    public void makingOrderTest() throws Exception{
        MainScooterPage mainScooterPage = new MainScooterPage(driver);
        mainScooterPage.clickOnAgreeWithCookieButton();
        mainScooterPage.waitForLoadMainScooterPage();
        //Thread.sleep(5_000);
        mainScooterPage.selectOrderButton(orderButton);


        WhoIsTheScooterForPage whoIsTheScooterForPage = new WhoIsTheScooterForPage(driver);

        whoIsTheScooterForPage.waitForLoadWhoIsTheScooterForPage();
        whoIsTheScooterForPage.customerFirstNameInput(customerFirstName);
        //Thread.sleep(5_000);
        whoIsTheScooterForPage.customerSecondNameInput(customerSecondName);
        whoIsTheScooterForPage.customerAddressInput(customerAddress);
        whoIsTheScooterForPage.inputAndSelectNameOfMetroStation(metroStation);
        whoIsTheScooterForPage.customerPhoneNumberInput(customerTelephoneNumber);
        whoIsTheScooterForPage.clickOnNextButton();

        AboutRentPage aboutRentPage = new AboutRentPage(driver);

        aboutRentPage.waitAboutRentPageLoad();
        aboutRentPage.inputDateOfDelivery(rentalDate);
        aboutRentPage.inputDurationOfRental(rentalPeriod);
        aboutRentPage.colourOfScooterSelect(scooterColor);
        aboutRentPage.inputCustomerComment(customerComment);
        aboutRentPage.clickOnNextButton();

        OrderHasBeenPlacedWindow orderHasBeenPlacedWindow = new OrderHasBeenPlacedWindow(driver);
        orderHasBeenPlacedWindow.clickOnButtonYes();
        assertTrue(orderHasBeenPlacedWindow.HeaderOfOrderHasBeenPlacedWindowText().contains(ExpectedWindowHeaderWhenOrderIsMakes));
    }
    @After
    public void tearDown() {
        driver.quit();
    }
}
