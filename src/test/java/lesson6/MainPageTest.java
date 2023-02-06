package lesson6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MainPageTest extends AbstractTest {

    @Test
    void clickToGenres(){
        new MainPage(getWebDriver()).goToGenresPage();
        Assertions.assertEquals("https://knigavuhe.org/genres/", getWebDriver().getCurrentUrl());
    }

    @Test
    void clickToAuthors(){
        new MainPage(getWebDriver()).goToAuthorsPage();
    }

    @Test
    void clickToReaders(){
        new MainPage(getWebDriver()).goToReadersPage();
    }

    @Test
    void clickToLogo(){
        new MainPage(getWebDriver()).goToMainPage();
    }
}
