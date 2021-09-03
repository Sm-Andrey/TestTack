package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public MainPage(WebDriver driver, WebDriverWait wait) {
            this.driver = driver;
            this.wait = wait;
            PageFactory.initElements(driver, this);
        }

    public void openHomePage(){
        driver.navigate().to("https://yandex.ru/");
    }

    public void openMailPage(){
        driver.navigate().to("https://mail.yandex.ru/");
    }

    @FindBy(xpath = "(//a[contains(@class, 'desk-notif-card__login-new-item')])[1]")
    public WebElement buttonAuthorization;

    @FindBy(xpath = "//*[@id='passp-field-login']")
    public WebElement fieldInputEmail;

    @FindBy(xpath = "//*[@id='passp:sign-in']")
    public WebElement buttonEnter;

    @FindBy(xpath = "//*[@id='passp-field-passwd']")
    public WebElement fieldInputPassword;

    @FindBy(xpath = "//*[@data-t='button:pseudo']")
    public WebElement buttonNotNow;

    @FindBy(xpath = "//a[contains(@class, 'desk-notif-card__domik-mail-line')]")
    private WebElement buttonGoToMail;

    public MailPage buttonGoToMail(){
        buttonGoToMail.click();
        return new MailPage(driver, wait);
    }


}
