import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import ru.qa.scooter.praktikum.services.page.object.HomePage;
import ru.qa.scooter.praktikum.services.page.object.OrderPage;

import static org.junit.Assert.assertTrue;


public class OrderPageTest {

    private WebDriver driver;


    public void startChrome(WebDriver driver) {
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    public void startFox(WebDriver driver) {
        WebDriverManager.firefoxdriver().setup();
        System.setProperty("webdriver.gecko.driver", "C:\\cygwin64\\home\\admin\\untitled\\geckodriver.exe");
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability("marionette", true);
        this.driver = new FirefoxDriver(capabilities);
        this.driver.get("https://qa-scooter.praktikum-services.ru/");
    }


    @Test
    public void checkOrderByUpButton() {
        startFox(driver);
        HomePage objHomePage = new HomePage(driver);
        objHomePage.clickOrderButton();
        OrderPage objOrderPage = new OrderPage(driver);
        objOrderPage.waitField();
        objOrderPage.makeOrderOnePageSocolniki("Иван", "Иванов", "Москва, Азовская, д. 23, кв 40", "+79887552545");
        objOrderPage.makeOrderTwoPageOneDay("24.12.2023", "Домофон 25*25");
        assertTrue(objOrderPage.actualOrder());
        driver.quit();
    }

    @Test
    public void checkOrderByMiddleButton() {
        startFox(driver);
        HomePage objHomePage = new HomePage(driver);
        objHomePage.clickOrderMiddleButton();
        OrderPage objOrderPage = new OrderPage(driver);
        objOrderPage.makeOrderOnePageTverskay("Илья", "Сидоров", "г. Домодедово, Азовская, д. 23, кв 40", "+79182566989");
        objOrderPage.makeOrderTwoPageSevenDay("24.12.2023", "");
        assertTrue(objOrderPage.actualOrder());
        driver.quit();
    }


}
