package ru.qa.scooter.praktikum.services.page.object;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderPage {
    private final WebDriver driver;

    // Имя
    private final By nameField = By.xpath(".//input[@placeholder='* Имя']");


    //Фамилия
    private final By surnameField = By.xpath(".//input[@placeholder='* Фамилия']");


    //Адрес: куда привезти заказ
    private final By addressField = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");


    //поле Станция метро
    private final By station = By.className("select-search__input");


    //Тверская
    private final By tverskayStation = By.xpath(".//button[@value='31']");


    //Сокольники
    private final By socolnikiStation = By.xpath(".//button[@value='4']");


    //Телефон: на него позвонит курьер
    private final By phoneNumberField = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");


    //Далее
    private final By next = By.className("Button_Middle__1CSJM");


    //Когда привезти самокат
    private final By dateField = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    //24.12.2023
    private final By twentyFourDecember = By.xpath(".//div[@class='react-datepicker__day react-datepicker__day--024 react-datepicker__day--selected react-datepicker__day--weekend']");

    //Срок аренды
    private final By termField = By.className("Dropdown-placeholder");

    //сутки
    private final By oneDay = By.xpath(".//div[@class='Dropdown-option' and text()='сутки']");


    //шестеро суток
    private final By sevenDay = By.xpath(".//div[@class='Dropdown-option' and text()='семеро суток']");


    //Цвет самоката - черный
    private final By black = By.xpath(".//*[@id=\"black\"]");


    //серая безысходность
    private final By grey = By.xpath(".//*[@id=\"grey\"]");


    //Комментарий для курьера
    private final By commentField = By.xpath(".//input[@placeholder='Комментарий для курьера']");


    //Заказать
    private final By orderButtonInForm = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать']");


    //Хотите оформить заказ - Да
    private final By orderButtonTakeYes = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Да']");

    //Посмотреть статус заказа
    private final By orderStatusButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Посмотреть статус']");


    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }


    public boolean actualOrder() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(orderStatusButton));
        return driver.findElement(orderStatusButton).getText().equals("Посмотреть статус");
    }


    public void makeOrderOnePageSocolniki(String name, String surname, String address, String number) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(nameField));
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
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(nameField));
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
