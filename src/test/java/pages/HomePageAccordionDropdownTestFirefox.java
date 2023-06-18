package pages;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import locators.WebDriverFactory;

public class HomePageAccordionDropdownTestFirefox {
    private WebDriver firefoxDriver;
    private WebDriverWait firefoxWait;
    private HomePage homePage;

    @Before
    public void setUp() {
        WebDriverFactory driverFactory = new WebDriverFactory();
        firefoxDriver = driverFactory.createFirefoxDriver();
        firefoxWait = new WebDriverWait(firefoxDriver, Duration.ofSeconds(10));
        homePage = new HomePage(firefoxDriver, firefoxWait);
        homePage.open();
        homePage.acceptCookie();
    }

    @Test
    public void testAccordionDropdownInFirefox() {
        testAccordionDropdownInBrowser(firefoxDriver, firefoxWait, "Firefox");
    }

    private void testAccordionDropdownInBrowser(WebDriver driver, WebDriverWait wait, String browserName) {
        homePage = new HomePage(driver, wait);

        // Ожидание загрузки элемента accordion__item
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("accordion__item")));

        List<WebElement> accordionItems = homePage.getAccordionItems();
        assertFalse("Список вопросов пуст", accordionItems.isEmpty());

        for (WebElement accordionItem : accordionItems) {
            assertTrue("Элемент аккордеона не видим", accordionItem.isDisplayed());
        }

        Random random = new Random();
        int item1Index = random.nextInt(accordionItems.size());
        int item2Index = random.nextInt(accordionItems.size());
        while (item2Index == item1Index) {
            item2Index = random.nextInt(accordionItems.size());
        }

        homePage.clickAccordionItem(item1Index);
        homePage.clickAccordionItem(item2Index);

        String item1Text = homePage.getAccordionItemText(accordionItems.get(item1Index));
        String item2Text = homePage.getAccordionItemText(accordionItems.get(item2Index));

        assertEquals("Неверный текст первого элемента аккордеона", item1Text, homePage.getAccordionItemText(accordionItems.get(item1Index)));
        assertEquals("Неверный текст второго элемента аккордеона", item2Text, homePage.getAccordionItemText(accordionItems.get(item2Index)));

        System.out.println("Тестирование завершено в браузере " + browserName);
        System.out.println("Протестированные элементы аккордеона: " + accordionItems.size());
    }

    @After
    public void tearDown() {
        if (firefoxDriver != null) {
            firefoxDriver.quit();
        }
    }
}
