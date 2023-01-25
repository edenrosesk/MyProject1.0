import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Search {

    public static void main(String[] args) {

        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");

        WebDriver driver = new FirefoxDriver(options);
        driver.get("https://knigavuhe.org");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebElement searchInput = driver.findElement(By.xpath(".//input[@name='q']"));

        searchInput.click();
        searchInput.sendKeys("Пушкин");
        searchInput.sendKeys(Keys.ENTER);

        //driver.quit();

    }
}