import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;



public class AddingBook {

    public static void main(String[] args) {

        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");

        WebDriver driver = new FirefoxDriver(options);
        driver.get("https://knigavuhe.org");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //Авторизация пользователя

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

        WebElement searchInput = driver.findElement(By.xpath(".//input[@name='q']"));

        searchInput.click();
        searchInput.sendKeys("Война и мир");
        searchInput.sendKeys(Keys.ENTER);

        WebElement openBook = driver.findElement(By.xpath(".//div[@id='books_list']//div[@class='bookkitem']/a"));
        openBook.click();

        WebElement addBook = driver.findElement(By.xpath(".//div[@id='book_fave_btn']"));
        addBook.click();

        goToShelf(driver);

        //удалить книгу
        openBook = driver.findElement(By.xpath(".//a[@href='/book/vojjna-i-mir/']"));
        openBook.click();

        WebElement removeBook = driver.findElement(By.xpath(".//div[@id='book_fave_btn']"));
        //WebElement removeBook = driver.findElement(By.xpath(".//div[@class='books_cr_book_button -del']"));
        removeBook.click();

        goToShelf(driver);

        //driver.quit();

    }

    static void goToShelf(WebDriver driver) {
        WebElement menuProfile = driver.findElement(By.xpath(".//div[@class='header_user']/a"));
        menuProfile.click();

        WebElement goToShelf = driver.findElement(By.xpath(".//a[@href='/user290880/fav/']"));
        goToShelf.click();
    }
}