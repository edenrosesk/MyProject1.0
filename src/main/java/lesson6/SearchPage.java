package lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SearchPage extends AbstractPage{

    @FindBy(xpath = ".//input[@name='q']")
    private WebElement searchInput;

    @FindBy(xpath = ".//button[@class='header_search_icon']")
    private WebElement searchButton;

    @FindBy(css = "div.bookkitem")
    private List<WebElement> searchItems;

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public void toSearch(String value){
        searchInput.click();
        new WebDriverWait(getDriver(), 5).until(ExpectedConditions.elementToBeClickable(searchInput));
        searchInput.sendKeys(value);
        searchButton.click();
    }

    public void takeItem(int n){
        searchItems.get(n).click();
    }

}
