package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class MailPage extends MainPage {

    public MailPage (WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@title='Simbirsoft Тестовое задание']")
    public List<WebElement> textListNameMail;

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

    public void waitMail(){
        var newWait = new WebDriverWait(driver, 30);
        newWait.until(driver -> textNowNameMail.isDisplayed());
    }
}
