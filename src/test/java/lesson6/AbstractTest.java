package lesson6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.concurrent.TimeUnit;

public abstract class AbstractTest {

    private static WebDriver webDriver;

    @BeforeAll
    static void init(){
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--incognito");
        //options.addArguments("--headless");
        options.addArguments("start-maximized");
        webDriver = new FirefoxDriver(options);
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    @BeforeEach
    void goTo(){
        Assertions.assertDoesNotThrow( ()-> webDriver.navigate().to("https://knigavuhe.org"),
                "Страница не доступна");
    }

    @AfterAll
    public static void exit(){

        if(webDriver !=null) webDriver.quit();
    }

    public WebDriver getWebDriver(){
        return this.webDriver;
    }
}
