package ru.qa.scooter.praktikum.services.page.object;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderPage {
    public static By orderButton = By.xpath(".//div[@class='Header_Nav__AGCXC']/button[@class='Button_Button__ra12g']");
    private final WebDriver driver;


    // Имя
    private final By nameField = By.xpath(".//input[@placeholder='* Имя']");


    //Фамилия
    private final By surnameField = By.xpath(".//input[@placeholder='* Фамилия']");


    //Адрес: куда привезти заказ
    private final By addressField = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");


    //поле Станция метро
    private final By station = By.xpath(".//*[@id=\"root\"]/div/div[2]/div[2]/div[4]/div/div[1]/input");


    //Тверская
    private final By tverskayStation = By.xpath(".//*[@id=\"root\"]/div/div[2]/div[2]/div[4]/div/div[2]/ul/li[31]");


    //Сокольники
    private final By socolnikiStation = By.xpath(".//*[@id=\"root\"]/div/div[2]/div[2]/div[4]/div/div[2]/ul/li[4]");


    //Телефон: на него позвонит курьер
    private final By phoneNumberField = By.xpath(".//*[@id=\"root\"]/div/div[2]/div[2]/div[5]/input");


    //Далее
    private final By next = By.xpath(".//*[@id=\"root\"]/div/div[2]/div[3]/button");


    //Когда привезти самокат
    private final By dateField = By.xpath(".//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/div[1]/div/input");
    //24.12.2023
    private final By twentyFourDecember = By.xpath(".//div[@class='react-datepicker__day react-datepicker__day--024 react-datepicker__day--selected react-datepicker__day--weekend']");


    //Срок аренды
    private final By termField = By.xpath(".//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div[1]/div[1]");


    //сутки
    private final By oneDay = By.xpath(".//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div[2]/div[1]");


    //шестеро суток
    private final By sevenDay = By.xpath(".//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div[2]/div[7]");


    //Цвет самоката - черный
    private final By black = By.xpath(".//*[@id=\"black\"]");


    //серая безысходность
    private final By grey = By.xpath(".//*[@id=\"grey\"]");


    //Комментарий для курьера
    private final By commentField = By.xpath(".//*[@id=\"root\"]/div/div[2]/div[2]/div[4]/input");


    //Заказать
    private final By orderButtonInForm = By.xpath(".//*[@id=\"root\"]/div/div[2]/div[3]/button[2]");


    //Хотите оформить заказ - Да
    private final By orderButtonTakeYes = By.xpath(".//*[@id=\"root\"]/div/div[2]/div[5]/div[2]/button[2]");

    //Посмотреть статус заказа
    private final By orderStatusButton = By.xpath(".//*[@id=\"root\"]/div/div[2]/div[5]/div[2]/button");


    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitField() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(nameField));
    }

    public boolean actualOrder() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(orderStatusButton));
        boolean actual = driver.findElement(orderStatusButton).getText().equals("Посмотреть статус");
        return actual;
    }


    public void makeOrderOnePageSocolniki(String name, String surname, String address, String number) {
        driver.findElement(nameField).click();
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(surnameField).click();
        driver.findElement(surnameField).sendKeys(surname);
        driver.findElement(addressField).click();
        driver.findElement(addressField).sendKeys(address);
        driver.findElement(station).click();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(socolnikiStation));
        driver.findElement(socolnikiStation).click();
        driver.findElement(phoneNumberField).click();
        driver.findElement(phoneNumberField).sendKeys(number);
        driver.findElement(next).click();
    }

    public void makeOrderOnePageTverskay(String name, String surname, String address, String number) {
        driver.findElement(nameField).click();
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(surnameField).sendKeys(surname);
        driver.findElement(addressField).sendKeys(address);
        driver.findElement(station).click();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(tverskayStation));
        driver.findElement(tverskayStation).click();
        driver.findElement(phoneNumberField).sendKeys(number);
        driver.findElement(next).click();
    }

    public void makeOrderTwoPageOneDay(String date, String comment) {
        driver.findElement(dateField).sendKeys(date);
        driver.findElement(twentyFourDecember).click();
        driver.findElement(termField).click();
        driver.findElement(oneDay).click();
        driver.findElement(black).click();
        driver.findElement(commentField).sendKeys(comment);
        driver.findElement(orderButtonInForm).click();
        new WebDriverWait(driver, 3).until(ExpectedConditions.elementToBeClickable(orderButtonTakeYes));
        driver.findElement(orderButtonTakeYes).click();

    }

    public void makeOrderTwoPageSevenDay(String date, String comment) {
        driver.findElement(dateField).sendKeys(date);
        driver.findElement(dateField).click();
        driver.findElement(twentyFourDecember).click();
        driver.findElement(termField).click();
        driver.findElement(sevenDay).click();
        driver.findElement(grey).click();
        driver.findElement(commentField).sendKeys(comment);
        driver.findElement(orderButtonInForm).click();
        new WebDriverWait(driver, 4).until(ExpectedConditions.elementToBeClickable(orderButtonTakeYes));
        driver.findElement(orderButtonTakeYes).click();

    }

}
