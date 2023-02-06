package lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;


public class AuthorizationPage extends AbstractPage {

    @FindBy(xpath = ".//div[@class='auth_form_line']//input[@name='email']")
    private WebElement emailInput;

    @FindBy(name = "password")
    private WebElement passwordInput;

    @FindBy(xpath = ".//div[@class='auth_form_line']/button")
    private WebElement loginButton;

    public AuthorizationPage(WebDriver driver){
        super(driver);
    }

   public AuthorizationPage setLogin(String login){
        this.emailInput.click();
        this.emailInput.sendKeys(login);
        return this;
   }

   public AuthorizationPage setPassword(String password){
       this.passwordInput.click();
       this.passwordInput.sendKeys(password);
       return this;

   }

    public void loginIn(){
        this.loginButton.click();
    }

    public void loginIn(String login, String password){

        Actions loginIn = new Actions(getDriver());
        loginIn
                .click(this.emailInput)
                .sendKeys(login)
                .click(this.passwordInput)
                .sendKeys(password)
                .click(this.loginButton)
                .build()
                .perform();
    }
}
