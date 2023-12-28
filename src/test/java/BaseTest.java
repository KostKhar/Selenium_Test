import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BaseTest {
    protected WebDriver driver;

    public BaseTest() {
    }

    @Before
    public void startFox() {
        WebDriverManager.firefoxdriver().setup();
        System.setProperty("webdriver.gecko.driver", "C:\\cygwin64\\home\\admin\\untitled\\geckodriver.exe");
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability("marionette", true);
        this.driver = new FirefoxDriver(capabilities);
        this.driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    @After
    public void browserQuit() {
        driver.quit();
    }

}
