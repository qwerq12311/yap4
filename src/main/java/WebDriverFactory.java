package locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import locators.WebDriverFactory;

public class WebDriverFactory {

    public WebDriver getDriver() {
        return createChromeDriver(); // Запуск ChromeDriver по умолчанию
    }

    public WebDriver createChromeDriver() {
        // Установите путь к исполняемому файлу ChromeDriver
        System.setProperty("webdriver.chrome.driver", "/Users/RA/Downloads/chromedriver_mac_arm64/chromedriver");
        ChromeOptions options = new ChromeOptions();
        // Добавьте дополнительные параметры, если необходимо
        return new ChromeDriver(options);
    }

    public WebDriver createFirefoxDriver() {
        // Установите путь к исполняемому файлу GeckoDriver
        System.setProperty("webdriver.gecko.driver", "/usr/local/bin/geckodriver");
        FirefoxOptions options = new FirefoxOptions();
        // Добавьте дополнительные параметры, если необходимо
        return new FirefoxDriver(options);
    }
}
