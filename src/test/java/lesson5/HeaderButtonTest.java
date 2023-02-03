package lesson5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;


public class HeaderButtonTest extends AbstractTest {
    private final WebDriver driver;

    public HeaderButtonTest() {
        driver = getDriver();
    }

    @Test
    void test() {

        WebElement genresButton = driver.findElement(By.xpath(".//div[@id='header_links']/a[@href='/genres/']"));
        genresButton.click();

        Assertions.assertEquals("Жанры аудиокниг", driver.getTitle(),"Открыта не та страница");

        WebElement authorsButton = driver.findElement(By.xpath(".//div[@id='header_links']/a[@href='/authors/']"));
        authorsButton.click();

        Assertions.assertEquals("Авторы аудиокниг", driver.getTitle(),"Открыта не та страница");

        WebElement readersButton = driver.findElement(By.xpath(".//div[@id='header_links']/a[@href='/readers/']"));
        readersButton.click();

        Assertions.assertEquals("Исполнители аудиокниг", driver.getTitle(),"Открыта не та страница");

        WebElement logoButton = driver.findElement(By.xpath(".//a[@class='header_logo']"));
        logoButton.click();

        Assertions.assertEquals("Аудиокниги слушай онлайн - адрес Книга в Ухе запоминай!", driver.getTitle(),"Открыта не та страница");
    }
}
