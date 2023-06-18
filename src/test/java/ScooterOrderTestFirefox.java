import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;
import pages.ScooterOrderPage;
import locators.WebDriverFactory;
import locators.ScooterOrderPageLocators;

import java.time.Duration;
import java.util.Random;

public class ScooterOrderTestFirefox {
    private WebDriver driver;
    private WebDriverWait wait;
    private HomePage homePage;
    private ScooterOrderPage scooterOrderPage;

    @Before
    public void setUpBeforeClass() {
        WebDriverFactory driverFactory = new WebDriverFactory();
        driver = driverFactory.createFirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        homePage = new HomePage(driver, wait);
        scooterOrderPage = new ScooterOrderPage(driver, wait);
        driver.manage().window().maximize();
    }

    @Test
    public void testScooterOrder() {
        homePage.open();
        Assert.assertTrue("Home page is not loaded", homePage.isPageLoaded());

        homePage.acceptCookie();
        homePage.clickTopOrderButton();

        Assert.assertTrue("Client details form is not displayed", scooterOrderPage.isClientDetailsFormDisplayed());

        scooterOrderPage.enterClientDetails("Тестирование", "Яндекс", "Практикум", "891812344321");
        scooterOrderPage.selectRandomMetroStation();
        scooterOrderPage.clickNextButtonInClientDetails();

        int randomRentalPeriodIndex = new Random().nextInt(3); // Генерируем случайный индекс от 0 до 2
        scooterOrderPage.fillOrderForm("20-06-2023", randomRentalPeriodIndex);
        scooterOrderPage.clickNextButton();

        try {
            Thread.sleep(2000); // Пауза 2 секунды
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        scooterOrderPage.clickPopupYesButton();

        // Assert.assertTrue("Order confirmation is not displayed", scooterOrderPage.isOrderConfirmationDisplayed());
        String orderNumber = scooterOrderPage.getOrderNumber();
        System.out.println("Order Number: " + orderNumber);

        //Assert.assertTrue("Popup Yes button is not displayed", scooterOrderPage.isPopupYesButtonDisplayed());

        //scooterOrderPage.clickPopupYesButton();

        //String orderElementText = scooterOrderPage.getOrderElementText();
        //System.out.println("Order Element: " + orderElementText);

        // scooterOrderPage.clickViewStatusButton();
    }

    @After
    public void tearDownAfterClass() {
        if (driver != null) {
            driver.quit();
        }
    }
}