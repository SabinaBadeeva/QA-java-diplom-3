package org.example.pageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AuthorisationPage {
    WebDriver driver;

    public AuthorisationPage(WebDriver driver) {
        this.driver = driver;}

    private By emailInput = By.xpath(".//input[@name='name']");
    private By passwordInput = By.xpath(".//input[@name='Пароль']");
    private By enterButton = By.xpath(".//button[text()='Войти']");
    private By recoverPassword = By.xpath("//p[2]/a");// Восстановить пароль
    private By rememberPassword = By.cssSelector(" div > p > a");// Войти (вспомнили пароль)

    //Метод для Авторизации
    public void getEnterEmailAccount(String email) {
        driver.findElement(emailInput).sendKeys(email);}

    public void getEnterPasswordAccount(String password) {
        driver.findElement(passwordInput).sendKeys(password);}

    public void getEnterAccount(String email, String password) {
        getEnterEmailAccount(email);
        getEnterPasswordAccount(password);
        headerEnterButtonIsClick();}

    //Метод проверки успешной регистрации (при успешной регистрации видна кнопка Войти)
    public void statusOfRegistration(String enterButtonText) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.textToBePresentInElementLocated(enterButton, enterButtonText));}

    public void statusOfRegistrationVisible() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(enterButton));}

    public void headerEnterButtonIsClick() {
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(enterButton)).click();}

    //ОЖИДАНИЕ прогрузки данных
    public void waitForLoadDataAccount() {
        new WebDriverWait(driver, 10).until(driver -> (driver.findElement(enterButton).getText() != null && !driver.findElement(enterButton).getText().isEmpty()));}

    // Клик на Восстановить пароль
    public void clickRecoverPassword() {
        driver.findElement(recoverPassword).click();}

    //Войти - через Вспомнили пароль
    public void clickRememberPassword() {
        driver.findElement(rememberPassword).click();
    }
}

