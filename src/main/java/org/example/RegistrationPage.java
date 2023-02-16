package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage {
    private WebDriver driver;
    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }
    //PageObjects
    private By registration = By.xpath("//div/p[1]/a"); //href Зарегистрироваться
    private By nameInput = By.xpath("//fieldset[1]/div/div/input");
    private By emailInput = By.xpath("//fieldset[2]/div/div/input");
    private By passwordInput = By.xpath("//fieldset[3]/div/div/input");
    private By primaryRegistration = By.xpath(".//a[text()='Войти']");
    private By incorrectPasswordMessage = By.xpath("//form/fieldset[3]/div/p");

    //Методы
    // клик по кнопке Зарегистрироваться
    public void clickRegistrationHref(){driver.findElement(registration).click();}
    //Метод регистрации с заполнением инпутов и нажатием на кнопку Зарегистрироваться
    public void setUsername(String name) {driver.findElement(nameInput).sendKeys(name);}
    public void setEmail(String email) {
        driver.findElement(emailInput).sendKeys(email);
    }
    public void setPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }
    public void registration(String name, String email, String password){
        setUsername(name);
        setEmail(email);
        setPassword(password);
        getPrimaryRegistration();}
    // клик по кнопке Зарегистрироваться после заполнения инпутов
    public void getPrimaryRegistration(){driver.findElement(primaryRegistration).click();}
    // Проверка -  при некорректном пароле выдает ошибку
    public String statusOfPasswordMessage(){
        return driver.findElement(incorrectPasswordMessage).getText();
    }
}


