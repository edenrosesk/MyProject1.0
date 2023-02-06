package lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage extends AbstractPage {

    @FindBy(xpath = ".//a[@class='header_logo']")
    private WebElement logoButton;

    @FindBy(xpath = ".//form/button[@class='header_search_icon']")
    private WebElement searchButton;

    @FindBy(xpath = ".//div[@id='header_links']/a[@href='/genres/']")
    private WebElement genresButton;

    @FindBy(xpath = ".//div[@id='header_links']/a[@href='/authors/']")
    private WebElement authorsButton;

    @FindBy(xpath = ".//div[@id='header_links']/a[@href='/readers/']")
    private WebElement readersButton;

    @FindBy(xpath = ".//div[@class='header_right']/a")
    private WebElement signIn;

    public MainPage(WebDriver driver){
        super(driver);
    }

    public void goToLoginPage(){
        signIn.click();
        new WebDriverWait(getDriver(), Duration.ofSeconds(10)).until(ExpectedConditions.urlContains("https://knigavuhe.org/login/"));
    }

    public void goToGenresPage(){
        genresButton.click();
        new WebDriverWait(getDriver(), Duration.ofSeconds(10)).until(ExpectedConditions.urlContains("https://knigavuhe.org/genres/"));
    }

    public void goToAuthorsPage(){
        authorsButton.click();
        new WebDriverWait(getDriver(), Duration.ofSeconds(10)).until(ExpectedConditions.urlContains("https://knigavuhe.org/authors/"));
    }

    public void goToReadersPage(){
        readersButton.click();
        new WebDriverWait(getDriver(), Duration.ofSeconds(10)).until(ExpectedConditions.urlContains("https://knigavuhe.org/readers/"));
    }

    public void goToMainPage() {
        logoButton.click();
        new WebDriverWait(getDriver(), Duration.ofSeconds(10)).until(ExpectedConditions.urlContains("https://knigavuhe.org"));
    }
}




