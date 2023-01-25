package lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Example {
    public static void main(String[] args) {

        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");

        WebDriver driver = new FirefoxDriver(options);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://www.livejournal.com");

        WebElement webElement1 = driver.findElement(By.xpath("/html/body/div[4]/header/div/nav[2]/ul/li[2]/a"));
        WebElement webElement2 = driver.findElement(By.name("user"));
        WebElement webElement3 = driver.findElement(By.name("password"));
        WebElement webElement4 = driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/form[1]/button"));

                List<WebElement> webElement = driver.findElements(By.name("error"));
        if(webElement.size()>1){

        }

        webElement1.click();
        webElement2.click();
        webElement2.sendKeys("Testlalal");
        webElement3.click();
        webElement3.sendKeys("2H7SJg3ky6P7cVM");
        webElement4.click();

    }
}