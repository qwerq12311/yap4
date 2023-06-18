package locators;

import org.openqa.selenium.By;

public class ScooterOrderPageLocators {
    // Локаторы элементов страницы заказа самоката

    public static final By DATE_PICKER_INPUT = By.cssSelector(".Order_MixedDatePicker__3qiay input[type='text']"); // Поле ввода для выбора даты


    public static final By BLACK_CHECKBOX = By.cssSelector("label[for='black']"); // Чекбокс "чёрный жемчуг"

    public static final By GREY_CHECKBOX = By.cssSelector("label[for='grey']"); // Чекбокс "серая безысходность"

    public static final By COURIER_COMMENT_INPUT = By.cssSelector("input.Input_Responsible__1jDKN"); // Поле ввода комментария для курьера

    public static final By ORDER_BUTTON_HEADER = By.xpath("//button[contains(text(), 'Заказать')]"); // Кнопка "Заказать" в заголовке страницы

    public static final By ORDER_BUTTON_FORM = By.xpath("//div[contains(@class, 'Order_Buttons__1xGrp')]/button[contains(text(), 'Заказать')]"); // Кнопка "Заказать" в форме заказа

    // Локаторы в попапе подтверждения создания заказа
    public static final By wantToOrderLocator = By.xpath("//div[contains(text(), 'Хотите оформить заказ?')]"); // Хотите оформить заказ?
    public static final By orderConfirmedLocator = By.xpath("//div[contains(text(), 'Заказ оформлен')]"); // Заказ оформлен
    public static final By POPUP_NO_BUTTON = By.cssSelector(".Order_Modal__YZ-d3 button:nth-child(1)"); // Кнопка "Нет" в попапе заказа
    public static final By POPUP_YES_BUTTON = By.xpath("//button[text()='Да']"); // Кнопка "Да" в попапе заказа

    // Локаторы для кнопки в попапе успешного экрана
    public static final By VIEW_STATUS_BUTTON = By.cssSelector(".Order_NextButton__1_rCA button"); // Кнопка "Посмотреть статус"

    // Локатор для элемента "Заказ оформлен"
    public static final By locatorOrderConfirmed = By.className("Order_ModalHeader__3FDaJ");
    public static final By orderNumber = By.xpath("//div[@class='Order_Text__2broi']/text()[1]");
    public static final By locatorOfferToConfirmed = By.xpath("//div[contains(@class, 'Order_ModalHeader__3FDaJ') and contains(text(), 'Заказ оформлен')]");

    // Локатор для элемента "Номер заказа"
    public static final By locatorOrderNumberLabel = By.xpath("//div[@class='Order_Text__2broi' and contains(text(), 'Номер заказа')]");

    // Локатор для значения заказа
    public static final By locatorOrderNumberValue = By.xpath("//div[@class='Order_Text__2broi']/text()[2]");

    public static final By FOR_WHOM_SCOOTER_DIV = By.cssSelector("div.Order_Header__BZXOb");

    // Локаторы для выбора срока аренды
    public static final By dropdownContainer = By.className("Dropdown-root"); // Локатор для внешнего контейнера выпадающего списка
    public static final By dropdownControl = By.className("Dropdown-control"); // Локатор для элемента управления выпадающим списком
    public static final By selectedValue = By.cssSelector(".Dropdown-placeholder.is-selected"); // Локатор для выбранного значения в выпадающем списке
    public static final By dropdownMenu = By.className("Dropdown-menu"); // Локатор для выпадающего меню списка
    public static final By dropdownOption = By.className("Dropdown-option"); // Локаторы для опций в выпадающем списке

}
