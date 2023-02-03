package lesson5;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;


public class AddingBookTest extends AuthAbstractTest {
    private final WebDriver driver;

    public AddingBookTest() {
        driver = getDriver();
    }

    @Test
    void test() {
      WebElement searchInput = driver.findElement(By.xpath(".//input[@name='q']"));

      searchInput.click();
      searchInput.sendKeys("Война и мир");
      searchInput.sendKeys(Keys.ENTER);

      WebElement openBook = driver.findElement(By.xpath(".//div[@id='books_list']//div[@class='bookkitem']/a"));
      openBook.click();

      WebElement addBook = driver.findElement(By.xpath(".//div[@id='book_fave_btn']"));
      addBook.click();

      goToShelf(driver);

      WebElement bookName = driver.findElement(By.xpath(".//div[@class='books_cr_book_name']"));
      Assertions.assertEquals("Война и мир", bookName.getText(),"Книга не добавлена");

        //удалить книгу
        openBook = driver.findElement(By.xpath(".//a[@href='/book/vojjna-i-mir/']"));
        openBook.click();

        WebElement removeBook = driver.findElement(By.xpath(".//div[@id='book_fave_btn']"));
        //WebElement removeBook = driver.findElement(By.xpath(".//div[@class='books_cr_book_button -del']"));
        removeBook.click();

        goToShelf(driver);

  }

    static void goToShelf(WebDriver driver) {
        WebElement menuProfile = driver.findElement(By.xpath(".//div[@class='header_user']/a"));
        menuProfile.click();

        WebElement goToShelf = driver.findElement(By.xpath(".//a[@href='/user290880/fav/']"));
        goToShelf.click();
    }
  }
