package lesson5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;


public class SearchTest extends AbstractTest {
    private final WebDriver driver;

    public SearchTest() {
        driver = getDriver();
    }

    @Test
    void test() throws InterruptedException {
        WebElement searchInput = driver.findElement(By.xpath(".//input[@name='q']"));

        searchInput.click();
        searchInput.sendKeys("Пушкин");
        searchInput.sendKeys(Keys.ENTER);

        Thread.sleep(2000);

        Assertions.assertEquals("Пушкин - Поиск на сайте по аудиокнигам, циклам, авторам и исполнителям", driver.getTitle(),"Не та страница");
    }
}
