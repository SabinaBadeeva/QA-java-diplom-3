package org.example.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class PrivateAccount {
    private WebDriver driver;
    public PrivateAccount(WebDriver driver) {
        this.driver = driver;
    }

    private By nameField = By.cssSelector("ul > li:nth-child(1) > div > div > input"); // инпут Имя
    private By emailField = By.xpath("//label[text()='Логин']/following-sibling::input"); // инпут email
    private By accountExit = By.cssSelector("nav > ul > li:nth-child(3) > button"); // Выйти

    // Метод получения значения поля Name
    public String getNameValue() {
        return driver.findElement(nameField).getAttribute("value");}

    // Метод получения значения поля Email
    public String getEmailValue() {
        return driver.findElement(emailField).getAttribute("value").toLowerCase();}

    //Клик по кнопке Выход
    public void clickLogOutButton() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(accountExit)).click();}

    public void scrollAccountLogOut() {
        WebElement element = driver.findElement
                (accountExit);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);}
}
