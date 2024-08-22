package pageObject.Constants;

import org.openqa.selenium.By;

public class MainScooterPageConstants {

    //Локатор поля важных вопросов
    public static final By IMPORTANT_QUESTION_FIELD_1 = By.id("accordion__heading-0");
    public static final By IMPORTANT_QUESTION_FIELD_2 = By.id("accordion__heading-1");
    public static final By IMPORTANT_QUESTION_FIELD_3 = By.id("accordion__heading-2");
    public static final By IMPORTANT_QUESTION_FIELD_4 = By.id("accordion__heading-3");
    public static final By IMPORTANT_QUESTION_FIELD_5 = By.id("accordion__heading-4");
    public static final By IMPORTANT_QUESTION_FIELD_6 = By.id("accordion__heading-5");
    public static final By IMPORTANT_QUESTION_FIELD_7 = By.id("accordion__heading-6");
    public static final By IMPORTANT_QUESTION_FIELD_8 = By.id("accordion__heading-7");
    //Текст поля важных вопросов
    public static final String IMPORTANT_QUESTION_FIELD_1_TEXT = "Сколько это стоит? И как оплатить?";
    public static final String IMPORTANT_QUESTION_FIELD_2_TEXT = "Хочу сразу несколько самокатов! Так можно?";
    public static final String IMPORTANT_QUESTION_FIELD_3_TEXT = "Как рассчитывается время аренды?";
    public static final String IMPORTANT_QUESTION_FIELD_4_TEXT = "Можно ли заказать самокат прямо на сегодня?";
    public static final String IMPORTANT_QUESTION_FIELD_5_TEXT = "Можно ли продлить заказ или вернуть самокат раньше?";
    public static final String IMPORTANT_QUESTION_FIELD_6_TEXT = "Вы привозите зарядку вместе с самокатом?";
    public static final String IMPORTANT_QUESTION_FIELD_7_TEXT = "Можно ли отменить заказ?";
    public static final String IMPORTANT_QUESTION_FIELD_8_TEXT = "Я живу за МКАДом, привезёте?";
    //Локатор поля ответа на вопрос
    public static final By ANSWER_TO_QUESTION_FIELD_1 = By.xpath(".//*[@aria-labelledby= 'accordion__heading-0']");
    public static final By ANSWER_TO_QUESTION_FIELD_2 = By.xpath(".//*[@aria-labelledby= 'accordion__heading-1']");
    public static final By ANSWER_TO_QUESTION_FIELD_3 = By.xpath(".//*[@aria-labelledby= 'accordion__heading-2']");
    public static final By ANSWER_TO_QUESTION_FIELD_4 = By.xpath(".//*[@aria-labelledby= 'accordion__heading-3']");
    public static final By ANSWER_TO_QUESTION_FIELD_5 = By.xpath(".//*[@aria-labelledby= 'accordion__heading-4']");
    public static final By ANSWER_TO_QUESTION_FIELD_6 = By.xpath(".//*[@aria-labelledby= 'accordion__heading-5']");
    public static final By ANSWER_TO_QUESTION_FIELD_7 = By.xpath(".//*[@aria-labelledby= 'accordion__heading-6']");
    public static final By ANSWER_TO_QUESTION_FIELD_8 = By.xpath(".//*[@aria-labelledby= 'accordion__heading-7']");
    //Текст поля ответа на вопрос
    public static final String ANSWER_TO_QUESTION_FIELD_TEXT_1 = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
    public static final String ANSWER_TO_QUESTION_FIELD_TEXT_2 = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
    public static final String ANSWER_TO_QUESTION_FIELD_TEXT_3 = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
    public static final String ANSWER_TO_QUESTION_FIELD_TEXT_4 = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
    public static final String ANSWER_TO_QUESTION_FIELD_TEXT_5 = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
    public static final String ANSWER_TO_QUESTION_FIELD_TEXT_6 = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
    public static final String ANSWER_TO_QUESTION_FIELD_TEXT_7 = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
    public static final String ANSWER_TO_QUESTION_FIELD_TEXT_8 = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";
}
