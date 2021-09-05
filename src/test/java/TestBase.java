import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class TestBase {

    protected WebDriver driver;
    protected WebDriverWait wait;
    public String initialWindow;
    @BeforeEach
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps = DesiredCapabilities.chrome();
        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), caps);
        //For Firefox use below capabilities
        //DesiredCapabilities caps = DesiredCapabilities.firefox();(new URL("http://localhost:4444/wd/hub"), caps);
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        var options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.DISMISS);
        driver = new ChromeDriver(options);
        initialWindow = driver.getWindowHandle();
        wait = new WebDriverWait(driver, 5);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


        }
    @AfterEach
    public void tearDown() throws IOException {
        try{
            takeScreenshot();
        }catch (UnhandledAlertException alertException){
            Alert alert = driver.switchTo().alert();
            System.out.println("Alert text: " + alert.getText());
            alert.accept();
            takeScreenshot();
        }
        driver.quit();
    }
    public void takeScreenshot() throws IOException {
        var sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(sourceFile, new File("c:\\tmp\\screenshot.png"));
    }
    public Set<String> getAllWindows(){
        return driver.getWindowHandles();
    }

    public void switchToFirstNewWindow(){
        var newWindows = getAllWindows().stream().filter(w -> !w.equals(initialWindow)).collect(Collectors.toSet());
        driver.switchTo().window(newWindows.stream().findFirst().get());
    }
    public void switchToWindow(String windowId){
        driver.switchTo().window(windowId);
    }
}
