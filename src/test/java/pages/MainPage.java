package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    @FindBy(xpath = "(//a[contains(@class, 'desk-notif-card__login-new-item')])[1]")
    public WebElement buttonAuthorization;

    @FindBy(xpath = "//a[contains(@class, 'desk-notif-card__domik-mail-line')]")
    private WebElement buttonGoToMail;

    public WebDriver driver;
    public WebDriverWait wait;

    public MainPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public void openHomePage() {
        driver.navigate().to("https://yandex.ru/");
    }

    public MailPage buttonGoToMail() {
        buttonGoToMail.click();
        return new MailPage(driver, wait);
    }


}
