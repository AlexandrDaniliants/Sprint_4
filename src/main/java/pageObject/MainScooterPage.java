package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static pageObject.Constants.MakeOrderButtons.BOTTOM_ORDER_BUTTON;
import static pageObject.Constants.MakeOrderButtons.TOP_ORDER_BUTTON;


public class MainScooterPage {
    WebDriver driver;

    private final By ScooterManePage = By.className("App_App__15LM-"); //Локатор главной страницы
    private final By questionFields = By.className("Home_FAQ__3uVm4");//Блок полей вопросов
    private final By topOrderButton = By.xpath("//button[@class='Button_Button__ra12g']"); //Верхняя нопка заказа
    private final By bottomOrderButton = By.cssSelector("button.Button_Button__ra12g.Button_Middle__1CSJM"); //Нижняя кнопка заказа
    private final By cookieAcceptButton =  By.id("rcc-confirm-button");

    public MainScooterPage(WebDriver driver) {
        this.driver = driver;
    }
    public void waitForLoadMainScooterPage() {  //Ждем загрузки страницы
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.presenceOfElementLocated(ScooterManePage));
    }

    public MainScooterPage scrollToQuestions(){ //Прокручиваем страницу до блока вопросов
        WebElement element  = driver.findElement(questionFields);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        return this;
    }

    public MainScooterPage scrollToBottomOrderButton(){ //Прокручиваем страницу до блока вопросов
        WebElement element  = driver.findElement(bottomOrderButton);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        return this;
    }

    public MainScooterPage clickOnImportantQuestions(By importantQuestions) {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(importantQuestions)).click();
        return this;
    }

    public void waitForLoadAnswerFieldAfterClick(By answerField) { // Ждем раскрытия поля ответа
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(driver -> (driver.findElement(answerField).getText() != null
                && !driver.findElement(answerField).getText().isEmpty()));
    }
    public MainScooterPage clickOnTopOrderButton() { // Нажатие верхней кнопки "Заказать"
        driver.findElement(topOrderButton).click();
        return this;
    }
    public MainScooterPage clickOnBottomOrderButton() { //Нажатие нижней кнопки "Заказать"
        driver.findElement(bottomOrderButton).click();
        return this;
    }
    public void clickOnAgreeWithCookieButton() {
        driver.findElement(cookieAcceptButton).click();
    }
    public void selectOrderButton(Enum button) throws Exception{ //Выбор кнопки "Заказать"
        if (button.equals(TOP_ORDER_BUTTON)) {
            clickOnTopOrderButton();
        }
        else if (button.equals(BOTTOM_ORDER_BUTTON)) {
            scrollToBottomOrderButton();
            Thread.sleep(5_000);
            clickOnBottomOrderButton();
        }
    }
    public void stepForTestingQuestionsAndAnswersFields(By importantQuestions, By answerField) {
        waitForLoadMainScooterPage();
        clickOnAgreeWithCookieButton();
        scrollToQuestions();
        clickOnImportantQuestions(importantQuestions);
        waitForLoadAnswerFieldAfterClick(answerField);
    }

}
