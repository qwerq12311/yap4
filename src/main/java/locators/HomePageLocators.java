package locators;

import org.openqa.selenium.By;

public class HomePageLocators {
    // Локаторы элементов главной страницы

    // Локатор кнопки согласия на использование куки
    public static final By COOKIE_CONSENT_BUTTON = By.cssSelector(".App_CookieConsent__1yUIN .App_CookieButton__3cvqF");


    public static final By INPUT_ORDER_NUMBER = By.id("input_order_number_id"); // Поле ввода номера заказа
    public static final By BUTTON_GO = By.id("button_go_id"); // Кнопка "Go"
    public static final By FAQ_QUESTIONS_LIST = By.className("accordion__item"); // Список вопросов FAQ

    // Элементы аккордиона
    public static final By ACCORDION_DIV = By.cssSelector(".accordion");
    public static final By ACCORDION_ITEM_DIV = By.cssSelector(".accordion__item");
    public static final By ACCORDION_ITEM_HEADING_DIV = By.cssSelector(".accordion__heading");
    public static final By ACCORDION_ITEM_BUTTON_DIV = By.cssSelector(".accordion__button");
    public static final By ACCORDION_ITEM_PANEL_DIV = By.cssSelector(".accordion__panel");


}
