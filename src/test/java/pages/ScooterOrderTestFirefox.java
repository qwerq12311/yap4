package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;
import pages.ScooterOrderPage;
import org.apache.commons.lang3.StringUtils;

import java.time.Duration;
import java.util.Random;

public class ScooterOrderTestFirefox {
    private WebDriver driver;
    private WebDriverWait wait;
    private HomePage homePage;
    private ScooterOrderPage scooterOrderPage;

    @Before
    public void setUpBeforeClass() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        homePage = new HomePage(driver, wait);
        scooterOrderPage = new ScooterOrderPage(driver, wait);
        driver.manage().window().maximize();
    }

    @Test
    public void testScooterOrder() {
        homePage.open();
        Assert.assertTrue("что-то пошло не так1", homePage.isPageLoaded());

        homePage.acceptCookie();
        homePage.clickTopOrderButton();

        Assert.assertTrue("что-то пошло не так2", scooterOrderPage.isClientDetailsFormDisplayed());

        scooterOrderPage.enterClientDetails("Тестирование", "Яндекс", "Практикум", "891812344321");
        scooterOrderPage.selectRandomMetroStation();
        scooterOrderPage.clickNextButtonInClientDetails();

        int randomRentalPeriodIndex = new Random().nextInt(3);
        scooterOrderPage.fillOrderForm("20-06-2023", randomRentalPeriodIndex);
        scooterOrderPage.clickNextButton();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        scooterOrderPage.clickPopupYesButton();

        // Проверяем, что всплывающее окно после создания заказа содержит ожидаемую фразу
        Assert.assertTrue("что-то пошло не так3", scooterOrderPage.isOrderConfirmationDisplayed());

// Получаем текст элемента заказа и проверяем его на содержание ожидаемой фразы
        String orderElementText = scooterOrderPage.getOrderElementText();
        String expectedOrderElementPhrase = "Заказ оформлен";
        Assert.assertTrue("что-то пошло не так4", StringUtils.containsIgnoreCase(orderElementText, expectedOrderElementPhrase));

// Дополнительная проверка, что на экране есть текст, содержащий "Заказ оформлен"
        Assert.assertTrue("что-то пошло не так5", scooterOrderPage.isOrderConfirmationDisplayed());
    }


    @Test
    public void testScooterOrder2() {
        homePage.open();
        Assert.assertTrue("что-то пошло не так6", homePage.isPageLoaded());

        homePage.acceptCookie();
        homePage.clickTopOrderButton();

        Assert.assertTrue("что-то пошло не так7", scooterOrderPage.isClientDetailsFormDisplayed());

        scooterOrderPage.enterClientDetails("Яндекс", "Тестирование", "херактикум", "891812355321");
        scooterOrderPage.selectRandomMetroStation();
        scooterOrderPage.clickNextButtonInClientDetails();

        int randomRentalPeriodIndex = new Random().nextInt(3);
        scooterOrderPage.fillOrderForm("24-06-2023", randomRentalPeriodIndex);
        scooterOrderPage.clickNextButton();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        scooterOrderPage.clickPopupYesButton();

        // Проверяем, что всплывающее окно после создания заказа содержит ожидаемую фразу
        Assert.assertTrue("что-то пошло не так8", scooterOrderPage.isOrderConfirmationDisplayed());

// Получаем текст элемента заказа и проверяем его на содержание ожидаемой фразы
        String orderElementText = scooterOrderPage.getOrderElementText();
        String expectedOrderElementPhrase = "Заказ оформлен";
        Assert.assertTrue("что-то пошло не так9", StringUtils.containsIgnoreCase(orderElementText, expectedOrderElementPhrase));

// Дополнительная проверка, что на экране есть текст, содержащий "Заказ оформлен"
        Assert.assertTrue("что-то пошло не так10", scooterOrderPage.isOrderConfirmationDisplayed());
    }

    @After
    public void tearDownAfterClass() {
        if (driver != null) {
            driver.quit();
        }
    }
}
