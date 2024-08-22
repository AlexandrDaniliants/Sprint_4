package pageObject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;
import static pageObject.Constants.MainScooterPageConstants.*;


@RunWith(Parameterized.class)

public class MainScooterPageTest {
    private WebDriver driver;
    private final String siteAddress = "https://qa-scooter.praktikum-services.ru/";
    private final By importantQuestionLocator;
    private final String expectedQuestion;
    private final By answerToQuestionLocator;
    private final String expectedAnswer;

    public MainScooterPageTest(By importantQuestionLocator, String expectedQuestion, By answerToQuestionLocator, String expectedAnswer) {
        this.importantQuestionLocator = importantQuestionLocator;
        this.expectedQuestion = expectedQuestion;
        this.answerToQuestionLocator = answerToQuestionLocator;
        this.expectedAnswer = expectedAnswer;

    }
    @Before
    public void startUp() {
        //Запуск Хрома
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //Запуск Мозиллы
//        WebDriverManager.firefoxdriver().setup();
//        driver = new FirefoxDriver();

        driver.get(siteAddress);
    }

    @Parameterized.Parameters
    public static Object [][] getParameters() {
        return new Object[][] {
                {IMPORTANT_QUESTION_FIELD_1, IMPORTANT_QUESTION_FIELD_1_TEXT, ANSWER_TO_QUESTION_FIELD_1, ANSWER_TO_QUESTION_FIELD_TEXT_1},
                {IMPORTANT_QUESTION_FIELD_2, IMPORTANT_QUESTION_FIELD_2_TEXT, ANSWER_TO_QUESTION_FIELD_2, ANSWER_TO_QUESTION_FIELD_TEXT_2},
                {IMPORTANT_QUESTION_FIELD_3, IMPORTANT_QUESTION_FIELD_3_TEXT, ANSWER_TO_QUESTION_FIELD_3, ANSWER_TO_QUESTION_FIELD_TEXT_3},
                {IMPORTANT_QUESTION_FIELD_4, IMPORTANT_QUESTION_FIELD_4_TEXT, ANSWER_TO_QUESTION_FIELD_4, ANSWER_TO_QUESTION_FIELD_TEXT_4},
                {IMPORTANT_QUESTION_FIELD_5, IMPORTANT_QUESTION_FIELD_5_TEXT, ANSWER_TO_QUESTION_FIELD_5, ANSWER_TO_QUESTION_FIELD_TEXT_5},
                {IMPORTANT_QUESTION_FIELD_6, IMPORTANT_QUESTION_FIELD_6_TEXT, ANSWER_TO_QUESTION_FIELD_6, ANSWER_TO_QUESTION_FIELD_TEXT_6},
                {IMPORTANT_QUESTION_FIELD_7, IMPORTANT_QUESTION_FIELD_7_TEXT, ANSWER_TO_QUESTION_FIELD_7, ANSWER_TO_QUESTION_FIELD_TEXT_7},
                {IMPORTANT_QUESTION_FIELD_8, IMPORTANT_QUESTION_FIELD_8_TEXT, ANSWER_TO_QUESTION_FIELD_8, ANSWER_TO_QUESTION_FIELD_TEXT_8},
        };
    }
    @Test
    public void FieldAnswersAndQuestionsTest () {

        //driver.get(siteAddress);

        MainScooterPage objManePage  = new MainScooterPage(driver);

//        objManePage.waitForLoadMainScooterPage();
//        objManePage.clickOnAgreeWithCookieButton();
//        objManePage.scrollToQuestions();
//        objManePage.clickOnImportantQuestions(importantQuestionLocator);
//        objManePage.waitForLoadAnswerFieldAfterClick(answerToQuestionLocator);
        //Шаг для ожидания загрузки главной страницы, нажатия кнопки куковб скрола страницы до блока вопросов,
        //клика по полю вопроса и ожидания открытия поля ответа.
        objManePage.stepForTestingQuestionsAndAnswersFields(importantQuestionLocator, answerToQuestionLocator);
        // Проверка текста ответа
        String result1 = driver.findElement(answerToQuestionLocator).getText();
        assertEquals (expectedAnswer,result1);
        // Проверка текста вопроса
        String result2 = driver.findElement(importantQuestionLocator).getText();
        assertEquals (expectedQuestion,result2);

    }

    @After
    public void tearDown() throws Exception{
        // Закрой браузер
        //Thread.sleep(1_000);
        driver.quit();
    }

}
