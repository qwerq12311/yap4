package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import locators.ScooterOrderPageLocators;
import locators.ClientDetailsLocators;

import java.util.List;
import java.util.Random;

public class ScooterOrderPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public ScooterOrderPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    // Вводит данные клиента
    public void enterClientDetails(String firstName, String lastName, String deliveryAddress, String phone) {
        driver.findElement(ClientDetailsLocators.FIRST_NAME_INPUT).sendKeys(firstName);
        driver.findElement(ClientDetailsLocators.LAST_NAME_INPUT).sendKeys(lastName);
        driver.findElement(ClientDetailsLocators.ADDRESS_INPUT).sendKeys(deliveryAddress);
        driver.findElement(ClientDetailsLocators.PHONE_NUMBER_INPUT).sendKeys(phone);
    }

    // Выбирает случайную станцию метро
    public void selectRandomMetroStation() {
        driver.findElement(ClientDetailsLocators.METRO_STATION_INPUT).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(ClientDetailsLocators.METRO_STATION_DROPDOWN));
        List<WebElement> metroStationOptions = driver.findElements(ClientDetailsLocators.METRO_STATION_OPTIONS);
        Random random = new Random();
        int randomIndex = random.nextInt(metroStationOptions.size());
        metroStationOptions.get(randomIndex).click();
    }

    // Нажимает кнопку "Далее" на странице данных клиента
    public void clickNextButtonInClientDetails() {
        driver.findElement(ClientDetailsLocators.NEXT_BUTTON).click();
    }

    // Заполняет форму заказа
    public void fillOrderForm(String date, int rentalPeriodIndex) {
        driver.findElement(ScooterOrderPageLocators.DATE_PICKER_INPUT).sendKeys(date + Keys.ENTER);
        clickRentalPeriodField();
        selectRentalPeriodByIndex(rentalPeriodIndex);
    }

    // Нажимает кнопку "Заказать" на форме заказа
    public void clickNextButton() {
        driver.findElement(ScooterOrderPageLocators.ORDER_BUTTON_FORM).click();
    }

    // Нажимает кнопку "Да" в попапе подтверждения создания заказа
    public void clickPopupYesButton() {
        driver.findElement(ScooterOrderPageLocators.POPUP_YES_BUTTON).click();
    }

    // Нажимает кнопку "Посмотреть статус" на форме заказа оформлен
    public void clickViewStatusButton() {
        driver.findElement(ScooterOrderPageLocators.VIEW_STATUS_BUTTON).click();
    }

    // Проверяет, отображается ли форма данных клиента
    public boolean isClientDetailsFormDisplayed() {
        return isElementDisplayed(ScooterOrderPageLocators.FOR_WHOM_SCOOTER_DIV);
    }

    // Проверяет, отображается ли форма выбора срока аренды
    public boolean isRentalPeriodFormDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(ScooterOrderPageLocators.dropdownContainer)).isDisplayed();
    }

    // Нажимает на поле выбора срока аренды
    public void clickRentalPeriodField() {
        WebElement rentalPeriodField = wait.until(ExpectedConditions.elementToBeClickable(ScooterOrderPageLocators.dropdownContainer));
        rentalPeriodField.click();
    }

    // Выбирает опцию срока аренды по индексу
    public void selectRentalPeriodByIndex(int index) {
        List<WebElement> dropdownOptions = driver.findElements(ScooterOrderPageLocators.dropdownOption);
        if (index >= 0 && index < dropdownOptions.size()) {
            dropdownOptions.get(index).click();
        } else {
            System.out.println("Invalid rental period index.");
        }
    }

    // Проверяет, отображается ли подтверждение оформления заказа
    public boolean isOrderConfirmationDisplayed() {
        return isElementDisplayed(ScooterOrderPageLocators.locatorOfferToConfirmed);
    }

    // Получает номер заказа
    public String getOrderNumber() {
        clickPopupYesButton();
        WebElement orderNumberElement = wait.until(ExpectedConditions.presenceOfElementLocated(ScooterOrderPageLocators.orderNumber));
        // Получение текстового значения номера заказа
        String orderNumber = orderNumberElement.getText();

        // Вывод номера заказа в консоль
        System.out.println("Номер заказа: " + orderNumber);
        return orderNumber;
    }

    // Проверяет, отображается ли кнопка "Да" в попапе
    public boolean isPopupYesButtonDisplayed() {
        return driver.findElement(ScooterOrderPageLocators.POPUP_YES_BUTTON).isDisplayed();
    }

    // Получает текст элемента заказа
    public String getOrderElementText() {
        return driver.findElement(ScooterOrderPageLocators.locatorOfferToConfirmed).getText();
    }

    // Проверяет, отображается ли элемент
    private boolean isElementDisplayed(By locator) {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}