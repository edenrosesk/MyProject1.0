package lesson5;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AuthorizationTest extends AbstractTest {
    private final WebDriver driver;

    public AuthorizationTest() {
        driver = getDriver();
    }

    @Test
    void test() {
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

        Assertions.assertEquals("Профиль @Иван_12345", driver.getTitle(),"Не авторизован");
    }
}
