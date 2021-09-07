package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class MailPage{

    @FindBy(css = "input.textinput__control")
    public WebElement fieldSearchMail;

    @FindBy(css = "div[class*=ns-view-messages-item-wrap]")
    public List<WebElement> textListNameMail;

    @FindBy(css = "button[class*=search-input__form-button]")
    public WebElement buttonSearchMail;

    @FindBy(xpath = "//*[@title='Simbirsoft Тестовое задание. Смотров']")
    public WebElement textNowNameMail;

    @FindBy(xpath = "//a[contains(@class, 'mail-ComposeButton')]")
    public WebElement buttonWrite;

    @FindBy(xpath = "(//*[@class='composeYabbles'])[1]")
    public WebElement stringAddress;

    @FindBy(xpath = "//*[@name='subject']")
    public WebElement stringTopic;

    @FindBy(xpath = "//*[contains(@class, 'cke_contents_ltr')]")
    public WebElement windowText;

    @FindBy(xpath = "(//button[contains(@class, 'Button2_size_l')])[1]")
    public WebElement buttonSend;

    public WebDriver driver;
    public WebDriverWait wait;
    public MailPage (WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }
    public void waitMail(){
        var newWait = new WebDriverWait(driver, 30);
        newWait.until(driver -> textNowNameMail.isDisplayed());
    }
}
