package locators;

import org.openqa.selenium.By;

public class ClientDetailsLocators {
    // Локаторы элементов страницы заказа самоката

    // Локатор для раздела "Для кого самокат"
    public static final By FOR_WHOM_SCOOTER_DIV = By.cssSelector("div.Order_Header__BZXOb");

    // Локатор для поля ввода "Имя"
    public static final By FIRST_NAME_INPUT = By.cssSelector("input[placeholder='* Имя']");

    // Локатор для поля ввода "Фамилия"
    public static final By LAST_NAME_INPUT = By.cssSelector("input[placeholder='* Фамилия']");

    // Локатор для поля ввода "Адрес: куда привезти заказ"
    public static final By ADDRESS_INPUT = By.cssSelector("input[placeholder='* Адрес: куда привезти заказ']");


    // Локатор для списка "Станция метро"
    public static final By METRO_STATION_INPUT = By.cssSelector("input.select-search__input[placeholder='* Станция метро']");


    // Локатор для поля ввода "Телефон: на него позвонит курьер"
    public static final By PHONE_NUMBER_INPUT = By.cssSelector("input[placeholder='* Телефон: на него позвонит курьер']");

    // Локатор для кнопки "Далее"
    public static final By NEXT_BUTTON = By.xpath("//button[contains(text(), 'Далее')]");

    // Локатор для выпадающего списка станций метро
    public static final By METRO_STATION_OPTIONS = By.cssSelector(".select-search__option");

    public static final By METRO_STATION_DROPDOWN = By.className("select-search");


}
