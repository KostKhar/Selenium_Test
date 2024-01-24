import org.junit.Test;
import ru.qa.scooter.praktikum.services.page.object.HomePage;
import ru.qa.scooter.praktikum.services.page.object.OrderPage;

import static org.junit.Assert.assertTrue;


public class OrderPageTest extends BaseTest {

    @Test
    public void checkOrderByUpButton() {
        HomePage objHomePage = new HomePage(driver);
        objHomePage.clickOrderButton();
        OrderPage objOrderPage = new OrderPage(driver);
        objOrderPage.makeOrderOnePageSocolniki("Иван", "Иванов", "Москва, Азовская, д. 23, кв 40", "+79887552545");
        objOrderPage.makeOrderTwoPageOneDay("24.12.2023", "Домофон 25*25");
        assertTrue(objOrderPage.actualOrder());
    }

    @Test
    public void checkOrderByMiddleButton() {
        HomePage objHomePage = new HomePage(driver);
        objHomePage.clickOrderMiddleButton();
        OrderPage objOrderPage = new OrderPage(driver);
        objOrderPage.makeOrderOnePageTverskay("Илья", "Сидоров", "г. Домодедово, Азовская, д. 23, кв 40", "+79182566989");
        objOrderPage.makeOrderTwoPageSevenDay("24.12.2023", "");
        assertTrue(objOrderPage.actualOrder());
    }


}
