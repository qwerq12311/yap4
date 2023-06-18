package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;

import locators.HomePageLocators;
import locators.ScooterOrderPageLocators;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;

    public HomePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void open() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    public boolean isPageLoaded() {
        return wait.until(ExpectedConditions.urlToBe("https://qa-scooter.praktikum-services.ru/"));
    }

    public void acceptCookie() {
        By cookieButtonLocator = HomePageLocators.COOKIE_CONSENT_BUTTON;
        WebElement cookieButton = wait.until(ExpectedConditions.elementToBeClickable(cookieButtonLocator));
        cookieButton.click();
    }

    public void clickAccordionButton() {
        By accordionButtonLocator = HomePageLocators.ACCORDION_ITEM_BUTTON_DIV;
        WebElement accordionButton = wait.until(ExpectedConditions.elementToBeClickable(accordionButtonLocator));
        accordionButton.click();
    }

    public void clickAccordionItem(int index) {
        By itemHeadingLocator = HomePageLocators.ACCORDION_ITEM_HEADING_DIV;
        List<WebElement> accordionItems = driver.findElements(itemHeadingLocator);
        if (index >= 0 && index < accordionItems.size()) {
            WebElement itemHeading = accordionItems.get(index);
            itemHeading.click();
        } else {
            System.out.println("Invalid accordion item index.");
        }
    }

    public String getAccordionItemText(WebElement accordionItem) {
        By itemPanelLocator = HomePageLocators.ACCORDION_ITEM_PANEL_DIV;
        WebElement itemPanel = accordionItem.findElement(itemPanelLocator);
        return itemPanel.getText();
    }

    public List<WebElement> getAccordionItems() {
        By accordionItemsLocator = HomePageLocators.FAQ_QUESTIONS_LIST;
        return driver.findElements(accordionItemsLocator);
    }

    public void clickTopOrderButton() {
        By orderButtonLocator = ScooterOrderPageLocators.ORDER_BUTTON_HEADER;
        WebElement orderButton = driver.findElement(orderButtonLocator);
        orderButton.click();
    }

    public void clickBottomOrderButton() {
        By orderButtonLocator = ScooterOrderPageLocators.ORDER_BUTTON_FORM;
        WebElement orderButton = wait.until(ExpectedConditions.elementToBeClickable(orderButtonLocator));
        orderButton.click();
    }

    public void chooseRandomFAQItem() {
        List<WebElement> faqItems = getAccordionItems();
        if (!faqItems.isEmpty()) {
            Random random = new Random();
            int randomIndex = random.nextInt(faqItems.size());
            WebElement faqItem = faqItems.get(randomIndex);
            clickAccordionItem(randomIndex);
        } else {
            System.out.println("No FAQ items found.");
        }
    }
}
