import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.MainPage;

public class Tests  extends TestBase {
    @Test
    public void testChaseEmail() {
        //arrange
        var homePage = new MainPage(driver, wait);
        homePage.openHomePage();
        var email = "andr3test@yandex.ru";
        var password = "qwerty!123";
        var expectedNameMail = "Simbirsoft Тестовое задание";
        //act
        homePage.buttonAuthorization.click();
        homePage.fieldInputEmail.sendKeys(email);
        homePage.buttonEnter.click();
        homePage.fieldInputPassword.sendKeys(password);
        homePage.buttonEnter.click();
        var mailPage = homePage.buttonGoToMail();
        switchToFirstNewWindow();
        //assert
        Assertions.assertAll(
                () -> Assertions.assertEquals(expectedNameMail, mailPage.textNameMail.getText(), "Название письма не совпадает"),
                () -> Assertions.assertEquals(2, mailPage.textListNameMail.size(), "Количество писем не совпадает")
        );

    }
}
