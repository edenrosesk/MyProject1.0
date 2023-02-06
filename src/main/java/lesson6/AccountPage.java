package lesson6;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends AbstractPage {

    @FindBy(xpath = ".//a[@id='header_user_link']")
    private WebElement profile;

    @FindBy(xpath = ".//a[@href='/login/logout/?token=731096b3d9d07e06bfcb']")
    private WebElement exit;

    public AccountPage(WebDriver driver){
        super(driver);
    }

    public void logOut(){
        this.profile.click();
        this.exit.click();
    }
}
