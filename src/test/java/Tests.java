import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.AuthorizationPage;
import pages.MailPage;
import pages.MainPage;

public class Tests extends TestBase {

    private String email = "andr3test@yandex.ru";
    private String password = "qwerty!123";
    private String expectedNameMail = "Simbirsoft Тестовое задание";
    private String textEmail = "Найдено писем - ";
    private String twoExpectedNameMail = "Simbirsoft Тестовое задание. Смотров";
    private int expectedSizeMail;

    @BeforeEach
    public void authorizeSite() {
        //arrange
        var homePage = new MainPage(driver, wait);
        homePage.openHomePage();
        homePage.buttonAuthorization.click();
        var authorizePage = new AuthorizationPage(driver, wait);
        authorizePage.authorize(email, password);
        homePage.buttonGoToMail();
    }

    @Test
    public void testEmail() {
        //act
        var mailPage = new MailPage(driver, wait);
        switchToFirstNewWindow();
        mailPage.fieldSearchMail.sendKeys(expectedNameMail);
        mailPage.buttonSearchMail.click();
        expectedSizeMail = mailPage.textListNameMail.size();
        mailPage.buttonWrite.click();
        mailPage.stringAddress.sendKeys(email);
        mailPage.stringTopic.sendKeys(twoExpectedNameMail);
        mailPage.windowText.sendKeys(textEmail + expectedSizeMail);
        mailPage.buttonSend.click();
        mailPage.waitMail();
        var actualTextName = mailPage.textNowNameMail.getText();
        //assert
        Assertions.assertAll(
                () -> Assertions.assertTrue(mailPage.textNowNameMail.isDisplayed(), "Письма не совпадает"),
                () -> Assertions.assertEquals(twoExpectedNameMail, actualTextName, "Название письма не совпадает")
        );
    }
}
