import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class HeaderButton {

    public static void main(String[] args) {

        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");

        WebDriver driver = new FirefoxDriver(options);
        driver.get("https://knigavuhe.org");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebElement searchButton = driver.findElement(By.xpath(".//form/button[@class='header_search_icon']"));
        searchButton.click();

        WebElement genresButton = driver.findElement(By.xpath(".//div[@id='header_links']/a[@href='/genres/']"));
        genresButton.click();

        WebElement authorsButton = driver.findElement(By.xpath(".//div[@id='header_links']/a[@href='/authors/']"));
        authorsButton.click();

        WebElement readersButton = driver.findElement(By.xpath(".//div[@id='header_links']/a[@href='/readers/']"));
        readersButton.click();

        WebElement logoButton = driver.findElement(By.xpath(".//a[@class='header_logo']"));
        logoButton.click();


        //driver.quit();
    }
}