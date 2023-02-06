package lesson6;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AuthorizationTest extends AbstractTest {

    @Test
    void loginIn() {
        new MainPage(getWebDriver()).goToLoginPage();
        Assertions.assertTrue(getWebDriver().getTitle().equals("Вход и регистрация"), "Страница входа недоступна");
        new AuthorizationPage(getWebDriver())
                .setLogin("Testlalal@yandex.ru")
                .setPassword("2H7SJg3ky6P7cVM")
                .loginIn();
        Assertions.assertTrue(getWebDriver().getTitle().equals("Профиль @Иван_12345"),"Не авторизован");
    }

    @Test
    void loginInSecond() throws InterruptedException {
        new MainPage(getWebDriver()).goToLoginPage();
        Assertions.assertTrue(getWebDriver().getTitle().equals("Вход и регистрация"), "Страница входа недоступна");
        new AuthorizationPage(getWebDriver())
                .loginIn("Testlalal@yandex.ru","2H7SJg3ky6P7cVM");
        Thread.sleep(2000);
        Assertions.assertTrue(getWebDriver().getTitle().equals("Профиль @Иван_12345"),"Не авторизован");
    }

    @AfterEach
    void logout(){
        new AccountPage(getWebDriver()).logOut();
        new WebDriverWait(getWebDriver(),Duration.ofSeconds(10 ));
        Assertions.assertTrue(getWebDriver().getTitle().equals("Профиль @Иван_12345"),"Не авторизован");
    }

}
