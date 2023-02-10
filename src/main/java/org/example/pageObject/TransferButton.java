package org.example.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TransferButton {
    WebDriver driver;

    public TransferButton(WebDriver driver) {
        this.driver = driver;
    }

    private By stellarBurgerLogo = By.cssSelector("nav > div > a");//Логотип
    private By constructorButton = By.xpath(".//p[contains(text(),\"Конструктор\")]");//Конструктор
    private By createOrderButton = By.xpath(".//button[contains(text(),\"Оформить заказ\")]"); //Оформить заказ
    // локаторы Конструктора
    private By bunsList = By.xpath("//span[text()='Булки']");
    private By saucesList = By.cssSelector("section.BurgerIngredients_ingredients__1N8v2 > div:nth-child(2) > div:nth-child(2) > span");
    private By fillingsList = By.cssSelector("section.BurgerIngredients_ingredients__1N8v2 > div:nth-child(2) > div:nth-child(3) > span");
    private By bunsTitle = By.cssSelector("section.BurgerIngredients_ingredients__1N8v2 > div:nth-child(2)");
    private By saucesTitle = By.xpath("//h2[text()='Соусы']");
    private By fillingsTitle = By.xpath("//h2[text()='Начинки']");


    // метод -  КЛИКАЕМ по Логотипу
    public void headerLogoIsClick() {
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(stellarBurgerLogo)).click();
    }


    // метод -  КЛИКАЕМ по Конструктору
    public void headerConstructorIsClick() {
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(constructorButton)).click();
    }

    //Метод проверяет,что на странице содержится элемент с нужным текстом
    public void createOrderButtonGetText(String orderButtonText) {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.textToBePresentInElementLocated(createOrderButton, orderButtonText));
    }

    //Клики по разделам Контейнера
    public void clickBunList() {
        driver.findElement(bunsList);
    }

    public void clickSaucesList() {
        driver.findElement(saucesList);
    }

    public void clickFillingsList() {
        driver.findElement(fillingsList);
    }

    //Методы отображения заголовков Контейнера
    public boolean isHeaderBunsVisible() {
        return driver.findElement(bunsTitle).isDisplayed();
    }

    public boolean isHeaderSaucesVisible() {
        return driver.findElement(saucesTitle).isDisplayed();
    }

    public boolean isHeaderFillingsVisible() {
        return driver.findElement(fillingsTitle).isDisplayed();
    }

    // Скроллы до блоков Соусы и Начини
    public void scrollSauceBlock() {
        WebElement element = driver.findElement
                (saucesTitle);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void scrollFillingsBlock() {
        WebElement element = driver.findElement
                (fillingsTitle);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
