package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AuthorizationPage  extends MainPage{
    public AuthorizationPage (WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id='passp-field-login']")
    public WebElement fieldInputEmail;

    @FindBy(xpath = "//*[@id='passp:sign-in']")
    public WebElement buttonEnter;

    @FindBy(xpath = "//*[@id='passp-field-passwd']")
    public WebElement fieldInputPassword;

    public MainPage authorize(String email, String password){
        this.fieldInputEmail.sendKeys(email);
        buttonEnter.click();
        this.fieldInputPassword.sendKeys(password);
        buttonEnter.click();
        return new MainPage(driver, wait);
    }

}
