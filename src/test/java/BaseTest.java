import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTest {
    protected WebDriver driver;
    // куки
    private final By buttonCookie = By.className("App_CookieButton__3cvqF");

    @Before
    public void startFox() {
        WebDriverManager.firefoxdriver().setup();
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability("marionette", true);
        this.driver = new FirefoxDriver(capabilities);
        this.driver.get("https://qa-scooter.praktikum-services.ru/");
        new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(buttonCookie));
        driver.findElement(buttonCookie).click();
    }

    @After
    public void browserQuit() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }

}
