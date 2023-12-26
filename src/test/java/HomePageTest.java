import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import ru.qa.scooter.praktikum.services.page.object.HomePage;

import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class HomePageTest {
    private final String message;
    private final int index;
    private final int index1;
    private final boolean isVisible;

    public HomePageTest(int index, int index1, String message, boolean isVisible) {
        this.index = index;
        this.index1 = index1;
        this.message = message;
        this.isVisible = isVisible;
    }

    @Parameterized.Parameters
    public static Object[][] getMessage() {
        return new Object[][]{
                {0, 1, "Сутки — 400 рублей. Оплата курьеру — наличными или картой.", true},
                {2, 3, "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.", true},
                {4, 5, "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.", true},
                {6, 7, "Только начиная с завтрашнего дня. Но скоро станем расторопнее.", true},
                {8, 9, "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.", true},
                {10, 11, "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.", true},
                {12, 13, "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.", true},
                {14, 15, "Да, обязательно. Всем самокатов! И Москве, и Московской области.", true},
                {8, 11, "Да, обязательно. Всем самокатов! И Москве, и Московской области.", false}
        };
    }

    @Test
    public void checkListButton() {
        WebDriverManager.firefoxdriver().setup();

        System.setProperty("webdriver.gecko.driver", "C:\\cygwin64\\home\\admin\\untitled\\geckodriver.exe");
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability("marionette", true);
        WebDriver driver = new FirefoxDriver(capabilities);
        driver.get("https://qa-scooter.praktikum-services.ru/");
        HomePage objHomePage = new HomePage(driver);
        boolean actual = objHomePage.returnButtonMessage(index, index1).equals(message);
        assertEquals(isVisible, actual);
        driver.quit();
    }
}