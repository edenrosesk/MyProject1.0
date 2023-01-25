import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Authorization {

    public static void main(String[] args) {

        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");

        WebDriver driver = new FirefoxDriver(options);
        driver.get("https://knigavuhe.org");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

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


      //driver.quit();
    }

}

