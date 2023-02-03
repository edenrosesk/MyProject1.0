package lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.concurrent.TimeUnit;

public abstract class AuthAbstractTest {

    private static WebDriver driver;

    @BeforeAll
    static void init() {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--incognito");
        //options.addArguments("--headless");
        options.addArguments("start-maximized");
        driver = new FirefoxDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @BeforeEach
    void goTo() throws InterruptedException {
        Assertions.assertDoesNotThrow(() -> driver.navigate().to("https://knigavuhe.org"),
                "Страница не доступна");
        Thread.sleep(2000);

        WebElement goToLoginPageButton = driver.findElement(By.xpath(".//div[@class='header_right']/a"));
        goToLoginPageButton.click();

        WebElement emailInput = driver.findElement(By.xpath(".//div[@class='auth_form_line']//input[@name='email']"));
        WebElement passwordInput = driver.findElement(By.name("password"));
        WebElement loginButton = driver.findElement(By.xpath(".//div[@class='auth_form_line']/button"));


        emailInput.click();
        emailInput.sendKeys("Testlalal@yandex.ru");
        passwordInput.click();
        passwordInput.sendKeys("2H7SJg3ky6P7cVM");

        loginButton.click();
    }


    @AfterAll
    static void close() {
        driver.quit();
    }

    public static WebDriver getDriver() {
        return driver;
    }
}

