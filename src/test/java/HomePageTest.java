import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.qa.scooter.praktikum.services.page.object.HomePage;

import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class HomePageTest extends BaseTest {
    private final String message;
    private final int questionIndex;
    private final int answerIndex;
    private final boolean isVisible;

    public HomePageTest(int questionIndex, int answerIndex, String message, boolean isVisible) {
        this.questionIndex = questionIndex;
        this.answerIndex = answerIndex;
        this.message = message;
        this.isVisible = isVisible;
    }

    @Parameterized.Parameters
    public static Object[][] getMessage() {
        return new Object[][]{
                {0, 0, "Сутки — 400 рублей. Оплата курьеру — наличными или картой.", true},
                {1, 1, "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.", true},
                {2, 2, "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.", true},
                {3, 3, "Только начиная с завтрашнего дня. Но скоро станем расторопнее.", true},
                {4, 4, "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.", true},
                {5, 5, "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.", true},
                {6, 6, "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.", true},
                {7, 7, "Да, обязательно. Всем самокатов! И Москве, и Московской области.", true},
                {5, 7, "Да, обязательно. Всем самокатов! И Москве, и Московской области.", false}
        };
    }

    @Test
    public void checkListButton() {
        HomePage objHomePage = new HomePage(driver);
        boolean actual = objHomePage.returnButtonMessage(questionIndex, answerIndex).equals(message);
        assertEquals(isVisible, actual);
    }
}