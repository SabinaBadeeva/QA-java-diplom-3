package org.example.pageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    private By enterAccountButton = By.xpath("//section[2]/div/button"); //Войти в аккаунт
    private By personalAccount = By.xpath("//header/nav/a"); //Личный кабинет



    //Методы
    // клик по кнопке Личный кабинет
    public void clickPersonalAccountButton(){driver.findElement(personalAccount).click();}
    // клик по кнопке Войти в аккаунт
    public void clickEnterAccountButton(){driver.findElement(enterAccountButton).click();}

}
