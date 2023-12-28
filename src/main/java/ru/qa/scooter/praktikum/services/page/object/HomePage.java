package ru.qa.scooter.praktikum.services.page.object;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class HomePage {
    private  WebDriver driver;

    //кнопка заказать верхняя
    private final By orderButton = By.xpath(".//div[@class='Header_Nav__AGCXC']/button[@class='Button_Button__ra12g']");

    //кнопка Заказать в середине
    private final By orderMiddleButton = By.xpath(".//div[5]/button");

    //Сколько это стоит? И как оплатить?
    private final By howCost = By.xpath(".//*[@id=\"accordion__heading-0\"]");
    //Сутки 400 рублей. Оплата курьеру - наличными или картой.
    private final By itCost = By.xpath(".//*[@id=\"accordion__panel-0\"]/p");

    //Хочу сразу несколько самокатов! Так можно?
    private final By howManyToOne = By.xpath(".//*[@id=\"accordion__heading-1\"]");
    //Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.
    private final By oneOrderOneScooter = By.xpath(".//p[text()='Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.']");
    //Как рассчитывается время аренды?
    private final By orderTimeRange = By.xpath(".//*[@id=\"accordion__heading-2\"]");
    //Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.
    private final By orderTimeRangeAbout = By.xpath(".//p[text()='Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.']");
    //Можно ли заказать самокат прямо на сегодня?
    private final By scooterWhenIGet = By.xpath(".//*[@id=\"accordion__heading-3\"]");
    //Только начиная с завтрашнего дня. Но скоро станем расторопнее.
    private final By scooterIGet = By.xpath(".//p[text()='Только начиная с завтрашнего дня. Но скоро станем расторопнее.']");
    //Можно ли продлить заказ или вернуть самокат раньше?
    private final By scooterWhenITake = By.xpath(".//*[@id=\"accordion__heading-4\"]");
    //Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.
    private final By scooterITake = By.xpath(".//p[text()='Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.']");
    //Вы привозите зарядку вместе с самокатом?
    private final By scooterHowCharge = By.xpath(".//*[@id=\"accordion__heading-5\"]");
    //Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.
    private final By scooterCharge = By.xpath(".//p[text()='Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.']");
    //Можно ли отменить заказ?
    private final By orderCancel = By.xpath(".//*[@id=\"accordion__heading-6\"]");
    //Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.
    private final By orderCancelConditions = By.xpath(".//p[text()='Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.']");

    //Я жизу за МКАДом, привезёте?
    private final By liveBehind = By.xpath(".//*[@id=\"accordion__heading-7\"]");
    //Да, обязательно. Всем самокатов! И Москве, и Московской области.
    private final By liveInOblast = By.xpath(".//p[text()='Да, обязательно. Всем самокатов! И Москве, и Московской области.']");


    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOrderButton() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(orderButton));
        driver.findElement(orderButton).click();

    }

    public void clickOrderMiddleButton() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(orderMiddleButton));
        new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(orderButton));
        driver.findElement(orderMiddleButton).click();
    }

    public String returnButtonMessage(int questionIndex, int answerIndex) {
        List<By> questions = new ArrayList<>();
        List<By> answers = new ArrayList<>();
        questions.add(0, howCost);
        answers.add(0, itCost);
        questions.add(1, howManyToOne);
        answers.add(1, oneOrderOneScooter);
        questions.add(2, orderTimeRange);
        answers.add(2, orderTimeRangeAbout);
        questions.add(3, scooterWhenIGet);
        answers.add(3, scooterIGet);
        questions.add(4, scooterWhenITake);
        answers.add(4, scooterITake);
        questions.add(5, scooterHowCharge);
        answers.add(5, scooterCharge);
        questions.add(6, orderCancel);
        answers.add(6, orderCancelConditions);
        questions.add(7, liveBehind);
        answers.add(7, liveInOblast);
        new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(orderButton));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(questions.get(questionIndex)));
        driver.findElement(questions.get(questionIndex)).click();
        return driver.findElement(answers.get(answerIndex)).getText();
    }

}


